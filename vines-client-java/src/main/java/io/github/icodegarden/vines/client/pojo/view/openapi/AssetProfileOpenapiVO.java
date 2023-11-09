package io.github.icodegarden.vines.client.pojo.view.openapi;

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
public class AssetProfileOpenapiVO {

	private String id;
	private Long createdTime;
	private String tenantId;
	private String name;
	private String description;
	private Boolean isDefault;
	private String defaultRuleChainId;
	private String defaultQueueName;

}
