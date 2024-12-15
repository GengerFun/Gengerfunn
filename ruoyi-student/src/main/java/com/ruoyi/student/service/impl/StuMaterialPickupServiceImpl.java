package com.ruoyi.student.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.student.domain.StuMaterialPickup;
import com.ruoyi.student.mapper.StuMaterialPickupMapper;
import com.ruoyi.student.service.IStuMaterialPickupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 物资领取记录Service业务层处理
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@Service
public class StuMaterialPickupServiceImpl implements IStuMaterialPickupService
{
    @Autowired
    private StuMaterialPickupMapper stuMaterialPickupMapper;

    /**
     * 查询物资领取记录
     *
     * @param id 物资领取记录主键
     * @return 物资领取记录
     */
    @Override
    public StuMaterialPickup selectStuMaterialPickupById(Long id)
    {
        return stuMaterialPickupMapper.selectStuMaterialPickupById(id);
    }

    /**
     * 查询物资领取记录列表
     *
     * @param stuMaterialPickup 物资领取记录
     * @return 物资领取记录
     */
    @Override
    public List<StuMaterialPickup> selectStuMaterialPickupList(StuMaterialPickup stuMaterialPickup)
    {
        return stuMaterialPickupMapper.selectStuMaterialPickupList(stuMaterialPickup);
    }

    /**
     * 新增物资领取记录
     *
     * @param stuMaterialPickup 物资领取记录
     * @return 结果
     */
    @Override
    public int insertStuMaterialPickup(StuMaterialPickup stuMaterialPickup)
    {
        stuMaterialPickup.setCreateTime(DateUtils.getNowDate());
        return stuMaterialPickupMapper.insertStuMaterialPickup(stuMaterialPickup);
    }

    /**
     * 修改物资领取记录
     *
     * @param stuMaterialPickup 物资领取记录
     * @return 结果
     */
    @Override
    public int updateStuMaterialPickup(StuMaterialPickup stuMaterialPickup)
    {
        stuMaterialPickup.setUpdateTime(DateUtils.getNowDate());
        return stuMaterialPickupMapper.updateStuMaterialPickup(stuMaterialPickup);
    }

    /**
     * 批量删除物资领取记录
     *
     * @param ids 需要删除的物资领取记录主键
     * @return 结果
     */
    @Override
    public int deleteStuMaterialPickupByIds(Long[] ids)
    {
        return stuMaterialPickupMapper.deleteStuMaterialPickupByIds(ids);
    }

    /**
     * 删除物资领取记录信息
     *
     * @param id 物资领取记录主键
     * @return 结果
     */
    @Override
    public int deleteStuMaterialPickupById(Long id)
    {
        return stuMaterialPickupMapper.deleteStuMaterialPickupById(id);
    }
}
