package io.github.icodegarden.vines.data.biz.core;

/**
 * 
 * @author Fangfang.Xu
 *
 * @param <T>
 */
public interface SimpleKeyFilterPredicate<T> extends KeyFilterPredicate {

	FilterPredicateValue<T> getValue();

}
