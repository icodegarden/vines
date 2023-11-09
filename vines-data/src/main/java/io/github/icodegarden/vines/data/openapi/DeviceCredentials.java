package io.github.icodegarden.vines.data.openapi;

import io.github.icodegarden.vines.data.biz.core.DeviceCredentialsType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DeviceCredentials {
	private DeviceCredentialsType credentialsType;
	private String credentialsId;
	private String credentialsValue;
}