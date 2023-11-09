package io.github.icodegarden.vines.data.biz.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.github.icodegarden.vines.data.biz.core.TransportPayloadTypeConfiguration.JsonTransportPayloadConfiguration;
import lombok.Data;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "transportPayloadType")
@JsonSubTypes({ @JsonSubTypes.Type(value = JsonTransportPayloadConfiguration.class, name = "JSON"),
/*
 * @JsonSubTypes.Type(value = ProtoTransportPayloadConfiguration.class, name =
 * "PROTOBUF")
 */
})
public interface TransportPayloadTypeConfiguration {

	@JsonIgnore
	TransportPayloadType getTransportPayloadType();

	@Data
	public class JsonTransportPayloadConfiguration implements TransportPayloadTypeConfiguration {

		@Override
		public TransportPayloadType getTransportPayloadType() {
			return TransportPayloadType.JSON;
		}
	}

}
