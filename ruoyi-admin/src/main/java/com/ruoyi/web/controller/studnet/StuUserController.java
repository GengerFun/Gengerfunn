package com.ruoyi.web.controller.studnet;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.student.domain.StuPayment;
import com.ruoyi.student.domain.StuUser;
import com.ruoyi.student.domain.dto.StuUserDto;
import com.ruoyi.student.service.IStuPaymentService;
import com.ruoyi.student.service.IStuUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生信息Controller
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@RestController
@RequestMapping("/student/user")
public class StuUserController extends BaseController
{
    @Autowired
    private IStuUserService stuUserService;

    @Autowired
    private IStuPaymentService stuPaymentService;
    /**
     * 查询学生信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public AjaxResult getAllMember()
    {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        StuUser stuUser = new StuUser();
        StuUserDto stuUserDto = stuUserService.selectStuUserById(user.getUserId());
        stuUser.setClassId(stuUserDto.getClassId());
        List<StuUser> list = stuUserService.selectStuUserList(stuUser);
        return success(list);
    }

    /**
     * 导出学生信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:user:export')")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuUser stuUser)
    {
        List<StuUser> list = stuUserService.selectStuUserList(stuUser);
        ExcelUtil<StuUser> util = new ExcelUtil<StuUser>(StuUser.class);
        util.exportExcel(response, list, "学生信息数据");
    }

    /**
     * 获取学生信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuUserService.selectStuUserById(id));
    }

    /**
     * 新增学生信息
     */
//    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @Log(title = "学生实名", businessType = BusinessType.INSERT)
    @PostMapping("/realName")
    public AjaxResult add(@RequestBody StuUser stuUser)
    {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        StuUserDto stuUserDto = stuUserService.selectStuUserById(user.getUserId());
        if (ObjectUtil.isNotEmpty(stuUserDto) && ObjectUtil.isNotEmpty(stuUserDto.getUserId())){
            throw new RuntimeException("请勿重复实名！");
        }
        return toAjax(stuUserService.insertStuUser(stuUser));
    }



    /**
     * 判断学生是否实名或者缴费
     */
//    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping(value = "/getPression")
    public AjaxResult getPression()
    {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        StuUser stuUser = new StuUser();
        stuUser.setUserId(user.getUserId());
        List<StuUser> stuUsers = stuUserService.selectStuUserList(stuUser);
        StuPayment stuPayment = new StuPayment();
        stuPayment.setStuId(user.getUserId());
        List<StuPayment> stuPayments = stuPaymentService.selectStuPaymentList(stuPayment);
        // 都没有操作
        /*if (stuUsers.size()==0 && stuPayments.size() == 0){
return AjaxResult.success("未实名");
        }*/
        // 都已完成
        if (stuUsers.size()!=0 && stuPayments.size() != 0){
            return AjaxResult.success("已缴费");
        }

        if (stuUsers.size()!=0 && stuPayments.size() == 0){
            return AjaxResult.success("已实名未缴费");
        }
        return AjaxResult.success("未实名");
    }

    /**
     * 修改学生信息
     */
//    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuUser stuUser)
    {
        return toAjax(stuUserService.updateStuUser(stuUser));
    }

    /**
     * 删除学生信息
     */
//    @PreAuthorize("@ss.hasPermi('system:user:remove')")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuUserService.deleteStuUserByIds(ids));
    }
}
