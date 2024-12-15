package com.ruoyi.student.service;

import com.ruoyi.student.domain.StuClass;

import java.util.List;

/**
 * 班级信息Service接口
 *
 * @author ruoyi
 * @date 2024-12-11
 */
public interface IStuClassService
{
    /**
     * 查询班级信息
     *
     * @param id 班级信息主键
     * @return 班级信息
     */
    public StuClass selectStuClassById(Long id);

    /**
     * 查询班级信息列表
     *
     * @param stuClass 班级信息
     * @return 班级信息集合
     */
    public List<StuClass> selectStuClassList(StuClass stuClass);

    /**
     * 新增班级信息
     *
     * @param stuClass 班级信息
     * @return 结果
     */
    public int insertStuClass(StuClass stuClass);

    /**
     * 修改班级信息
     *
     * @param stuClass 班级信息
     * @return 结果
     */
    public int updateStuClass(StuClass stuClass);

    /**
     * 批量删除班级信息
     *
     * @param ids 需要删除的班级信息主键集合
     * @return 结果
     */
    public int deleteStuClassByIds(Long[] ids);

    /**
     * 删除班级信息信息
     *
     * @param id 班级信息主键
     * @return 结果
     */
    public int deleteStuClassById(Long id);
}
