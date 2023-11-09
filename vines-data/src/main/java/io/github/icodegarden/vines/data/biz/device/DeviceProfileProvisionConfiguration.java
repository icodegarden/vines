package io.github.icodegarden.vines.data.biz.device;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.github.icodegarden.vines.data.biz.device.DeviceProfileProvisionConfiguration.AllowCreateNewDevicesDeviceProfileProvisionConfiguration;
import io.github.icodegarden.vines.data.biz.device.DeviceProfileProvisionConfiguration.CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration;
import io.github.icodegarden.vines.data.biz.device.DeviceProfileProvisionConfiguration.DisabledDeviceProfileProvisionConfiguration;
import lombok.Data;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = DisabledDeviceProfileProvisionConfiguration.class, name = "DISABLED"),
		@JsonSubTypes.Type(value = AllowCreateNewDevicesDeviceProfileProvisionConfiguration.class, name = "ALLOW_CREATE_NEW_DEVICES"),
		@JsonSubTypes.Type(value = CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.class, name = "CHECK_PRE_PROVISIONED_DEVICES") })
public interface DeviceProfileProvisionConfiguration extends Serializable {

	String getProvisionDeviceSecret();

	@JsonIgnore
	DeviceProfileProvisionType getType();

	@Data
	public class DisabledDeviceProfileProvisionConfiguration implements DeviceProfileProvisionConfiguration {

		private String provisionDeviceSecret;

		@Override
		public DeviceProfileProvisionType getType() {
			return DeviceProfileProvisionType.DISABLED;
		}

	}

	@Data
	public class AllowCreateNewDevicesDeviceProfileProvisionConfiguration
			implements DeviceProfileProvisionConfiguration {

		private String provisionDeviceSecret;

		@Override
		public DeviceProfileProvisionType getType() {
			return DeviceProfileProvisionType.ALLOW_CREATE_NEW_DEVICES;
		}

	}

	@Data
	public class CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration
			implements DeviceProfileProvisionConfiguration {

		private String provisionDeviceSecret;

		@Override
		public DeviceProfileProvisionType getType() {
			return DeviceProfileProvisionType.CHECK_PRE_PROVISIONED_DEVICES;
		}

	}

}