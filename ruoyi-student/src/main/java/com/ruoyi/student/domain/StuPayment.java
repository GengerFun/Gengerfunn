package com.ruoyi.student.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 缴费记录对象 stu_payment
 *
 * @author ruoyi
 * @date 2024-12-11
 */
public class StuPayment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long stuId;

    /** 缴费金额 */
    @Excel(name = "缴费金额")
    private Long amount;

    /** 支付方式（如 0支付宝、1 微信支付、2 银行卡,3其他） */
    @Excel(name = "支付方式", readConverterExp = "如=,0=支付宝、1,微=信支付、2,银=行卡,3其他")
    private String payMethod;

    public Long getPayType() {
        return payType;
    }

    public void setPayType(Long payType) {
        this.payType = payType;
    }

    /** 1 统计学费、2 住宿费,3 书本费 */
    @Excel(name = "1 统计学费、2 住宿费,3 书本费")
    private Long payType;

    /** 缴费状态（如 0待支付、1已支付） */
    @Excel(name = "缴费状态", readConverterExp = "如=,0=待支付、1已支付")
    private String status;

    /** 第三方交易流水号，支付单号 */
    @Excel(name = "第三方交易流水号，支付单号")
    private String transactionId;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId()
    {
        return stuId;
    }
    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    public Long getAmount()
    {
        return amount;
    }
    public void setPayMethod(String payMethod)
    {
        this.payMethod = payMethod;
    }

    public String getPayMethod()
    {
        return payMethod;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
    }

    public String getTransactionId()
    {
        return transactionId;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("stuId", getStuId())
            .append("amount", getAmount())
            .append("payMethod", getPayMethod())
            .append("payType", getPayType())
            .append("status", getStatus())
            .append("transactionId", getTransactionId())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
