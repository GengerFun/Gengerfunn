package com.ruoyi.student.mapper;

import com.ruoyi.student.domain.StuDormitory;

import java.util.List;

/**
 * 宿舍信息Mapper接口
 *
 * @author ruoyi
 * @date 2024-12-11
 */
public interface StuDormitoryMapper
{
    /**
     * 查询宿舍信息
     *
     * @param id 宿舍信息主键
     * @return 宿舍信息
     */
    public StuDormitory selectStuDormitoryById(Long id);

    /**
     * 查询宿舍信息列表
     *
     * @param stuDormitory 宿舍信息
     * @return 宿舍信息集合
     */
    public List<StuDormitory> selectStuDormitoryList(StuDormitory stuDormitory);

    /**
     * 新增宿舍信息
     *
     * @param stuDormitory 宿舍信息
     * @return 结果
     */
    public int insertStuDormitory(StuDormitory stuDormitory);

    /**
     * 修改宿舍信息
     *
     * @param stuDormitory 宿舍信息
     * @return 结果
     */
    public int updateStuDormitory(StuDormitory stuDormitory);

    /**
     * 删除宿舍信息
     *
     * @param id 宿舍信息主键
     * @return 结果
     */
    public int deleteStuDormitoryById(Long id);

    /**
     * 批量删除宿舍信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuDormitoryByIds(Long[] ids);
}
