package io.github.icodegarden.vines.data.biz.core;

import java.io.Serializable;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Data
public class TenantProfileQueueConfiguration implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String topic;
	private int pollInterval;
	private int partitions;
	private boolean consumerPerPartition;
	private long packProcessingTimeout;
	private SubmitStrategy submitStrategy;
	private ProcessingStrategy processingStrategy;
	private JsonNode additionalInfo;
}
