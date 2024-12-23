package com.ruoyi.student.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.student.domain.StuPayment;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 学生信息对象 stu_user
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@Data
public class PaymentVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 班级名称 */
    private Long id;

    /** 班级名称 */
    private String payName;

    /** 班级名称 */
    private Long amount;

    /** 类型 */
    private String type;

    /** 班级名称 */
    private String status;

    /** 班级名称 */
    private String button;
}
