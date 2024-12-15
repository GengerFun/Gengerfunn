package com.ruoyi.student.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物资领取记录对象 stu_material_pickup
 *
 * @author ruoyi
 * @date 2024-12-11
 */
public class StuMaterialPickup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long stuId;

    /** 宿舍ID */
    @Excel(name = "宿舍ID")
    private Long dormitoryId;

    /** 领取数量 */
    @Excel(name = "领取数量")
    private Long quantity;

    /** 物料ID */
    @Excel(name = "物料ID")
    private Long materialId;

    /** 领取状态（如 0未领取、1已领取） */
    @Excel(name = "领取状态", readConverterExp = "如=,0=未领取、1已领取")
    private String status;

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
    public void setDormitoryId(Long dormitoryId)
    {
        this.dormitoryId = dormitoryId;
    }

    public Long getDormitoryId()
    {
        return dormitoryId;
    }
    public void setQuantity(Long quantity)
    {
        this.quantity = quantity;
    }

    public Long getQuantity()
    {
        return quantity;
    }
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
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
            .append("dormitoryId", getDormitoryId())
            .append("quantity", getQuantity())
            .append("materialId", getMaterialId())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
