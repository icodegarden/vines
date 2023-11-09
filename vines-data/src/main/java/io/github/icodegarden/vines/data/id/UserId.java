package io.github.icodegarden.vines.data.id;

import io.github.icodegarden.vines.data.biz.core.EntityType;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public class UserId extends EntityId{

	public UserId(String id) {
		super(id, EntityType.USER);
	}
}
