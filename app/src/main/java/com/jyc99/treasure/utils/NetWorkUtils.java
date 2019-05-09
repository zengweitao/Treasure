package com.jyc99.treasure.utils;

import android.app.Activity;
import com.jyc99.treasure.model.TradeSimpleResult;

public class NetWorkUtils {
    public static void tokens(final Activity activity, final String url) {
        AutonymUtils.refreshToken(activity, new MyAutonymListener() {
            @Override
            public void onSuccessful(TradeSimpleResult accountInfoEntity) {
                //TODO 将拿到新的token重新放置在请求头的 Authorization里,我这边是将token加密存储在本地，然后在OkHttp3Utils里取出token放置在请求头里
                //TODO 小伙伴如果需要存储加密代码，可以私信我，我的微信是：18738523758，加我时请加备注，谢谢！
                String userToken = accountInfoEntity.getUserToken();
                //todo 下一步就是加密存储在本地，然后在OkHttp3Utils里取出token放置在请求头里
            }

            @Override
            public void onFailure() {
                super.onFailure();
            }
        });
    }
}
