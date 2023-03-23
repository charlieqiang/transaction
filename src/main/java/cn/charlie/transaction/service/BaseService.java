package cn.charlie.transaction.service;

import cn.charlie.transaction.entity.base.BaseInfo;
import cn.charlie.transaction.entity.base.BaseInfoParam;

/**
 * @author charlie
 * @date 3/23/2023 7:59 PM
 **/
public interface BaseService {

    /**
     * 保存
     *
     * @param baseInfoParam 基础信息参数
     * @return 结果
     * @throws Exception 异常
     */
    BaseInfo save(BaseInfoParam baseInfoParam) throws Exception;
}
