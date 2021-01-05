package com.pony.sc_home_personal.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author gaofeng
 * @date 2019/12/21 13:52
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> {

    private int code;
    private String message;
    private T data;

    private ResponseResult(ResultStatus resultStatus) {
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMsg();
    }

    private ResponseResult(ResultStatus resultStatus, T data) {
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMsg();
        this.data = data;
    }

    public static <T> ResponseResult<T> success(int code, T data) {
        ResponseResult<T> responseResult = null;
        switch (code) {
            case 10001:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_SELECT, data);
                break;
            case 10002:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_NO_DATA, data);
                break;
            case 10003:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_INSERT, data);
                break;
            case 10004:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_UPDATE, data);
                break;
            case 10005:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_DELETE);
                break;
            case 10006:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_SETTING, data);
                break;
            case 10007:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_EDIT_PASSWORD);
                break;
            case 10008:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_RESET_PASSWORD);
                break;
            case 10009:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_ACCOUNT_AVAILABLE);
                break;
            case 10010:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_PAY);
                break;
            case 10011:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_CHECK);
                break;
            case 30001:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PAY);
                break;
            case 20000:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_CONSTANT);
                break;
            case 20001:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_MENU_MODULES);
                break;
            case 20002:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_MENU_MODULES);
                break;
            case 20003:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_MENU_MODULES_LIST);
                break;
            case 20004:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_MENU_MODULES_PAGE);
                break;
            case 20005:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_MENU_MODULES_GROUP);
                break;
            case 20006:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_MENU_MODULES_GROUP);
                break;
            case 20007:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_MENU_MODULES_GROUP_LIST);
                break;
            case 20008:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_MENU_MODULES_GROUP_PAGE);
                break;
            case 20009:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_MENU_MODULES_RELATION);
                break;
            case 20010:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_MENU_MODULES_RELATION);
                break;
            case 20011:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_MENU_MODULES_RELATION_LIST);
                break;
            case 20012:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_MENU_MODULES_RELATION_PAGE);
                break;
            case 20013:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PERMISSION);
                break;
            case 20014:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_PERMISSION);
                break;
            case 20015:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PERMISSION_LIST);
                break;
            case 20016:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PERMISSION_PAGE);
                break;
            case 20017:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PERMISSION_GROUP);
                break;
            case 20018:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_PERMISSION_GROUP);
                break;
            case 20019:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PERMISSION_GROUP_LIST);
                break;
            case 20020:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PERMISSION_GROUP_PAGE);
                break;
            case 20021:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PERMISSION_RELATION);
                break;
            case 20022:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_PERMISSION_RELATION);
                break;
            case 20023:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PERMISSION_RELATION_LIST);
                break;
            case 20024:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PERMISSION_RELATION_PAGE);
                break;
            case 20025:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_COMPANY);
                break;
            case 20026:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_COMPANY);
                break;
            case 20027:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_COMPANY_LIST);
                break;
            case 20028:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_COMPANY_PAGE);
                break;
            case 20029:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_DEPARTMENT);
                break;
            case 20030:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_DEPARTMENT);
                break;
            case 20031:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_DEPARTMENT_LIST);
                break;
            case 20032:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_DEPARTMENT_PAGE);
                break;
            case 20033:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_POSITION);
                break;
            case 20034:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_POSITION);
                break;
            case 20035:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_POSITION_LIST);
                break;
            case 20036:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_POSITION_PAGE);
                break;
            case 20037:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PROFESSION);
                break;
            case 20038:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_PROFESSION);
                break;
            case 20039:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PROFESSION_LIST);
                break;
            case 20040:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PROFESSION_PAGE);
                break;
            case 20041:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_STAFF);
                break;
            case 20042:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_STAFF);
                break;
            case 20043:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_STAFF_LIST);
                break;
            case 20044:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_STAFF_PAGE);
                break;
            case 20045:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_LOGIN);
                break;
            case 20046:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_LOGIN);
                break;
            case 20047:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_LOGIN_LIST);
                break;
            case 20048:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_LOGIN_PAGE);
                break;
            case 20049:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_MENU_RELATION_MODULES);
                break;
            case 20050:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_MENU_RELATION_MODULES_LIST);
                break;
            case 20051:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_MENU_RELATION_MODULES_PAGE);
                break;
            case 20052:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_COMPANY_PARENT);
                break;
            case 20053:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_COMPANY_PARENT_LIST);
                break;
            case 20054:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_COMPANY_PARENT_PAGE);
                break;
            case 20055:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_DEPARTMENT_PARENT_COMPANY);
                break;
            case 20056:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_DEPARTMENT_PARENT_COMPANY_LIST);
                break;
            case 20057:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_DEPARTMENT_PARENT_COMPANY_PAGE);
                break;
            case 20058:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_POSITION_DEPARTMENT_COMPANY);
                break;
            case 20059:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_POSITION_DEPARTMENT_COMPANY_LIST);
                break;
            case 20060:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_POSITION_DEPARTMENT_COMPANY_PAGE);
                break;
            case 20061:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_STAFF_LOGIN_COMPANY_DEPARTMENT_POSITION_PROFESSION_GROUP);
                break;
            case 20062:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_STAFF_LOGIN_COMPANY_DEPARTMENT_POSITION_PROFESSION_GROUP_LIST);
                break;
            case 20063:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_STAFF_LOGIN_COMPANY_DEPARTMENT_POSITION_PROFESSION_GROUP_PAGE);
                break;
            case 20064:
                responseResult = new ResponseResult<>(ResultStatus.IS_NO_STAFF_MANAGER);
                break;
            case 20065:
                responseResult = new ResponseResult<>(ResultStatus.IS_STAFF_MANAGER);
                break;
            case 20066:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_ACCOUNT);
                break;
            case 20067:
                responseResult = new ResponseResult<>(ResultStatus.CORRECT_NO_PASSWORD);
                break;
            case 20068:
                responseResult = new ResponseResult<>(ResultStatus.EQUAL_NO_PASSWORD);
                break;

            case 10101:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_LOGIN, data);
                break;
            case 10102:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_LOGIN_EDIT);
                break;
            case 10103:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_LOGIN_PASSWORD_EDIT);
                break;
            case 10104:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_LOGIN_PASSWORD_RESET);
                break;
            case 10105:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_LOGIN_DELETE);
                break;
            case 10106:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_LOGIN_ACCOUNTS);
                break;
            case 10107:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_DEVICE_WORK);
                break;
            case 10108:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_SEND_SMS, data);
                break;
            case 10109:
                responseResult = new ResponseResult<>(ResultStatus.SUCCESS_REGISTER);
                break;
            case 20101:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_LOGIN_NO);
                break;
            case 20102:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_LOGIN_PASSWORD);
                break;
            case 20103:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_LOGIN_ACCOUNTS);
                break;
            case 20104:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_CUSTOMER);
                break;
            case 20105:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_HOUSE);
                break;
            case 20106:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_BIND_ROOM);
                break;
            case 20107:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_BIND_SCENARIO_MODE);
                break;
            case 20108:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_ROOM, data);
                break;
            case 20109:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_BIND_DEVICE);
                break;
            case 20110:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_CENTRAL_CONTROLLER);
                break;
            case 20111:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_DEVICE, data);
                break;
            case 20112:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_DEVICE_FUNCTION);
                break;
            case 20113:
                responseResult = new ResponseResult<>(ResultStatus.INTELLIGENT_DEVICE_CODE_ERROR);
                break;
            case 20114:
                responseResult = new ResponseResult<>(ResultStatus.INTELLIGENT_NO_DEVICE_CODE);
                break;
            case 20115:
                responseResult = new ResponseResult<>(ResultStatus.INTELLIGENT_DEVICE_NO_WORK);
                break;
            case 20116:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_WARN_FUNCTION);
                break;
            case 20117:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_SCENARIO_MODE);
                break;
            case 20118:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_SCHEDULE);
                break;
            case 20119:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_SEND_SMS, data);
                break;
            case 20121:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_VERIFY_PAST_DUE);
                break;
            case 20123:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_RELAY);
                break;
            case 20220:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_CUSTOMER_ENABLED);
                break;
            case 20221:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_VERIFY_PAST_DUE);
                break;
            case 20122:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_VERIFY);
                break;
            case 20223:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_REGISTER);
                break;
            case 20224:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_PASS_WORD);
                break;
            case 20225:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_TYPE_MANAGE, data);
                break;
            case 20226:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_ABOUT_US);
                break;
            case 20227:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_HOUSE_RELATIONSHIP);
                break;
            case 20228:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_PHONE);
                break;
            case 20229:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_HAVE_CUSTOMER);
                break;
            case 20230:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_DELETE_FAIL_TO);
                break;
            case 20231:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_FAILED_ADD_SCENARIO);
                break;
            case 20232:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_ERROR_ADD_SCENARIO);
                break;
            case 20233:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_FAILED_ADD_ROOM);
                break;
            case 20234:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_ERROR_ADD_ROOM);
                break;
            case 20235:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_EDITION);
                break;
            case 20236:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_NAME);
                break;
            case 20237:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NAME);
                break;
            case 20238:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_NO_EDITION_MESSAGE, data);
                break;
            case 20239:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_FAILED_JSON);
                break;
            case 20240:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_FAILED_EDIT_WARN_SETTING);
                break;
            case 20241:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_DEVICE_STATE_UNBIND);
                break;
            case 20242:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_DEVICE_STATE_OFF);
                break;
            case 20243:
                responseResult = new ResponseResult<>(ResultStatus.EXISTENT_DEVICE_STATE_STUDY);
                break;
            default:
                break;
        }
        return responseResult;
    }

    public static <T> ResponseResult<T> unsafe(int code) {
        if (code == 30000) {
            return new ResponseResult<>(ResultStatus.PERMISSION_NO);
        }
        if (code == 40000) {
            return new ResponseResult<>(ResultStatus.ILLEGAL_PARAMETER);
        }
        return null;
    }

//    public static <T> ResponseResult<T> fail(int code) {
//        return new ResponseResult<>(ResultStatus.SUCCESS_INSERT);
//    }
}
