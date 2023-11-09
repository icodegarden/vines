package io.github.icodegarden.vines.data.biz.core;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.github.icodegarden.vines.data.biz.core.KeyFilterPredicate.BooleanFilterPredicate;
import io.github.icodegarden.vines.data.biz.core.KeyFilterPredicate.ComplexFilterPredicate;
import io.github.icodegarden.vines.data.biz.core.KeyFilterPredicate.NumericFilterPredicate;
import io.github.icodegarden.vines.data.biz.core.KeyFilterPredicate.StringFilterPredicate;
import lombok.Data;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = StringFilterPredicate.class, name = "STRING"),
		@JsonSubTypes.Type(value = NumericFilterPredicate.class, name = "NUMERIC"),
		@JsonSubTypes.Type(value = BooleanFilterPredicate.class, name = "BOOLEAN"),
		@JsonSubTypes.Type(value = ComplexFilterPredicate.class, name = "COMPLEX") })
public interface KeyFilterPredicate extends Serializable {

	@JsonIgnore
	FilterPredicateType getType();

	@Data
	public class StringFilterPredicate implements SimpleKeyFilterPredicate<String> {

		private StringOperation operation;
		private FilterPredicateValue<String> value;
		private boolean ignoreCase;

		@Override
		public FilterPredicateType getType() {
			return FilterPredicateType.STRING;
		}

		public enum StringOperation {
			EQUAL, NOT_EQUAL, STARTS_WITH, ENDS_WITH, CONTAINS, NOT_CONTAINS, IN, NOT_IN
		}
	}

	@Data
	public class NumericFilterPredicate implements SimpleKeyFilterPredicate<Double> {

		private NumericOperation operation;
		private FilterPredicateValue<Double> value;

		@Override
		public FilterPredicateType getType() {
			return FilterPredicateType.NUMERIC;
		}

		public enum NumericOperation {
			EQUAL, NOT_EQUAL, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL
		}
	}

	@Data
	public class BooleanFilterPredicate implements SimpleKeyFilterPredicate<Boolean> {

		private BooleanOperation operation;
		private FilterPredicateValue<Boolean> value;

		@Override
		public FilterPredicateType getType() {
			return FilterPredicateType.BOOLEAN;
		}

		public enum BooleanOperation {
			EQUAL, NOT_EQUAL
		}
	}

	@Data
	public class ComplexFilterPredicate implements KeyFilterPredicate {

		private ComplexOperation operation;
		private List<KeyFilterPredicate> predicates;

		@Override
		public FilterPredicateType getType() {
			return FilterPredicateType.COMPLEX;
		}

		public enum ComplexOperation {
			AND, OR
		}
	}

}
