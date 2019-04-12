package com.jyc99.treasure;

/**
 * 先主要用于检测无线
 */
public class AppConfig {
    public static final double VERSION = 1.0;

    /**
     * 错误处理广播
     */
    public static final String RECEIVER_ERROR = AppConfig.class.getName()
            + "org.kymjs.android.frame.error";
    /**
     * 无网络警告广播
     */
    public static final String RECEIVER_NOT_NET_WARN = AppConfig.class.getName()
            + "org.kymjs.android.frame.notnet";
    /**
     * preference键值对
     */

    //preference保存登录状态userId的key
    public static final String PREFER_USERID_TAG = "userId";
    //登录状态token的key
    public static final String PREFER_TOKEN_TAG="token";
    //最近使用手机号ltphone的key
    public static final String PREFER_LTPHONE_TAG="ltphone";
    //后台返回用户手机号
    public static final String PREFER_LOGINPHONE_TAG="loginPhone";
    //preference保存登录userRecommendCode的key
    public static final String USER_RECOMMEND_CODE = "userRecommendCode";
    //用户是否设置了手势密码
    //public static final String PREFER_ISSET_GESTUREKEY_TAG="isset_geskey";
    //是否启用指纹解锁
    public static final String IS_PREFER_FINGERPRINT_ENABLE="isFingerPrintEnable";//指纹解锁和手势解锁只能启用其中一个
    //手势密码值
    public static final String PREFER_GESTUREKEY_TAG="gesturekey";
    //用户头像
    public static final String PREFER_USER_HEAD_URL="head_url";
    //是否启用手势解锁
    public static final String IS_PREFER_GESTURE_ENABLE="isGestureEnable";
    //是否实名认证
    public static final String PREFER_IS_REALNAME ="realName";
    //是否运营商授权
    public static final String PREFER_IS_AUTH="auth";
    //用户类型 用户类型[1_个人,2_企业]
    public static final String PREFER_IS_USERTYPE="userType";
    //开户状态(是否开户)
    public static final String PREFER_IS_ACCOUNTOPEN="accountOpen";
    //开户审核中状态(是否开户)
    public static final String PREFER_IS_ACCOUNTSTATUS="accountStatus";
    /***************************身份证是别的key和secort********************************/
    public static final String ID_CARD_API_KEY = "5a48e8b919c84dd39fd5af7bcdec7a56";
    public static final String ID_CARD_API_SECRET = "b59116ab63934efa950013e1a86d87d6";
    /**************************人脸识别的key和secort**********************/
    public static final String FACE_API_KEY = "5a48e8b919c84dd39fd5af7bcdec7a56";
    public static final String FACE_API_SECRET = "b59116ab63934efa950013e1a86d87d6";
    //HotFix私人秘钥
    public static final String HOTFIXAESKEY="sky1234567890sky";
    //是否需要杀死热更新进程:true-需要重启 false-不需要重启
    public static final String HOTFIXAE_ISRESTART="isRestart";
    //告客户书
    public static final String SHOW_GAO_KE_HU_SHU ="gaoKeHuShu";
    //百度定位经度
    public static final String BAIDU_LONGITUDE ="longitude";
    //百度定位纬度
    public static final String BAIDU_LATITUDE ="latitude";
    //百度定位详细地址
    public static final String BAIDU_ADDRSTR ="AddrStr";
    //身份证识别--身份证正面照的地址
    public static final String IDCARD_FRONT_ADDRSTR ="idCard_front_addrstr";

}
