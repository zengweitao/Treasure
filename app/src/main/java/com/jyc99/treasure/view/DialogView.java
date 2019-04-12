package com.jyc99.treasure.view;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jyc99.treasure.R;

/**
 * Created by zeng on 2016/9/18.
 */
public abstract class DialogView extends CustomDialog {
  private Context mContext;
  private int tag = 0;//0是取消 1是确定
  public static final int OK_BUTTON_CLICK = 1;
  public static final int CANCEL_BUTTON_CLICK = 0;

  public DialogView(Context context, int width, int height, int layout, int style) {
    super(context, width, height, layout, style);
    this.setOnDismissListener(new DialogInterface.OnDismissListener() {
      @Override
      public void onDismiss(DialogInterface dialog) {
        isdismiss(tag);
      }
    });
  }

  public DialogView(Context context, int layout, int style) {
    super(context, layout, style);
    this.setOnDismissListener(new DialogInterface.OnDismissListener() {
      @Override
      public void onDismiss(DialogInterface dialog) {
        isdismiss(tag);
      }
    });
  }

  public DialogView(Context context) {
    super(context, R.layout.my_dialog, R.style.dialog);
    this.setOnDismissListener(new DialogInterface.OnDismissListener() {
      @Override
      public void onDismiss(DialogInterface dialog) {
        isdismiss(tag);
      }
    });
  }

  public abstract void isdismiss(int tag);

  public void showdialog2(String title, String boby, String text_cancel, String text_ok) {

    TextView dialog_title = (TextView) this
      .findViewById(R.id.dialog_title);
    TextView dialog_message = (TextView) this
      .findViewById(R.id.dialog_message);
    TextView dialog_ok = (TextView) this.findViewById(R.id.dialog_ok);
    TextView dialog_cancel = (TextView) this
      .findViewById(R.id.dialog_cancel);
    ImageView include_hine = (ImageView) this.findViewById(R.id.include_hine);
    if (!TextUtils.isEmpty(text_cancel)) {
      dialog_cancel.setVisibility(View.VISIBLE);
      dialog_cancel.setText(text_cancel);
      dialog_cancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          tag = CANCEL_BUTTON_CLICK;
          DialogView.this.dismiss();
        }
      });
    } else {
      dialog_cancel.setVisibility(View.GONE);
      include_hine.setVisibility(View.GONE);

    }
    dialog_title.setText(title);
    dialog_message.setText(boby);
    if (!TextUtils.isEmpty(text_ok)) {
      dialog_ok.setVisibility(View.VISIBLE);
      dialog_ok.setText(text_ok);
      dialog_ok.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          tag = OK_BUTTON_CLICK;
          DialogView.this.dismiss();
        }
      });
    } else {
      dialog_ok.setVisibility(View.GONE);
      include_hine.setVisibility(View.GONE);
    }

    this.show();
  }


}
