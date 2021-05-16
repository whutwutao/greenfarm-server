package com.wu.greenfarm.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.google.gson.Gson;
import com.wu.greenfarm.config.AlipayConfig;
import com.wu.greenfarm.utils.OrderInfoUtil2_0;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AlipayController {

    @RequestMapping(value = "/alipay")
    public String alipay(@RequestBody HashMap<String,String> map) {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = map.get("orderNum");
        //付款金额，必填
        String total_amount = map.get("amount");
        //订单名称，必填
        String subject = map.get("subject");
        //商品描述，可空
        //String body = ordersDesc == null ? "" : ordersDesc;

        String timeout_express = "1c";
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                //+ "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping(value = "/alipayTest")
    public HashMap<String,String> alipayTest(@RequestBody HashMap<String,String> map) {
        String total_amount = map.get("total_amount");
        String subject = map.get("subject");
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(AlipayConfig.app_id, total_amount, subject, true);
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

        String privateKey = AlipayConfig.merchant_private_key;
        String sign = OrderInfoUtil2_0.getSign(params, privateKey,true);
        final String orderInfo = orderParam + "&" + sign;
        HashMap<String,String> result = new HashMap<>();
        result.put("orderInfo",orderInfo);
        return result;
    }

}
