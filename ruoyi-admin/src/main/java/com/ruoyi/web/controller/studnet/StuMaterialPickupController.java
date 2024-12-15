package com.ruoyi.web.controller.studnet;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.student.domain.StuMaterialPickup;
import com.ruoyi.student.service.IStuMaterialPickupService;
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
 * 物资领取记录Controller
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@RestController
@RequestMapping("/student/pickup")
public class StuMaterialPickupController extends BaseController
{
    @Autowired
    private IStuMaterialPickupService stuMaterialPickupService;

    /**
     * 查询物资领取记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:pickup:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuMaterialPickup stuMaterialPickup)
    {
        startPage();
        List<StuMaterialPickup> list = stuMaterialPickupService.selectStuMaterialPickupList(stuMaterialPickup);
        return getDataTable(list);
    }

    /**
     * 导出物资领取记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:pickup:export')")
    @Log(title = "物资领取记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuMaterialPickup stuMaterialPickup)
    {
        List<StuMaterialPickup> list = stuMaterialPickupService.selectStuMaterialPickupList(stuMaterialPickup);
        ExcelUtil<StuMaterialPickup> util = new ExcelUtil<StuMaterialPickup>(StuMaterialPickup.class);
        util.exportExcel(response, list, "物资领取记录数据");
    }

    /**
     * 获取物资领取记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:pickup:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuMaterialPickupService.selectStuMaterialPickupById(id));
    }

    /**
     * 新增物资领取记录
     */
    @PreAuthorize("@ss.hasPermi('system:pickup:add')")
    @Log(title = "物资领取记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuMaterialPickup stuMaterialPickup)
    {
        return toAjax(stuMaterialPickupService.insertStuMaterialPickup(stuMaterialPickup));
    }

    /**
     * 修改物资领取记录
     */
    @PreAuthorize("@ss.hasPermi('system:pickup:edit')")
    @Log(title = "物资领取记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuMaterialPickup stuMaterialPickup)
    {
        return toAjax(stuMaterialPickupService.updateStuMaterialPickup(stuMaterialPickup));
    }

    /**
     * 删除物资领取记录
     */
    @PreAuthorize("@ss.hasPermi('system:pickup:remove')")
    @Log(title = "物资领取记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuMaterialPickupService.deleteStuMaterialPickupByIds(ids));
    }
}
