package io.github.icodegarden.vines.data.id;

import io.github.icodegarden.vines.data.biz.core.EntityType;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public class DeviceId extends EntityId {

	public DeviceId(String id) {
		super(id, EntityType.DEVICE);
	}
}
