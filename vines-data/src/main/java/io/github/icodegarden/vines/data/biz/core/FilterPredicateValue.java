package io.github.icodegarden.vines.data.biz.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 
 * @author Fangfang.Xu
 *
 * @param <T>
 */
@Data
public class FilterPredicateValue<T> {

	private T defaultValue;
	private T userValue;
	private DynamicValue<T> dynamicValue;

	/**
	 * json序列化用
	 */
	public FilterPredicateValue() {
	}

	public FilterPredicateValue(T defaultValue) {
		this(defaultValue, null, null);
	}

	@JsonCreator
	public FilterPredicateValue(@JsonProperty("defaultValue") T defaultValue, @JsonProperty("userValue") T userValue,
			@JsonProperty("dynamicValue") DynamicValue<T> dynamicValue) {
		this.defaultValue = defaultValue;
		this.userValue = userValue;
		this.dynamicValue = dynamicValue;
	}

	@JsonIgnore
	public T getValue() {
		if (this.userValue != null) {
			return this.userValue;
		} else {
			if (this.dynamicValue != null && this.dynamicValue.getResolvedValue() != null) {
				return this.dynamicValue.getResolvedValue();
			} else {
				return defaultValue;
			}
		}
	}

	public static FilterPredicateValue<Double> fromDouble(double value) {
		return new FilterPredicateValue<>(value);
	}

	public static FilterPredicateValue<String> fromString(String value) {
		return new FilterPredicateValue<>(value);
	}

	public static FilterPredicateValue<Boolean> fromBoolean(boolean value) {
		return new FilterPredicateValue<>(value);
	}

	@Data
	public static class DynamicValue<T> {

		@JsonIgnore
		private T resolvedValue;

		private DynamicValueSourceType sourceType;
		private String sourceAttribute;
		private boolean inherit;

		/**
		 * json序列化用
		 */
		public DynamicValue() {
		}

		public DynamicValue(DynamicValueSourceType sourceType, String sourceAttribute) {
			this.sourceAttribute = sourceAttribute;
			this.sourceType = sourceType;
			this.inherit = false;
		}

	}

	public static enum DynamicValueSourceType {
		CURRENT_TENANT, CURRENT_CUSTOMER, CURRENT_USER, CURRENT_DEVICE
	}

}
