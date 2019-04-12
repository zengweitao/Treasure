package com.jyc99.treasure.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.jyc99.treasure.model.TradeSimpleResult;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作工具包<br>
 * <p/>
 * <b>创建时间</b> 2014-8-14
 *
 * @author kymjs (https://github.com/kymjs)
 * @version 1.1
 */
public class StringUtils {
  private final static Pattern emailer = Pattern
    .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
  private final static Pattern phone = Pattern
    .compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

  //^((?=.*[0-9])(?=.*[a-zA-Z!@#$%^&*()_+|{}?><\-\]\\[\/]).{6,16})|((?=.*[a-zA-Z])(?=.*[0-9!@#$%^&*()_+|{}?><\-\]\\[\/]).{6,16})|((?=.*[0-9a-zA-Z])(?=.*[!@#$%^&*()_+|{}?><\-\]\\[\/]).{6,16})$
  // 判断登录密码格式是否合法
  public static boolean isMiMa(String mima) {
    Pattern p = Pattern
//      .compile("^((?=.*[0-9])(?=.*[a-zA-Z\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\|\\{\\}\\?\\>\\<\\-\\]\\\\\\[\\/\\]]).{6,16})|((?=.*[a-zA-Z])(?=.*[0-9\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\|\\{\\}\\?\\>\\<\\-\\]\\\\\\[\\/\\]]).{6,16})|((?=.*[0-9a-zA-Z])(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\|\\{\\}\\?\\>\\<\\-\\]\\\\\\[\\/\\]]).{6,20})$");
      .compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$");
    Matcher m = p.matcher(mima);
    return m.matches();
  }

  /**
   * 判断给定字符串是否空白串 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
   */
  public static boolean isEmpty(CharSequence input) {
    if (input == null || "".equals(input))
      return true;

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
        return false;
      }
    }
    return true;
  }

  //显示金额
  public static String showMoney(int money) {
    DecimalFormat decimalFormat = new DecimalFormat("###,###");
    return decimalFormat.format(money);
  }

  //显示金额小数点两位
  public static String showMoney(double money) {
    NumberFormat nf= NumberFormat.getInstance();
    nf.setGroupingUsed(false);
    DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
    return decimalFormat.format(Double.valueOf(formateRate(nf.format(money),2)));
  }

  //显示金额小数点两位
  public static String showMoney2(double money) {
    NumberFormat nf= NumberFormat.getInstance();
    nf.setGroupingUsed(false);
    DecimalFormat decimalFormat = new DecimalFormat("######.##");
    return decimalFormat.format(Double.valueOf(formateRate(nf.format(money),2)));
  } //显示金额小数点两位

  //显示金额小数点两位
  public static String showMoney3(double money) {
    NumberFormat nf= NumberFormat.getInstance();
    nf.setGroupingUsed(false);
    DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
    return decimalFormat.format(Double.valueOf(formateRate(nf.format(money),2)));
  } //显示金额小数点两位

  public static String showMoney2(String money) {
    try {
      if (isDouble(money)) {
        money=formateRate(money,2);
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
        return decimalFormat.format(Double.parseDouble(money));
      } else {
        return money;
      }
    } catch (Exception e) {
      return money;
    }
  }

  //显示金额小数点两位
  public static String showMoney(String money) {
    if (!TextUtils.isEmpty(money)) {
      try {
        if (isDouble(money)) {
          money=formateRate(money,2);
          DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
          return decimalFormat.format(Double.parseDouble(money));
        } else {
          return money;
        }
      } catch (Exception e) {
        return money;
      }
    } else {
      return money;
    }
  }
//显示金额小数点两位
  public static String showMoney5(String money) {
    if (!TextUtils.isEmpty(money)) {
      try {
        if (isDouble(money)) {
          money=formateRate(money,2);
          DecimalFormat decimalFormat = new DecimalFormat("#####0.00");
          return decimalFormat.format(Double.parseDouble(money));
        } else {
          return money;
        }
      } catch (Exception e) {
        return money;
      }
    } else {
      return money;
    }
  }

  public static String showMoney4(String money) {
    try {
      if (isDouble(money)) {
        money=formateRate(money,2);
        DecimalFormat decimalFormat = new DecimalFormat("######.##");
        return decimalFormat.format(Double.parseDouble(money));
      } else {
        return money;
      }
    } catch (Exception e) {
      return money;
    }
  }

  //显示金额小数点两位
  public static String showMoney3(String money) {
    if (!TextUtils.isEmpty(money)) {
      money=formateRate(money,2);
      try {
        if (isDouble(money)) {
          DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
          return decimalFormat.format(Double.parseDouble(money));
        } else {
          return money;
        }
      } catch (Exception e) {
        return money;
      }
    } else {
      return money;
    }

  }

  public static String formateRate(String rateStr, int tonum) {
    if (rateStr.indexOf(".") != -1) {
      //获取小数点的位置
      int num = 0;
      //找到小数点在字符串中的位置,找到返回一个int类型的数字,不存在的话返回 -1
      num = rateStr.indexOf(".");

      String dianAfter = rateStr.substring(0, num + 1);//输入100.30,dianAfter = 100.
      String afterData = rateStr.replace(dianAfter, "");//把原字符(rateStr)串包括小数点和小数点前的字符替换成"",最后得到小数点后的字符(不包括小数点)


      if (tonum==0){
        return rateStr.substring(0, num);
      }else {
        //判断小数点后字符的长度并做不同的操作,得到小数点后两位的字符串
        if (afterData.length() > tonum) {
          afterData = afterData.substring(0, tonum);
        }
        //返回元字符串开始到小数点的位置 + "." + 小数点后两位字符
        return rateStr.substring(0, num) + "." + afterData;
      }
    } else {
      return rateStr;
    }
  }


  public static String StrAddStr(String... strings) {
    StringBuilder s5 = new StringBuilder();
    for (String string : strings) {
      if (!TextUtils.isEmpty(string)) {
        s5.append(string);
      }
    }

    return s5.toString();
  }

  //将两个金额相减后小数点两位
  private static Double d_all;
  private static Double d_now;

  public static String transtion(String number_all, String number_already) {
    try {
      if (!StringUtils.isEmpty(number_all)) {
        d_all = Double.valueOf(number_all);
      } else {
        d_all = Double.valueOf("0.0");
      }
      if (!StringUtils.isEmpty(number_already)) {
        d_now = Double.valueOf(number_already);
      } else {
        d_now = Double.valueOf("0.0");
      }
      Double d_surplus = d_all - d_now;
      //转化后的剩余金额
      BigDecimal num_already = new BigDecimal(d_surplus.toString());
      String already_money = StringUtils.showMoney2(num_already.toString());
      return already_money;
    } catch (Exception e) {
      return "";
    }
  }

  /**
   * 提供精确的加法运算。
   *
   * @param v1 被加数
   * @param v2 加数
   * @return 两个参数的和
   */
  public static double add(double v1, double v2) {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.add(b2).doubleValue();
  }

  /**
   * 提供精确的减法运算。
   *
   * @param v1 被减数
   * @param v2 减数
   * @return 两个参数的差
   */
  public static double sub(double v1, double v2) {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.subtract(b2).doubleValue();
  }

  /**
   * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
   * 定精度，以后的数字四舍五入。
   *
   * @param v1    被除数
   * @param v2    除数
   * @param scale 表示表示需要精确到小数点以后几位。
   * @return 两个参数的商
   */
  public static double div(double v1, double v2, int scale) {
    if (scale < 0) {
      throw new IllegalArgumentException(
        "The scale must be a positive integer or zero");
    }
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
  }


  /**
   * 判断字符是否可以转换成double类型
   */
  public static boolean isDouble(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException ex) {
    }
    return false;
  }

  /**
   * 判断给定字符串是否空白串 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
   */
  public static boolean isEmpty(CharSequence... strs) {
    for (CharSequence str : strs) {
      if (isEmpty(str)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 判断是不是一个合法的电子邮件地址
   */
  public static boolean isEmail(CharSequence email) {
    if (isEmpty(email))
      return false;
    return emailer.matcher(email).matches();
  }

  /**
   * 判断是不是一个合法的手机号码
   */
  public static boolean isPhone(CharSequence phoneNum) {
    if (isEmpty(phoneNum))
      return false;
    return phone.matcher(phoneNum).matches();
  }

  public static boolean isSpace(String s) {
    return (s == null || s.trim().length() == 0);
  }

  /**
   * 返回当前系统时间
   */
  public static String getDataTime(String format) {
    SimpleDateFormat df = new SimpleDateFormat(format);
    return df.format(new Date());
  }

  /**
   * 字符串转整数
   *
   * @param str
   * @param defValue
   * @return
   */
  public static int toInt(String str, int defValue) {
    try {
      return Integer.parseInt(str);
    } catch (Exception e) {
    }
    return defValue;
  }

  /**
   * 对象转整
   *
   * @param obj
   * @return 转换异常返回 0
   */
  public static int toInt(Object obj) {
    if (obj == null)
      return 0;
    return toInt(obj.toString(), 0);
  }

  /**
   * String转long
   *
   * @param obj
   * @return 转换异常返回 0
   */
  public static long toLong(String obj) {
    try {
      return Long.parseLong(obj);
    } catch (Exception e) {
    }
    return 0;
  }

  /**
   * String转double
   *
   * @param obj
   * @return 转换异常返回 0
   */
  public static double toDouble(String obj) {
    try {
      return Double.parseDouble(obj);
    } catch (Exception e) {
    }
    return 0D;
  }

  /**
   * String转float
   *
   * @param obj
   * @return 转换异常返回 0
   */
  public static float toFloat(String obj) {
    if (!TextUtils.isEmpty(obj)) {
      try {
        return Float.parseFloat(obj);
      } catch (Exception e) {
        return 0f;
      }
    } else {
      return 0f;
    }

  }

  /**
   * 字符串转布尔
   *
   * @param b
   * @return 转换异常返回 false
   */
  public static boolean toBool(String b) {
    try {
      return Boolean.parseBoolean(b);
    } catch (Exception e) {
    }
    return false;
  }

  /**
   * 判断一个字符串是不是数字
   */
  public static boolean isNumber(CharSequence str) {
    try {
      Integer.parseInt(str.toString());
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * byte[]数组转换为16进制的字符串。
   *
   * @param data 要转换的字节数组。
   * @return 转换后的结果。
   */
  public static final String byteArrayToHexString(byte[] data) {
    StringBuilder sb = new StringBuilder(data.length * 2);
    for (byte b : data) {
      int v = b & 0xff;
      if (v < 16) {
        sb.append('0');
      }
      sb.append(Integer.toHexString(v));
    }
    return sb.toString().toUpperCase(Locale.getDefault());
  }

  /**
   * 16进制表示的字符串转换为字节数组。
   *
   * @param s 16进制表示的字符串
   * @return byte[] 字节数组
   */
  public static byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] d = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
      // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个进制字节
      d[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
        .digit(s.charAt(i + 1), 16));
    }
    return d;
  }

  private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
    @Override
    protected SimpleDateFormat initialValue() {
      return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
  };

  private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
    @Override
    protected SimpleDateFormat initialValue() {
      return new SimpleDateFormat("yyyy-MM-dd");
    }
  };

  /**
   * 以友好的方式显示时间
   *
   * @param sdate
   * @return
   */
  public static String friendlyTime(String sdate) {
    Date time = null;

    if (isInEasternEightZones()) {
      time = toDate(sdate);
    } else {
      time = transformTime(toDate(sdate), TimeZone.getTimeZone("GMT+08"),
        TimeZone.getDefault());
    }

    if (time == null) {
      return "Unknown";
    }
    String ftime = "";
    Calendar cal = Calendar.getInstance();

    // 判断是否是同一天
    String curDate = dateFormater2.get().format(cal.getTime());
    String paramDate = dateFormater2.get().format(time);
    if (curDate.equals(paramDate)) {
      int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
      if (hour == 0)
        ftime = Math.max(
          (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
          + "分钟前";
      else
        ftime = hour + "小时前";
      return ftime;
    }

    long lt = time.getTime() / 86400000;
    long ct = cal.getTimeInMillis() / 86400000;
    int days = (int) (ct - lt);
    if (days == 0) {
      int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
      if (hour == 0)
        ftime = Math.max(
          (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
          + "分钟前";
      else
        ftime = hour + "小时前";
    } else if (days == 1) {
      ftime = "昨天";
    } else if (days == 2) {
      ftime = "前天 ";
    } else if (days > 2 && days < 31) {
      ftime = days + "天前";
    } else if (days >= 31 && days <= 2 * 31) {
      ftime = "一个月前";
    } else if (days > 2 * 31 && days <= 3 * 31) {
      ftime = "2个月前";
    } else if (days > 3 * 31 && days <= 4 * 31) {
      ftime = "3个月前";
    } else {
      ftime = dateFormater2.get().format(time);
    }
    return ftime;
  }

  /**
   * 将字符串转位日期类型
   *
   * @param sdate
   * @return
   */
  public static Date toDate(String sdate) {
    return toDate(sdate, dateFormater.get());
  }

  public static Date toDate(String sdate, SimpleDateFormat dateFormater) {
    try {
      return dateFormater.parse(sdate);
    } catch (ParseException e) {
      return null;
    }
  }

  /**
   * 判断用户的设备时区是否为东八区（中国） 2014年7月31日
   *
   * @return
   */
  public static boolean isInEasternEightZones() {
    boolean defaultVaule = true;
    if (TimeZone.getDefault() == TimeZone.getTimeZone("GMT+08"))
      defaultVaule = true;
    else
      defaultVaule = false;
    return defaultVaule;
  }

  /**
   * 根据不同时区，转换时间 2014年7月31日
   */
  public static Date transformTime(Date date, TimeZone oldZone,
                                   TimeZone newZone) {
    Date finalDate = null;
    if (date != null) {
      int timeOffset = oldZone.getOffset(date.getTime())
        - newZone.getOffset(date.getTime());
      finalDate = new Date(date.getTime() - timeOffset);
    }
    return finalDate;
  }

  /**
   * 验证身份证号是否符合规则
   *
   * @param text 身份证号
   * @return
   */
  public static boolean personIdValidation(String text) {
    String regX = "[0-9]{17}X";
    String regx = "[0-9]{17}x";
    String reg1 = "[0-9]{15}";
    String regex = "[0-9]{18}";
    return text.matches(regx) || text.matches(reg1) || text.matches(regex) || text.matches(regX);
  }

  // 判断手机号码是否合法
  public static boolean isMobileNO(String mobiles) {
    if (TextUtils.isEmpty(mobiles)) {
      return false;
    }
    Pattern p = Pattern
      .compile("^1\\d{10}$");
    Matcher m = p.matcher(mobiles);
    return m.matches();
  }

  /**
   * 显示登录用户的账号
   * 1.是手机号显示139****1259的样式
   * 2.是用户名的话显示用户名
   */
  public static String showPhoneNum(String str) {
    if (isMobileNO(str)) {
      //是手机号
      StringBuilder sb = new StringBuilder(str);
      sb.replace(3, 7, "****");
      return sb.toString();
    } else {
      //非手机号
      return str;
    }
  }

  /**
   * 显示登录用户的账号
   * 1.是手机号显示13*******59的样式
   * 2.是用户名的话显示用户名
   */
  public static String showUserName2(String str) {
    if (isMobileNO(str)) {
      //是手机号
      StringBuilder sb = new StringBuilder(str);
      sb.replace(2, 9, "*******");
      return sb.toString();
    } else {
      //非手机号
      return str;
    }
  }

  /**
   * 显示登录用户的账号
   * 1.是手机号显示*******5859的样式
   * 2.是用户名的话显示用户名
   */
  public static String showUserName3(String str) {
    if (isMobileNO(str)) {
      //是手机号
      StringBuilder sb = new StringBuilder(str);
      sb.replace(0, 7, "*******");
      return sb.toString();
    } else {
      //非手机号
      return str;
    }
  }

  /**
   * 密文显示姓名
   * 如李*明
   *
   * @param str
   * @return
   */
  public static String showName(String str) {
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    StringBuilder sb = new StringBuilder(str);
    int amountNum = str.length();
    String symbol = "";
    if (amountNum > 2) {
      for (int i = 0; i < (amountNum - 2); i++) {
        symbol = symbol + "*";
      }
      sb.replace(1, amountNum - 1, symbol);
    } else if (amountNum == 2) {
      sb.replace(1, amountNum, "*");
    }
    return sb.toString();
  }

  /**
   * 密文显示身份证号
   * 如4101*********0236
   *
   * @param str
   * @return
   */
  public static String showIdCard(String str) {
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    StringBuilder sb = new StringBuilder(str);
    int amountNum = str.length();
    sb.replace(3, amountNum - 4, "***********");
    return sb.toString();
  }

  /**
   * 银行卡后四位
   * 如0236
   *
   * @param str
   * @return
   */
  public static String bankCardNumForLast(String str) {
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    StringBuilder sb = new StringBuilder(str);
    int amountNum = str.length();
    sb.replace(0, amountNum - 4, "");
    return sb.toString();
  }


  //判断验证码是否合法
  public static boolean isYZM(Context ctx, String yzm) {
    boolean isTure;
    if (yzm.length() == 0) {
      MyToast.showMyToast(ctx, "验证码不能为空", 0);
      isTure = false;
    } else if (yzm.length() < 5) {
      MyToast.showMyToast(ctx, "验证码格式错误", 0);
      isTure = false;
    } else {
      isTure = true;
    }
    return isTure;
  }

  /**
   * 显示用户的身份证号码
   *
   * @param str 用户的身份证号码
   * @return abc***********defg
   */
  public static String showAuthenticationBankIDNumber(String str) {
    StringBuilder sb = new StringBuilder(str);
    sb.replace(4, str.length() - 4, "***********");
    return sb.toString();
  }

  /**
   * @param str       字符串只能为两位小数或者整数
   * @param isDecimal 是否是小数
   * @Description 格式化字符串，每三位用逗号隔开
   */
  public static String addComma(String str, boolean isDecimal) {
    //先将字符串颠倒顺序
    str = new StringBuilder(str).reverse().toString();
    if (str.equals("0")) {
      return str;
    }
    String str2 = "";
    for (int i = 0; i < str.length(); i++) {
      if (i * 3 + 3 > str.length()) {
        str2 += str.substring(i * 3, str.length());
        break;
      }
      str2 += str.substring(i * 3, i * 3 + 3) + ",";
    }
    if (str2.endsWith(",")) {
      str2 = str2.substring(0, str2.length() - 1);
    }
    //最后再将顺序反转过来
    String temp = new StringBuilder(str2).reverse().toString();
    if (isDecimal) {
      //去掉最后的","
      return temp.substring(0, temp.lastIndexOf(",")) + temp.substring(temp.lastIndexOf(",") + 1, temp.length());
    } else {
      return temp;
    }
  }

  //将String转化成int
  public static int transforNumber(String value) {
    int i = 0;
    if (!TextUtils.isEmpty(value)) {
      Double dp = Double.parseDouble(value);
      if (dp >= 1) {
        i = (int) Double.parseDouble(value);
      } else if (dp > 0 && dp < 1) {
        i = 1;
      } else {
        i = 0;
      }
      return i;
    } else {
      return 0;
    }
  }
  //将String转化成int,如果是小数，比如0.5，都视为0
  public static int transforNumber2(String value) {
    int i = 0;
    if (!TextUtils.isEmpty(value)) {
      Double dp = Double.parseDouble(value);
      if (dp >= 1) {
        i = (int) Double.parseDouble(value);
      } else if (dp > 0 && dp < 1) {
        i = 0;
      } else {
        i = 0;
      }
      return i;
    } else {
      return 0;
    }
  }

  //将String转float
  public static float transforFloat(String value) {
    float t = 0;
    if (!TextUtils.isEmpty(value)) {
      try {
        t = Float.parseFloat(value);
        return t;
      } catch (Exception e) {
        return 0;
      }
    } else {
      return 0;
    }
  }

  /**
   * 保留两位小数
   *
   * @param s              editText
   * @param DECIMAL_DIGITS 小数点后几位
   * @param editText       输入框
   */
  public static void RetainDecimalDigits(CharSequence s, int DECIMAL_DIGITS, EditText editText) {
    if (isDouble(s.toString())) {
      if (s.toString().contains(".")) {
        if (s.length() - 1 - s.toString().indexOf(".") > DECIMAL_DIGITS) {
          s = s.toString().subSequence(0,
            s.toString().indexOf(".") + DECIMAL_DIGITS + 1);
          editText.setText(s);
          editText.setSelection(s.length());
        }
      }
      if (s.toString().trim().substring(0).equals(".")) {
        s = "0" + s;
        editText.setText(s);
        editText.setSelection(2);
      }
      if (s.toString().startsWith("0")
        && s.toString().trim().length() > 1) {
        if (!s.toString().substring(1, 2).equals(".")) {
          editText.setText(s.subSequence(1, s.length()));
//          editText.setSelection(editText.ge.length());
          return;
        }
      }
    } else {
      return;
    }
  }

  //返回toast提示
  public static String errorMessage(TradeSimpleResult.ErrorInfoBean value) {
    if (value!=null){
      return  value.getErrorMessage()+"";
    }else {
      return "请求错误！";
    }
  }


}
