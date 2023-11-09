package io.github.icodegarden.vines.data.biz.device;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.github.icodegarden.vines.data.biz.core.MqttTopics;
import io.github.icodegarden.vines.data.biz.core.TransportPayloadType;
import io.github.icodegarden.vines.data.biz.core.TransportPayloadTypeConfiguration;
import io.github.icodegarden.vines.data.biz.device.DeviceProfileTransportConfiguration.DefaultDeviceProfileTransportConfiguration;
import io.github.icodegarden.vines.data.biz.device.DeviceProfileTransportConfiguration.MqttDeviceProfileTransportConfiguration;
import lombok.Data;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = DefaultDeviceProfileTransportConfiguration.class, name = "DEFAULT"),
		@JsonSubTypes.Type(value = MqttDeviceProfileTransportConfiguration.class, name = "MQTT"),
/*
 * @JsonSubTypes.Type(value = Lwm2mDeviceProfileTransportConfiguration.class,
 * name = "LWM2M"),
 * 
 * @JsonSubTypes.Type(value = CoapDeviceProfileTransportConfiguration.class,
 * name = "COAP"),
 * 
 * @JsonSubTypes.Type(value = SnmpDeviceProfileTransportConfiguration.class,
 * name = "SNMP")
 */
})
public interface DeviceProfileTransportConfiguration extends Serializable {

	@JsonIgnore
	DeviceTransportType getType();

	default void validate() {
	}

	@Data
	public class DefaultDeviceProfileTransportConfiguration implements DeviceProfileTransportConfiguration {

		@Override
		public DeviceTransportType getType() {
			return DeviceTransportType.DEFAULT;
		}

	}

	@Data
	public class MqttDeviceProfileTransportConfiguration implements DeviceProfileTransportConfiguration {

		private String deviceTelemetryTopic = MqttTopics.DEVICE_TELEMETRY_TOPIC;
		private String deviceAttributesTopic = MqttTopics.DEVICE_ATTRIBUTES_TOPIC;
		private TransportPayloadTypeConfiguration transportPayloadTypeConfiguration;
		private boolean sendAckOnValidationException;

		@Override
		public DeviceTransportType getType() {
			return DeviceTransportType.MQTT;
		}

		public TransportPayloadTypeConfiguration getTransportPayloadTypeConfiguration() {
			if (transportPayloadTypeConfiguration != null) {
				return transportPayloadTypeConfiguration;
			} else {
				return new JsonTransportPayloadConfiguration();
			}
		}

		@Data
		public class JsonTransportPayloadConfiguration implements TransportPayloadTypeConfiguration {

			@Override
			public TransportPayloadType getTransportPayloadType() {
				return TransportPayloadType.JSON;
			}
		}
	}

}