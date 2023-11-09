package io.github.icodegarden.vines.data.biz.device;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.github.icodegarden.vines.data.biz.device.DeviceProfileConfiguration.DefaultDeviceProfileConfiguration;
import lombok.Data;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = DefaultDeviceProfileConfiguration.class, name = "DEFAULT") })
public interface DeviceProfileConfiguration extends Serializable {
	
	@JsonIgnore
	DeviceProfileType getType();

	@Data
	public static class DefaultDeviceProfileConfiguration implements DeviceProfileConfiguration {

		@Override
		public DeviceProfileType getType() {
			return DeviceProfileType.DEFAULT;
		}

	}
}