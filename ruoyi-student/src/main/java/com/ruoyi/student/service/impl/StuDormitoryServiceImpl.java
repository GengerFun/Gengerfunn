package com.ruoyi.student.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.student.domain.StuDormitory;
import com.ruoyi.student.mapper.StuDormitoryMapper;
import com.ruoyi.student.service.IStuDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 宿舍信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@Service
public class StuDormitoryServiceImpl implements IStuDormitoryService
{
    @Autowired
    private StuDormitoryMapper stuDormitoryMapper;

    /**
     * 查询宿舍信息
     *
     * @param id 宿舍信息主键
     * @return 宿舍信息
     */
    @Override
    public StuDormitory selectStuDormitoryById(Long id)
    {
        return stuDormitoryMapper.selectStuDormitoryById(id);
    }

    /**
     * 查询宿舍信息列表
     *
     * @param stuDormitory 宿舍信息
     * @return 宿舍信息
     */
    @Override
    public List<StuDormitory> selectStuDormitoryList(StuDormitory stuDormitory)
    {
        return stuDormitoryMapper.selectStuDormitoryList(stuDormitory);
    }

    /**
     * 新增宿舍信息
     *
     * @param stuDormitory 宿舍信息
     * @return 结果
     */
    @Override
    public int insertStuDormitory(StuDormitory stuDormitory)
    {
        stuDormitory.setCreateTime(DateUtils.getNowDate());
        return stuDormitoryMapper.insertStuDormitory(stuDormitory);
    }

    /**
     * 修改宿舍信息
     *
     * @param stuDormitory 宿舍信息
     * @return 结果
     */
    @Override
    public int updateStuDormitory(StuDormitory stuDormitory)
    {
        stuDormitory.setUpdateTime(DateUtils.getNowDate());
        return stuDormitoryMapper.updateStuDormitory(stuDormitory);
    }

    /**
     * 批量删除宿舍信息
     *
     * @param ids 需要删除的宿舍信息主键
     * @return 结果
     */
    @Override
    public int deleteStuDormitoryByIds(Long[] ids)
    {
        return stuDormitoryMapper.deleteStuDormitoryByIds(ids);
    }

    /**
     * 删除宿舍信息信息
     *
     * @param id 宿舍信息主键
     * @return 结果
     */
    @Override
    public int deleteStuDormitoryById(Long id)
    {
        return stuDormitoryMapper.deleteStuDormitoryById(id);
    }
}
