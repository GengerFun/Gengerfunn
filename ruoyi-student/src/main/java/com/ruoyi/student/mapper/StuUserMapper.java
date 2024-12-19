package com.ruoyi.student.mapper;

import com.ruoyi.student.domain.StuUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生信息Mapper接口
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@Mapper
public interface StuUserMapper
{
    /**
     * 查询学生信息
     *
     * @param id 学生信息主键
     * @return 学生信息
     */
    public StuUser selectStuUserById(Long id);

    /**
     * 查询学生信息列表
     *
     * @param stuUser 学生信息
     * @return 学生信息集合
     */
    public List<StuUser> selectStuUserList(StuUser stuUser);

    /**
     * 新增学生信息
     *
     * @param stuUser 学生信息
     * @return 结果
     */
    public int insertStuUser(StuUser stuUser);

    /**
     * 修改学生信息
     *
     * @param stuUser 学生信息
     * @return 结果
     */
    public int updateStuUser(StuUser stuUser);

    /**
     * 删除学生信息
     *
     * @param id 学生信息主键
     * @return 结果
     */
    public int deleteStuUserById(Long id);

    /**
     * 批量删除学生信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuUserByIds(Long[] ids);
}
