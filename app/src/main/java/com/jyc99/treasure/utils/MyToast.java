package com.jyc99.treasure.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jyc99.treasure.R;


public class MyToast extends Toast {
    public MyToast(Context context) {
        super(context);
    }

    private static Toast mToast = null;
//    public static void showToast(Context context, String text, int duration) {
//        if (mToast == null) {
//            mToast = new Toast(context);
//        }
//        mToast.setText(text);
//        mToast.setDuration(duration);
//        mToast.show();
//    }

    //自定义样式的Toast
    public static void showMyToast(Context context, String text, int duration) {
        if (context != null) {

            View view = View.inflate(context, R.layout.toast_text, null);
            TextView tv_toast = (TextView) view.findViewById(R.id.tv_toast);
            if (mToast == null) {
                mToast = new Toast(context);
            }
            mToast.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 180);
            tv_toast.setText(text);
            mToast.setDuration(duration);
            mToast.setView(view);
            mToast.show();

        }
    }

    public static void showSimpleShortToast(Context context, String text, int duration) {
        if (context != null) {

            View view = View.inflate(context, R.layout.toast_text, null);
            TextView tv_toast = (TextView) view.findViewById(R.id.tv_toast);
            if (mToast == null) {
                mToast = new Toast(context);
            }
            mToast.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 180);
            tv_toast.setText(text);
            mToast.setDuration(duration);
            mToast.setView(view);
            mToast.show();

        }
    }

    //自定义样式的Toast
    public static void showMyToast2(Context context, String text, int duration) {
        View view = View.inflate(context, R.layout.toast_text, null);
        TextView tv_toast = (TextView) view.findViewById(R.id.tv_toast);
        if (mToast == null) {
            mToast = new Toast(context);
        }
        mToast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
        tv_toast.setText(text);
        mToast.setDuration(duration);
        mToast.setView(view);
        mToast.show();

    }

    //带图标的Toast--成功
    public static void showMyToastIconOk(Context context, String text, int duration) {
        View view = View.inflate(context, R.layout.toast_text_icon, null);
        TextView tv_toast = (TextView) view.findViewById(R.id.tv_toast_text);
        if (mToast == null) {
            mToast = new Toast(context);
        }
        mToast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
        tv_toast.setText(text);
        mToast.setDuration(duration);
        mToast.setView(view);
        mToast.show();
    }

    //带图标的Toast--失败
    public static void showMyToastIconError(Context context, String text, int duration) {
        View view = View.inflate(context, R.layout.toast_text_icon, null);
        TextView tv_toast = (TextView) view.findViewById(R.id.tv_toast_text);
        ImageView icon_toast=(ImageView) view.findViewById(R.id.tv_toast_icon);
        icon_toast.setImageResource(R.mipmap.ic_toast_error);
        if (mToast == null) {
            mToast = new Toast(context);
        }
        mToast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
        tv_toast.setText(text);
        mToast.setDuration(duration);
        mToast.setView(view);
        mToast.show();
    }

}
