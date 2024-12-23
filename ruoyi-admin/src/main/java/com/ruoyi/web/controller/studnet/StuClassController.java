package com.ruoyi.web.controller.studnet;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.student.domain.StuClass;
import com.ruoyi.student.service.IStuClassService;
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
 * 班级信息Controller
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@RestController
@RequestMapping("/student/class")
public class StuClassController extends BaseController
{
    @Autowired
    private IStuClassService stuClassService;

    /**
     * 查询班级信息列表
     */

    @GetMapping("/list")
    public TableDataInfo list(StuClass stuClass)
    {
        startPage();
        List<StuClass> list = stuClassService.selectStuClassList(stuClass);
        return getDataTable(list);
    }

    /**
     * 导出班级信息列表
     */

    @Log(title = "班级信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuClass stuClass)
    {
        List<StuClass> list = stuClassService.selectStuClassList(stuClass);
        ExcelUtil<StuClass> util = new ExcelUtil<StuClass>(StuClass.class);
        util.exportExcel(response, list, "班级信息数据");
    }

    /**
     * 获取班级信息详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuClassService.selectStuClassById(id));
    }

    /**
     * 新增班级信息
     */

    @Log(title = "班级信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuClass stuClass)
    {
        return toAjax(stuClassService.insertStuClass(stuClass));
    }

    /**
     * 修改班级信息
     */

    @Log(title = "班级信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuClass stuClass)
    {
        return toAjax(stuClassService.updateStuClass(stuClass));
    }

    /**
     * 删除班级信息
     */

    @Log(title = "班级信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuClassService.deleteStuClassByIds(ids));
    }
}
