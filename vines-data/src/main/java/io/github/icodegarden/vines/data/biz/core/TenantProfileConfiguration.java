package io.github.icodegarden.vines.data.biz.core;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.github.icodegarden.vines.data.biz.core.TenantProfileConfiguration.DefaultTenantProfileConfiguration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = DefaultTenantProfileConfiguration.class, name = "DEFAULT") })
public interface TenantProfileConfiguration extends Serializable {

	@JsonIgnore
	TenantProfileType getType();

//    @JsonIgnore
//    long getProfileThreshold(ApiUsageRecordKey key);
//
//    @JsonIgnore
//    long getWarnThreshold(ApiUsageRecordKey key);

	@JsonIgnore
	int getMaxRuleNodeExecsPerMessage();

	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	@Data
	class DefaultTenantProfileConfiguration implements TenantProfileConfiguration {
		private static final long serialVersionUID = 1L;

		private long maxDevices;
		private long maxAssets;
		private long maxCustomers;
		private long maxUsers;
		private long maxDashboards;
		private long maxRuleChains;
		private long maxResourcesInBytes;
		private long maxOtaPackagesInBytes;

		private String transportTenantMsgRateLimit;
		private String transportTenantTelemetryMsgRateLimit;
		private String transportTenantTelemetryDataPointsRateLimit;
		private String transportDeviceMsgRateLimit;
		private String transportDeviceTelemetryMsgRateLimit;
		private String transportDeviceTelemetryDataPointsRateLimit;

		private String tenantEntityExportRateLimit;
		private String tenantEntityImportRateLimit;

		private long maxTransportMessages;
		private long maxTransportDataPoints;
		private long maxREExecutions;
		private long maxJSExecutions;
		private long maxDPStorageDays;
		private int maxRuleNodeExecutionsPerMessage;
		private long maxEmails;
		private long maxSms;
		private long maxCreatedAlarms;

		private String tenantServerRestLimitsConfiguration;
		private String customerServerRestLimitsConfiguration;

		private int maxWsSessionsPerTenant;
		private int maxWsSessionsPerCustomer;
		private int maxWsSessionsPerRegularUser;
		private int maxWsSessionsPerPublicUser;
		private int wsMsgQueueLimitPerSession;
		private long maxWsSubscriptionsPerTenant;
		private long maxWsSubscriptionsPerCustomer;
		private long maxWsSubscriptionsPerRegularUser;
		private long maxWsSubscriptionsPerPublicUser;
		private String wsUpdatesPerSessionRateLimit;

		private String cassandraQueryTenantRateLimitsConfiguration;

		private int defaultStorageTtlDays;
		private int alarmsTtlDays;
		private int rpcTtlDays;

		private double warnThreshold;

//        @Override
//        public long getProfileThreshold(ApiUsageRecordKey key) {
//            switch (key) {
//                case TRANSPORT_MSG_COUNT:
//                    return maxTransportMessages;
//                case TRANSPORT_DP_COUNT:
//                    return maxTransportDataPoints;
//                case JS_EXEC_COUNT:
//                    return maxJSExecutions;
//                case RE_EXEC_COUNT:
//                    return maxREExecutions;
//                case STORAGE_DP_COUNT:
//                    return maxDPStorageDays;
//                case EMAIL_EXEC_COUNT:
//                    return maxEmails;
//                case SMS_EXEC_COUNT:
//                    return maxSms;
//                case CREATED_ALARMS_COUNT:
//                    return maxCreatedAlarms;
//            }
//            return 0L;
//        }
//
//        @Override
//        public long getWarnThreshold(ApiUsageRecordKey key) {
//            return (long) (getProfileThreshold(key) * (warnThreshold > 0.0 ? warnThreshold : 0.8));
//        }

		@Override
		public TenantProfileType getType() {
			return TenantProfileType.DEFAULT;
		}

		@Override
		public int getMaxRuleNodeExecsPerMessage() {
			return maxRuleNodeExecutionsPerMessage;
		}
	}
}
