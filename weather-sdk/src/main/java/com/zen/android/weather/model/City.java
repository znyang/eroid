package com.zen.android.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zen
 * @version 2016/3/10
 */
public class City {

    @JsonProperty("province_cn")
    private String mProvince;
    @JsonProperty("district_cn")
    private String district_cn;
    @JsonProperty("name_cn")
    private String mNameCn;
    @JsonProperty("name_en")
    private String mNameEn;    // "chaoyang",  //城市拼音
    @JsonProperty("area_id")
    private String mAreaId;   // "101010300"  //城市代码

    public String getAreaId() {
        return mAreaId;
    }

    public void setAreaId(String areaId) {
        mAreaId = areaId;
    }

    public String getNameEn() {
        return mNameEn;
    }

    public void setNameEn(String nameEn) {
        mNameEn = nameEn;
    }

    public String getNameCn() {
        return mNameCn;
    }

    public void setNameCn(String nameCn) {
        mNameCn = nameCn;
    }

    public String getDistrict_cn() {
        return district_cn;
    }

    public void setDistrict_cn(String district_cn) {
        this.district_cn = district_cn;
    }

    public String getProvince() {
        return mProvince;
    }

    public void setProvince(String province) {
        mProvince = province;
    }
}
