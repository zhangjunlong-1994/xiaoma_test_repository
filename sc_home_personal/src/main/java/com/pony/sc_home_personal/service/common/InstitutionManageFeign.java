package com.pony.sc_home_personal.service.common;

import com.pony.sc_home_personal.bean.base.StaffBean;
import com.pony.sc_home_personal.bean.response.StaffInstitutionAllInfoListBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author haozhongyu
 * @date 2019/11/25 9:30
 **/
@FeignClient(name = "sp-common-manage")
@RequestMapping("/Inner_StaffAndLogin")
public interface InstitutionManageFeign {

    /**
     * @author haozhongyu
     * @date 2019/12/2 14:55
     **/
    @PostMapping("/SearchStaffById.do")
    ViewBean<StaffBean> searchStaff(@RequestParam("id") long id);

    /**
     * @author hanshuang
     * @date 2020/07/10 14:56
     **/
    @PostMapping("/SearchStaffInstitutionAllInfoListByCompanyIdAndDepartmentId.do")
    ViewBean<StaffInstitutionAllInfoListBean> searchStaffInstitutionAllInfoListByCompanyIdAndDepartmentId
            (@RequestParam("companyId") long companyId,
             @RequestParam("departmentId") long departmentId);
}
