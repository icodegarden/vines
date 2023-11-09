package io.github.icodegarden.vines.data.biz.device;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Data
public class DeviceData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DeviceConfiguration configuration;
	private DeviceTransportConfiguration transportConfiguration;
}