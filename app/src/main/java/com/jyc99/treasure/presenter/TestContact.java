package com.jyc99.treasure.presenter;

import com.jyc99.treasure.model.LunBoTuEntity;
import com.jyc99.treasure.mvpBase.BasePresenter;
import com.jyc99.treasure.mvpBase.BaseView;

import java.util.HashMap;

/*
 * 创建时间:  2019/4/7 on 11:13
 * 用于设置Presenter里设置数据和获取数据的方法
 */
public interface TestContact {

    interface view extends BaseView {
        /**
         * 设置数据
         * 用于网络请求成功失败后，回调给view的方法
         * @param lunBoTuEntity
         */
        void setData(LunBoTuEntity lunBoTuEntity, String tag);

        void ErrorData(Throwable e);
    }

    interface presenter extends BasePresenter {
        /**
         * 获取数据
         * 用于view层发起网络请求，获取数据
         */
        void getData(HashMap<Object, Object> map, String tag);
    }
}
