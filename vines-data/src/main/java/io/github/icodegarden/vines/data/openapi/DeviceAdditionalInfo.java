package io.github.icodegarden.vines.data.openapi;

import io.github.icodegarden.nutrient.lang.annotation.Length;
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
@Getter
@Setter
@ToString
public class DeviceAdditionalInfo {
	
	@Length(max = 200)
	private String description;
	private Boolean gateway;
	private Boolean overwriteActivityTime;
}