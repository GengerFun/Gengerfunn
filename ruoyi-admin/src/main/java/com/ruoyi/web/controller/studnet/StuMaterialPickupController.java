package com.ruoyi.web.controller.studnet;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.student.domain.StuMajor;
import com.ruoyi.student.domain.StuMaterial;
import com.ruoyi.student.domain.StuMaterialPickup;
import com.ruoyi.student.domain.StuPayment;
import com.ruoyi.student.domain.dto.StuUserDto;
import com.ruoyi.student.domain.vo.StuMaterialPickupVo;
import com.ruoyi.student.domain.vo.StuUserMaterialVo;
import com.ruoyi.student.service.IStuMajorService;
import com.ruoyi.student.service.IStuMaterialPickupService;
import com.ruoyi.student.service.IStuMaterialService;
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

    @Autowired
    private IStuUserService stuUserService;

    @Autowired
    private IStuMajorService stuMajorService;

    @Autowired
    private IStuMaterialService stuMaterialService;
    /**
     * 查询物资领取记录列表
     */
//    @PreAuthorize("@ss.hasPermi('system:pickup:list')")
    @GetMapping("/list")
    public AjaxResult list()
    {
        StuMaterialPickup stuMaterialPickup = new StuMaterialPickup();
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        startPage();
        stuMaterialPickup.setStuId(user.getUserId());
        List<StuMaterialPickup> list = stuMaterialPickupService.selectStuMaterialPickupList(stuMaterialPickup);
        List<StuMaterialPickupVo> stuMaterialPickupVoList = list.stream().map(pickup -> {
            StuMaterialPickupVo stuMaterialPickupVo = BeanUtil.copyProperties(pickup, StuMaterialPickupVo.class);
            StuMaterial stuMaterial = stuMaterialService.selectStuMaterialById(pickup.getMaterialId());
            stuMaterialPickupVo.setStuMaterial(stuMaterial);
            return stuMaterialPickupVo;
        }).collect(Collectors.toList());
        List<StuMaterialPickupVo> pickup = stuMaterialPickupVoList.stream()
                .filter(materialPickup -> "1".equals(materialPickup.getStatus()))
                .collect(Collectors.toList());
        List<StuMaterialPickupVo> noPickup = stuMaterialPickupVoList.stream()
                .filter(materialPickup -> "0".equals(materialPickup.getStatus()))
                .collect(Collectors.toList());
        StuUserMaterialVo stuUserMaterialVo = new StuUserMaterialVo();
        StuUserDto stuUserDto = stuUserService.selectStuUserById(user.getUserId());
        stuUserMaterialVo.setIdStudent(stuUserDto.getIdStudent());
        stuUserMaterialVo.setStuName(stuUserDto.getStuName());
        stuUserMaterialVo.setClassName(stuUserDto.getStuClass().getClassName());
        StuMajor stuMajor = stuMajorService.selectStuMajorById(stuUserDto.getMajorId());
        stuUserMaterialVo.setMajorName(stuMajor.getMajorName());
        stuUserMaterialVo.setDepartment(stuMajor.getDepartment());
        stuUserMaterialVo.setPickup(pickup);
        stuUserMaterialVo.setNoPickup(noPickup);

        return success(stuUserMaterialVo);
    }

    /**
     * 导出物资领取记录列表
     */
//    @PreAuthorize("@ss.hasPermi('system:pickup:export')")
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
//    @PreAuthorize("@ss.hasPermi('system:pickup:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuMaterialPickupService.selectStuMaterialPickupById(id));
    }

    /**
     * 新增物资领取记录
     */
//    @PreAuthorize("@ss.hasPermi('system:pickup:add')")
    @Log(title = "物资领取记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuMaterialPickup stuMaterialPickup)
    {
        return toAjax(stuMaterialPickupService.insertStuMaterialPickup(stuMaterialPickup));
    }

    /**
     * 修改物资领取记录
     */
//    @PreAuthorize("@ss.hasPermi('system:pickup:edit')")
    @Log(title = "物资领取记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuMaterialPickup stuMaterialPickup)
    {
        return toAjax(stuMaterialPickupService.updateStuMaterialPickup(stuMaterialPickup));
    }

    /**
     * 删除物资领取记录
     */
//    @PreAuthorize("@ss.hasPermi('system:pickup:remove')")
    @Log(title = "物资领取记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuMaterialPickupService.deleteStuMaterialPickupByIds(ids));
    }
}
