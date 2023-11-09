package io.github.icodegarden.vines.data.id;

import io.github.icodegarden.vines.data.biz.core.EntityType;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public class TenantId extends EntityId{

	public TenantId(String id) {
		super(id, EntityType.TENANT);
	}
}
