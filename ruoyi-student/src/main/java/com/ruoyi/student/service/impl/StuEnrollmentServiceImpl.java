package com.ruoyi.student.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.student.domain.StuEnrollment;
import com.ruoyi.student.mapper.StuEnrollmentMapper;
import com.ruoyi.student.service.IStuEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学籍信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@Service
public class StuEnrollmentServiceImpl implements IStuEnrollmentService
{
    @Autowired
    private StuEnrollmentMapper stuEnrollmentMapper;

    /**
     * 查询学籍信息
     *
     * @param id 学籍信息主键
     * @return 学籍信息
     */
    @Override
    public StuEnrollment selectStuEnrollmentById(Long id)
    {
        return stuEnrollmentMapper.selectStuEnrollmentById(id);
    }

    /**
     * 查询学籍信息列表
     *
     * @param stuEnrollment 学籍信息
     * @return 学籍信息
     */
    @Override
    public List<StuEnrollment> selectStuEnrollmentList(StuEnrollment stuEnrollment)
    {
        return stuEnrollmentMapper.selectStuEnrollmentList(stuEnrollment);
    }

    /**
     * 新增学籍信息
     *
     * @param stuEnrollment 学籍信息
     * @return 结果
     */
    @Override
    public int insertStuEnrollment(StuEnrollment stuEnrollment)
    {
        stuEnrollment.setCreateTime(DateUtils.getNowDate());
        return stuEnrollmentMapper.insertStuEnrollment(stuEnrollment);
    }

    /**
     * 修改学籍信息
     *
     * @param stuEnrollment 学籍信息
     * @return 结果
     */
    @Override
    public int updateStuEnrollment(StuEnrollment stuEnrollment)
    {
        stuEnrollment.setUpdateTime(DateUtils.getNowDate());
        return stuEnrollmentMapper.updateStuEnrollment(stuEnrollment);
    }

    /**
     * 批量删除学籍信息
     *
     * @param ids 需要删除的学籍信息主键
     * @return 结果
     */
    @Override
    public int deleteStuEnrollmentByIds(Long[] ids)
    {
        return stuEnrollmentMapper.deleteStuEnrollmentByIds(ids);
    }

    /**
     * 删除学籍信息信息
     *
     * @param id 学籍信息主键
     * @return 结果
     */
    @Override
    public int deleteStuEnrollmentById(Long id)
    {
        return stuEnrollmentMapper.deleteStuEnrollmentById(id);
    }
}
