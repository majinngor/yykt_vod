package com.yy.service.impl;

import com.github.wxpay.sdk.WXPayUtil;
import com.yy.UserInfoFeignClient;
import com.yy.service.OrderInfoService;
import com.yy.service.WXPayService;
import com.yy.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class WXPayServiceImpl implements WXPayService {

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;



    @Override
    public Map<String, String> createJsapi(String orderNo) {
        try {

            Map<String, String> paramMap = new HashMap();
            //1、设置参数
            paramMap.put("appid", "wxf913bfa3a2c7eeeb");
            paramMap.put("mch_id", "1481962542");
            paramMap.put("nonce_str", WXPayUtil.generateNonceStr());
            paramMap.put("body", "test");
            paramMap.put("out_trade_no", orderNo);
            paramMap.put("total_fee", "1");
            paramMap.put("spbill_create_ip", "127.0.0.1");
            paramMap.put("notify_url", "http://.yy.cn/api/order/wxPay/notify");
            paramMap.put("trade_type", "JSAPI");
//			paramMap.put("openid", "o1R-t5trto9c5sdYt6l1ncGmY5Y");
            //UserInfo userInfo = userInfoFeignClient.getById(paymentInfo.getUserId());
//			paramMap.put("openid", "oepf36SawvvS8Rdqva-Cy4flFFg");
            paramMap.put("openid", "oQTXC56lAy3xMOCkKCImHtHoLL");

            //2、HTTPClient来根据URL访问第三方接口并且传递参数
            HttpClientUtils client = new HttpClientUtils("https://api.mch.weixin.qq.com/pay/unifiedorder");

            //client设置参数
            client.setXmlParam(WXPayUtil.generateSignedXml(paramMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9"));
            client.setHttps(true);
            client.post();
            //3、返回第三方的数据
            String xml = client.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);
            if(null != resultMap.get("result_code")  && !"SUCCESS".equals(resultMap.get("result_code"))) {
                System.out.println("error1");
            }

            //4、再次封装参数
            Map<String, String> parameterMap = new HashMap<>();
            String prepayId = String.valueOf(resultMap.get("prepay_id"));
            String packages = "prepay_id=" + prepayId;
            parameterMap.put("appId", "wxf913bfa3a2c7eeeb");
            parameterMap.put("nonceStr", resultMap.get("nonce_str"));
            parameterMap.put("package", packages);
            parameterMap.put("signType", "MD5");
            parameterMap.put("timeStamp", String.valueOf(new Date().getTime()));
            //生成微信签名
            String sign = WXPayUtil.generateSignature(parameterMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9");

            //返回结果
            Map<String, String> result = new HashMap();
            result.put("appId", "wxf913bfa3a2c7eeeb");
            result.put("timeStamp", parameterMap.get("timeStamp"));
            result.put("nonceStr", parameterMap.get("nonceStr"));
            result.put("signType", "MD5");
            result.put("paySign", sign);
            result.put("package", packages);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    @Override
    public Map queryPayStatus(String orderNo) {
        try {
            //1、封装参数
            Map paramMap = new HashMap<>();
//            paramMap.put("appid", wxPayAccountConfig.getAppId());
//            paramMap.put("mch_id", wxPayAccountConfig.getMchId());
            paramMap.put("out_trade_no", orderNo);
            paramMap.put("nonce_str", WXPayUtil.generateNonceStr());

            //2、设置请求
            HttpClientUtils client = new HttpClientUtils("https://api.mch.weixin.qq.com/pay/orderquery");
//            client.setXmlParam(WXPayUtil.generateSignedXml(paramMap, wxPayAccountConfig.getKey()));
            client.setHttps(true);
            client.post();
            //3、返回第三方的数据
            String xml = client.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);
            //6、转成Map
            //7、返回
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}