package cn.charlie.transaction.controller;

import cn.charlie.transaction.SpringServiceTest;
import cn.charlie.transaction.controller.builder.BaseInfoParamBuilder;
import cn.charlie.transaction.entity.base.BaseInfoParam;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author charlie
 * @date 3/23/2023 8:26 PM
 **/
public class BaseControllerTest extends SpringServiceTest {

    @Test
    public void testGetResult() throws Exception {
        final Map<String, String> header = new HashMap<>();
        String param = "str";
        ResultActions resultActions = returnGetResultActions("/base?param=" + param, header);
        String exp = "$.data";
        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(exp).value(param));
    }

    @Test
    public void testSaveBaseInfoByParam() throws Exception {
        final Map<String, String> header = new HashMap<>();
        BaseInfoParam baseInfoParam = BaseInfoParamBuilder.buildBaseInfoParam();
        ResultActions resultActions = returnPostResultActions("/base", baseInfoParam, header);
        String exp = "$.data.baseId";
        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(exp).value(baseInfoParam.getBaseId()));
    }

}
