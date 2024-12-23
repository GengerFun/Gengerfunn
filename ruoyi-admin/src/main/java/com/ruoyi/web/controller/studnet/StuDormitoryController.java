package com.ruoyi.web.controller.studnet;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.student.domain.StuDormitory;
import com.ruoyi.student.domain.dto.StuUserDto;
import com.ruoyi.student.domain.vo.StuUserDormitoryVo;
import com.ruoyi.student.service.IStuDormitoryService;
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
 * 宿舍信息Controller
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@RestController
@RequestMapping("/student/dormitory")
public class StuDormitoryController extends BaseController
{
    @Autowired
    private IStuDormitoryService stuDormitoryService;

    @Autowired
    private IStuUserService stuUserService;
    /**
     * 查询宿舍信息列表
     */

    @GetMapping("/list")
    public TableDataInfo list(StuDormitory stuDormitory)
    {
        startPage();
        List<StuDormitory> list = stuDormitoryService.selectStuDormitoryList(stuDormitory);
        return getDataTable(list);
    }

    /**
     * 导出宿舍信息列表
     */

    @Log(title = "宿舍信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuDormitory stuDormitory)
    {
        List<StuDormitory> list = stuDormitoryService.selectStuDormitoryList(stuDormitory);
        ExcelUtil<StuDormitory> util = new ExcelUtil<StuDormitory>(StuDormitory.class);
        util.exportExcel(response, list, "宿舍信息数据");
    }

    /**
     * 获取宿舍信息详细信息
     */

    @GetMapping("/getDormitoryByUserId")
    public AjaxResult getDormitoryByUserId()
    {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        StuUserDto stuUserDto = stuUserService.selectStuUserById(user.getUserId());
        StuUserDormitoryVo stuUserDormitoryVo = BeanUtil.copyProperties(stuUserDto, StuUserDormitoryVo.class);
        StuDormitory stuDormitory = stuDormitoryService.selectStuDormitoryById(stuUserDto.getDormitoryId());
        stuUserDormitoryVo.setStuDormitory(stuDormitory);
        return success(stuUserDormitoryVo);
    }

    /**
     * 新增宿舍信息
     */

    @Log(title = "宿舍信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuDormitory stuDormitory)
    {
        return toAjax(stuDormitoryService.insertStuDormitory(stuDormitory));
    }

    /**
     * 修改宿舍信息
     */

    @Log(title = "宿舍信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuDormitory stuDormitory)
    {
        return toAjax(stuDormitoryService.updateStuDormitory(stuDormitory));
    }

    /**
     * 删除宿舍信息
     */

    @Log(title = "宿舍信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuDormitoryService.deleteStuDormitoryByIds(ids));
    }
}
