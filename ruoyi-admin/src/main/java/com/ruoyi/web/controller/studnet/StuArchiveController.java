package com.ruoyi.web.controller.studnet;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.student.domain.StuArchive;
import com.ruoyi.student.service.IStuArchiveService;
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
 * 档案信息管理Controller
 *
 * @author ruoyi
 * @date 2025-01-15
 */
@RestController
@RequestMapping("/student/archive")
public class StuArchiveController extends BaseController
{
    @Autowired
    private IStuArchiveService stuArchiveService;

    /**
     * 查询档案信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:archive:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuArchive stuArchive)
    {
        startPage();
        List<StuArchive> list = stuArchiveService.selectStuArchiveList(stuArchive);
        return getDataTable(list);
    }

    /**
     * 导出档案信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:archive:export')")
    @Log(title = "档案信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuArchive stuArchive)
    {
        List<StuArchive> list = stuArchiveService.selectStuArchiveList(stuArchive);
        ExcelUtil<StuArchive> util = new ExcelUtil<StuArchive>(StuArchive.class);
        util.exportExcel(response, list, "档案信息管理数据");
    }

    /**
     * 获取档案信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:archive:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuArchiveService.selectStuArchiveById(id));
    }

    /**
     * 新增档案信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:archive:add')")
    @Log(title = "档案信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuArchive stuArchive)
    {
        return toAjax(stuArchiveService.insertStuArchive(stuArchive));
    }

    /**
     * 修改档案信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:archive:edit')")
    @Log(title = "档案信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuArchive stuArchive)
    {
        return toAjax(stuArchiveService.updateStuArchive(stuArchive));
    }

    /**
     * 删除档案信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:archive:remove')")
    @Log(title = "档案信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuArchiveService.deleteStuArchiveByIds(ids));
    }
}
