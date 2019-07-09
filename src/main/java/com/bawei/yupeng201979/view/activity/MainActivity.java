package com.bawei.yupeng201979.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bawei.yupeng201979.R;
import com.bawei.yupeng201979.bean.Bean;
import com.bawei.yupeng201979.moudel.http.HttpUtils;
import com.bawei.yupeng201979.presenter.HomePreaenter;
import com.bawei.yupeng201979.view.adapter.MyAdapter;
import com.bawei.yupeng201979.view.beas.BeasActivity;
import com.bawei.yupeng201979.view.interpace.IMaintion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.zhaoliang5156.xlistview.XListView;

public class MainActivity extends BeasActivity implements IMaintion {
    private String str = "http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1003&count=5&page=1";
    private List<Bean> list = new ArrayList<>();
    private List<Bean> lists = new ArrayList<>();
    private int page = 1;
    private XListView xListView;
    private HttpUtils httpUtils = HttpUtils.getInstance();
    private MyAdapter adapter;

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initFind() {
    xListView = findViewById(R.id.xlv);
    }

    @Override
    public void initData() {
        HomePreaenter homePreaenter = new HomePreaenter();
        homePreaenter.ontean(this);
        homePreaenter.onload();
        xListView.setPullRefreshEnable(true);
        xListView.setPullLoadEnable(true);
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                page = 1;
                list.clear();
                xListView.stopLoadMore();
                xListView.stopRefresh();
                getDate();
            }

            @Override
            public void onLoadMore() {
                page ++;
                xListView.stopLoadMore();
                xListView.stopRefresh();
                getDate();
            }
        });
        adapter = new MyAdapter(list, MainActivity.this);
        xListView.setAdapter(adapter);
        getDate();

    }

    private void getDate() {
        httpUtils.Task(str, new HttpUtils.Back() {
        @Override
        public void getData(String s) {
            try {
                JSONObject object = new JSONObject(s);
                JSONArray result = object.getJSONArray("result");
                for (int i = 0; i < result.length(); i++) {
                    JSONObject obj = (JSONObject) result.get(i);
                    String masterPic = obj.getString("masterPic");
                    String commodityName = obj.getString("commodityName");
                    list.add(new Bean(masterPic,commodityName));
                }
                adapter.notifyDataSetChanged();
                lists.addAll(list);
                if (page == 1){
                    xListView.stopRefresh();
                }else {
                    xListView.stopLoadMore();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    }

    @Override
    public void initListen() {

    }

    @Override
    public void ok(String strl) {
        Log.e("skl",""+strl);
    }

    @Override
    public void error(String strl) {

    }
}
