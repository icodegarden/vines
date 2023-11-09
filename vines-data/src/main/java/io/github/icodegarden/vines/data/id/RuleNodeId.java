package io.github.icodegarden.vines.data.id;

import io.github.icodegarden.vines.data.biz.core.EntityType;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public class RuleNodeId extends EntityId{

	public RuleNodeId(String id) {
		super(id, EntityType.RULE_NODE);
	}
}
