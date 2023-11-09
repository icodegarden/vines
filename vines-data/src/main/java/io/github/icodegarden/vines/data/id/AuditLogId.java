package io.github.icodegarden.vines.data.id;

import io.github.icodegarden.vines.data.biz.core.EntityType;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public class AuditLogId extends EntityId {

	public AuditLogId(String id) {
		super(id, EntityType.AUDITLOG);
	}
}
