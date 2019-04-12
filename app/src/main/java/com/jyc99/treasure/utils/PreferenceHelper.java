package com.jyc99.treasure.utils;


import android.content.Context;
import android.content.SharedPreferences;

import com.jyc99.treasure.MyApplication;


/**
 * SharedPreferences操作工具包<br>
 * <p/>
 * <b>说明</b> 本工具包只能在单进程项目下使用，多进程共享请使用如下demo的两行代码重写: <br>
 * Context otherContext = c.createPackageContext( "com.android.contacts",
 * Context.CONTEXT_IGNORE_SECURITY); <br>
 * SharedPreferences sp = otherContext.getSharedPreferences( "my_file",
 * Context.MODE_MULTI_PROCESS);<br>
 */
public class PreferenceHelper {
    public static String DEFAULT_FILE_NAME = "TY";

    /*public static void write(String k, int v) {
        SharedPreferences preference = MyApplication.getContext().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putInt(k, v);
        editor.commit();
    }*/

   /* public static void write(String k,
                             boolean v) {
        SharedPreferences preference = MyApplication.getContext().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putBoolean(k, v);
        editor.commit();
    }*/

    /* public static void write(String k,
                              String v) throws Exception {
         SharedPreferences preference = MyApplication.getContext().getSharedPreferences(fileName,
                 Context.MODE_PRIVATE);
         v=CipherUtils.encrypt(v);
         SharedPreferences.Editor editor = preference.edit();
         editor.putString(k, v);
         editor.commit();
     }*/
    public static void write(String fileName, String k, int v) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putInt(k, v);
        editor.commit();
    }
  public static void write(String fileName, String k, long v) {
    SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(fileName,
      Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = preference.edit();
    editor.putLong(k, v);
    editor.commit();
  }

    public static void write(String fileName, String k,
                             boolean v) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putBoolean(k, v);
        editor.commit();
    }

    //对String类型保存时候加密
    public static void write(String fileName, String k,
                             String v) throws Exception {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        v = CipherUtils.encrypt(v==null?"":v);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(k, v==null?"":v);
        editor.commit();
    }

    public static int readInt(String fileName, String k) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return preference.getInt(k, 0);
    }

    public static int readInt(String fileName, String k,
                              int defv) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getInt(k, defv);
    }

  public static long readLong(String fileName, String k,
                            long defv) {
    SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(fileName,
      Context.MODE_PRIVATE);
    return preference.getLong(k, defv);
  }

    public static boolean readBoolean(String fileName, String k, boolean defBool) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getBoolean(k, defBool);
    }

    //读取字符串需要解密
    public static String readString(String fileName, String k,
                                    String defV) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        if (defV.equals(preference.getString(k, defV))) {
            return defV;
        } else {
            try {
                return CipherUtils.decrypt(preference.getString(k, defV));
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static void remove(String fileNmae, String k) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(fileNmae,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.remove(k);
        editor.commit();
    }

    public static void clean(String fileName) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.clear();
        editor.commit();
    }
   /* public static int readInt(String k) {
        SharedPreferences preference = MyApplication.getContext().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getInt(k, 0);
    }
*/
  /*  public static int readInt(String k,
                              int defv) {
        SharedPreferences preference = MyApplication.getContext().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getInt(k, defv);
    }*/

   /* public static boolean readBoolean(String fileName, String k) {
        SharedPreferences preference = MyApplication.getContext().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getBoolean(k, false);
    }*/
   /* public static boolean readBoolean(
            String k, boolean defBool) {
        SharedPreferences preference = MyApplication.getContext().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getBoolean(k, defBool);
    }*/

   /* public static String readString(String k) throws Exception {
        SharedPreferences preference = MyApplication.getContext().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        if (TextUtils.isEmpty(preference.getString(k, null))){
            return preference.getString(k, null);
        }else {
            return CipherUtils.decrypt(preference.getString(k, null));
        }
    }*/

    /*public static String readString(String k,
                                    String defV){
        SharedPreferences preference = MyApplication.getContext().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        if (defV.equals(preference.getString(k, defV))){
            return defV;
        }else {
            try {
                return CipherUtils.decrypt(preference.getString(k, defV));
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }*/

   /* public static void remove(String k) {
        SharedPreferences preference = MyApplication.getContext().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.remove(k);
        editor.commit();
    }
*/
   /* public static void clean() {
        SharedPreferences preference = MyApplication.getContext().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.clear();
        editor.commit();
    }*/

}
