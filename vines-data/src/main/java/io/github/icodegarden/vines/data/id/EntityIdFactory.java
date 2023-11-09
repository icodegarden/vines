package io.github.icodegarden.vines.data.id;

import io.github.icodegarden.vines.data.biz.core.EntityType;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public class EntityIdFactory {

	public static EntityId getByTypeAndId(String type, String uuid) {
		return getByTypeAndUuid(EntityType.valueOf(type), uuid);
	}
//
//    public static EntityId getByTypeAndUuid(String type, UUID uuid) {
//        return getByTypeAndUuid(EntityType.valueOf(type), uuid);
//    }

//    public static EntityId getByTypeAndUuid(EntityType type, String uuid) {
//        return getByTypeAndUuid(type, UUID.fromString(uuid));
//    }

	public static EntityId getByTypeAndId(EntityType type, EntityId id) {
		return getByTypeAndUuid(type, id.getId());
	}

	public static EntityId getByTypeAndUuid(EntityType type, String uuid) {
		switch (type) {
		case TENANT:
			return new TenantId(uuid);
		case CUSTOMER:
			return new CustomerId(uuid);
		case USER:
			return new UserId(uuid);
		case DASHBOARD:
			return new DashboardId(uuid);
		case DEVICE:
			return new DeviceId(uuid);
		case ASSET:
			return new AssetId(uuid);
		case ALARM:
			return new AlarmId(uuid);
		case RULE_CHAIN:
			return new RuleChainId(uuid);
		case RULE_NODE:
			return new RuleNodeId(uuid);
//            case ENTITY_VIEW:
//                return new EntityViewId(uuid);
//            case WIDGETS_BUNDLE:
//                return new WidgetsBundleId(uuid);
//            case WIDGET_TYPE:
//                return new WidgetTypeId(uuid);
		case DEVICE_PROFILE:
			return new DeviceProfileId(uuid);
		case ASSET_PROFILE:
			return new AssetProfileId(uuid);
		case TENANT_PROFILE:
			return new TenantProfileId(uuid);
//            case API_USAGE_STATE:
//                return new ApiUsageStateId(uuid);
//            case TB_RESOURCE:
//                return new TbResourceId(uuid);
		case OTA_PACKAGE:
			return new OtaPackageId(uuid);
//            case EDGE:
//                return new EdgeId(uuid);
//            case RPC:
//                return new RpcId(uuid);
//            case QUEUE:
//                return new QueueId(uuid);
		default:
			throw new IllegalArgumentException("EntityType " + type + " is not supported!");
		}
	}

}
