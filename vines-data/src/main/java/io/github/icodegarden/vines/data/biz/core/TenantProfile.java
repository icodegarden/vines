package io.github.icodegarden.vines.data.biz.core;

import java.io.Serializable;

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
public class TenantProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityId id;

	private Long createdTime;

	private String name;

	private String description;

	private String searchText;

	private Boolean isDefault;

	private Boolean isolatedTbCore;

	private Boolean isolatedTbRuleEngine;

//	private JsonNode profileData;
	private TenantProfileData profileData;
}
