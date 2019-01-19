package com.turbo.codegenerator.model;

/**
*
* @author hl.Yang
* @create 2019-1-19 15:23:10
* @desc GPS信息表（根据经纬度获取）
**/
public class GpsInfo{

    //主键;
    private Long id;
    //渠道编号;
    private String channelNum;
    //产品编号;
    private String channelProduct;
    //在三方系统中的id;
    private String assetId;
    //请求流水号，全局唯一;
    private String requestNo;
    //姓名;
    private String borrowerName;
    //借款人身份证号码;
    private String borrowerIdCard;
    //借款人银行账号/卡号;
    private String borrowerCardNo;
    //常用手机号（即用户注册手机号）;
    private String borrowerPhone;
    //经度;
    private Double longitude;
    //纬度;
    private Double latitude;
    //国家;
    private String country;
    //省;
    private String province;
    //城市;
    private String city;
    //区县;
    private String district;
    //乡镇;
    private String town;
    //街道;
    private String street;
    //街道门牌号;
    private String streetNumber;
    //行政区划代码;
    private String adcode;
    //国家代码;
    private String countryCode;
    //相对当前坐标点的方向，当有门牌号的时候返回数据;
    private String direction;
    //相对当前坐标点的距离，当有门牌号的时候返回数据;
    private String distance;
    //坐标所在商圈信息，如 "人民大学,中关村,苏州街"。最多返回3个;
    private String business;
    //当前位置结合POI的语义化结果描述;
    private String sematicDescription;
    //返回报文;
    private String returnMsg;
    //创建时间;
    private Long createTime;
    //修改时间;
    private Long modifyTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getChannelNum() {
        return channelNum;
    }
    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum;
    }
    public String getChannelProduct() {
        return channelProduct;
    }
    public void setChannelProduct(String channelProduct) {
        this.channelProduct = channelProduct;
    }
    public String getAssetId() {
        return assetId;
    }
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
    public String getRequestNo() {
        return requestNo;
    }
    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }
    public String getBorrowerName() {
        return borrowerName;
    }
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
    public String getBorrowerIdCard() {
        return borrowerIdCard;
    }
    public void setBorrowerIdCard(String borrowerIdCard) {
        this.borrowerIdCard = borrowerIdCard;
    }
    public String getBorrowerCardNo() {
        return borrowerCardNo;
    }
    public void setBorrowerCardNo(String borrowerCardNo) {
        this.borrowerCardNo = borrowerCardNo;
    }
    public String getBorrowerPhone() {
        return borrowerPhone;
    }
    public void setBorrowerPhone(String borrowerPhone) {
        this.borrowerPhone = borrowerPhone;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getTown() {
        return town;
    }
    public void setTown(String town) {
        this.town = town;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getStreetNumber() {
        return streetNumber;
    }
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    public String getAdcode() {
        return adcode;
    }
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getDistance() {
        return distance;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }
    public String getBusiness() {
        return business;
    }
    public void setBusiness(String business) {
        this.business = business;
    }
    public String getSematicDescription() {
        return sematicDescription;
    }
    public void setSematicDescription(String sematicDescription) {
        this.sematicDescription = sematicDescription;
    }
    public String getReturnMsg() {
        return returnMsg;
    }
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Long getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

}
