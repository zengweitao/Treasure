package com.jyc99.treasure.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.jyc99.treasure.R;
import com.jyc99.treasure.base.LifecycleBaseActivity;
import com.jyc99.treasure.model.LunBoTuEntity;
import com.jyc99.treasure.presenter.TestContact;
import com.jyc99.treasure.presenter.TestPresenter;
import com.jyc99.treasure.utils.ErrorHandler;
import com.jyc99.treasure.utils.StringUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends LifecycleBaseActivity<TestContact.presenter> implements TestContact.view {

    private TextView textView;
    private HashMap<Object, Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = new HashMap<>();
        initView();
        initData();

    }

    private void initData() {
        presenter.getData(map, "first");
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.main_text);
    }

    /**
     * 初始化presenter
     *
     * @return 对应的presenter
     */
    @Override
    public TestContact.presenter initPresenter() {
        return new TestPresenter(this, MainActivity.this);
    }

    /**
     * 设置数据
     * 刷新界面
     *
     * @param lunBoTuEntity 数据源
     */
    @Override
    public void setData(LunBoTuEntity lunBoTuEntity, String tag) {
//        list.addAll(dataList);
//        adapter.notifyDataSetChanged();
        if ("LunBoTu".equals(tag)) {
            String imageUrl = lunBoTuEntity.getResult().getList().get(0).getImageUrl();
            System.out.println("图片地址:" + imageUrl);
        }
    }

    @Override
    public void ErrorData(Throwable e) {

    }

    @Override
    public void showLoadingDialog(String msg) {
        textView.setText(msg);
    }

    @Override
    public void dismissLoadingDialog() {

    }

}
