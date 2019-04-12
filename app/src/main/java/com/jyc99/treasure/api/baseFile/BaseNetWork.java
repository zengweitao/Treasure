package com.jyc99.treasure.api.baseFile;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zeng on 2019/4/10.
 */

public class BaseNetWork extends RetrofitUtils{

    /**https://github.com/r17171709/Retrofit2Demo
     * 插入观察者
     * @param observable
     * @param observer
     * @param <T>
     */
    public  <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }
}
