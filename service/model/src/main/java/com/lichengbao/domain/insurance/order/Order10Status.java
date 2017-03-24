/**
 * 
 */
package com.lichengbao.domain.insurance.order;

/**
 * @author jwang
 *
 */
public enum Order10Status {

	未知,
	已填被保人信息,
	已填被保车辆基本信息,
	行驶证已上传_尚未审核,
	尚未报价,
	已报价,
	不能下单_离上一保单到期超过一个月,
	保单寄送地址未填,
	尚未支付,
	已支付,
	已删除,
	行驶证已上传_审核未通过,
	已申请返现
	
}
