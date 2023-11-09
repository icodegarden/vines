package io.github.icodegarden.vines.data.id;

import io.github.icodegarden.vines.data.biz.core.EntityType;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public class CustomerId extends EntityId{

	public CustomerId(String id) {
		super(id, EntityType.CUSTOMER);
	}
}
