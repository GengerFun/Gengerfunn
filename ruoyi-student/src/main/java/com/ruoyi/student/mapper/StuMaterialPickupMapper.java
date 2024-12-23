package com.ruoyi.student.mapper;

import com.ruoyi.student.domain.StuMaterialPickup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 物资领取记录Mapper接口
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@Mapper
public interface StuMaterialPickupMapper
{
    /**
     * 查询物资领取记录
     *
     * @param id 物资领取记录主键
     * @return 物资领取记录
     */
    public StuMaterialPickup selectStuMaterialPickupById(Long id);

    /**
     * 查询物资领取记录列表
     *
     * @param stuMaterialPickup 物资领取记录
     * @return 物资领取记录集合
     */
    public List<StuMaterialPickup> selectStuMaterialPickupList(StuMaterialPickup stuMaterialPickup);

    /**
     * 新增物资领取记录
     *
     * @param stuMaterialPickup 物资领取记录
     * @return 结果
     */
    public int insertStuMaterialPickup(StuMaterialPickup stuMaterialPickup);

    /**
     * 修改物资领取记录
     *
     * @param stuMaterialPickup 物资领取记录
     * @return 结果
     */
    public int updateStuMaterialPickup(StuMaterialPickup stuMaterialPickup);

    /**
     * 删除物资领取记录
     *
     * @param id 物资领取记录主键
     * @return 结果
     */
    public int deleteStuMaterialPickupById(Long id);

    /**
     * 批量删除物资领取记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuMaterialPickupByIds(Long[] ids);
}
