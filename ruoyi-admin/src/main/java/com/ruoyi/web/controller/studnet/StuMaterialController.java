package com.ruoyi.web.controller.studnet;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.student.domain.StuMaterial;
import com.ruoyi.student.service.IStuMaterialService;
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
 * 物资管理Controller
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@RestController
@RequestMapping("/student/material")
public class StuMaterialController extends BaseController
{
    @Autowired
    private IStuMaterialService stuMaterialService;

    /**
     * 查询物资管理列表
     */
//    @PreAuthorize("@ss.hasPermi('system:material:list')")
    @GetMapping("/getAllMaterial")
    public TableDataInfo getAllMaterial()
    {
        startPage();
        StuMaterial stuMaterial = new StuMaterial();
        List<StuMaterial> list = stuMaterialService.selectStuMaterialList(stuMaterial);
        return getDataTable(list);
    }

    /**
     * 导出物资管理列表
     */
//    @PreAuthorize("@ss.hasPermi('system:material:export')")
    @Log(title = "物资管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuMaterial stuMaterial)
    {
        List<StuMaterial> list = stuMaterialService.selectStuMaterialList(stuMaterial);
        ExcelUtil<StuMaterial> util = new ExcelUtil<StuMaterial>(StuMaterial.class);
        util.exportExcel(response, list, "物资管理数据");
    }

    /**
     * 获取物资管理详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:material:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuMaterialService.selectStuMaterialById(id));
    }

    /**
     * 新增物资管理
     */
//    @PreAuthorize("@ss.hasPermi('system:material:add')")
    @Log(title = "物资管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuMaterial stuMaterial)
    {
        return toAjax(stuMaterialService.insertStuMaterial(stuMaterial));
    }

    /**
     * 修改物资管理
     */
//    @PreAuthorize("@ss.hasPermi('system:material:edit')")
    @Log(title = "物资管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuMaterial stuMaterial)
    {
        return toAjax(stuMaterialService.updateStuMaterial(stuMaterial));
    }

    /**
     * 删除物资管理
     */
//    @PreAuthorize("@ss.hasPermi('system:material:remove')")
    @Log(title = "物资管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuMaterialService.deleteStuMaterialByIds(ids));
    }
}
