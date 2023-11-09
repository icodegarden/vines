package io.github.icodegarden.vines.client;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.node.ObjectNode;

import io.github.icodegarden.nutrient.exchange.http.HttpEntity;
import io.github.icodegarden.nutrient.exchange.http.HttpHeaders;
import io.github.icodegarden.nutrient.exchange.http.HttpMethod;
import io.github.icodegarden.nutrient.exchange.http.RestRequestTemplate;
import io.github.icodegarden.nutrient.lang.exception.remote.RemoteException;
import io.github.icodegarden.nutrient.lang.tuple.Tuple2;
import io.github.icodegarden.vines.client.pojo.query.AssetProfileQuery;
import io.github.icodegarden.vines.client.pojo.query.AssetQuery;
import io.github.icodegarden.vines.client.pojo.query.AttributeQuery;
import io.github.icodegarden.vines.client.pojo.query.DeviceProfileQuery;
import io.github.icodegarden.vines.client.pojo.query.DeviceQuery;
import io.github.icodegarden.vines.client.pojo.query.RuleChainQuery;
import io.github.icodegarden.vines.client.pojo.query.TimeseriesQuery;
import io.github.icodegarden.vines.client.pojo.transfer.CreateAssetOpenapiDTO;
import io.github.icodegarden.vines.client.pojo.transfer.CreateDeviceOpenapiDTO;
import io.github.icodegarden.vines.client.pojo.transfer.TriggerRuleChainOpenapiDTO;
import io.github.icodegarden.vines.client.pojo.transfer.UpdateAssetOpenapiDTO;
import io.github.icodegarden.vines.client.pojo.transfer.UpdateDeviceOpenapiDTO;
import io.github.icodegarden.vines.client.pojo.view.openapi.AssetOpenapiVO;
import io.github.icodegarden.vines.client.pojo.view.openapi.AssetProfileOpenapiVO;
import io.github.icodegarden.vines.client.pojo.view.openapi.AttributeKvVO;
import io.github.icodegarden.vines.client.pojo.view.openapi.DeviceOpenapiVO;
import io.github.icodegarden.vines.client.pojo.view.openapi.DeviceProfileOpenapiVO;
import io.github.icodegarden.vines.client.pojo.view.openapi.RuleChainOpenapiVO;
import io.github.icodegarden.vines.client.pojo.view.openapi.TriggerRuleChainOpenapiVO;
import io.github.icodegarden.vines.client.pojo.view.openapi.TsKvLatestVO;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public class VinesClient implements Closeable {

	private RestRequestTemplate template;

	private final ClientProperties clientProperties;

	public VinesClient(ClientProperties clientProperties) {
		Assert.notNull(clientProperties.getServerAddress(), "serverAddress must not empty");
		if (!clientProperties.getServerAddress().startsWith("http")) {
			clientProperties.setServerAddress("http://" + clientProperties.getServerAddress());
		}

		this.clientProperties = clientProperties;

		template = new RestRequestTemplate();
		template.setConnectTimeout(clientProperties.getExchange().getConnectTimeout());
		template.setReadTimeout(clientProperties.getExchange().getReadTimeout());
	}

	public RuleChainOpenapiVO getRuleChain(String id) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/ruleChains").append("/").append(id);

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<RuleChainOpenapiVO> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				RuleChainOpenapiVO.class);

		return entity.getBody();
	}

	public List<RuleChainOpenapiVO> pageRuleChains(RuleChainQuery query) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/ruleChains")//
				.append("?page=").append(Integer.toString(query.getPage()))//
				.append("&size=").append(Integer.toString(query.getSize()));
		if (query.getNameLike() != null) {
			url.append("&nameLike=").append(query.getNameLike());
		}

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<List<RuleChainOpenapiVO>> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<RuleChainOpenapiVO>>() {
				});

		return entity.getBody();
	}

	public AssetProfileOpenapiVO getAssetProfile(String id) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/assetProfiles").append("/").append(id);

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<AssetProfileOpenapiVO> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				AssetProfileOpenapiVO.class);

		return entity.getBody();
	}

	public List<AssetProfileOpenapiVO> pageAssetProfiles(AssetProfileQuery query) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/assetProfiles")//
				.append("?page=").append(Integer.toString(query.getPage()))//
				.append("&size=").append(Integer.toString(query.getSize()));
		if (query.getNameLike() != null) {
			url.append("&nameLike=").append(query.getNameLike());
		}

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<List<AssetProfileOpenapiVO>> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<AssetProfileOpenapiVO>>() {
				});

		return entity.getBody();
	}

	public DeviceProfileOpenapiVO getDeviceProfile(String id) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/deviceProfiles").append("/").append(id);

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<DeviceProfileOpenapiVO> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				DeviceProfileOpenapiVO.class);

		return entity.getBody();
	}

	public List<DeviceProfileOpenapiVO> pageDeviceProfiles(DeviceProfileQuery query) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/deviceProfiles")//
				.append("?page=").append(Integer.toString(query.getPage()))//
				.append("&size=").append(Integer.toString(query.getSize()));
		if (query.getNameLike() != null) {
			url.append("&nameLike=").append(query.getNameLike());
		}

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<List<DeviceProfileOpenapiVO>> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<DeviceProfileOpenapiVO>>() {
				});

		return entity.getBody();
	}

//	public void deleteRuleChain(String id) {
//		StringBuilder url = new StringBuilder(50)//
//				.append(clientProperties.getServerAddress())//
//				.append("/openapi/v1/ruleChains").append("/").append(id);
//
//		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());
//
//		template.exchange(url.toString(), HttpMethod.DELETE, httpEntity, Void.class);
//	}

	public AssetOpenapiVO getAsset(String id) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/assets").append("/").append(id);

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<AssetOpenapiVO> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				AssetOpenapiVO.class);

		return entity.getBody();
	}

	public List<AssetOpenapiVO> pageAssets(AssetQuery query) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/assets")//
				.append("?page=").append(Integer.toString(query.getPage()))//
				.append("&size=").append(Integer.toString(query.getSize()));
		if (query.getNameLike() != null) {
			url.append("&nameLike=").append(query.getNameLike());
		}

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<List<AssetOpenapiVO>> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<AssetOpenapiVO>>() {
				});

		return entity.getBody();
	}

	public AssetOpenapiVO createAsset(CreateAssetOpenapiDTO dto) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/assets");

		HttpEntity<?> httpEntity = new HttpEntity<>(dto, buildHeaders());

		HttpEntity<AssetOpenapiVO> entity = template.exchange(url.toString(), HttpMethod.POST, httpEntity,
				AssetOpenapiVO.class);

		return entity.getBody();
	}

	public AssetOpenapiVO updateAsset(UpdateAssetOpenapiDTO dto) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/assets");

		HttpEntity<?> httpEntity = new HttpEntity<>(dto, buildHeaders());

		HttpEntity<AssetOpenapiVO> entity = template.exchange(url.toString(), HttpMethod.PUT, httpEntity,
				AssetOpenapiVO.class);

		return entity.getBody();
	}

	public void deleteAsset(String id) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/assets").append("/").append(id);

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		template.exchange(url.toString(), HttpMethod.DELETE, httpEntity, Void.class);
	}

	public DeviceOpenapiVO getDevice(String id) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/devices").append("/").append(id);

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<DeviceOpenapiVO> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				DeviceOpenapiVO.class);

		return entity.getBody();
	}

	public List<DeviceOpenapiVO> pageDevices(DeviceQuery query) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/devices")//
				.append("?page=").append(Integer.toString(query.getPage()))//
				.append("&size=").append(Integer.toString(query.getSize()));
		if (query.getNameLike() != null) {
			url.append("&nameLike=").append(query.getNameLike());
		}

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<List<DeviceOpenapiVO>> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<DeviceOpenapiVO>>() {
				});

		return entity.getBody();
	}

	public DeviceOpenapiVO createDevice(CreateDeviceOpenapiDTO dto) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/devices");

		HttpEntity<?> httpEntity = new HttpEntity<>(dto, buildHeaders());

		HttpEntity<DeviceOpenapiVO> entity = template.exchange(url.toString(), HttpMethod.POST, httpEntity,
				DeviceOpenapiVO.class);

		return entity.getBody();
	}

	public DeviceOpenapiVO updateDevice(UpdateDeviceOpenapiDTO dto) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/devices");

		HttpEntity<?> httpEntity = new HttpEntity<>(dto, buildHeaders());

		HttpEntity<DeviceOpenapiVO> entity = template.exchange(url.toString(), HttpMethod.PUT, httpEntity,
				DeviceOpenapiVO.class);

		return entity.getBody();
	}

	public void deleteDevice(String id) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/devices").append("/").append(id);

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		template.exchange(url.toString(), HttpMethod.DELETE, httpEntity, Void.class);
	}

	public AttributeKvVO getAttributeByEntity(String entityType, String entityId, String attributeType,
			String attributeKey) throws RemoteException {
		Assert.notNull(entityType, "entityType must present");
		Assert.notNull(entityId, "entityId must present");
		Assert.notNull(attributeType, "attributeType must present");
		Assert.notNull(attributeKey, "attributeKey must present");

		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/attributes/findOneByEntity")//
				.append("?entityType=").append(entityType)//
				.append("&entityId=").append(entityId)//
				.append("&attributeType=").append(attributeType)//
				.append("&attributeKey=").append(attributeKey);

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<AttributeKvVO> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				AttributeKvVO.class);

		return entity.getBody();
	}

	public List<AttributeKvVO> pageAttributesByEntity(AttributeQuery query) throws RemoteException {
		Assert.notNull(query.getEntityType(), "entityType must present");
		Assert.notNull(query.getEntityId(), "entityId must present");

		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/attributes/pageByEntity")//
				.append("?entityType=").append(query.getEntityType())//
				.append("&entityId=").append(query.getEntityId())//
				.append("&page=").append(Integer.toString(query.getPage()))//
				.append("&size=").append(Integer.toString(query.getSize()));

		if (query.getAttributeType() != null) {
			url.append("&attributeType=").append(query.getAttributeType());
		}

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<List<AttributeKvVO>> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<AttributeKvVO>>() {
				});

		return entity.getBody();
	}

	public TsKvLatestVO getTimeseriesByEntity(String entityId, String key) throws RemoteException {
		Assert.notNull(entityId, "entityId must present");
		Assert.notNull(key, "key must present");

		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/timeseries/findOneByEntity")//
				.append("?entityId=").append(entityId)//
				.append("&key=").append(key);

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<TsKvLatestVO> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				TsKvLatestVO.class);

		return entity.getBody();
	}

	public List<TsKvLatestVO> pageTimeseriesByEntity(TimeseriesQuery query) throws RemoteException {
		Assert.notNull(query.getEntityId(), "entityId must present");

		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/timeseries/pageByEntity")//
				.append("?entityId=").append(query.getEntityId())//
				.append("&page=").append(Integer.toString(query.getPage()))//
				.append("&size=").append(Integer.toString(query.getSize()));

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<List<TsKvLatestVO>> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<TsKvLatestVO>>() {
				});

		return entity.getBody();
	}

	public List<String> listEntityTypes() throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/entitys/type");

		HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(buildHeaders());

		HttpEntity<List<String>> entity = template.exchange(url.toString(), HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<String>>() {
				});

		return entity.getBody();
	}

	public TriggerRuleChainOpenapiVO triggerRuleChain(TriggerRuleChainOpenapiDTO request) throws RemoteException {
		StringBuilder url = new StringBuilder(50)//
				.append(clientProperties.getServerAddress())//
				.append("/openapi/v1/ruleChains/trigger");

		HttpEntity<TriggerRuleChainOpenapiDTO> httpEntity = new HttpEntity<>(request, buildHeaders());

		HttpEntity<TriggerRuleChainOpenapiVO> entity = template.exchange(url.toString(), HttpMethod.POST, httpEntity,
				TriggerRuleChainOpenapiVO.class);

		return entity.getBody();
	}

	private HttpHeaders buildHeaders() {
		Tuple2<String, String> tuple2 = clientProperties.getAuthentication().httpToken();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(tuple2.getT1(), tuple2.getT2());
		return httpHeaders;
	}

	@Override
	public void close() throws IOException {
	}
}
