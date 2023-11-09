package io.github.icodegarden.vines.data.id;

import lombok.Getter;
import lombok.ToString;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Getter
@ToString
public class EntityObject {

	private final String tenantId;
	private final EntityId entityId;
	private final String entityName;
	private final String customerId;

	public EntityObject(String tenantId, EntityId entityId, String entityName, String customerId) {
		super();
		this.tenantId = tenantId;
		this.entityId = entityId;
		this.entityName = entityName;
		this.customerId = customerId;
	}
}
