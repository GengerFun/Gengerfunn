package com.ruoyi.student.service;

import com.ruoyi.student.domain.StuMajor;

import java.util.List;

/**
 * 专业信息Service接口
 *
 * @author ruoyi
 * @date 2024-12-11
 */
public interface IStuMajorService
{
    /**
     * 查询专业信息
     *
     * @param id 专业信息主键
     * @return 专业信息
     */
    public StuMajor selectStuMajorById(Long id);

    /**
     * 查询专业信息列表
     *
     * @param stuMajor 专业信息
     * @return 专业信息集合
     */
    public List<StuMajor> selectStuMajorList(StuMajor stuMajor);

    /**
     * 新增专业信息
     *
     * @param stuMajor 专业信息
     * @return 结果
     */
    public int insertStuMajor(StuMajor stuMajor);

    /**
     * 修改专业信息
     *
     * @param stuMajor 专业信息
     * @return 结果
     */
    public int updateStuMajor(StuMajor stuMajor);

    /**
     * 批量删除专业信息
     *
     * @param ids 需要删除的专业信息主键集合
     * @return 结果
     */
    public int deleteStuMajorByIds(Long[] ids);

    /**
     * 删除专业信息信息
     *
     * @param id 专业信息主键
     * @return 结果
     */
    public int deleteStuMajorById(Long id);
}
