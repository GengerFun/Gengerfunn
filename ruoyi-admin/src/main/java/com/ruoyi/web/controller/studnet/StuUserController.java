package com.ruoyi.web.controller.studnet;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.student.domain.StuUser;
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

    /**
     * 查询学生信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuUser stuUser)
    {
        startPage();
        List<StuUser> list = stuUserService.selectStuUserList(stuUser);
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:export')")
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
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuUserService.selectStuUserById(id));
    }

    /**
     * 新增学生信息
     */
    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuUser stuUser)
    {
        return toAjax(stuUserService.insertStuUser(stuUser));
    }

    /**
     * 修改学生信息
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuUser stuUser)
    {
        return toAjax(stuUserService.updateStuUser(stuUser));
    }

    /**
     * 删除学生信息
     */
    @PreAuthorize("@ss.hasPermi('system:user:remove')")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuUserService.deleteStuUserByIds(ids));
    }
}
