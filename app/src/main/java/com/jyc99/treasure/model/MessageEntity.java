package com.jyc99.treasure.model;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 2018/11/6.
 */

public class MessageEntity extends TradeSimpleResult implements Serializable {


    /**
     * Result : {"list":[{"Id":"22222222222","MessageContent":"工商银行","MessageType":"工商银行","ReadStatus":"工商银行","PushTime":"工商银行","MessageTypeDesc":"工商银行","PushStatusDesc":"工商银行"}],"totalRecord":"1111111111","unReadCount":"111111111111"}
     */

    private ResultBean Result;

    public ResultBean getResult() {
        return Result;
    }

    public void setResult(ResultBean Result) {
        this.Result = Result;
    }

    public static class ResultBean {
        /**
         * list : [{"Id":"22222222222","MessageContent":"工商银行","MessageType":"工商银行","ReadStatus":"工商银行","PushTime":"工商银行","MessageTypeDesc":"工商银行","PushStatusDesc":"工商银行"}]
         * totalRecord : 1111111111
         * unReadCount : 111111111111
         */

        private String totalRecord;
        private String unReadCount;
        private List<ListBean> list;

        public String getTotalRecord() {
            return totalRecord;
        }

        public void setTotalRecord(String totalRecord) {
            this.totalRecord = totalRecord;
        }

        public String getUnReadCount() {
            return unReadCount;
        }

        public void setUnReadCount(String unReadCount) {
            this.unReadCount = unReadCount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * Id : 22222222222
             * MessageContent : 工商银行
             * MessageType : 工商银行
             * ReadStatus : 工商银行
             * PushTime : 工商银行
             * MessageTypeDesc : 工商银行
             * PushStatusDesc : 工商银行
             */

            private String Id;
            private String MessageContent;
            private String MessageType;
            private String ReadStatus;
            private String PushTime;
            private String MessageTypeDesc;
            private String PushStatusDesc;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getMessageContent() {
                return MessageContent;
            }

            public void setMessageContent(String MessageContent) {
                this.MessageContent = MessageContent;
            }

            public String getMessageType() {
                return MessageType;
            }

            public void setMessageType(String MessageType) {
                this.MessageType = MessageType;
            }

            public String getReadStatus() {
                return ReadStatus;
            }

            public void setReadStatus(String ReadStatus) {
                this.ReadStatus = ReadStatus;
            }

            public String getPushTime() {
                return PushTime;
            }

            public void setPushTime(String PushTime) {
                this.PushTime = PushTime;
            }

            public String getMessageTypeDesc() {
                return MessageTypeDesc;
            }

            public void setMessageTypeDesc(String MessageTypeDesc) {
                this.MessageTypeDesc = MessageTypeDesc;
            }

            public String getPushStatusDesc() {
                return PushStatusDesc;
            }

            public void setPushStatusDesc(String PushStatusDesc) {
                this.PushStatusDesc = PushStatusDesc;
            }
        }
    }
}
