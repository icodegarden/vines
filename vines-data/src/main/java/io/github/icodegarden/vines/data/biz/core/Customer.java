package io.github.icodegarden.vines.data.biz.core;

import java.io.Serializable;

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
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityId id;

	private Long createdTime;

	private String name;

	private String title;

	private EntityId tenantId;

	private EntityId externalId;

	private String searchText;

	private String country;

	private String state;

	private String city;

	private String address;

	private String address2;

	private String zip;

	private String phone;

	private String email;

	private JsonNode additionalInfo;

}
