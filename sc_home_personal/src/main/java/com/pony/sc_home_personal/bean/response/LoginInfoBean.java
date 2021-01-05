package com.pony.sc_home_personal.bean.response;

import lombok.Data;
import net.sf.json.JSONObject;

/**
 * @author gaofeng
 * @date 2020/6/1 14:15
 **/
@Data
public class LoginInfoBean {

    private JSONObject loginBean;
    private JSONObject userBean;
    private JSONObject tokenBean;
    private JSONObject loginStaffBean;
    private String sessionId;
    private String userId;
}
