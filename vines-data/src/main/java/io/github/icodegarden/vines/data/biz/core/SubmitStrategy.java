package io.github.icodegarden.vines.data.biz.core;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Setter
@Getter
@ToString
public class SubmitStrategy implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private SubmitStrategyType type;
	private int batchSize;

	public static enum SubmitStrategyType implements Serializable {
		
		BURST, BATCH, SEQUENTIAL_BY_ORIGINATOR, SEQUENTIAL_BY_TENANT, SEQUENTIAL
	}
}