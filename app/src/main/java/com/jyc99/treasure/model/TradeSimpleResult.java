package com.jyc99.treasure.model;

import java.io.Serializable;

/**
 * Created by zeng on 2017/9/20.
 * Introduction: 交易系统基础返回实体类
 */

public class TradeSimpleResult implements Serializable{

  /**
   * Success : false
   * StatusCode : 500
   * Message : 处理失败
   * ErrorInfo : {"ErrorMessage":"请输入真实的身份证姓名信息","ErrorCode":"-1"}
   */

  private boolean Success;
  private int StatusCode;
  private String Message;
  private ErrorInfoBean ErrorInfo;
  private String userToken;

  public String getUserToken() {
    return userToken;
  }

  public void setUserToken(String userToken) {
    this.userToken = userToken;
  }

  public boolean isSuccess() {
    return Success;
  }

  public void setSuccess(boolean Success) {
    this.Success = Success;
  }

  public int getStatusCode() {
    return StatusCode;
  }

  public void setStatusCode(int StatusCode) {
    this.StatusCode = StatusCode;
  }

  public String getMessage() {
    return Message;
  }

  public void setMessage(String Message) {
    this.Message = Message;
  }

  public ErrorInfoBean getErrorInfo() {
    return ErrorInfo;
  }

  public void setErrorInfo(ErrorInfoBean ErrorInfo) {
    this.ErrorInfo = ErrorInfo;
  }

  public static class ErrorInfoBean {
    /**
     * ErrorMessage : 请输入真实的身份证姓名信息
     * ErrorCode : -1
     */

    private String ErrorMessage;
    private String ErrorCode;

    public String getErrorMessage() {
      return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
      this.ErrorMessage = ErrorMessage;
    }

    public String getErrorCode() {
      return ErrorCode;
    }

    public void setErrorCode(String ErrorCode) {
      this.ErrorCode = ErrorCode;
    }
  }
}

