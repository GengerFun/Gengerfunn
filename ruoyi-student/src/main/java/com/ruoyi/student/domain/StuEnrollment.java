package com.ruoyi.student.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学籍信息对象 stu_enrollment
 *
 * @author ruoyi
 * @date 2024-12-11
 */
public class StuEnrollment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long stuId;

    /** 预计毕业日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计毕业日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expectedGraduationDate;

    /** 最近一次学籍状态变更日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近一次学籍状态变更日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statusChangeDate;

    /** 入学日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入学日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryDate;

    /** 当前学籍状态（如0在读、1休学、2退学等） */
    @Excel(name = "当前学籍状态", readConverterExp = "如=0在读、1休学、2退学等")
    private String currentStatus;

    /** 学籍状态变更原因 */
    @Excel(name = "学籍状态变更原因")
    private String statusChangeReason;

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
    public void setExpectedGraduationDate(Date expectedGraduationDate)
    {
        this.expectedGraduationDate = expectedGraduationDate;
    }

    public Date getExpectedGraduationDate()
    {
        return expectedGraduationDate;
    }
    public void setStatusChangeDate(Date statusChangeDate)
    {
        this.statusChangeDate = statusChangeDate;
    }

    public Date getStatusChangeDate()
    {
        return statusChangeDate;
    }
    public void setEntryDate(Date entryDate)
    {
        this.entryDate = entryDate;
    }

    public Date getEntryDate()
    {
        return entryDate;
    }
    public void setCurrentStatus(String currentStatus)
    {
        this.currentStatus = currentStatus;
    }

    public String getCurrentStatus()
    {
        return currentStatus;
    }
    public void setStatusChangeReason(String statusChangeReason)
    {
        this.statusChangeReason = statusChangeReason;
    }

    public String getStatusChangeReason()
    {
        return statusChangeReason;
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
            .append("expectedGraduationDate", getExpectedGraduationDate())
            .append("statusChangeDate", getStatusChangeDate())
            .append("entryDate", getEntryDate())
            .append("currentStatus", getCurrentStatus())
            .append("statusChangeReason", getStatusChangeReason())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
