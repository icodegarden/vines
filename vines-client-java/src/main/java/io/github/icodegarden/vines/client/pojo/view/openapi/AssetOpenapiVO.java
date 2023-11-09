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
public class AssetOpenapiVO {

	private String id;
	private Long createdTime;
	private String tenantId;
	private String customerId;
	private String name;
	private String type;
	private String label;
	private String assetProfileId;
	private JsonNode additionalInfo;
	
}
