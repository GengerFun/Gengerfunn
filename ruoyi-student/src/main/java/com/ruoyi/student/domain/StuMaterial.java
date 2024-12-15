package com.ruoyi.student.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物资管理对象 stu_material
 *
 * @author ruoyi
 * @date 2024-12-11
 */
public class StuMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 物资名称 */
    @Excel(name = "物资名称")
    private String materialName;

    /** 物资类型  1 被子、2 日用品, 3 钥匙 */
    @Excel(name = "物资类型  1 被子、2 日用品, 3 钥匙")
    private String materialType;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long quantityCount;

    /** 单价 */
    @Excel(name = "单价")
    private Long unitPrice;

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
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialName()
    {
        return materialName;
    }
    public void setMaterialType(String materialType)
    {
        this.materialType = materialType;
    }

    public String getMaterialType()
    {
        return materialType;
    }
    public void setQuantityCount(Long quantityCount)
    {
        this.quantityCount = quantityCount;
    }

    public Long getQuantityCount()
    {
        return quantityCount;
    }
    public void setUnitPrice(Long unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public Long getUnitPrice()
    {
        return unitPrice;
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
            .append("materialName", getMaterialName())
            .append("materialType", getMaterialType())
            .append("quantityCount", getQuantityCount())
            .append("unitPrice", getUnitPrice())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
