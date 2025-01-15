package com.ruoyi.web.controller.studnet;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.student.domain.*;
import com.ruoyi.student.domain.dto.StuUserDto;
import com.ruoyi.student.domain.vo.PaymentVo;
import com.ruoyi.student.domain.vo.StuUserPaymentVo;
import com.ruoyi.student.service.*;
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
 * 缴费记录Controller
 *
 * @author ruoyi
 * @date 2024-12-11
 */
@RestController
@RequestMapping("/student/payment")
public class StuPaymentController extends BaseController
{
    @Autowired
    private IStuPaymentService stuPaymentService;

    @Autowired
    private IStuUserService stuUserService;

    @Autowired
    private IStuMajorService stuMajorService;

    @Autowired
    private IStuMaterialService stuMaterialService;
    @Autowired
    private IStuMaterialPickupService stuMaterialPickupService;

    @Autowired
    private IStuPaytypeService stuPaytypeService;

    @PreAuthorize("@ss.hasPermi('system:payment:list')")
    @GetMapping("/getAllPayment")
    public TableDataInfo getAllPayment(StuPayment stuPayment)
    {
        if (ObjectUtil.isNotEmpty(stuPayment.getTransactionId())){
            StuUser stuUser = new StuUser();
            stuUser.setStuName(stuPayment.getTransactionId());
            List<StuUser> stuUsers = stuUserService.selectStuUserList(stuUser);
            stuPayment.setStuId(stuUsers.get(0).getUserId());
            stuPayment.setTransactionId(null);
        }
        startPage();
        List<StuPayment> list = stuPaymentService.selectStuPaymentList(stuPayment);
        list.stream().forEach(payment ->{
            StuUserDto stuUserDto = stuUserService.selectStuUserById(payment.getStuId());
            payment.setCreateBy(stuUserDto.getStuName());
        });
        return getDataTable(list);
    }

    /**
     * 查询缴费记录列表
     */
//    @PreAuthorize("@ss.hasPermi('system:payment:list')")
    @GetMapping("/list")
    public AjaxResult list()
    {
        StuPayment stuPayment = new StuPayment();
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        stuPayment.setStuId(user.getUserId());
        //startPage();
        List<StuPayment> list = stuPaymentService.selectStuPaymentList(stuPayment);
//        list.stream().forEach(payment ->{
//            StuPaytype stuPaytype = stuPaytypeService.selectStuPaytypeById(payment.getPayType());
//            payment.setRemark(stuPaytype.getPayName());
//        });
        StuUserPaymentVo stuUserPaymentVo = new StuUserPaymentVo();
        List<StuPayment> paymentList = list.stream()
                .filter(payment -> "0".equals(payment.getStatus()))
                .collect(Collectors.toList());

        List<StuPayment> noPaymentList = list.stream()
                .filter(noPayment -> "1".equals(noPayment.getStatus()))
                .collect(Collectors.toList());
        stuUserPaymentVo.setNoPaymentList(noPaymentList);
        stuUserPaymentVo.setPaymentList(paymentList);

        StuUserDto stuUserDto = stuUserService.selectStuUserById(user.getUserId());
        stuUserPaymentVo.setIdStudent(stuUserDto.getIdStudent());
        stuUserPaymentVo.setStuName(stuUserDto.getStuName());
        stuUserPaymentVo.setClassName(stuUserDto.getStuClass().getClassName());
        StuMajor stuMajor = stuMajorService.selectStuMajorById(stuUserDto.getMajorId());

        stuUserPaymentVo.setMajorName(stuMajor.getMajorName());
        stuUserPaymentVo.setDepartment(stuMajor.getDepartment());

        return success(stuUserPaymentVo);
    }

    /**
     * 导出缴费记录列表
     */
//    @PreAuthorize("@ss.hasPermi('system:payment:export')")
    @Log(title = "缴费记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuPayment stuPayment)
    {
        List<StuPayment> list = stuPaymentService.selectStuPaymentList(stuPayment);
        ExcelUtil<StuPayment> util = new ExcelUtil<StuPayment>(StuPayment.class);
        util.exportExcel(response, list, "缴费记录数据");
    }

    /**
     * 获取缴费记录详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:payment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuPaymentService.selectStuPaymentById(id));
    }

    /**
     * 新增缴费记录
     */
//    @PreAuthorize("@ss.hasPermi('system:payment:add')")
    @Log(title = "缴费记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuPayment stuPayment)
    {
        return toAjax(stuPaymentService.insertStuPayment(stuPayment));
    }

    /**
     * 修改缴费记录
     */
//    @PreAuthorize("@ss.hasPermi('system:payment:edit')")
    @Log(title = "缴费记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuPayment stuPayment)
    {
        return toAjax(stuPaymentService.updateStuPayment(stuPayment));
    }

    /**
     * 删除缴费记录
     */
//    @PreAuthorize("@ss.hasPermi('system:payment:remove')")
    @Log(title = "缴费记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuPaymentService.deleteStuPaymentByIds(ids));
    }


    /**
     * 缴费记录
     */
//    @PreAuthorize("@ss.hasPermi('system:payment:add')")
    @Log(title = "缴费记录", businessType = BusinessType.INSERT)
    @PostMapping("/paymentMoney")
    public AjaxResult paymentMoney(@RequestBody List<PaymentVo> paymentList)
    {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        StuPayment payments = new StuPayment();
        payments.setStuId(user.getUserId());
        List<StuPayment> stuPayments = stuPaymentService.selectStuPaymentList(payments);
        if(ObjectUtil.isNotEmpty(stuPayments)){
            throw new RuntimeException("请勿重复缴费！");
        }
        paymentList.stream().forEach(payment ->{
            StuPayment stuPayment = new StuPayment();
            stuPayment.setStatus(payment.getStatus());
            stuPayment.setPayType(payment.getId());
            stuPayment.setAmount(payment.getAmount());
            stuPayment.setStuId(user.getUserId());
            stuPayment.setRemark(payment.getPayName());
            stuPaymentService.insertStuPayment(stuPayment);
            if("2".equals(payment.getType())){
                StuMaterialPickup stuMaterialPickup = new StuMaterialPickup();
                stuMaterialPickup.setStuId(user.getUserId());
                stuMaterialPickup.setMaterialId(payment.getId());
                stuMaterialPickup.setQuantity(1L);
                stuMaterialPickup.setStatus("0");
                stuMaterialPickupService.insertStuMaterialPickup(stuMaterialPickup);
            }
        });

        return success("缴费成功！");
    }
}
