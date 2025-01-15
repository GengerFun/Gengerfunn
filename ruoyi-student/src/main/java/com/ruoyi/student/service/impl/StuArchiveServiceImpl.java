package com.ruoyi.student.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.student.domain.StuArchive;
import com.ruoyi.student.mapper.StuArchiveMapper;
import com.ruoyi.student.service.IStuArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 档案信息管理Service业务层处理
 *
 * @author ruoyi
 * @date 2025-01-15
 */
@Service
public class StuArchiveServiceImpl implements IStuArchiveService
{
    @Autowired
    private StuArchiveMapper stuArchiveMapper;

    /**
     * 查询档案信息管理
     *
     * @param id 档案信息管理主键
     * @return 档案信息管理
     */
    @Override
    public StuArchive selectStuArchiveById(Long id)
    {
        return stuArchiveMapper.selectStuArchiveById(id);
    }

    /**
     * 查询档案信息管理列表
     *
     * @param stuArchive 档案信息管理
     * @return 档案信息管理
     */
    @Override
    public List<StuArchive> selectStuArchiveList(StuArchive stuArchive)
    {
        return stuArchiveMapper.selectStuArchiveList(stuArchive);
    }

    /**
     * 新增档案信息管理
     *
     * @param stuArchive 档案信息管理
     * @return 结果
     */
    @Override
    public int insertStuArchive(StuArchive stuArchive)
    {
        stuArchive.setCreateTime(DateUtils.getNowDate());
        return stuArchiveMapper.insertStuArchive(stuArchive);
    }

    /**
     * 修改档案信息管理
     *
     * @param stuArchive 档案信息管理
     * @return 结果
     */
    @Override
    public int updateStuArchive(StuArchive stuArchive)
    {
        stuArchive.setUpdateTime(DateUtils.getNowDate());
        return stuArchiveMapper.updateStuArchive(stuArchive);
    }

    /**
     * 批量删除档案信息管理
     *
     * @param ids 需要删除的档案信息管理主键
     * @return 结果
     */
    @Override
    public int deleteStuArchiveByIds(Long[] ids)
    {
        return stuArchiveMapper.deleteStuArchiveByIds(ids);
    }

    /**
     * 删除档案信息管理信息
     *
     * @param id 档案信息管理主键
     * @return 结果
     */
    @Override
    public int deleteStuArchiveById(Long id)
    {
        return stuArchiveMapper.deleteStuArchiveById(id);
    }
}
