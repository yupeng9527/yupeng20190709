package com.bawei.yupeng201979.bean;

/*
 *
 * 姓名：于鹏
 * 创建时间：
 * 具体功能：
 */public class Bean {
     private String masterPic;
     private String commodityName;

     public Bean() {
     }

     public Bean(String masterPic, String commodityName) {
          this.masterPic = masterPic;
          this.commodityName = commodityName;
     }

     @Override
     public String toString() {
          return "Bean{" +
                  "masterPic='" + masterPic + '\'' +
                  ", commodityName='" + commodityName + '\'' +
                  '}';
     }

     public String getMasterPic() {
          return masterPic;
     }

     public void setMasterPic(String masterPic) {
          this.masterPic = masterPic;
     }

     public String getCommodityName() {
          return commodityName;
     }

     public void setCommodityName(String commodityName) {
          this.commodityName = commodityName;
     }
}
