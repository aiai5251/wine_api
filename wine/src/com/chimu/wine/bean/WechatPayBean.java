package com.chimu.wine.bean;

import com.chimu.utils.tools.CMString;

import java.security.MessageDigest;

public class WechatPayBean {
    private String appid; 				// appid
    private String mch_id;				// 商户号
    private String device_info;
    private String nonce_str;			// 随机字符串，不长于32位。
    private String sign;				// sign
    private String body;				// 商品简单描述，该字段须严格按照规范传递
    private String detail;
    private String attach;              // 附加参数
    private String out_trade_no;		// 商户系统内部的订单号,32个字符内、可包含字母
    private String fee_type;
    private String total_fee;			// 订单总金额，单位为分
    private String spbill_create_ip;	// APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
    private String time_start;
    private String time_expire;
    private String goods_tag;
    private String notify_url;			// 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数
    private String trade_type;			// 取值如下：JSAPI，NATIVE，APP
    private String product_id;			// trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义
    private String limit_pay;
    private String openid;				// trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public void setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void buildSign() {
        StringBuffer sb = new StringBuffer();
        if(CMString.isValid(appid))
            sb.append(String.format("appid=%s&", 				appid));
        if(CMString.isValid(attach))
            sb.append(String.format("attach=%s&", 				attach));
        if(CMString.isValid(body))
            sb.append(String.format("body=%s&", 				body));
        if(CMString.isValid(detail))
            sb.append(String.format("detail=%s&", 				detail));
        if(CMString.isValid(device_info))
            sb.append(String.format("device_info=%s&", 			device_info));
        if(CMString.isValid(fee_type))
            sb.append(String.format("fee_type=%s&", 			fee_type));
        if(CMString.isValid(goods_tag))
            sb.append(String.format("goods_tag=%s&", 			goods_tag));
        if(CMString.isValid(limit_pay))
            sb.append(String.format("limit_pay=%s&", 			limit_pay));
        if(CMString.isValid(mch_id))
            sb.append(String.format("mch_id=%s&", 				mch_id));
        if(CMString.isValid(nonce_str))
            sb.append(String.format("nonce_str=%s&", 			nonce_str));
        if(CMString.isValid(notify_url))
            sb.append(String.format("notify_url=%s&", 			notify_url));
        if(CMString.isValid(openid))
            sb.append(String.format("openid=%s&", 				openid));
        if(CMString.isValid(out_trade_no))
            sb.append(String.format("out_trade_no=%s&", 		out_trade_no));
        if(CMString.isValid(product_id))
            sb.append(String.format("product_id=%s&", 			product_id));
        if(CMString.isValid(spbill_create_ip))
            sb.append(String.format("spbill_create_ip=%s&", 	spbill_create_ip));
        if(CMString.isValid(time_expire))
            sb.append(String.format("time_expire=%s&", 			time_expire));
        if(CMString.isValid(time_start))
            sb.append(String.format("time_start=%s&", 			time_start));
        if(CMString.isValid(total_fee))
            sb.append(String.format("total_fee=%s&", 			total_fee));
        if(CMString.isValid(trade_type))
            sb.append(String.format("trade_type=%s&", 			trade_type));

        if(sb.length() > 0){
            sb.append("key=chimuwechat00010001000100010001");
            sign = CMString.MD5Encode(sb.toString()).toUpperCase();
        }
    }

    public String createXml() {
        StringBuilder xml = new StringBuilder();

        if(CMString.isValid(appid))
            xml.append(String.format("<appid>%s</appid>", 						appid));
        if(CMString.isValid(attach))
            xml.append(String.format("<attach>%s</attach>", 					attach));
        if(CMString.isValid(body))
            xml.append(String.format("<body>%s</body>", 						body));
        if(CMString.isValid(detail))
            xml.append(String.format("<detail>%s</detail>", 					detail));
        if(CMString.isValid(device_info))
            xml.append(String.format("<device_info>%s</device_info>", 			device_info));
        if(CMString.isValid(fee_type))
            xml.append(String.format("<fee_type>%s</fee_type>", 				fee_type));
        if(CMString.isValid(goods_tag))
            xml.append(String.format("<goods_tag>%s</goods_tag>", 				goods_tag));
        if(CMString.isValid(limit_pay))
            xml.append(String.format("<limit_pay>%s</limit_pay>", 				limit_pay));
        if(CMString.isValid(mch_id))
            xml.append(String.format("<mch_id>%s</mch_id>", 					mch_id));
        if(CMString.isValid(nonce_str))
            xml.append(String.format("<nonce_str>%s</nonce_str>", 				nonce_str));
        if(CMString.isValid(notify_url))
            xml.append(String.format("<notify_url>%s</notify_url>", 			notify_url));
        if(CMString.isValid(openid))
            xml.append(String.format("<openid>%s</openid>", 					openid));
        if(CMString.isValid(out_trade_no))
            xml.append(String.format("<out_trade_no>%s</out_trade_no>", 		out_trade_no));
        if(CMString.isValid(product_id))
            xml.append(String.format("<product_id>%s</product_id>", 			product_id));
        if(CMString.isValid(spbill_create_ip))
            xml.append(String.format("<spbill_create_ip>%s</spbill_create_ip>", spbill_create_ip));
        if(CMString.isValid(time_expire))
            xml.append(String.format("<time_expire>%s</time_expire>", 			time_expire));
        if(CMString.isValid(time_start))
            xml.append(String.format("<time_start>%s</time_start>", 			time_start));
        if(CMString.isValid(total_fee))
            xml.append(String.format("<total_fee>%s</total_fee>", 				total_fee));
        if(CMString.isValid(trade_type))
            xml.append(String.format("<trade_type>%s</trade_type>", 			trade_type));
        if(CMString.isValid(sign))
            xml.append(String.format("<sign>%s</sign>", 						sign));

        return "<xml>" + xml.toString() + "</xml>";
    }

}
