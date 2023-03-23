package cn.charlie.transaction.enums;

import cn.charlie.transaction.entity.result.ResultCode;

/**
 * @author charlie
 * @date 3/22/2023 7:27 PM
 **/
public enum SystemCodeEnum implements ResultCode {
    SUCCESS(0, "操作成功"),
    OPERATE_ERROR(1, "操作失败"),
    NO_ACCOUNT(2, "账号不存在"),
    NO_LOGIN(3, "请先登录"),
    SYSTEM_ERROR(4, "系统错误，请联系管理员"),
    SYSTEM_BUSY(5, "系统繁忙，请稍后再试"),
    INNER_INVOKE_ERROR(6, "内部调用失败"),
    CREDENTIALS_ERROR(7, "登录凭证错误或已过期，请重新登录"),
    CID_CREDENTIALS_ERROR(8, "设备使用的凭证错误，请重新登录"),
    KICK_OUT(9, "您已经在其他地方登录，请重新登录"),
    NO_SUCH_PARAMETER_ERROR(10, "参数不存在");

    private final int code;
    private final String msg;

    private SystemCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public static String getNameByCode(Integer code) {
        if (code == null) {
            return null;
        } else {
            SystemCodeEnum[] var1 = values();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                SystemCodeEnum systemCodeEnum = var1[var3];
                if (code == systemCodeEnum.getCode()) {
                    return systemCodeEnum.getMsg();
                }
            }

            return null;
        }
    }

    public static SystemCodeEnum getEnumByCode(Integer code) {
        if (code == null) {
            return null;
        } else {
            SystemCodeEnum[] var1 = values();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                SystemCodeEnum systemCodeEnum = var1[var3];
                if (code == systemCodeEnum.getCode()) {
                    return systemCodeEnum;
                }
            }

            return null;
        }
    }
}
