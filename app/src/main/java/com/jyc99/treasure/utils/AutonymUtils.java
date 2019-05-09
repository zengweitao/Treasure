package com.jyc99.treasure.utils;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jyc99.treasure.api.UserNetWork;
import com.jyc99.treasure.model.TradeSimpleResult;

import java.net.URLEncoder;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zeng on 2019/5/5.
 */

public class AutonymUtils {
    /**
     * 刷新token
     *
     * @param activity
     * @param myAutonymListeners
     */

    public static void refreshToken(Activity activity, final MyAutonymListener myAutonymListeners) {
        UserNetWork userNetWork = new UserNetWork();
        HashMap<String, Object> map = new HashMap<>();
        userNetWork.getUserRecordEntity(map, new Observer<TradeSimpleResult>() {
            @Override
            public void onSubscribe(Disposable d) {
                //取消网络请求
                //d.dispose();
            }

            @Override
            public void onNext(TradeSimpleResult tradeSimpleResult) {
                if (tradeSimpleResult.isSuccess()) {
                    //网络请求成功
                    myAutonymListeners.onSuccessful(tradeSimpleResult);
                } else {
                    myAutonymListeners.onFailure();
                }
            }

            @Override
            public void onError(Throwable e) {
                //网络请求失败
                myAutonymListeners.onFailure();
            }

            @Override
            public void onComplete() {
                //网络请求完成
            }
        });
    }
}
