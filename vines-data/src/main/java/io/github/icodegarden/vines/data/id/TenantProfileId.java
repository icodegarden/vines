package io.github.icodegarden.vines.data.id;

import io.github.icodegarden.vines.data.biz.core.EntityType;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public class TenantProfileId extends EntityId {

	public TenantProfileId(String id) {
		super(id, EntityType.TENANT_PROFILE);
	}
}
