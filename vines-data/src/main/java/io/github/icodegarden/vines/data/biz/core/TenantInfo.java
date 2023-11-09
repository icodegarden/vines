package io.github.icodegarden.vines.data.biz.core;

import java.io.Serializable;

import com.fasterxml.jackson.databind.JsonNode;

import io.github.icodegarden.vines.data.id.EntityId;
import io.github.icodegarden.vines.data.id.TenantProfileId;
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
public class TenantInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EntityId id;
	private Long createdTime;

//	@ApiModelProperty(position = 3, value = "Title of the tenant", example = "Company A")
	private String title;
//	@ApiModelProperty(position = 5, value = "Geo region of the tenant", example = "North America")
	private String region;
//	@ApiModelProperty(position = 6, required = true, value = "JSON object with Tenant Profile Id")
	private TenantProfileId tenantProfileId;

	private String country;
	private String state;
	private String city;
	private String address;
	private String address2;
	private String zip;
	private String phone;
	private String email;

//	@ApiModelProperty(position = 15, value = "Tenant Profile name", example = "Default")
	private String tenantProfileName;

	private String name;

	private JsonNode additionalInfo;
	
	private Boolean eventNotify;
	private String eventNotifyUrl;
	private EventNotityCredentialsType credentialsType;
	private String credentialsValue;

	/**
	 * with查询才有
	 */
	private TenantProfile tenantProfile;
}
