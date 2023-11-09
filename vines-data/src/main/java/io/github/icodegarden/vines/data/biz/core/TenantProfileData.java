package io.github.icodegarden.vines.data.biz.core;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Data
public class TenantProfileData implements Serializable {
	private static final long serialVersionUID = 1L;

//    @ApiModelProperty(position = 1, value = "Complex JSON object that contains profile settings: max devices, max assets, rate limits, etc.")
    private TenantProfileConfiguration configuration;

//    @ApiModelProperty(position = 2, value = "JSON array of queue configuration per tenant profile")
    private List<TenantProfileQueueConfiguration> queueConfiguration;

}
