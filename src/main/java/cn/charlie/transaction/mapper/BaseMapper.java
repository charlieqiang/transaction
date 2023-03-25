package cn.charlie.transaction.mapper;

import cn.charlie.transaction.entity.base.BaseInfo;

/**
 * @author charlie
 * @date 3/23/2023 8:08 PM
 **/
public interface BaseMapper {

    /**
     * 保存
     *
     * @param baseInfo 基础信息
     * @return 影响条数
     */
    int save(BaseInfo baseInfo);

    /**
     * 更新
     *
     * @param baseInfo 基础信息
     * @return 影响条数
     */
    int update(BaseInfo baseInfo);
}
