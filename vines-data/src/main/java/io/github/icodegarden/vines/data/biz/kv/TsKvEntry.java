package io.github.icodegarden.vines.data.biz.kv;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 
 * @author Fangfang.Xu
 *
 */
public interface TsKvEntry extends KvEntry {

	long getTs();

	@JsonIgnore
	int getDataPoints();

	@JsonIgnore
	default TsValue toTsValue() {
		return new TsValue(getTs(), getValueAsString());
	}

}
