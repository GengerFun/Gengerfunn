package com.ruoyi.student.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.student.domain.StuClass;
import com.ruoyi.student.domain.StuUser;
import com.ruoyi.student.domain.dto.StuUserDto;
import com.ruoyi.student.mapper.StuClassMapper;
import com.ruoyi.student.mapper.StuUserMapper;
import com.ruoyi.student.service.IStuUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ruoyi.common.utils.SecurityUtils.getLoginUser;

/**
 * 学生信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@Service
public class StuUserServiceImpl implements IStuUserService
{
    @Autowired
    private StuUserMapper stuUserMapper;

    @Autowired
    private StuClassMapper stuClassMapper;

    /**
     * 查询学生信息
     *
     * @param id 学生信息主键
     * @return 学生信息
     */
    @Override
    public StuUserDto selectStuUserById(Long id)
    {
        StuUser stuUser = stuUserMapper.selectStuUserById(id);
        StuClass stuClass = stuClassMapper.selectStuClassById(id);
        StuUserDto stuUserDto = new StuUserDto();
        stuUserDto.setStuClass(stuClass);
        stuUserDto.setIdStudent(stuUser.getIdStudent());
        stuUserDto.setIdNumber(stuUser.getIdNumber());
        stuUserDto.setMajorId(stuUser.getMajorId());
        stuUserDto.setClassId(stuUser.getClassId());
        stuUserDto.setDormitoryId(stuUser.getDormitoryId());
        stuUserDto.setStuName(stuUser.getStuName());
        return stuUserDto;
    }

    /**
     * 查询学生信息列表
     *
     * @param stuUser 学生信息
     * @return 学生信息
     */
    @Override
    public List<StuUser> selectStuUserList(StuUser stuUser)
    {
        return stuUserMapper.selectStuUserList(stuUser);
    }

    /**
     * 新增学生信息
     *
     * @param stuUser 学生信息
     * @return 结果
     */
    @Override
    public int insertStuUser(StuUser stuUser)
    {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        stuUser.setUserId(user.getUserId());
        stuUser.setCreateTime(DateUtils.getNowDate());
        return stuUserMapper.insertStuUser(stuUser);
    }

    /**
     * 修改学生信息
     *
     * @param stuUser 学生信息
     * @return 结果
     */
    @Override
    public int updateStuUser(StuUser stuUser)
    {
        stuUser.setUpdateTime(DateUtils.getNowDate());
        return stuUserMapper.updateStuUser(stuUser);
    }

    /**
     * 批量删除学生信息
     *
     * @param ids 需要删除的学生信息主键
     * @return 结果
     */
    @Override
    public int deleteStuUserByIds(Long[] ids)
    {
        return stuUserMapper.deleteStuUserByIds(ids);
    }

    /**
     * 删除学生信息信息
     *
     * @param id 学生信息主键
     * @return 结果
     */
    @Override
    public int deleteStuUserById(Long id)
    {
        return stuUserMapper.deleteStuUserById(id);
    }
}
