package com.jyc99.treasure.model;


import java.io.Serializable;
import java.util.List;

/**
 * Created by zeng on 2019/1/8.
 */

public class UserRechargeWay extends TradeSimpleResult implements Serializable {

  /**
   * arguments : []
   * datas : {"picurls":[{"code":"app_icon_picurl_hkrl","content":"","desc":"\u2018回款日历\u2019右上角小标签图片地址","enable":false,"iconflag":false,"id":4,"picUrl":"","system":0},{"code":"app_icon_picurl_wdfl","content":"","desc":"\u2019我的福利\u2018右上角小标签图片地址","enable":false,"iconflag":false,"id":5,"picUrl":"","system":0},{"code":"app_icon_picurl_wdyq","content":"","desc":"\u2019我的邀请\u2018右上角小标签图片地址","enable":false,"iconflag":false,"id":6,"picUrl":"","system":0},{"code":"app_icon_picurl_wdyy","content":"","desc":"\u2019我的预约\u2018右上角小标签图片地址","enable":false,"iconflag":false,"id":7,"picUrl":"","system":0},{"code":"app_icon_picurl_szmx","content":"","desc":"\u2019收支明细\u2018右上角小标签图片地址","enable":false,"iconflag":false,"id":8,"picUrl":"www.taobao.com","system":0},{"code":"app_icon_picurl_zqzr","content":"","desc":"\u2018债权转让\u2019右上角小标签图片地址","enable":false,"iconflag":false,"id":9,"picUrl":"www.baidu.com","system":0},{"code":"app_icon_picurl_grzx","content":"","desc":"\u2018个人中心\u2019右上角小标签图片地址","enable":false,"iconflag":false,"id":10,"picUrl":"","system":0}],"result":true}
   * message :
   * statusCode :
   * timeMillis : 1549963630023
   */

  private DatasBean datas;
  private String message;
  private int statusCode;
  private long timeMillis;
  private List<?> arguments;

  public DatasBean getDatas() {
    return datas;
  }

  public void setDatas(DatasBean datas) {
    this.datas = datas;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public long getTimeMillis() {
    return timeMillis;
  }

  public void setTimeMillis(long timeMillis) {
    this.timeMillis = timeMillis;
  }

  public List<?> getArguments() {
    return arguments;
  }

  public void setArguments(List<?> arguments) {
    this.arguments = arguments;
  }

  public static class DatasBean {
    /**
     * picurls : [{"code":"app_icon_picurl_hkrl","content":"","desc":"\u2018回款日历\u2019右上角小标签图片地址","enable":false,"iconflag":false,"id":4,"picUrl":"","system":0},{"code":"app_icon_picurl_wdfl","content":"","desc":"\u2019我的福利\u2018右上角小标签图片地址","enable":false,"iconflag":false,"id":5,"picUrl":"","system":0},{"code":"app_icon_picurl_wdyq","content":"","desc":"\u2019我的邀请\u2018右上角小标签图片地址","enable":false,"iconflag":false,"id":6,"picUrl":"","system":0},{"code":"app_icon_picurl_wdyy","content":"","desc":"\u2019我的预约\u2018右上角小标签图片地址","enable":false,"iconflag":false,"id":7,"picUrl":"","system":0},{"code":"app_icon_picurl_szmx","content":"","desc":"\u2019收支明细\u2018右上角小标签图片地址","enable":false,"iconflag":false,"id":8,"picUrl":"www.taobao.com","system":0},{"code":"app_icon_picurl_zqzr","content":"","desc":"\u2018债权转让\u2019右上角小标签图片地址","enable":false,"iconflag":false,"id":9,"picUrl":"www.baidu.com","system":0},{"code":"app_icon_picurl_grzx","content":"","desc":"\u2018个人中心\u2019右上角小标签图片地址","enable":false,"iconflag":false,"id":10,"picUrl":"","system":0}]
     * result : true
     */

    private boolean result;
    private List<PicurlsBean> picurls;

    public boolean isResult() {
      return result;
    }

    public void setResult(boolean result) {
      this.result = result;
    }

    public List<PicurlsBean> getPicurls() {
      return picurls;
    }

    public void setPicurls(List<PicurlsBean> picurls) {
      this.picurls = picurls;
    }

    public static class PicurlsBean {
      /**
       * code : app_icon_picurl_hkrl
       * content :
       * desc : ‘回款日历’右上角小标签图片地址
       * enable : false
       * iconflag : false
       * id : 4
       * picUrl :
       * system : 0
       */

      private String code;
      private String content;
      private String desc;
      private boolean enable;
      private boolean iconflag;
      private int id;
      private String picUrl;
      private int system;

      public String getCode() {
        return code;
      }

      public void setCode(String code) {
        this.code = code;
      }

      public String getContent() {
        return content;
      }

      public void setContent(String content) {
        this.content = content;
      }

      public String getDesc() {
        return desc;
      }

      public void setDesc(String desc) {
        this.desc = desc;
      }

      public boolean isEnable() {
        return enable;
      }

      public void setEnable(boolean enable) {
        this.enable = enable;
      }

      public boolean isIconflag() {
        return iconflag;
      }

      public void setIconflag(boolean iconflag) {
        this.iconflag = iconflag;
      }

      public int getId() {
        return id;
      }

      public void setId(int id) {
        this.id = id;
      }

      public String getPicUrl() {
        return picUrl;
      }

      public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
      }

      public int getSystem() {
        return system;
      }

      public void setSystem(int system) {
        this.system = system;
      }
    }
  }
}
