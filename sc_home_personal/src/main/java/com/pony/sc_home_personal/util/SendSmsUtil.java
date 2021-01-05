package com.pony.sc_home_personal.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Random;

/**
 * @author hanshuang
 * @date 2020/06/22 13:25
 **/
public class SendSmsUtil {

    //发送手机验证码
    public static String sendSms(String mobile) {
        //AccessKeyId 阿里云个人页面
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                "LTAI4GC8Tmu4haDMde9Ru8rg", "rGYEsMx6xU2EjAYF6tZyA17JcLBFgX");
        IAcsClient client = new DefaultAcsClient(profile);
        //随机验证码6位
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //需要发送验证码的手机号
        request.putQueryParameter("PhoneNumbers", mobile);
        //短信签名名称
        request.putQueryParameter("SignName", "小马骥家");
        //短信模板id
        request.putQueryParameter("TemplateCode", "SMS_193056882");
        //发送的验证码
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + verifyCode + "\"}");
//        try {
//            CommonResponse response = client.getCommonResponse(request);
//            JSONObject jsonObject = JSONObject.fromObject(response.getData());
//            if (jsonObject.has("Code") && jsonObject.getString("Code").equals("OK")){
//
//            }else {
//                viewBean.setData(jsonObject.getString("Message"));
//                viewBean.setCode(20119);
//            }
//        } catch (com.aliyuncs.exceptions.ClientException e) {
//            e.printStackTrace();
//        }
        return verifyCode;
    }
}
