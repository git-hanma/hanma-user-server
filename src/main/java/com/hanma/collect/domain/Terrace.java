package com.hanma.collect.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Terrace implements Serializable{
    private Long merchantId;

    private Long staffId;

    private String merchantName;

    private Integer merchantStatus;

    private String merchantAddress;

    private String merchantLinkman;

    private String merchantPhone;

    private Integer merchantType;

    private Integer merchantGrade;

    private String merchantImg;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date merchantCreateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date merchantUpdateTime;

    private Integer merchantYn;

    private String merchantIntro;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public Integer getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(Integer merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress == null ? null : merchantAddress.trim();
    }

    public String getMerchantLinkman() {
        return merchantLinkman;
    }

    public void setMerchantLinkman(String merchantLinkman) {
        this.merchantLinkman = merchantLinkman == null ? null : merchantLinkman.trim();
    }

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone == null ? null : merchantPhone.trim();
    }

    public Integer getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(Integer merchantType) {
        this.merchantType = merchantType;
    }

    public Integer getMerchantGrade() {
        return merchantGrade;
    }

    public void setMerchantGrade(Integer merchantGrade) {
        this.merchantGrade = merchantGrade;
    }

    public String getMerchantImg() {
        return merchantImg;
    }

    public void setMerchantImg(String merchantImg) {
        this.merchantImg = merchantImg == null ? null : merchantImg.trim();
    }

    public Date getMerchantCreateTime() {
        return merchantCreateTime;
    }

    public void setMerchantCreateTime(Date merchantCreateTime) {
        this.merchantCreateTime = merchantCreateTime;
    }

    public Date getMerchantUpdateTime() {
        return merchantUpdateTime;
    }

    public void setMerchantUpdateTime(Date merchantUpdateTime) {
        this.merchantUpdateTime = merchantUpdateTime;
    }

    public Integer getMerchantYn() {
        return merchantYn;
    }

    public void setMerchantYn(Integer merchantYn) {
        this.merchantYn = merchantYn;
    }

    public String getMerchantIntro() {
        return merchantIntro;
    }

    public void setMerchantIntro(String merchantIntro) {
        this.merchantIntro = merchantIntro == null ? null : merchantIntro.trim();
    }

    @Override
    public String toString() {
        return "Terrace{" +
                "merchantId=" + merchantId +
                ", staffId=" + staffId +
                ", merchantName='" + merchantName + '\'' +
                ", merchantStatus=" + merchantStatus +
                ", merchantAddress='" + merchantAddress + '\'' +
                ", merchantLinkman='" + merchantLinkman + '\'' +
                ", merchantPhone='" + merchantPhone + '\'' +
                ", merchantType=" + merchantType +
                ", merchantGrade=" + merchantGrade +
                ", merchantImg='" + merchantImg + '\'' +
                ", merchantCreateTime=" + merchantCreateTime +
                ", merchantUpdateTime=" + merchantUpdateTime +
                ", merchantYn=" + merchantYn +
                ", merchantIntro='" + merchantIntro + '\'' +
                '}';
    }
}