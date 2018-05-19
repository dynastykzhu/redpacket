package com.wsloan.redpacket.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class TUser implements Serializable {
    /**
     * 微信openid
     */
    private String openId;

    private String name;

    /**
     * 手机号
     */
    private String cmtel;

    /**
     * 所获得得奖励
     */
    private BigDecimal allRewards;

    /**
     * 可提现的奖励
     */
    private BigDecimal availableRewards;

    private Date createDate;

    private static final long serialVersionUID = 1L;


    public TUser() {
    }

    public TUser(String openId, BigDecimal allRewards, BigDecimal availableRewards) {
        this.openId = openId;
        this.allRewards = allRewards;
        this.availableRewards = availableRewards;
    }

    public TUser(String openId, String name, String cmtel, BigDecimal allRewards, BigDecimal availableRewards, Date createDate) {
        this.openId = openId;
        this.name = name;
        this.cmtel = cmtel;
        this.allRewards = allRewards;
        this.availableRewards = availableRewards;
        this.createDate = createDate;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmtel() {
        return cmtel;
    }

    public void setCmtel(String cmtel) {
        this.cmtel = cmtel;
    }

    public BigDecimal getAllRewards() {
        return allRewards;
    }

    public void setAllRewards(BigDecimal allRewards) {
        this.allRewards = allRewards;
    }

    public BigDecimal getAvailableRewards() {
        return availableRewards;
    }

    public void setAvailableRewards(BigDecimal availableRewards) {
        this.availableRewards = availableRewards;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TUser other = (TUser) that;
        return (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCmtel() == null ? other.getCmtel() == null : this.getCmtel().equals(other.getCmtel()))
            && (this.getAllRewards() == null ? other.getAllRewards() == null : this.getAllRewards().equals(other.getAllRewards()))
            && (this.getAvailableRewards() == null ? other.getAvailableRewards() == null : this.getAvailableRewards().equals(other.getAvailableRewards()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCmtel() == null) ? 0 : getCmtel().hashCode());
        result = prime * result + ((getAllRewards() == null) ? 0 : getAllRewards().hashCode());
        result = prime * result + ((getAvailableRewards() == null) ? 0 : getAvailableRewards().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", openId=").append(openId);
        sb.append(", name=").append(name);
        sb.append(", cmtel=").append(cmtel);
        sb.append(", allRewards=").append(allRewards);
        sb.append(", availableRewards=").append(availableRewards);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}