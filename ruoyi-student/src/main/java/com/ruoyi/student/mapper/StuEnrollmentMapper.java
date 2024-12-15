package com.ruoyi.student.mapper;

import com.ruoyi.student.domain.StuEnrollment;

import java.util.List;

/**
 * 学籍信息Mapper接口
 *
 * @author ruoyi
 * @date 2024-12-11
 */
public interface StuEnrollmentMapper
{
    /**
     * 查询学籍信息
     *
     * @param id 学籍信息主键
     * @return 学籍信息
     */
    public StuEnrollment selectStuEnrollmentById(Long id);

    /**
     * 查询学籍信息列表
     *
     * @param stuEnrollment 学籍信息
     * @return 学籍信息集合
     */
    public List<StuEnrollment> selectStuEnrollmentList(StuEnrollment stuEnrollment);

    /**
     * 新增学籍信息
     *
     * @param stuEnrollment 学籍信息
     * @return 结果
     */
    public int insertStuEnrollment(StuEnrollment stuEnrollment);

    /**
     * 修改学籍信息
     *
     * @param stuEnrollment 学籍信息
     * @return 结果
     */
    public int updateStuEnrollment(StuEnrollment stuEnrollment);

    /**
     * 删除学籍信息
     *
     * @param id 学籍信息主键
     * @return 结果
     */
    public int deleteStuEnrollmentById(Long id);

    /**
     * 批量删除学籍信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuEnrollmentByIds(Long[] ids);
}
