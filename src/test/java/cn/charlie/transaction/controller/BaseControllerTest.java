package cn.charlie.transaction.controller;

import cn.charlie.transaction.SpringServiceTest;
import cn.charlie.transaction.controller.builder.BaseInfoParamBuilder;
import cn.charlie.transaction.entity.base.BaseInfoParam;
import cn.charlie.transaction.entity.base.BaseInfoParamForUpdate;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Test
    public void testSaveBaseInfoByParamInLoop() throws Exception {
        final Map<String, String> header = new HashMap<>();
        int itemQty = 8;
        List<BaseInfoParam> baseInfoParamList = new ArrayList<>();
        for (int i = 0; i < itemQty; i++) {
            BaseInfoParam baseInfoParam = BaseInfoParamBuilder.buildBaseInfoParam();
            baseInfoParamList.add(baseInfoParam);
        }
        ResultActions resultActions = returnPostResultActions("/base/loop", baseInfoParamList, header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSaveBaseInfoByParamInTryBlock() throws Exception {
        final Map<String, String> header = new HashMap<>();
        int itemQty = 8;
        List<BaseInfoParam> baseInfoParamList = new ArrayList<>();
        for (int i = 0; i < itemQty; i++) {
            BaseInfoParam baseInfoParam = BaseInfoParamBuilder.buildBaseInfoParam();
            baseInfoParamList.add(baseInfoParam);
        }
        ResultActions resultActions = returnPostResultActions("/base/try-block", baseInfoParamList, header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSaveBaseInfoByParamInThread() throws Exception {
        final Map<String, String> header = new HashMap<>();
        int itemQty = 8;
        List<BaseInfoParam> baseInfoParamList = new ArrayList<>();
        for (int i = 0; i < itemQty; i++) {
            BaseInfoParam baseInfoParam = BaseInfoParamBuilder.buildBaseInfoParam();
            baseInfoParamList.add(baseInfoParam);
        }
        ResultActions resultActions = returnPostResultActions("/base/thread", baseInfoParamList, header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSaveBaseInfoByParamInNewTx() throws Exception {
        final Map<String, String> header = new HashMap<>();
        int itemQty = 8;
        List<BaseInfoParam> baseInfoParamList = new ArrayList<>();
        for (int i = 0; i < itemQty; i++) {
            BaseInfoParam baseInfoParam = BaseInfoParamBuilder.buildBaseInfoParam();
            baseInfoParamList.add(baseInfoParam);
        }
        ResultActions resultActions = returnPostResultActions("/base/new-tx", baseInfoParamList, header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSaveBaseInfoByParamInNewTryTx() throws Exception {
        final Map<String, String> header = new HashMap<>();
        int itemQty = 8;
        List<BaseInfoParam> baseInfoParamList = new ArrayList<>();
        for (int i = 0; i < itemQty; i++) {
            BaseInfoParam baseInfoParam = BaseInfoParamBuilder.buildBaseInfoParam();
            baseInfoParamList.add(baseInfoParam);
        }
        ResultActions resultActions = returnPostResultActions("/base/new-try-tx", baseInfoParamList, header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateBaseInfoByParamInNewTx() throws Exception {
        final Map<String, String> header = new HashMap<>();
        BaseInfoParamForUpdate baseInfoParamForUpdate = new BaseInfoParamForUpdate();
        BaseInfoParam baseInfoFirstParam = new BaseInfoParam();
        baseInfoFirstParam.setBaseId(1089284975455461376L);
        baseInfoFirstParam.setBaseCode("1");
        BaseInfoParam baseInfoSecondParam = new BaseInfoParam();
        baseInfoSecondParam.setBaseId(1089284975455461377L);
        baseInfoSecondParam.setBaseCode("1");
        baseInfoParamForUpdate.setBaseInfoFirstParam(baseInfoFirstParam);
        baseInfoParamForUpdate.setBaseInfoSecondParam(baseInfoSecondParam);
        ResultActions resultActions = returnPostResultActions("/base/multi-new-tx", baseInfoParamForUpdate, header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateBaseInfoByParamInNewTryTx() throws Exception {
        final Map<String, String> header = new HashMap<>();
        BaseInfoParamForUpdate baseInfoParamForUpdate = new BaseInfoParamForUpdate();
        BaseInfoParam baseInfoFirstParam = new BaseInfoParam();
        baseInfoFirstParam.setBaseId(1089284975455461376L);
        baseInfoFirstParam.setBaseCode("2");
        BaseInfoParam baseInfoSecondParam = new BaseInfoParam();
        baseInfoSecondParam.setBaseId(1089284975455461377L);
        baseInfoSecondParam.setBaseCode("2");
        baseInfoParamForUpdate.setBaseInfoFirstParam(baseInfoFirstParam);
        baseInfoParamForUpdate.setBaseInfoSecondParam(baseInfoSecondParam);
        ResultActions resultActions = returnPostResultActions("/base/multi-new-try-tx", baseInfoParamForUpdate, header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
