package cn.charlie.transaction.service;

import cn.charlie.transaction.entity.base.BaseInfo;
import cn.charlie.transaction.entity.base.BaseInfoParam;
import cn.charlie.transaction.mapper.BaseMapper;
import cn.charlie.transaction.service.builder.BaseInfoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
}
