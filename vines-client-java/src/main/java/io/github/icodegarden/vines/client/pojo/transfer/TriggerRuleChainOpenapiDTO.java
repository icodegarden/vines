package io.github.icodegarden.vines.client.pojo.transfer;

import java.util.Map;

import io.github.icodegarden.nutrient.lang.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Builder
@Getter
@Setter
@ToString
public class TriggerRuleChainOpenapiDTO {

	@NonNull
	private String entityId;
	@NonNull
	private String entityType;
	/**
	 * 若不指定，将使用profile关联的的规则链（若有），否则使用租户ROOT规则链
	 */
	@Nullable
	private String ruleChainId;
	
	@Nullable
	private Map<String, String> metadata;

	/**
	 * json
	 */
	@NonNull
	private Object data;
	
	@Nullable
	private Boolean ruleTrace;

}
