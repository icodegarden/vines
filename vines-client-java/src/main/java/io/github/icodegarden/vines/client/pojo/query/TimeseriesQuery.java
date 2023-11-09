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
public class TimeseriesQuery extends BaseQuery {

	private String entityId;

	@Builder
	public TimeseriesQuery(int page, int size, String entityId) {
		super(page, size, null);
		this.entityId = entityId;
	}

}
