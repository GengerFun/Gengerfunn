package com.ruoyi.web.controller.studnet;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.student.domain.StuEnrollment;
import com.ruoyi.student.domain.dto.StuUserDto;
import com.ruoyi.student.domain.vo.StuUserVO;
import com.ruoyi.student.service.IStuEnrollmentService;
import com.ruoyi.student.service.IStuUserService;
import com.ruoyi.system.service.ISysUserService;
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
 * 学籍信息Controller
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@RestController
@RequestMapping("/student/enrollment")
public class StuEnrollmentController extends BaseController
{
    @Autowired
    private IStuEnrollmentService stuEnrollmentService;

    @Autowired
    private IStuUserService stuUserService;

    @Autowired
    private ISysUserService userService;
    /**
     * 查询学籍信息列表
     */

    @GetMapping("/list")
    public TableDataInfo list(StuEnrollment stuEnrollment)
    {
        startPage();
        List<StuEnrollment> list = stuEnrollmentService.selectStuEnrollmentList(stuEnrollment);
        return getDataTable(list);
    }

    /**
     * 导出学籍信息列表
     */

    @Log(title = "学籍信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuEnrollment stuEnrollment)
    {
        List<StuEnrollment> list = stuEnrollmentService.selectStuEnrollmentList(stuEnrollment);
        ExcelUtil<StuEnrollment> util = new ExcelUtil<StuEnrollment>(StuEnrollment.class);
        util.exportExcel(response, list, "学籍信息数据");
    }

    /**
     * 获取学籍信息详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:enrollment:query')")
    @GetMapping(value = "/getEnrollmentByUserId")
    public AjaxResult getEnrollmentByUserId()
    {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        StuUserDto stuUserDto = stuUserService.selectStuUserById(user.getUserId());
        StuUserVO stuUserVO = new StuUserVO();
        stuUserVO.setIdNumber(stuUserDto.getIdNumber());
        stuUserVO.setClassName(stuUserDto.getStuClass().getClassName());
        stuUserVO.setIdStudent(stuUserDto.getIdStudent());
        StuEnrollment stuEnrollment = stuEnrollmentService.selectStuEnrollmentById(user.getUserId());
        stuUserVO.setStuEnrollment(stuEnrollment);
        return success(stuUserVO);
    }

    /**
     * 新增学籍信息
     */
//     @PreAuthorize("@ss.hasPermi('system:enrollment:add')")
    @Log(title = "学籍信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuEnrollment stuEnrollment)
    {
        return toAjax(stuEnrollmentService.insertStuEnrollment(stuEnrollment));
    }

    /**
     * 修改学籍信息
     */
//     @PreAuthorize("@ss.hasPermi('system:enrollment:edit')")
    @Log(title = "学籍信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuEnrollment stuEnrollment)
    {
        return toAjax(stuEnrollmentService.updateStuEnrollment(stuEnrollment));
    }

    /**
     * 删除学籍信息
     */
//     @PreAuthorize("@ss.hasPermi('system:enrollment:remove')")
    @Log(title = "学籍信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuEnrollmentService.deleteStuEnrollmentByIds(ids));
    }
}
