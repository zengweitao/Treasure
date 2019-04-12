package com.jyc99.treasure.model;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 2018/11/7.
 */

public class LunBoTuEntity extends TradeSimpleResult implements Serializable {


    /**
     * Result : {"list":[{"orderNo":1,"imageUrl":"http://192.168.1.39:10010/UpLoadFile/LargerPhoto/20181107120046.jpg","pageUrl":"https://tieba.baidu.com","shareUrl":"https://www.baidu.com","content":""},{"orderNo":2,"imageUrl":"http://192.168.1.39:10010/UpLoadFile/LargerPhoto/20181107140855.jpg","pageUrl":"https://tieba.baidu.com","shareUrl":"","content":""}]}
     */

    private ResultBean Result;

    public ResultBean getResult() {
        return Result;
    }

    public void setResult(ResultBean Result) {
        this.Result = Result;
    }

    public static class ResultBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * orderNo : 1
             * imageUrl : http://192.168.1.39:10010/UpLoadFile/LargerPhoto/20181107120046.jpg
             * pageUrl : https://tieba.baidu.com
             * shareUrl : https://www.baidu.com
             * content :
             */

            private int orderNo;
            private String imageUrl;
            private String pageUrl;
            private String shareUrl;
            private String content;

            public int getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(int orderNo) {
                this.orderNo = orderNo;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getPageUrl() {
                return pageUrl;
            }

            public void setPageUrl(String pageUrl) {
                this.pageUrl = pageUrl;
            }

            public String getShareUrl() {
                return shareUrl;
            }

            public void setShareUrl(String shareUrl) {
                this.shareUrl = shareUrl;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
