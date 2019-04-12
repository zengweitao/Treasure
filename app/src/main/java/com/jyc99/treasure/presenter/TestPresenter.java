package com.jyc99.treasure.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.jyc99.treasure.model.LunBoTuEntity;
import com.jyc99.treasure.api.UserNetWork;
import com.jyc99.treasure.mvpBase.BasePresenterImpl;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *  P层示例
 * 创建时间:  2019/4/7 on 11:17
 *
 */
public class TestPresenter extends BasePresenterImpl<TestContact.view> implements TestContact.presenter {
    private Activity mActivity;

    public TestPresenter(TestContact.view view, Activity activity) {
        super(view);
        mActivity = activity;
    }

    /**
     * 获取数据
     */
    @Override
    public void getData(HashMap<Object, Object> map, String tag) {
        UserNetWork userNetWork = new UserNetWork();
        if ("first".equals(tag)) {
            getLunBoTu(userNetWork);
        } else if ("".equals(tag)) {

        }
    }

    /**
     * 轮播图的网络请求
     *
     * @param userNetWork
     */
    private void getLunBoTu(UserNetWork userNetWork) {
        userNetWork.toGetLunBoTuEntity(new Observer<LunBoTuEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
                //用于Activity销毁时清除所有的网络请求
                addDisposable(d);
            }

            @Override
            public void onNext(LunBoTuEntity lunBoTuEntity) {
                if (lunBoTuEntity.isSuccess()) {
                    view.setData(lunBoTuEntity, "LunBoTu");
                    view.showLoadingDialog("成功");
                    Toast.makeText(mActivity, "请求成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mActivity, "请求失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
                view.ErrorData(e);
                view.dismissLoadingDialog();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
