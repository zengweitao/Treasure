package com.jyc99.treasure.utils;

import com.jyc99.treasure.model.TradeSimpleResult;

/**
 * Created by dell on 2017/12/1.
 */

public abstract class MyAutonymListener  {
  public void onSuccessful(TradeSimpleResult accountInfoEntity){}
  public void onFailure(){}
}
