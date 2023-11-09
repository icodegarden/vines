package io.github.icodegarden.vines.client.pojo.view.openapi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Getter
@Setter
@ToString
public class AttributeKvVO {

	private String entityType;
	private String entityId;
	private String attributeType;
	private String attributeKey;

	private Boolean booleanValue;
	private String strValue;
	private Long longValue;
	private Double doubleValue;
	private String jsonValue;
	private Long lastUpdateTs;

}
