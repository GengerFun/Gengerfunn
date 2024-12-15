package com.ruoyi.student.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.student.domain.StuPayment;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 学生信息对象 stu_user
 *
 * @author ruoyi
 * @date 2024-12-11
 */
public class StuUserPaymentVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    /** 专业名称 */
    private String majorName;

    /** 所属院系 */
    private String department;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /** 班级名称 */
    private String className;
    public List<StuPayment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<StuPayment> paymentList) {
        this.paymentList = paymentList;
    }

    private List<StuPayment> paymentList;

    public List<StuPayment> getNoPaymentList() {
        return noPaymentList;
    }

    public void setNoPaymentList(List<StuPayment> noPaymentList) {
        this.noPaymentList = noPaymentList;
    }

    private List<StuPayment> noPaymentList;
    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 学生姓名/老师姓名 */
    @Excel(name = "学生姓名/老师姓名")
    private String stuName;

    /**  0学生、1老师 3其他 */
    @Excel(name = " 0学生、1老师 3其他")
    private String jobType;

    /** 学号/公职号 */
    @Excel(name = "学号/公职号")
    private String idStudent;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String idNumber;

    /** 专业ID */
    @Excel(name = "专业ID")
    private Long majorId;

    /** 班级ID */
    @Excel(name = "班级ID")
    private Long classId;

    /** 宿舍ID */
    @Excel(name = "宿舍ID")
    private Long dormitoryId;

    /** 报到状态（0未报到 1已报到） */
    @Excel(name = "报到状态", readConverterExp = "0=未报到,1=已报到")
    private String registrationStatus;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 用户性别（0男 1女 2未知） */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /** 头像地址 */
    @Excel(name = "头像地址")
    private String avatar;

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
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setStuName(String stuName)
    {
        this.stuName = stuName;
    }

    public String getStuName()
    {
        return stuName;
    }
    public void setJobType(String jobType)
    {
        this.jobType = jobType;
    }

    public String getJobType()
    {
        return jobType;
    }
    public void setIdStudent(String idStudent)
    {
        this.idStudent = idStudent;
    }

    public String getIdStudent()
    {
        return idStudent;
    }
    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber()
    {
        return idNumber;
    }
    public void setMajorId(Long majorId)
    {
        this.majorId = majorId;
    }

    public Long getMajorId()
    {
        return majorId;
    }
    public void setClassId(Long classId)
    {
        this.classId = classId;
    }

    public Long getClassId()
    {
        return classId;
    }
    public void setDormitoryId(Long dormitoryId)
    {
        this.dormitoryId = dormitoryId;
    }

    public Long getDormitoryId()
    {
        return dormitoryId;
    }
    public void setRegistrationStatus(String registrationStatus)
    {
        this.registrationStatus = registrationStatus;
    }

    public String getRegistrationStatus()
    {
        return registrationStatus;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
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
            .append("userId", getUserId())
            .append("stuName", getStuName())
            .append("jobType", getJobType())
            .append("idStudent", getIdStudent())
            .append("idNumber", getIdNumber())
            .append("majorId", getMajorId())
            .append("classId", getClassId())
            .append("dormitoryId", getDormitoryId())
            .append("registrationStatus", getRegistrationStatus())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("sex", getSex())
            .append("avatar", getAvatar())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
