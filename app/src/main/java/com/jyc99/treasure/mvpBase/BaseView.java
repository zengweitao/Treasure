package com.jyc99.treasure.mvpBase;

/*
 * 总的view层，用来统一显示dialog，toast
 * 创建时间:  2019/4/9 on 14:16
 */
public interface BaseView {

    void showLoadingDialog(String msg);

    void dismissLoadingDialog();
}
