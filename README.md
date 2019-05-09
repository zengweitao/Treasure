# Treasure
5.9号新增
    添加token过期自动刷新token，刷新后再请求一次接口的功能;
/****************************************************************/

1.该框架为MVP+retrofit2+rxjava2+rxandroid+okhttp3+Lifecycle 的网络框架，结合了Google官方AAC（Android Architecture Components），实现生命周期的管理。

2.同时可以应对项目多个BaseUrl的网络请求，针对对接多业务方灵活取用

3.自定义拦截器，可以动态的设置请求头里的参数，对返回的code码做同一封装处理。同时对接口返回的error，做统一处理，以下是错误的统一处理：
public class ErrorHandler {
    private static String data = "{\"Success\": false,\"StatusCode\": 500,\"Message\": \"处理失败\", \"ErrorInfo\":            {\"ErrorMessage\": \"网络请求错误\",\"ErrorCode\": \"404\" },\"Result\": null}";

    public static TradeSimpleResult handle(Throwable throwable) {
        if (throwable instanceof HttpException) {
            HttpException error = (HttpException) throwable;
            try {
                String string = error.response().errorBody().string();
                if (isJSONValid(string)) {
                    return new Gson().fromJson(string, TradeSimpleResult.class);
                } else {
                    return new Gson().fromJson(data, TradeSimpleResult.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            throwable.printStackTrace();
            return null;
        }
    }

    public static String errorMessage(Throwable e) {
        TradeSimpleResult errBody = ErrorHandler.handle(e);
        if (errBody != null) {
            final Activity activity = AppManager.topActivity();
            //用户类型
            final String userType = PreferenceHelper.readString(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.PREFER_IS_USERTYPE, "");
            String errorCode = errBody.getErrorInfo().getErrorCode();
            if (activity != null && !activity.isDestroyed()) {
                if ("401".equals(errorCode)) {
                    //token失效了
                    try {
                        PreferenceHelper.write(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.PREFER_TOKEN_TAG, "");
                        DialogView dialogView = new DialogView(activity, 180, 180, R.layout.my_dialog, R.style.dialog) {
                            @Override
                            public void isdismiss(int tag) {
                                if (tag == DialogView.CANCEL_BUTTON_CLICK) {
//                                    activity.startActivity(new Intent(activity, RoleChangeActivity.class));
                                }
                            }
                        };
                        dialogView.showdialog2("温馨提示", "登录失效，请重新登录", "去登录", "");
                    } catch (Exception es) {
                        es.printStackTrace();
                    }
                }
            }
            return errBody.getErrorInfo().getErrorMessage();
        }
        return "";
    }

    public final static boolean isJSONValid(String jsonInString) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
