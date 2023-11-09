package io.github.icodegarden.vines.client.pojo.view.openapi;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
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
public class TriggerRuleChainOpenapiVO {

	private Map<String, String> metadata;

	private JsonNode data;

	private ObjectNode ruleTrace;

	private Long takeTimeMs;

}
