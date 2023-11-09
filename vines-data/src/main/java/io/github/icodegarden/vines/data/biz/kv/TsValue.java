package io.github.icodegarden.vines.data.biz.kv;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;
/**
 * 
 * @author Fangfang.Xu
 *
 */
@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TsValue {

    public static final TsValue EMPTY = new TsValue(0, "");

    private final long ts;
    private final String value;
    private final Long count;

    public TsValue(long ts, String value) {
        this(ts, value, null);
    }

}
