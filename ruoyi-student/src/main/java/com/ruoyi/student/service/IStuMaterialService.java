package com.ruoyi.student.service;

import com.ruoyi.student.domain.StuMaterial;

import java.util.List;

/**
 * 物资管理Service接口
 *
 * @author ruoyi
 * @date 2024-12-11
 */
public interface IStuMaterialService
{
    /**
     * 查询物资管理
     *
     * @param id 物资管理主键
     * @return 物资管理
     */
    public StuMaterial selectStuMaterialById(Long id);

    /**
     * 查询物资管理列表
     *
     * @param stuMaterial 物资管理
     * @return 物资管理集合
     */
    public List<StuMaterial> selectStuMaterialList(StuMaterial stuMaterial);

    /**
     * 新增物资管理
     *
     * @param stuMaterial 物资管理
     * @return 结果
     */
    public int insertStuMaterial(StuMaterial stuMaterial);

    /**
     * 修改物资管理
     *
     * @param stuMaterial 物资管理
     * @return 结果
     */
    public int updateStuMaterial(StuMaterial stuMaterial);

    /**
     * 批量删除物资管理
     *
     * @param ids 需要删除的物资管理主键集合
     * @return 结果
     */
    public int deleteStuMaterialByIds(Long[] ids);

    /**
     * 删除物资管理信息
     *
     * @param id 物资管理主键
     * @return 结果
     */
    public int deleteStuMaterialById(Long id);
}