package io.github.icodegarden.vines.client.pojo.transfer;

import io.github.icodegarden.nutrient.lang.annotation.Length;
import io.github.icodegarden.nutrient.lang.annotation.NotNull;
import io.github.icodegarden.vines.data.biz.device.DeviceData;
import io.github.icodegarden.vines.data.openapi.AssetAdditionalInfo;
import io.github.icodegarden.vines.data.openapi.DeviceAdditionalInfo;
import io.github.icodegarden.vines.data.openapi.DeviceCredentials;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Builder
@Getter
@Setter
@ToString
public class UpdateDeviceOpenapiDTO {

	@Length(max = 64)
	@NonNull
	private String id;

	@Length(max = 64)
	private String customerId;
	@Length(max = 30)
	private String name;
	@Length(max = 30)
	private String label;

	private DeviceData deviceData;
	@Length(max = 64)
	private String deviceProfileId;

	private DeviceAdditionalInfo additionalInfo;

	private DeviceCredentials deviceCredentials;

}
