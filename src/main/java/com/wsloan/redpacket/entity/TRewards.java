package com.wsloan.redpacket.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class TRewards implements Serializable {
    private Integer id;

    /**
     * 接收红包的openid
     */
    private String openIdAccept;

    /**
     * 接收红包的名称
     */
    private String nameAccept;

    /**
     * 打开红包奖励
     */
    private BigDecimal awardAccept;

    /**
     * 发送红包的openid
     */
    private String openIdSend;
    /**
     * 发送红包的名称
     */
    private String nameSend;

    /**
     * 发送红包被拆奖励
     */
    private BigDecimal awardSend;

    private Date create;

    public TRewards() {
    }

    public TRewards(String openIdAccept, String nameAccept, BigDecimal awardAccept, String openIdSend, String nameSend, BigDecimal awardSend, Date create) {
        this.openIdAccept = openIdAccept;
        this.nameAccept = nameAccept;
        this.awardAccept = awardAccept;
        this.openIdSend = openIdSend;
        this.nameSend = nameSend;
        this.awardSend = awardSend;
        this.create = create;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenIdAccept() {
        return openIdAccept;
    }

    public void setOpenIdAccept(String openIdAccept) {
        this.openIdAccept = openIdAccept;
    }

    public String getNameAccept() {
        return nameAccept;
    }

    public void setNameAccept(String nameAccept) {
        this.nameAccept = nameAccept;
    }

    public BigDecimal getAwardAccept() {
        return awardAccept;
    }

    public void setAwardAccept(BigDecimal awardAccept) {
        this.awardAccept = awardAccept;
    }

    public String getOpenIdSend() {
        return openIdSend;
    }

    public void setOpenIdSend(String openIdSend) {
        this.openIdSend = openIdSend;
    }

    public String getNameSend() {
        return nameSend;
    }

    public void setNameSend(String nameSend) {
        this.nameSend = nameSend;
    }

    public BigDecimal getAwardSend() {
        return awardSend;
    }

    public void setAwardSend(BigDecimal awardSend) {
        this.awardSend = awardSend;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
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
        TRewards other = (TRewards) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpenIdAccept() == null ? other.getOpenIdAccept() == null : this.getOpenIdAccept().equals(other.getOpenIdAccept()))
            && (this.getNameAccept() == null ? other.getNameAccept() == null : this.getNameAccept().equals(other.getNameAccept()))
            && (this.getAwardAccept() == null ? other.getAwardAccept() == null : this.getAwardAccept().equals(other.getAwardAccept()))
            && (this.getOpenIdSend() == null ? other.getOpenIdSend() == null : this.getOpenIdSend().equals(other.getOpenIdSend()))
            && (this.getNameSend() == null ? other.getNameSend() == null : this.getNameSend().equals(other.getNameSend()))
            && (this.getAwardSend() == null ? other.getAwardSend() == null : this.getAwardSend().equals(other.getAwardSend()))
            && (this.getCreate() == null ? other.getCreate() == null : this.getCreate().equals(other.getCreate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOpenIdAccept() == null) ? 0 : getOpenIdAccept().hashCode());
        result = prime * result + ((getNameAccept() == null) ? 0 : getNameAccept().hashCode());
        result = prime * result + ((getAwardAccept() == null) ? 0 : getAwardAccept().hashCode());
        result = prime * result + ((getOpenIdSend() == null) ? 0 : getOpenIdSend().hashCode());
        result = prime * result + ((getNameSend() == null) ? 0 : getNameSend().hashCode());
        result = prime * result + ((getAwardSend() == null) ? 0 : getAwardSend().hashCode());
        result = prime * result + ((getCreate() == null) ? 0 : getCreate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openIdAccept=").append(openIdAccept);
        sb.append(", nameAccept=").append(nameAccept);
        sb.append(", awardAccept=").append(awardAccept);
        sb.append(", openIdSend=").append(openIdSend);
        sb.append(", nameSend=").append(nameSend);
        sb.append(", awardSend=").append(awardSend);
        sb.append(", create=").append(create);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}