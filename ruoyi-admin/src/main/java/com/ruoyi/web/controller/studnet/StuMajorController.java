package com.ruoyi.web.controller.studnet;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.student.domain.StuMajor;
import com.ruoyi.student.service.IStuMajorService;
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
 * 专业信息Controller
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@RestController
@RequestMapping("/student/major")
public class StuMajorController extends BaseController
{
    @Autowired
    private IStuMajorService stuMajorService;

    /**
     * 查询专业信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:major:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuMajor stuMajor)
    {
        startPage();
        List<StuMajor> list = stuMajorService.selectStuMajorList(stuMajor);
        return getDataTable(list);
    }

    /**
     * 导出专业信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:major:export')")
    @Log(title = "专业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuMajor stuMajor)
    {
        List<StuMajor> list = stuMajorService.selectStuMajorList(stuMajor);
        ExcelUtil<StuMajor> util = new ExcelUtil<StuMajor>(StuMajor.class);
        util.exportExcel(response, list, "专业信息数据");
    }

    /**
     * 获取专业信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:major:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuMajorService.selectStuMajorById(id));
    }

    /**
     * 新增专业信息
     */
//    @PreAuthorize("@ss.hasPermi('system:major:add')")
    @Log(title = "专业信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuMajor stuMajor)
    {
        return toAjax(stuMajorService.insertStuMajor(stuMajor));
    }

    /**
     * 修改专业信息
     */
//    @PreAuthorize("@ss.hasPermi('system:major:edit')")
    @Log(title = "专业信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuMajor stuMajor)
    {
        return toAjax(stuMajorService.updateStuMajor(stuMajor));
    }

    /**
     * 删除专业信息
     */
//    @PreAuthorize("@ss.hasPermi('system:major:remove')")
    @Log(title = "专业信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuMajorService.deleteStuMajorByIds(ids));
    }
}
