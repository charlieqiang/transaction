package cn.charlie.transaction;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author charlie
 * @date 3/15/2023 2:13 PM
 **/
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public abstract class SpringServiceTest {
    protected Logger LOGGER = LoggerFactory.getLogger(SpringServiceTest.class);

    public static final String UTF_8 = "UTF-8";

    @Autowired
    protected MockMvc mvc;

    protected String returnGetResponseContent(String url, Map<String, String> headers) throws Exception {
        ResultActions resultActions = returnGetResultActions(url, headers);
        MvcResult mvcResult = resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        mvcResult.getResponse().setCharacterEncoding(UTF_8);
        return mvcResult.getResponse().getContentAsString();
    }

    protected ResultActions returnGetResultActions(String url, Map<String, String> headers) throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
        ResultActions resultActions = mvc.perform(getMockHttpServletRequestBuilder(requestBuilder, headers)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding(UTF_8));

        return resultActions;
    }

    private MockHttpServletRequestBuilder getMockHttpServletRequestBuilder(MockHttpServletRequestBuilder requestBuilder, Map<String, String> headers) {
        if (null == headers) {
            headers = new HashMap<>();
        }
        headers.put("from-unit-test", "Y");
        for (Map.Entry<String, String> headerEntry : headers.entrySet()) {
            requestBuilder = requestBuilder.header(headerEntry.getKey(), headerEntry.getValue());
        }
        return requestBuilder;
    }

    protected String returnPostResponseContent(String url, Object request, Map<String, String> headers) throws Exception {
        ResultActions resultActions = returnPostResultActions(url, request, headers);
        MvcResult mvcResult = resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        mvcResult.getResponse().setCharacterEncoding(UTF_8);
        return mvcResult.getResponse().getContentAsString();
    }

    protected ResultActions returnPostResultActions(String url, Object request, Map<String, String> headers) throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
        ResultActions resultActions = mvc.perform(getMockHttpServletRequestBuilder(requestBuilder, headers)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding(UTF_8)
                .content(JSON.toJSONString(request)));

        return resultActions;
    }

    protected String returnPutResponseContent(String url, Object request, Map<String, String> headers) throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put(url);
        MvcResult mvcResult = mvc.perform(getMockHttpServletRequestBuilder(requestBuilder, headers)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding(UTF_8)
                        .content(JSON.toJSONString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        mvcResult.getResponse().setCharacterEncoding(UTF_8);
        return mvcResult.getResponse().getContentAsString();
    }

    protected ResultActions returnPutResultActions(String url, Object request, Map<String, String> headers) throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put(url);
        ResultActions resultActions = mvc.perform(getMockHttpServletRequestBuilder(requestBuilder, headers)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding(UTF_8)
                .content(JSON.toJSONString(request)));

        return resultActions;
    }
}