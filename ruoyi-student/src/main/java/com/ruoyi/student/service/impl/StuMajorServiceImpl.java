package com.ruoyi.student.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.student.domain.StuMajor;
import com.ruoyi.student.mapper.StuMajorMapper;
import com.ruoyi.student.service.IStuMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 专业信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@Service
public class StuMajorServiceImpl implements IStuMajorService
{
    @Autowired
    private StuMajorMapper stuMajorMapper;

    /**
     * 查询专业信息
     *
     * @param id 专业信息主键
     * @return 专业信息
     */
    @Override
    public StuMajor selectStuMajorById(Long id)
    {
        return stuMajorMapper.selectStuMajorById(id);
    }

    /**
     * 查询专业信息列表
     *
     * @param stuMajor 专业信息
     * @return 专业信息
     */
    @Override
    public List<StuMajor> selectStuMajorList(StuMajor stuMajor)
    {
        return stuMajorMapper.selectStuMajorList(stuMajor);
    }

    /**
     * 新增专业信息
     *
     * @param stuMajor 专业信息
     * @return 结果
     */
    @Override
    public int insertStuMajor(StuMajor stuMajor)
    {
        stuMajor.setCreateTime(DateUtils.getNowDate());
        return stuMajorMapper.insertStuMajor(stuMajor);
    }

    /**
     * 修改专业信息
     *
     * @param stuMajor 专业信息
     * @return 结果
     */
    @Override
    public int updateStuMajor(StuMajor stuMajor)
    {
        stuMajor.setUpdateTime(DateUtils.getNowDate());
        return stuMajorMapper.updateStuMajor(stuMajor);
    }

    /**
     * 批量删除专业信息
     *
     * @param ids 需要删除的专业信息主键
     * @return 结果
     */
    @Override
    public int deleteStuMajorByIds(Long[] ids)
    {
        return stuMajorMapper.deleteStuMajorByIds(ids);
    }

    /**
     * 删除专业信息信息
     *
     * @param id 专业信息主键
     * @return 结果
     */
    @Override
    public int deleteStuMajorById(Long id)
    {
        return stuMajorMapper.deleteStuMajorById(id);
    }
}
