package com.ruoyi.student.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.student.domain.StuMaterial;
import com.ruoyi.student.mapper.StuMaterialMapper;
import com.ruoyi.student.service.IStuMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 物资管理Service业务层处理
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@Service
public class StuMaterialServiceImpl implements IStuMaterialService
{
    @Autowired
    private StuMaterialMapper stuMaterialMapper;

    /**
     * 查询物资管理
     *
     * @param id 物资管理主键
     * @return 物资管理
     */
    @Override
    public StuMaterial selectStuMaterialById(Long id)
    {
        return stuMaterialMapper.selectStuMaterialById(id);
    }

    /**
     * 查询物资管理列表
     *
     * @param stuMaterial 物资管理
     * @return 物资管理
     */
    @Override
    public List<StuMaterial> selectStuMaterialList(StuMaterial stuMaterial)
    {
        return stuMaterialMapper.selectStuMaterialList(stuMaterial);
    }

    /**
     * 新增物资管理
     *
     * @param stuMaterial 物资管理
     * @return 结果
     */
    @Override
    public int insertStuMaterial(StuMaterial stuMaterial)
    {
        stuMaterial.setCreateTime(DateUtils.getNowDate());
        return stuMaterialMapper.insertStuMaterial(stuMaterial);
    }

    /**
     * 修改物资管理
     *
     * @param stuMaterial 物资管理
     * @return 结果
     */
    @Override
    public int updateStuMaterial(StuMaterial stuMaterial)
    {
        stuMaterial.setUpdateTime(DateUtils.getNowDate());
        return stuMaterialMapper.updateStuMaterial(stuMaterial);
    }

    /**
     * 批量删除物资管理
     *
     * @param ids 需要删除的物资管理主键
     * @return 结果
     */
    @Override
    public int deleteStuMaterialByIds(Long[] ids)
    {
        return stuMaterialMapper.deleteStuMaterialByIds(ids);
    }

    /**
     * 删除物资管理信息
     *
     * @param id 物资管理主键
     * @return 结果
     */
    @Override
    public int deleteStuMaterialById(Long id)
    {
        return stuMaterialMapper.deleteStuMaterialById(id);
    }
}
