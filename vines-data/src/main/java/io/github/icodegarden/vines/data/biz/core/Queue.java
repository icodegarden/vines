package io.github.icodegarden.vines.data.biz.core;

import java.io.Serializable;

import com.fasterxml.jackson.databind.JsonNode;

import io.github.icodegarden.vines.data.id.EntityId;
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
public class Queue implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EntityId id;
	private Long createdTime;

	private EntityId tenantId;
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
