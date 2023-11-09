package io.github.icodegarden.vines.client.pojo.query;

import io.github.icodegarden.nutrient.lang.query.BaseQuery;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author Fangfang.Xu
 *
 */
@Getter
@ToString
public class AttributeQuery extends BaseQuery {

	private String entityType;
	private String entityId;
	private String attributeType;

	@Builder
	public AttributeQuery(int page, int size, String orderBy, String entityType, String entityId,
			String attributeType) {
		super(page, size, orderBy);
		this.entityType = entityType;
		this.entityId = entityId;
		this.attributeType = attributeType;
	}

}
