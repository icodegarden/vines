package io.github.icodegarden.vines.data.biz.device;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.github.icodegarden.vines.data.biz.device.DeviceTransportConfiguration.DefaultDeviceTransportConfiguration;
import io.github.icodegarden.vines.data.biz.device.DeviceTransportConfiguration.MqttDeviceTransportConfiguration;
import lombok.Data;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = DefaultDeviceTransportConfiguration.class, name = "DEFAULT"),
		@JsonSubTypes.Type(value = MqttDeviceTransportConfiguration.class, name = "MQTT"),
/*
 * @JsonSubTypes.Type(value = CoapDeviceTransportConfiguration.class, name =
 * "COAP"),
 * 
 * @JsonSubTypes.Type(value = Lwm2mDeviceTransportConfiguration.class, name =
 * "LWM2M"),
 * 
 * @JsonSubTypes.Type(value = SnmpDeviceTransportConfiguration.class, name =
 * "SNMP")
 */
})
public interface DeviceTransportConfiguration extends Serializable {
	
	@JsonIgnore
	DeviceTransportType getType();

	default void validate() {
	}

	@Data
	public class DefaultDeviceTransportConfiguration implements DeviceTransportConfiguration {
		private static final long serialVersionUID = 1L;

		@Override
		public DeviceTransportType getType() {
			return DeviceTransportType.DEFAULT;
		}
	}

	@Data
	public class MqttDeviceTransportConfiguration implements DeviceTransportConfiguration {
		private static final long serialVersionUID = 1L;
		
		@JsonIgnore
		private Map<String, Object> properties = new HashMap<>();

		@JsonAnyGetter
		public Map<String, Object> properties() {
			return this.properties;
		}

		@JsonAnySetter
		public void put(String name, Object value) {
			this.properties.put(name, value);
		}

		@Override
		public DeviceTransportType getType() {
			return DeviceTransportType.MQTT;
		}
	}

}
