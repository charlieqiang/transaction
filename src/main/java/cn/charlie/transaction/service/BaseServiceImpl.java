package cn.charlie.transaction.service;

import cn.charlie.transaction.entity.base.BaseInfo;
import cn.charlie.transaction.entity.base.BaseInfoParam;
import cn.charlie.transaction.entity.base.BaseInfoParamForUpdate;
import cn.charlie.transaction.mapper.BaseMapper;
import cn.charlie.transaction.service.builder.BaseInfoBuilder;
import cn.charlie.transaction.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author charlie
 * @date 3/23/2023 7:59 PM
 **/
@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private BaseMapper baseMapper;

    @Override
    public BaseInfo save(BaseInfoParam baseInfoParam) throws Exception {
        if (ObjectUtils.isEmpty(baseInfoParam)) {
            throw new Exception("参数不能为空");
        }

        BaseInfo baseInfo = BaseInfoBuilder.buildBaseInfo(baseInfoParam);
        baseMapper.save(baseInfo);
        return baseInfo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<BaseInfo> saveInLoop(List<BaseInfoParam> baseInfoParamList) throws Exception {
        if (CollectionUtils.isEmpty(baseInfoParamList)) {
            throw new Exception("参数不能为空");
        }

        List<BaseInfo> baseInfoList = new ArrayList<>();
        for (BaseInfoParam baseInfoParam : baseInfoParamList) {
            BaseInfo baseInfo = BaseInfoBuilder.buildBaseInfo(baseInfoParam);
            baseMapper.save(baseInfo);
            baseInfoList.add(baseInfo);
        }

        return baseInfoList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<BaseInfo> saveInTryBlock(List<BaseInfoParam> baseInfoParamList) throws Exception {
        if (CollectionUtils.isEmpty(baseInfoParamList)) {
            throw new Exception("参数不能为空");
        }

        List<BaseInfo> baseInfoList = new ArrayList<>();
        try {
            List<BaseInfo> baseInfoTempList = buildBaseInfoList(baseInfoParamList);
            baseInfoList.addAll(baseInfoTempList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseInfoList;
    }

    @Async("fastHorsesExecutor")
    public List<BaseInfo> buildBaseInfoList(List<BaseInfoParam> baseInfoParamList) {
        List<BaseInfo> baseInfoTempList = new ArrayList<>();
        for (BaseInfoParam baseInfoParam : baseInfoParamList) {
            BaseInfo baseInfo = BaseInfoBuilder.buildBaseInfo(baseInfoParam);
            baseMapper.save(baseInfo);
            baseInfoTempList.add(baseInfo);
        }
        System.out.println(Thread.currentThread().getName());
        return baseInfoTempList;
    }

    @Override
    @Transactional
    public List<BaseInfo> saveInThread(List<BaseInfoParam> baseInfoParamList) throws Exception {
        if (CollectionUtils.isEmpty(baseInfoParamList)) {
            throw new Exception("参数不能为空");
        }
        List<BaseInfo> baseInfoList = ApplicationContextUtil.getBean(BaseService.class)
                .buildBaseInfoList(baseInfoParamList);
        return baseInfoList;
    }

    @Override
    @Transactional
    public List<BaseInfo> saveInNewTx(List<BaseInfoParam> baseInfoParamList) throws Exception {
        List<BaseInfo> baseInfoList = saveInLoop(baseInfoParamList);
        ApplicationContextUtil.getBean(BaseService.class)
                .saveInLoop(baseInfoParamList);
        return baseInfoList;
    }

    @Override
    @Transactional
    public void updateInNewTx(BaseInfoParamForUpdate baseInfoParamForUpdate) {
        updateInNewTxSub(baseInfoParamForUpdate.getBaseInfoFirstParam());
        ApplicationContextUtil.getBean(BaseService.class)
                .updateInNewTxSub(baseInfoParamForUpdate.getBaseInfoSecondParam());
    }

    @Override
    @Transactional
    public void updateInNewTryTx(BaseInfoParamForUpdate baseInfoParamForUpdate) {
        updateInNewTxSub(baseInfoParamForUpdate.getBaseInfoFirstParam());
        ApplicationContextUtil.getBean(BaseService.class)
                .updateInNewTryTxSub(baseInfoParamForUpdate.getBaseInfoSecondParam());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateInNewTxSub(BaseInfoParam baseInfoParam) {
        BaseInfo baseInfo = BaseInfoBuilder.buildBaseInfo(baseInfoParam);
        baseMapper.update(baseInfo);
        Boolean flag = false;
        if (flag) {
            int i = 1 / 0;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateInNewTryTxSub(BaseInfoParam baseInfoParam) {
        try {
            BaseInfo baseInfo = BaseInfoBuilder.buildBaseInfo(baseInfoParam);
            baseMapper.update(baseInfo);
            Boolean flag = false;
            if (flag) {
                int i = 1 / 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
