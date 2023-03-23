package cn.charlie.transaction.controller.builder;

import cn.charlie.transaction.entity.base.BaseInfoParam;
import cn.charlie.transaction.entity.snowflakeid.SnowflakeIdWorker;

/**
 * @author charlie
 * @date 3/23/2023 10:06 PM
 **/
public class BaseInfoParamBuilder {
    public static BaseInfoParam buildBaseInfoParam() {
        BaseInfoParam baseInfoParam = new BaseInfoParam();
        baseInfoParam.setBaseId(SnowflakeIdWorker.getInstance().nextId());
        return baseInfoParam;
    }
}
