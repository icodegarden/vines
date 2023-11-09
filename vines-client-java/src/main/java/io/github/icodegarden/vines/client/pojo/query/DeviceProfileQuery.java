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
public class DeviceProfileQuery extends BaseQuery {

	private String nameLike;

	@Builder
	public DeviceProfileQuery(int page, int size, String nameLike) {
		super(page, size, null);
		this.nameLike = nameLike;
	}

}
