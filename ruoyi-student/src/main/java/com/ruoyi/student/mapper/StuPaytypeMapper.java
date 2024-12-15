package com.ruoyi.student.mapper;

import com.ruoyi.student.domain.StuPaytype;

import java.util.List;

/**
 * 缴费类型Mapper接口
 *
 * @author ruoyi
 * @date 2024-12-15
 */
public interface StuPaytypeMapper
{
    /**
     * 查询缴费类型
     *
     * @param id 缴费类型主键
     * @return 缴费类型
     */
    public StuPaytype selectStuPaytypeById(Long id);

    /**
     * 查询缴费类型列表
     *
     * @param stuPaytype 缴费类型
     * @return 缴费类型集合
     */
    public List<StuPaytype> selectStuPaytypeList(StuPaytype stuPaytype);

    /**
     * 新增缴费类型
     *
     * @param stuPaytype 缴费类型
     * @return 结果
     */
    public int insertStuPaytype(StuPaytype stuPaytype);

    /**
     * 修改缴费类型
     *
     * @param stuPaytype 缴费类型
     * @return 结果
     */
    public int updateStuPaytype(StuPaytype stuPaytype);

    /**
     * 删除缴费类型
     *
     * @param id 缴费类型主键
     * @return 结果
     */
    public int deleteStuPaytypeById(Long id);

    /**
     * 批量删除缴费类型
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuPaytypeByIds(Long[] ids);
}
