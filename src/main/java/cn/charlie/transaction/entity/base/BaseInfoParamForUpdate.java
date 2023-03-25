package cn.charlie.transaction.entity.base;

import java.io.Serializable;

/**
 * @author charlie
 * @date 3/23/2023 9:52 PM
 **/
public class BaseInfoParamForUpdate implements Serializable {
    private static final long serialVersionUID = -8869921264488006092L;

    private BaseInfoParam baseInfoFirstParam;
    private BaseInfoParam baseInfoSecondParam;

    public BaseInfoParam getBaseInfoFirstParam() {
        return baseInfoFirstParam;
    }

    public void setBaseInfoFirstParam(BaseInfoParam baseInfoFirstParam) {
        this.baseInfoFirstParam = baseInfoFirstParam;
    }

    public BaseInfoParam getBaseInfoSecondParam() {
        return baseInfoSecondParam;
    }

    public void setBaseInfoSecondParam(BaseInfoParam baseInfoSecondParam) {
        this.baseInfoSecondParam = baseInfoSecondParam;
    }
}