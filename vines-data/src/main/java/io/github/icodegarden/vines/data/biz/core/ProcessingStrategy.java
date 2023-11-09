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
public class ProcessingStrategy implements Serializable {
	private static final long serialVersionUID = 1L;

	private ProcessingStrategyType type;
	private int retries;
	private double failurePercentage;
	private long pauseBetweenRetries;
	private long maxPauseBetweenRetries;

	public static enum ProcessingStrategyType implements Serializable {
		SKIP_ALL_FAILURES, SKIP_ALL_FAILURES_AND_TIMED_OUT, RETRY_ALL, RETRY_FAILED, RETRY_TIMED_OUT,
		RETRY_FAILED_AND_TIMED_OUT
	}
}