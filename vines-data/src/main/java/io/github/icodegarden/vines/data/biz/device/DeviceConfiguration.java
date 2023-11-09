package io.github.icodegarden.vines.data.biz.device;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.github.icodegarden.vines.data.biz.device.DeviceConfiguration.DefaultDeviceConfiguration;
import lombok.Data;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = DefaultDeviceConfiguration.class, name = "DEFAULT") })
public interface DeviceConfiguration extends Serializable {

	@JsonIgnore
	DeviceProfileType getType();

	@Data
	public class DefaultDeviceConfiguration implements DeviceConfiguration {

		private static final long serialVersionUID = -2225378639573611325L;

		@Override
		public DeviceProfileType getType() {
			return DeviceProfileType.DEFAULT;
		}

	}

}
