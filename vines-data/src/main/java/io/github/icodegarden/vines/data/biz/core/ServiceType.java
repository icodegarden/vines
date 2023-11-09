package io.github.icodegarden.vines.data.biz.core;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public enum ServiceType {

	TB_CORE, TB_RULE_ENGINE, TB_TRANSPORT, JS_EXECUTOR, TB_VC_EXECUTOR;

	public static ServiceType of(String serviceType) {
		return ServiceType.valueOf(serviceType.replace("-", "_").toUpperCase());
	}
}
