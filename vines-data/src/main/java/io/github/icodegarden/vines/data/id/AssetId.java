package io.github.icodegarden.vines.data.id;

import io.github.icodegarden.vines.data.biz.core.EntityType;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public class AssetId extends EntityId {

	public AssetId(String id) {
		super(id, EntityType.ASSET);
	}
}
