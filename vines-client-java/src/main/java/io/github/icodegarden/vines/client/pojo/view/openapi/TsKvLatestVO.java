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
public class TsKvLatestVO {

	private String entityId;

	private String key;

	private Long ts;

	private Boolean booleanValue;

	private String strValue;

	private Long longValue;

	private Double doubleValue;

	private String jsonValue;

}
