package com.ruoyi.student.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 档案信息管理对象 stu_archive
 *
 * @author ruoyi
 * @date 2025-01-15
 */
public class StuArchive extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long stuId;

    /** 档案转递类型 */
    @Excel(name = "档案转递类型")
    private String archiveType;

    /** 档案转递单位名称 */
    @Excel(name = "档案转递单位名称")
    private String archiveName;

    /** 档案转递单位地址 */
    @Excel(name = "档案转递单位地址")
    private String archiveAdress;

    /** 档案转递联系人 */
    @Excel(name = "档案转递联系人")
    private String archivePerson;

    /** 档案转递联系电话 */
    @Excel(name = "档案转递联系电话")
    private String archivePhone;

    /** 户口迁移类型 */
    @Excel(name = "户口迁移类型")
    private String hukouType;

    /** 档案转递单位编码 */
    @Excel(name = "档案转递单位编码")
    private String archiveCode;

    /** 户口迁移地址 */
    @Excel(name = "户口迁移地址")
    private String hukouAdress;

    /** 协议补充内容 */
    @Excel(name = "协议补充内容")
    private String agreement;

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
    public void setArchiveType(String archiveType)
    {
        this.archiveType = archiveType;
    }

    public String getArchiveType()
    {
        return archiveType;
    }
    public void setArchiveName(String archiveName)
    {
        this.archiveName = archiveName;
    }

    public String getArchiveName()
    {
        return archiveName;
    }
    public void setArchiveAdress(String archiveAdress)
    {
        this.archiveAdress = archiveAdress;
    }

    public String getArchiveAdress()
    {
        return archiveAdress;
    }
    public void setArchivePerson(String archivePerson)
    {
        this.archivePerson = archivePerson;
    }

    public String getArchivePerson()
    {
        return archivePerson;
    }
    public void setArchivePhone(String archivePhone)
    {
        this.archivePhone = archivePhone;
    }

    public String getArchivePhone()
    {
        return archivePhone;
    }
    public void setHukouType(String hukouType)
    {
        this.hukouType = hukouType;
    }

    public String getHukouType()
    {
        return hukouType;
    }
    public void setArchiveCode(String archiveCode)
    {
        this.archiveCode = archiveCode;
    }

    public String getArchiveCode()
    {
        return archiveCode;
    }
    public void setHukouAdress(String hukouAdress)
    {
        this.hukouAdress = hukouAdress;
    }

    public String getHukouAdress()
    {
        return hukouAdress;
    }
    public void setAgreement(String agreement)
    {
        this.agreement = agreement;
    }

    public String getAgreement()
    {
        return agreement;
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
            .append("archiveType", getArchiveType())
            .append("archiveName", getArchiveName())
            .append("archiveAdress", getArchiveAdress())
            .append("archivePerson", getArchivePerson())
            .append("archivePhone", getArchivePhone())
            .append("hukouType", getHukouType())
            .append("archiveCode", getArchiveCode())
            .append("hukouAdress", getHukouAdress())
            .append("agreement", getAgreement())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
