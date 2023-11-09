package io.github.icodegarden.vines.data.biz.alarm;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import io.github.icodegarden.vines.data.id.AlarmId;
import io.github.icodegarden.vines.data.id.EntityId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Data
@Builder
@AllArgsConstructor
public class Alarm {

	private EntityId id;

	private Long createdTime;

	private EntityId tenantId;

	private EntityId customerId;

//    @ApiModelProperty(position = 6, required = true, value = "representing type of the Alarm", example = "High Temperature Alarm")
	private String type;
//    @ApiModelProperty(position = 7, required = true, value = "JSON object with alarm originator id")
	private EntityId originator;
//    @ApiModelProperty(position = 8, required = true, value = "Alarm severity", example = "CRITICAL")
	private AlarmSeverity severity;
//    @ApiModelProperty(position = 9, required = true, value = "Alarm status", example = "CLEARED_UNACK")
	private AlarmStatus status;
//    @ApiModelProperty(position = 10, value = "Timestamp of the alarm start time, in milliseconds", example = "1634058704565")
	private long startTs;
//    @ApiModelProperty(position = 11, value = "Timestamp of the alarm end time(last time update), in milliseconds", example = "1634111163522")
	private long endTs;
//    @ApiModelProperty(position = 12, value = "Timestamp of the alarm acknowledgement, in milliseconds", example = "1634115221948")
	private long ackTs;
//    @ApiModelProperty(position = 13, value = "Timestamp of the alarm clearing, in milliseconds", example = "1634114528465")
	private long clearTs;
//    @ApiModelProperty(position = 14, value = "JSON object with alarm details")
	private transient JsonNode details;
//    @ApiModelProperty(position = 15, value = "Propagation flag to specify if alarm should be propagated to parent entities of alarm originator", example = "true")
	private boolean propagate;
//    @ApiModelProperty(position = 16, value = "Propagation flag to specify if alarm should be propagated to the owner (tenant or customer) of alarm originator", example = "true")
	private boolean propagateToOwner;
//    @ApiModelProperty(position = 17, value = "Propagation flag to specify if alarm should be propagated to the tenant entity", example = "true")
	private boolean propagateToTenant;
//    @ApiModelProperty(position = 18, value = "JSON array of relation types that should be used for propagation. " +
//            "By default, 'propagateRelationTypes' array is empty which means that the alarm will be propagated based on any relation type to parent entities. " +
//            "This parameter should be used only in case when 'propagate' parameter is set to true, otherwise, 'propagateRelationTypes' array will be ignored.")
	private List<String> propagateRelationTypes;

	public Alarm() {
		super();
	}

	public Alarm(AlarmId id) {
		this.id = id;
	}

	public Alarm(Alarm alarm) {
		this.id = alarm.getId();
		this.createdTime = alarm.getCreatedTime();
		this.tenantId = alarm.getTenantId();
		this.customerId = alarm.getCustomerId();
		this.type = alarm.getType();
		this.originator = alarm.getOriginator();
		this.severity = alarm.getSeverity();
		this.status = alarm.getStatus();
		this.startTs = alarm.getStartTs();
		this.endTs = alarm.getEndTs();
		this.ackTs = alarm.getAckTs();
		this.clearTs = alarm.getClearTs();
		this.details = alarm.getDetails();
		this.propagate = alarm.isPropagate();
		this.propagateToOwner = alarm.isPropagateToOwner();
		this.propagateToTenant = alarm.isPropagateToTenant();
		this.propagateRelationTypes = alarm.getPropagateRelationTypes();
	}

	public String getName() {
		return type;
	}

}
