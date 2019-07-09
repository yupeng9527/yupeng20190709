package com.bawei.yupeng201979.presenter;

import com.bawei.yupeng201979.view.activity.MainActivity;

/*
 *
 * 姓名：于鹏
 * 创建时间：
 * 具体功能：
 */public class HomePreaenter {
     public HomePreaenter(){

     }
     private MainActivity homepresenter;
     public void ontean(MainActivity mainActivity){
         homepresenter = mainActivity;
     }
     public void onload(){
         homepresenter.ok("ok");
     }
}
