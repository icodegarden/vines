package io.github.icodegarden.vines.data.biz.device;

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
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityId id;

	protected Long createdTime;

	private EntityId tenantId;
	private EntityId customerId;
	private String name;
	private String type;
	private String label;
	private JsonNode additionalInfo;
	private DeviceData deviceData;
	private EntityId deviceProfileId;
	private EntityId firmwareId;// OtaPackageId
	private EntityId softwareId;// OtaPackageId
	private EntityId externalId;// DeviceId

}
