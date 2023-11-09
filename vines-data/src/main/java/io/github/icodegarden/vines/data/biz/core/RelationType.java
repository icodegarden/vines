package io.github.icodegarden.vines.data.biz.core;

import lombok.Getter;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Getter
public enum RelationType {

	EDGE_TYPE("ManagedByEdge"), CONTAINS_TYPE("Contains"), MANAGES_TYPE("Manages");

	final String value;

	private RelationType(String value) {
		this.value = value;
	}
}