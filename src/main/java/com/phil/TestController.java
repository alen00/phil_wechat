package com.phil.test;

import java.util.TreeMap;

import com.phil.modules.util.JsonUtil;
import com.phil.wechat.msg.model.template.req.WechatTemplateMsg;
import com.phil.wechat.msg.model.template.resp.TemplateMsgResult;
import com.phil.wechat.msg.service.WechatMsgService;
import com.phil.wechat.msg.service.impl.WechatMsgServiceImpl;

public class TestController {
	

	public static void main(String[] args) {
			TemplateMsgResult templateMsgResult = null;
			TreeMap<String, TreeMap<String, String>> params = new TreeMap<>();
			//微信测试号配置模板信息
//			{{first.DATA}} 
//			订单商品：{{keyword1.DATA}} 
//			订单编号：{{keyword2.DATA}}
//			支付金额：{{keyword3.DATA}} 
//			支付时间：{{keyword4.DATA}} 
//			{{remark.DATA}}

			// 根据具体模板参数组装
			params.put("first", WechatTemplateMsg.item("您的户外旅行活动订单已经支付完成，可在我的个人中心中查看", "#000000"));
			params.put("keyword1", WechatTemplateMsg.item("8.1发现尼泊尔—人文与自然的旅行圣地", "#000000"));
			params.put("keyword2", WechatTemplateMsg.item("5000元", "#000000"));
			params.put("keyword3", WechatTemplateMsg.item("2017.1.2", "#000000"));
			params.put("keyword4", WechatTemplateMsg.item("5", "#000000"));
			params.put("remark", WechatTemplateMsg.item("请届时携带好身份证件准时到达集合地点，若临时退改将产生相应损失，敬请谅解,谢谢！", "#000000"));
			WechatTemplateMsg wechatTemplateMsg = new WechatTemplateMsg();
			wechatTemplateMsg.setTemplate_id("fR9Mj_neAODmHvILyOH2q8gf45K8OEeZ-URCHo7y8Ls");
			wechatTemplateMsg.setTouser("oJ_p9xNUcyrdiPVHaII9WJ6PIbqU");
			wechatTemplateMsg.setUrl("http://www.baidu.com");
			wechatTemplateMsg.setData(params);
			String data = JsonUtil.toJsonString(wechatTemplateMsg);
			WechatMsgService wechatMsgService = new WechatMsgServiceImpl();
			String token = "13_0bqpOtec-QH9TgHNoYu9HfEZ28fMQl0Zjalw87MJoEK7S8jQXoOJqTdyRQepk8kP0-fbpskPg1--MfnwmGalggIzZF5SS1LKtpNviPb8EBYf3y5C_Ig3Fl8wBoCDebRVEPZaGajvfzvpjdqIMLXgABACBN";
			templateMsgResult = wechatMsgService.sendTemplate(token, data);
			System.out.println(templateMsgResult);
	}
}
