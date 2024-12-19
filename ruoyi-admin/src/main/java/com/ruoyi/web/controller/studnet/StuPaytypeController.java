package com.ruoyi.web.controller.studnet;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.student.domain.StuPaytype;
import com.ruoyi.student.service.IStuPaytypeService;
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
 * 缴费类型Controller
 *
 * @author ruoyi
 * @date 2024-12-15
 */
@RestController
@RequestMapping("/student/paytype")
public class StuPaytypeController extends BaseController
{
    @Autowired
    private IStuPaytypeService stuPaytypeService;

    /**
     * 查询缴费类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:paytype:list')")
    @GetMapping("/list")
    public TableDataInfo list()
    {
        StuPaytype stuPaytype = new StuPaytype();
        startPage();
        List<StuPaytype> list = stuPaytypeService.selectStuPaytypeList(stuPaytype);
        return getDataTable(list);
    }

    /**
     * 导出缴费类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:paytype:export')")
    @Log(title = "缴费类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuPaytype stuPaytype)
    {
        List<StuPaytype> list = stuPaytypeService.selectStuPaytypeList(stuPaytype);
        ExcelUtil<StuPaytype> util = new ExcelUtil<StuPaytype>(StuPaytype.class);
        util.exportExcel(response, list, "缴费类型数据");
    }

    /**
     * 获取缴费类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:paytype:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuPaytypeService.selectStuPaytypeById(id));
    }

    /**
     * 新增缴费类型
     */
    @PreAuthorize("@ss.hasPermi('system:paytype:add')")
    @Log(title = "缴费类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuPaytype stuPaytype)
    {
        return toAjax(stuPaytypeService.insertStuPaytype(stuPaytype));
    }

    /**
     * 修改缴费类型
     */
    @PreAuthorize("@ss.hasPermi('system:paytype:edit')")
    @Log(title = "缴费类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuPaytype stuPaytype)
    {
        return toAjax(stuPaytypeService.updateStuPaytype(stuPaytype));
    }

    /**
     * 删除缴费类型
     */
    @PreAuthorize("@ss.hasPermi('system:paytype:remove')")
    @Log(title = "缴费类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuPaytypeService.deleteStuPaytypeByIds(ids));
    }
}
