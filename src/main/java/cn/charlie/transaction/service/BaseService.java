package cn.charlie.transaction.service;

import cn.charlie.transaction.entity.base.BaseInfo;
import cn.charlie.transaction.entity.base.BaseInfoParam;
import cn.charlie.transaction.entity.base.BaseInfoParamForUpdate;

import java.util.List;

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

    /**
     * 循环保存
     *
     * @param baseInfoParamList 基础信息参数列表
     * @return 结果
     */
    List<BaseInfo> saveInLoop(List<BaseInfoParam> baseInfoParamList) throws Exception;

    /**
     * 在try块内循环保存
     *
     * @param baseInfoParamList 基础信息参数列表
     * @return 结果
     */
    List<BaseInfo> saveInTryBlock(List<BaseInfoParam> baseInfoParamList) throws Exception;

    /**
     * 多线程循环保存
     *
     * @param baseInfoParamList 基础信息参数列表
     * @return 结果
     */
    List<BaseInfo> saveInThread(List<BaseInfoParam> baseInfoParamList) throws Exception;

    /**
     * 异步保存基础信息参数列表
     * 注意: 该操作十分危险, 因为当方法结束后, 事务会直接提交, 没有执行完的线程, 事务没办法保证.
     *
     * @param baseInfoParamList 基础信息参数列表
     * @return 结果
     */
    List<BaseInfo> buildBaseInfoList(List<BaseInfoParam> baseInfoParamList);

    /**
     * 在新事务中保存
     * 注意: 此时程序会阻塞, insert操作触发写锁, 第二次开启新事务, 再次insert时会阻塞
     *
     * @param baseInfoParamList 基础信息参数列表
     * @return 结果
     */
    List<BaseInfo> saveInNewTx(List<BaseInfoParam> baseInfoParamList) throws Exception;

    /**
     * 在新事务中更新
     *
     * @param baseInfoParamForUpdate 基础信息参数
     */
    void updateInNewTx(BaseInfoParamForUpdate baseInfoParamForUpdate);

    /**
     * 在新事务try块中更新
     *
     * @param baseInfoParamForUpdate 基础信息参数
     */
    void updateInNewTryTx(BaseInfoParamForUpdate baseInfoParamForUpdate);

    /**
     * 在新事务中更新子程序
     *
     * @param baseInfoParam 基础信息参数
     */
    void updateInNewTxSub(BaseInfoParam baseInfoParam);

    /**
     * 在新事务try块中更新子程序
     *
     * @param baseInfoParam
     */
    void updateInNewTryTxSub(BaseInfoParam baseInfoParam);
}