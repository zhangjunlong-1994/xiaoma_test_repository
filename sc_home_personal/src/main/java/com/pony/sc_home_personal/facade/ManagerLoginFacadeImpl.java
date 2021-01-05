package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.ManagerBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.util.PermissionUtil;
import com.pony.sc_home_personal.util.TokenUtil;
import org.springframework.stereotype.Component;

/**
 * @author chujialin
 * @date 2020/3/25 11:14
 **/
@Component
public class ManagerLoginFacadeImpl implements ManagerLoginFacade {

    @Override
    public ResponseResult<ManagerBean> loginByManagerToken(String token, long projectId) {
        ManagerBean managerBean = TokenUtil.getManagerTokenInfo(token);
        if (managerBean == null) {
            return ResponseResult.success(ResultStatus.EXISTENT_LOGIN_NO.getCode(), null);
        } else {
            if (PermissionUtil.hasManagerPermission(managerBean, projectId, null, null)) {
                TokenUtil.saveMangerToken(token);
                return ResponseResult.success(ResultStatus.SUCCESS_LOGIN.getCode(), managerBean);
            } else {
                return ResponseResult.success(ResultStatus.IS_NO_STAFF_MANAGER.getCode(), null);
            }
        }
    }

    @Override
    public ResponseResult<ManagerBean> loginByToken(String token) {
        if (TokenUtil.verifyToken(token)) {
            ManagerBean managerBean = TokenUtil.getManagerTokenInfo(token);
            if (managerBean == null) {
                return ResponseResult.success(ResultStatus.IS_NO_STAFF_MANAGER.getCode(), null);
            } else {
                return ResponseResult.success(ResultStatus.SUCCESS_LOGIN.getCode(), managerBean);
            }
        } else {
            return ResponseResult.success(ResultStatus.EXISTENT_LOGIN_NO.getCode(), null);
        }
    }
}
