package com.bawei.yupeng201979.moudel.http;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 *
 * 姓名：于鹏
 * 创建时间：
 * 具体功能：
 */public class HttpUtils {
    private static HttpUtils httpUtils = new HttpUtils();
    private HttpUtils(){}
    public static HttpUtils getInstance(){
        return httpUtils;
    }
    public String getstring(String strurl){
        HttpURLConnection connection = null;
        try {
            URL url = new URL(strurl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            int code = connection.getResponseCode();
            if (code == 200){
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String str = "";
                while ((str = reader.readLine())!=null){
                    buffer.append(str);
                }
                reader.close();
                connection.disconnect();
                return buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public void Task(String strurk , final Back back){
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return getstring(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                back.getData(s);
            }
        }.execute(strurk);
    }
    public interface Back{
        void getData(String s);
    }
    public Bitmap getbitmap(String strurl){
        HttpURLConnection connection = null;
        Bitmap bitmap = null;
        try {
            URL url = new URL(strurl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int code = connection.getResponseCode();
            if (code == 200){
                InputStream stream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(stream);
                connection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    public void Taskb(String strurk,final Backb backb){
        new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                return getbitmap(strings[0]);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                backb.getDatab(bitmap);
            }
        }.execute(strurk);
    }
    public interface Backb{
        void getDatab(Bitmap bitmap);
    }
}
