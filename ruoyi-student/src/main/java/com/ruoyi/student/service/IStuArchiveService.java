package com.ruoyi.student.service;

import com.ruoyi.student.domain.StuArchive;

import java.util.List;


/**
 * 档案信息管理Service接口
 *
 * @author ruoyi
 * @date 2025-01-15
 */
public interface IStuArchiveService
{
    /**
     * 查询档案信息管理
     *
     * @param id 档案信息管理主键
     * @return 档案信息管理
     */
    public StuArchive selectStuArchiveById(Long id);

    /**
     * 查询档案信息管理列表
     *
     * @param stuArchive 档案信息管理
     * @return 档案信息管理集合
     */
    public List<StuArchive> selectStuArchiveList(StuArchive stuArchive);

    /**
     * 新增档案信息管理
     *
     * @param stuArchive 档案信息管理
     * @return 结果
     */
    public int insertStuArchive(StuArchive stuArchive);

    /**
     * 修改档案信息管理
     *
     * @param stuArchive 档案信息管理
     * @return 结果
     */
    public int updateStuArchive(StuArchive stuArchive);

    /**
     * 批量删除档案信息管理
     *
     * @param ids 需要删除的档案信息管理主键集合
     * @return 结果
     */
    public int deleteStuArchiveByIds(Long[] ids);

    /**
     * 删除档案信息管理信息
     *
     * @param id 档案信息管理主键
     * @return 结果
     */
    public int deleteStuArchiveById(Long id);
}
