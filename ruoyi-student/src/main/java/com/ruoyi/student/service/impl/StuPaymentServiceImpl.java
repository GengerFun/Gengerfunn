package com.ruoyi.student.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.student.domain.StuPayment;
import com.ruoyi.student.mapper.StuPaymentMapper;
import com.ruoyi.student.service.IStuPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 缴费记录Service业务层处理
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@Service
public class StuPaymentServiceImpl implements IStuPaymentService
{
    @Autowired
    private StuPaymentMapper stuPaymentMapper;

    /**
     * 查询缴费记录
     *
     * @param id 缴费记录主键
     * @return 缴费记录
     */
    @Override
    public StuPayment selectStuPaymentById(Long id)
    {
        return stuPaymentMapper.selectStuPaymentById(id);
    }

    /**
     * 查询缴费记录列表
     *
     * @param stuPayment 缴费记录
     * @return 缴费记录
     */
    @Override
    public List<StuPayment> selectStuPaymentList(StuPayment stuPayment)
    {



        return stuPaymentMapper.selectStuPaymentList(stuPayment);
    }

    /**
     * 新增缴费记录
     *
     * @param stuPayment 缴费记录
     * @return 结果
     */
    @Override
    public int insertStuPayment(StuPayment stuPayment)
    {
        stuPayment.setCreateTime(DateUtils.getNowDate());
        return stuPaymentMapper.insertStuPayment(stuPayment);
    }

    /**
     * 修改缴费记录
     *
     * @param stuPayment 缴费记录
     * @return 结果
     */
    @Override
    public int updateStuPayment(StuPayment stuPayment)
    {
        stuPayment.setUpdateTime(DateUtils.getNowDate());
        return stuPaymentMapper.updateStuPayment(stuPayment);
    }

    /**
     * 批量删除缴费记录
     *
     * @param ids 需要删除的缴费记录主键
     * @return 结果
     */
    @Override
    public int deleteStuPaymentByIds(Long[] ids)
    {
        return stuPaymentMapper.deleteStuPaymentByIds(ids);
    }

    /**
     * 删除缴费记录信息
     *
     * @param id 缴费记录主键
     * @return 结果
     */
    @Override
    public int deleteStuPaymentById(Long id)
    {
        return stuPaymentMapper.deleteStuPaymentById(id);
    }
}
