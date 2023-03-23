package cn.charlie.transaction.service.builder;

import cn.charlie.transaction.entity.base.BaseInfo;
import cn.charlie.transaction.entity.base.BaseInfoParam;

/**
 * @author charlie
 * @date 3/23/2023 9:53 PM
 **/
public class BaseInfoBuilder {
    public static BaseInfo buildBaseInfo(BaseInfoParam baseInfoParam) {
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setBaseId(baseInfoParam.getBaseId());
        baseInfo.setBaseCode(baseInfoParam.getBaseCode());
        return baseInfo;
    }
}
