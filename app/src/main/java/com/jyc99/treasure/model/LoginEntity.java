package com.jyc99.treasure.model;


import java.io.Serializable;

/**
 * Created by zeng on 2018/10/20.
 */

public class LoginEntity extends TradeSimpleResult implements Serializable {

    private ResultBean Result;

    public ResultBean getResult() {
        return Result;
    }

    public void setResult(ResultBean Result) {
        this.Result = Result;
    }

    public static class ResultBean {
        /**
         * accessToken : 执行失败
         */

        private String  Token;

        public String getToken() {
            return  Token;
        }

        public void setToken(String Token) {
            this.Token = Token;
        }
    }
}
