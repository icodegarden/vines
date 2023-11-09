package io.github.icodegarden.vines.data.biz.kv;

import java.io.Serializable;
import java.util.Optional;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public interface KvEntry extends Serializable {

    String getKey();

    DataType getDataType();

    Optional<String> getStrValue();

    Optional<Long> getLongValue();

    Optional<Boolean> getBooleanValue();

    Optional<Double> getDoubleValue();

    Optional<String> getJsonValue();

    String getValueAsString();

    Object getValue();
}
