package com.ruoyi.student.mapper;

import com.ruoyi.student.domain.StuPayment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 缴费记录Mapper接口
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@Mapper
public interface StuPaymentMapper
{
    /**
     * 查询缴费记录
     *
     * @param id 缴费记录主键
     * @return 缴费记录
     */
    public StuPayment selectStuPaymentById(Long id);

    /**
     * 查询缴费记录列表
     *
     * @param stuPayment 缴费记录
     * @return 缴费记录集合
     */
    public List<StuPayment> selectStuPaymentList(StuPayment stuPayment);

    /**
     * 新增缴费记录
     *
     * @param stuPayment 缴费记录
     * @return 结果
     */
    public int insertStuPayment(StuPayment stuPayment);

    /**
     * 修改缴费记录
     *
     * @param stuPayment 缴费记录
     * @return 结果
     */
    public int updateStuPayment(StuPayment stuPayment);

    /**
     * 删除缴费记录
     *
     * @param id 缴费记录主键
     * @return 结果
     */
    public int deleteStuPaymentById(Long id);

    /**
     * 批量删除缴费记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuPaymentByIds(Long[] ids);
}
