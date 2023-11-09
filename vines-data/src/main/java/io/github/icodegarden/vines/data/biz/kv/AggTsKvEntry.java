package io.github.icodegarden.vines.data.biz.kv;

import lombok.ToString;
/**
 * 
 * @author Fangfang.Xu
 *
 */
@ToString
public class AggTsKvEntry extends BasicTsKvEntry {
	private static final long serialVersionUID = 1L;
	
    private final long count;

    public AggTsKvEntry(long ts, KvEntry kv, long count) {
        super(ts, kv);
        this.count = count;
    }

    @Override
    public TsValue toTsValue() {
        return new TsValue(ts, getValueAsString(), count);
    }
}
