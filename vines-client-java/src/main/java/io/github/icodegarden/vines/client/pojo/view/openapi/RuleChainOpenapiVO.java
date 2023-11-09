package io.github.icodegarden.vines.client.pojo.view.openapi;

import com.fasterxml.jackson.databind.JsonNode;

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
public class RuleChainOpenapiVO {

	private String id;
	private Long createdTime;
	private JsonNode additionalInfo;
	private JsonNode configuration;
	private String tenantId;
	private String name;
	private String type;//RuleChainType [CORE, EDGE]
	private String firstRuleNodeId;
	private Boolean root;
	private Boolean debugMode;
	private String externalId;

}
