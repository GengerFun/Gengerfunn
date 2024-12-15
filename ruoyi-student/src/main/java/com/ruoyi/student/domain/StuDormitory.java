package com.ruoyi.student.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍信息对象 stu_dormitory
 *
 * @author ruoyi
 * @date 2024-12-11
 */
public class StuDormitory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 宿舍楼编号 */
    @Excel(name = "宿舍楼编号")
    private String building;

    /** 房间号 */
    @Excel(name = "房间号")
    private String roomNumber;

    /** 床位总数 */
    @Excel(name = "床位总数")
    private String bedCount;

    /** 可用床位数 */
    @Excel(name = "可用床位数")
    private String availableBeds;

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
    public void setBuilding(String building)
    {
        this.building = building;
    }

    public String getBuilding()
    {
        return building;
    }
    public void setRoomNumber(String roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber()
    {
        return roomNumber;
    }
    public void setBedCount(String bedCount)
    {
        this.bedCount = bedCount;
    }

    public String getBedCount()
    {
        return bedCount;
    }
    public void setAvailableBeds(String availableBeds)
    {
        this.availableBeds = availableBeds;
    }

    public String getAvailableBeds()
    {
        return availableBeds;
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
            .append("building", getBuilding())
            .append("roomNumber", getRoomNumber())
            .append("bedCount", getBedCount())
            .append("availableBeds", getAvailableBeds())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
