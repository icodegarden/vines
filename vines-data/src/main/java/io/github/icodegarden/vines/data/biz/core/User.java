package io.github.icodegarden.vines.data.biz.core;

import com.fasterxml.jackson.databind.JsonNode;

import io.github.icodegarden.vines.data.id.EntityId;
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
public class User {

	private EntityId id;

	private Long createdTime;

	private EntityId tenantId;

	private EntityId customerId;

	private Authority authority;

	private String email;
	
	private Boolean openapiUser;
	
	private String freeLoginValue;

	private String firstName;

	private String lastName;

	private JsonNode additionalInfo;

	/**
	 * 
	 */
	public String getName() {
		return email;
	}

}
