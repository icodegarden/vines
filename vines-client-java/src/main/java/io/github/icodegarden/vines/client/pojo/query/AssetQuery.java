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
public class AssetQuery extends BaseQuery {

	private String nameLike;

	@Builder
	public AssetQuery(int page, int size, String nameLike) {
		super(page, size, null);
		this.nameLike = nameLike;
	}

}
