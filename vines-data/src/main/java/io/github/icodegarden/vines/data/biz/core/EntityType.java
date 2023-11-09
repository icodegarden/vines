package io.github.icodegarden.vines.data.biz.core;

import java.io.Serializable;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public enum EntityType implements Serializable {
	TENANT, CUSTOMER, USER, DASHBOARD, ASSET, DEVICE, ALARM, RULE_CHAIN, RULE_NODE, ENTITY_VIEW, WIDGETS_BUNDLE,
	WIDGET_TYPE, TENANT_PROFILE, DEVICE_PROFILE, ASSET_PROFILE, API_USAGE_STATE, TB_RESOURCE, OTA_PACKAGE, EDGE, RPC,
	QUEUE, AUDITLOG;
}
