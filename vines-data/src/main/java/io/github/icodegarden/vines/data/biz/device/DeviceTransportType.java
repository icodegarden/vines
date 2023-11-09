package io.github.icodegarden.vines.data.biz.device;

import java.io.Serializable;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public enum DeviceTransportType implements Serializable {
	DEFAULT, MQTT, COAP, LWM2M, SNMP
}
