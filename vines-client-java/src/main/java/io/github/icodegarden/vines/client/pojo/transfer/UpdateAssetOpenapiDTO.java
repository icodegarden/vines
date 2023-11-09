package io.github.icodegarden.vines.client.pojo.transfer;

import io.github.icodegarden.nutrient.lang.annotation.Length;
import io.github.icodegarden.vines.data.openapi.AssetAdditionalInfo;
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
public class UpdateAssetOpenapiDTO {

	@Length(max = 64)
	@NonNull
	private String id;
	@Length(max = 64)
	private String assetProfileId;
	@Length(max = 64)
	private String customerId;
	@Length(max = 30)
	private String name;
	@Length(max = 30)
	private String label;

	private AssetAdditionalInfo additionalInfo;
}
