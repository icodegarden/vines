package io.github.icodegarden.vines.data.biz.core;

import com.fasterxml.jackson.databind.JsonNode;

import io.github.icodegarden.vines.data.id.EntityId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Relation {

	private String fromId;

	private String fromType;

	private String toId;

	private String toType;

	private String relationTypeGroup;

	private String relationType;// Success、Other、Post attributes、Post telemetry、Contains等

	private JsonNode additionalInfo;

	public Relation(EntityId from, EntityId to, RelationTypeGroup relationTypeGroup, String relationType) {
		this.fromId = from.getId();
		this.fromType = from.getEntityType().name();
		this.toId = to.getId();
		this.toType = to.getEntityType().name();
		this.relationTypeGroup = relationTypeGroup.name();
		this.relationType = relationType;
//		this.additionalInfo = additionalInfo;
	}
}
