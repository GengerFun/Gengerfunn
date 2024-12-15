package com.ruoyi.student.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.student.domain.StuPaytype;
import com.ruoyi.student.mapper.StuPaytypeMapper;
import com.ruoyi.student.service.IStuPaytypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 缴费类型Service业务层处理
 *
 * @author ruoyi
 * @date 2024-12-15
 */
@Service
public class StuPaytypeServiceImpl implements IStuPaytypeService
{
    @Autowired
    private StuPaytypeMapper stuPaytypeMapper;

    /**
     * 查询缴费类型
     *
     * @param id 缴费类型主键
     * @return 缴费类型
     */
    @Override
    public StuPaytype selectStuPaytypeById(Long id)
    {
        return stuPaytypeMapper.selectStuPaytypeById(id);
    }

    /**
     * 查询缴费类型列表
     *
     * @param stuPaytype 缴费类型
     * @return 缴费类型
     */
    @Override
    public List<StuPaytype> selectStuPaytypeList(StuPaytype stuPaytype)
    {
        return stuPaytypeMapper.selectStuPaytypeList(stuPaytype);
    }

    /**
     * 新增缴费类型
     *
     * @param stuPaytype 缴费类型
     * @return 结果
     */
    @Override
    public int insertStuPaytype(StuPaytype stuPaytype)
    {
        stuPaytype.setCreateTime(DateUtils.getNowDate());
        return stuPaytypeMapper.insertStuPaytype(stuPaytype);
    }

    /**
     * 修改缴费类型
     *
     * @param stuPaytype 缴费类型
     * @return 结果
     */
    @Override
    public int updateStuPaytype(StuPaytype stuPaytype)
    {
        stuPaytype.setUpdateTime(DateUtils.getNowDate());
        return stuPaytypeMapper.updateStuPaytype(stuPaytype);
    }

    /**
     * 批量删除缴费类型
     *
     * @param ids 需要删除的缴费类型主键
     * @return 结果
     */
    @Override
    public int deleteStuPaytypeByIds(Long[] ids)
    {
        return stuPaytypeMapper.deleteStuPaytypeByIds(ids);
    }

    /**
     * 删除缴费类型信息
     *
     * @param id 缴费类型主键
     * @return 结果
     */
    @Override
    public int deleteStuPaytypeById(Long id)
    {
        return stuPaytypeMapper.deleteStuPaytypeById(id);
    }
}
