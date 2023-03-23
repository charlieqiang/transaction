package cn.charlie.transaction.entity.base;

/**
 * @author charlie
 * @date 3/23/2023 9:52 PM
 **/
public class BaseInfoParam {
    /**
     * id
     */
    private Long baseId;

    /**
     * 编号
     */
    private String baseCode;

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }
}
