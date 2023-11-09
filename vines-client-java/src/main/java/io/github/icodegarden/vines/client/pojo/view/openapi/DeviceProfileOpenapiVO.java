package io.github.icodegarden.vines.client.pojo.view.openapi;

import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Setter
@Getter
@ToString
public class DeviceProfileOpenapiVO {

	private String id;

	private Long createdTime;

	private String name;

	private String type;

	private String transportType;

	private String provisionType;

	private ObjectNode profileData;

	private String description;

	private Boolean isDefault;

	private String tenantId;

	private String defaultRuleChainId;

	private String defaultQueueName;

}
