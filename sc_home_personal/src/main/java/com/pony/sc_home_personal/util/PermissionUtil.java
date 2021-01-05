package com.pony.sc_home_personal.util;

import com.pony.sc_home_personal.bean.base.ManagerBean;
import org.springframework.stereotype.Component;

/**
 * 判断人员权限级别（超管：1；项目管理：2；公司管理：3；部门管理：4；普通员工：5）
 */
@Component
public class PermissionUtil {

    /**
     * @author chujialin
     * @date 2020/12/11 17:28
     **/
    public static boolean hasManagerPermission(ManagerBean staffBean, Long projectId, Long companyId, Long departmentId) {
        //非管理员
        if (!staffBean.isManager()) {
            return false;
        }

        //超管权限
        if (projectId == null || projectId == 0) {
            return staffBean.getProjectId() == 0;
        }
        //项目管理权限
        else if (companyId == null || companyId == 0) {
            return staffBean.getProjectId() == 0 ||
                    (staffBean.getProjectId() == projectId && staffBean.getCompanyId() == 0);
        }
        //公司管理权限
        else if (departmentId == null || departmentId == 0) {
            return staffBean.getProjectId() == 0 ||
                    (staffBean.getProjectId() == projectId && staffBean.getCompanyId() == 0) ||
                    (staffBean.getProjectId() == projectId && staffBean.getCompanyId() == companyId && staffBean.getDepartmentId() == 0);
        }
        //部门管理权限
        else {
            return staffBean.getProjectId() == 0 ||
                    (staffBean.getProjectId() == projectId && staffBean.getCompanyId() == 0) ||
                    (staffBean.getProjectId() == projectId && staffBean.getCompanyId() == companyId && staffBean.getDepartmentId() == 0) ||
                    (staffBean.getProjectId() == projectId && staffBean.getCompanyId() == companyId && staffBean.getDepartmentId() == departmentId);
        }
    }

    /**
     * @author chujialin
     * @date 2020/12/11 17:28
     **/
    public static boolean hasSearchPermission(ManagerBean staffBean, Long projectId, Long companyId, Long departmentId, Long staffId) {
        //管理权限
        if (staffBean.isManager() && hasManagerPermission(staffBean, projectId, companyId, departmentId)) {
            return true;
        }
        //普通权限
        else {
            //超管权限
            if (projectId == null || projectId == 0) {
                return false;
            }
            //项目权限
            else if (companyId == null || companyId == 0) {
                return staffBean.getProjectId() == projectId;
            }
            //公司权限
            else if (departmentId == null || departmentId == 0) {
                return staffBean.getProjectId() == projectId &&
                        staffBean.getCompanyId() == companyId;
            }
            //部门权限
            else if (staffId == null || staffId == 0) {
                return staffBean.getProjectId() == projectId &&
                        staffBean.getCompanyId() == companyId &&
                        staffBean.getDepartmentId() == departmentId;
            }
            //人员权限
            else {
                return staffBean.getProjectId() == projectId &&
                        staffBean.getCompanyId() == companyId &&
                        staffBean.getDepartmentId() == departmentId &&
                        staffBean.getId() == staffId;
            }
        }
    }
}
