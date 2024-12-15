package com.ruoyi.student.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.student.domain.StuClass;
import com.ruoyi.student.mapper.StuClassMapper;
import com.ruoyi.student.service.IStuClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 班级信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@Service
public class StuClassServiceImpl implements IStuClassService
{
    @Autowired
    private StuClassMapper stuClassMapper;

    /**
     * 查询班级信息
     *
     * @param id 班级信息主键
     * @return 班级信息
     */
    @Override
    public StuClass selectStuClassById(Long id)
    {
        return stuClassMapper.selectStuClassById(id);
    }

    /**
     * 查询班级信息列表
     *
     * @param stuClass 班级信息
     * @return 班级信息
     */
    @Override
    public List<StuClass> selectStuClassList(StuClass stuClass)
    {
        return stuClassMapper.selectStuClassList(stuClass);
    }

    /**
     * 新增班级信息
     *
     * @param stuClass 班级信息
     * @return 结果
     */
    @Override
    public int insertStuClass(StuClass stuClass)
    {
        stuClass.setCreateTime(DateUtils.getNowDate());
        return stuClassMapper.insertStuClass(stuClass);
    }

    /**
     * 修改班级信息
     *
     * @param stuClass 班级信息
     * @return 结果
     */
    @Override
    public int updateStuClass(StuClass stuClass)
    {
        stuClass.setUpdateTime(DateUtils.getNowDate());
        return stuClassMapper.updateStuClass(stuClass);
    }

    /**
     * 批量删除班级信息
     *
     * @param ids 需要删除的班级信息主键
     * @return 结果
     */
    @Override
    public int deleteStuClassByIds(Long[] ids)
    {
        return stuClassMapper.deleteStuClassByIds(ids);
    }

    /**
     * 删除班级信息信息
     *
     * @param id 班级信息主键
     * @return 结果
     */
    @Override
    public int deleteStuClassById(Long id)
    {
        return stuClassMapper.deleteStuClassById(id);
    }
}
