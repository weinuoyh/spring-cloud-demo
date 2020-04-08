package com.jwt.Constant;

public enum TokenEnum {
    /** 过期 */
    EXPIRED("EXPIRED"),

    /** 无效(token不合法) */
    INVALID("INVALID"),

    /** 有效的 */
    VALID("VALID");

    private String state;

    TokenEnum(String state) {
        this.state = state;
    }

    /**
     * 根据状态字符串获取token状态枚举对象
     * @param tokenState
     * @return TokenState
     */
    public static TokenEnum getTokenState(String tokenState) {
        TokenEnum[] states = TokenEnum.values();
        TokenEnum ts = null;
        for(TokenEnum state : states) {
            if(state.toString().equals(tokenState)) {
                ts = state;
                break;
            }
        }
        return ts;
    }

    @Override
    public String toString() {
        return this.state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
