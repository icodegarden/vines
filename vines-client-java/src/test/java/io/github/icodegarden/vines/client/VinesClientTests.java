package io.github.icodegarden.vines.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;

import io.github.icodegarden.nutrient.lang.util.JsonUtils;
import io.github.icodegarden.vines.client.pojo.query.AssetProfileQuery;
import io.github.icodegarden.vines.client.pojo.query.AssetQuery;
import io.github.icodegarden.vines.client.pojo.query.DeviceProfileQuery;
import io.github.icodegarden.vines.client.pojo.query.DeviceQuery;
import io.github.icodegarden.vines.client.pojo.query.RuleChainQuery;
import io.github.icodegarden.vines.client.pojo.transfer.CreateAssetOpenapiDTO;
import io.github.icodegarden.vines.client.pojo.transfer.CreateDeviceOpenapiDTO;
import io.github.icodegarden.vines.client.pojo.transfer.TriggerRuleChainOpenapiDTO;
import io.github.icodegarden.vines.client.pojo.transfer.UpdateAssetOpenapiDTO;
import io.github.icodegarden.vines.client.pojo.transfer.UpdateDeviceOpenapiDTO;
import io.github.icodegarden.vines.client.pojo.view.openapi.AssetOpenapiVO;
import io.github.icodegarden.vines.client.pojo.view.openapi.AssetProfileOpenapiVO;
import io.github.icodegarden.vines.client.pojo.view.openapi.DeviceOpenapiVO;
import io.github.icodegarden.vines.client.pojo.view.openapi.DeviceProfileOpenapiVO;
import io.github.icodegarden.vines.client.pojo.view.openapi.RuleChainOpenapiVO;
import io.github.icodegarden.vines.client.pojo.view.openapi.TriggerRuleChainOpenapiVO;
import io.github.icodegarden.vines.client.security.BasicAuthentication;
import io.github.icodegarden.vines.data.openapi.AssetAdditionalInfo;
import io.github.icodegarden.vines.data.openapi.DeviceAdditionalInfo;

/**
 * 
 * @author Fangfang.Xu
 *
 */
class VinesClientTests {

	BasicAuthentication authentication = new BasicAuthentication("ota@qq.com", "123456");
	ClientProperties clientProperties = new ClientProperties("localhost:5454", authentication);
	VinesClient vinesClient = new VinesClient(clientProperties);

	@BeforeEach
	void init() {
	}

	@AfterEach
	void close() throws IOException {
	}

	@Test
	void getRuleChain() throws Exception {
		RuleChainQuery query = RuleChainQuery.builder().build();
		List<RuleChainOpenapiVO> list = vinesClient.pageRuleChains(query);

		Assertions.assertThat(list).isNotEmpty();

		RuleChainOpenapiVO one = vinesClient.getRuleChain(list.get(0).getId());

		System.out.println(one);

		Assertions.assertThat(one).isNotNull();
	}

	@Test
	void pageRuleChains() throws Exception {
		RuleChainQuery query = RuleChainQuery.builder().build();
		List<RuleChainOpenapiVO> list = vinesClient.pageRuleChains(query);

		System.out.println(list);

		Assertions.assertThat(list).isNotNull();
	}

	@Test
	void getAssetProfile() throws Exception {
		AssetProfileQuery query = AssetProfileQuery.builder().build();
		List<AssetProfileOpenapiVO> list = vinesClient.pageAssetProfiles(query);

		Assertions.assertThat(list).isNotEmpty();

		AssetProfileOpenapiVO one = vinesClient.getAssetProfile(list.get(0).getId());

		System.out.println(one);

		Assertions.assertThat(one).isNotNull();
	}

	@Test
	void pageAssetProfiles() throws Exception {
		AssetProfileQuery query = AssetProfileQuery.builder().build();
		List<AssetProfileOpenapiVO> list = vinesClient.pageAssetProfiles(query);

		System.out.println(list);

		Assertions.assertThat(list).isNotNull();
	}

	@Test
	void getAsset() throws Exception {
		AssetQuery query = AssetQuery.builder().build();
		List<AssetOpenapiVO> list = vinesClient.pageAssets(query);

		Assertions.assertThat(list).isNotEmpty();

		AssetOpenapiVO one = vinesClient.getAsset(list.get(0).getId());

		System.out.println(one);

		Assertions.assertThat(one).isNotNull();
	}

	@Test
	void pageAssets() throws Exception {
		AssetQuery query = AssetQuery.builder().build();
		List<AssetOpenapiVO> list = vinesClient.pageAssets(query);

		System.out.println(list);

		Assertions.assertThat(list).isNotNull();
	}

	@Test
	void createAsset() throws Exception {
		AssetOpenapiVO one = doCreateAsset();

		System.out.println(one);

		Assertions.assertThat(one).isNotNull();

		vinesClient.deleteAsset(one.getId());
	}

	private AssetOpenapiVO doCreateAsset() throws Exception {
		AssetProfileQuery query = AssetProfileQuery.builder().build();
		List<AssetProfileOpenapiVO> list = vinesClient.pageAssetProfiles(query);

		AssetAdditionalInfo additionalInfo = new AssetAdditionalInfo();
		additionalInfo.setDescription("描述");

		CreateAssetOpenapiDTO dto = CreateAssetOpenapiDTO.builder()//
				.name("资产-" + System.currentTimeMillis())//
				.assetProfileId(list.get(0).getId())//
				.additionalInfo(additionalInfo)//
				.label("label")//
				.build();

		return vinesClient.createAsset(dto);
	}

	@Test
	void updateAsset() throws Exception {
		AssetOpenapiVO one = doCreateAsset();

		UpdateAssetOpenapiDTO dto = UpdateAssetOpenapiDTO.builder()//
				.id(one.getId())//
				.name("资产" + System.currentTimeMillis())//
				.build();

		one = vinesClient.updateAsset(dto);

		System.out.println(one);

		Assertions.assertThat(one).isNotNull();
		Assertions.assertThat(one.getName()).isEqualTo(dto.getName());

		vinesClient.deleteAsset(one.getId());
	}

	@Test
	void getDeviceProfile() throws Exception {
		DeviceProfileQuery query = DeviceProfileQuery.builder().build();
		List<DeviceProfileOpenapiVO> list = vinesClient.pageDeviceProfiles(query);

		Assertions.assertThat(list).isNotEmpty();

		DeviceProfileOpenapiVO one = vinesClient.getDeviceProfile(list.get(0).getId());

		System.out.println(one);

		Assertions.assertThat(one).isNotNull();
	}

	@Test
	void pageDeviceProfiles() throws Exception {
		DeviceProfileQuery query = DeviceProfileQuery.builder().build();
		List<DeviceProfileOpenapiVO> list = vinesClient.pageDeviceProfiles(query);

		System.out.println(list);

		Assertions.assertThat(list).isNotNull();
	}

	@Test
	void getDevice() throws Exception {
		DeviceQuery query = DeviceQuery.builder().build();
		List<DeviceOpenapiVO> list = vinesClient.pageDevices(query);

		Assertions.assertThat(list).isNotEmpty();

		DeviceOpenapiVO one = vinesClient.getDevice(list.get(0).getId());

		System.out.println(one);

		Assertions.assertThat(one).isNotNull();
	}

	@Test
	void pageDevices() throws Exception {
		DeviceQuery query = DeviceQuery.builder().build();
		List<DeviceOpenapiVO> list = vinesClient.pageDevices(query);

		System.out.println(list);

		Assertions.assertThat(list).isNotNull();
	}

	@Test
	void createDevice() throws Exception {
		DeviceOpenapiVO one = doCreateDevice();

		System.out.println(one);

		Assertions.assertThat(one).isNotNull();

		vinesClient.deleteDevice(one.getId());
	}

	private DeviceOpenapiVO doCreateDevice() throws Exception {
		DeviceProfileQuery query = DeviceProfileQuery.builder().build();
		List<DeviceProfileOpenapiVO> list = vinesClient.pageDeviceProfiles(query);

		DeviceAdditionalInfo additionalInfo = new DeviceAdditionalInfo();
		additionalInfo.setDescription("描述");

		CreateDeviceOpenapiDTO dto = CreateDeviceOpenapiDTO.builder()//
				.name("设备-" + System.currentTimeMillis())//
				.deviceProfileId(list.get(0).getId())//
				.additionalInfo(additionalInfo)//
				.label("label")//
				.build();

		return vinesClient.createDevice(dto);
	}

	@Test
	void updateDevice() throws Exception {
		DeviceOpenapiVO one = doCreateDevice();

		UpdateDeviceOpenapiDTO dto = UpdateDeviceOpenapiDTO.builder()//
				.id(one.getId())//
				.name("设备" + System.currentTimeMillis())//
				.build();

		one = vinesClient.updateDevice(dto);

		System.out.println(one);

		Assertions.assertThat(one).isNotNull();
		Assertions.assertThat(one.getName()).isEqualTo(dto.getName());

		vinesClient.deleteDevice(one.getId());
	}

//	@Test
//	void deleteRuleChain() throws Exception {
//		RuleChainQuery query = RuleChainQuery.builder().build();
//		List<RuleChainOpenapiVO> list = vinesClient.pageRuleChains(query);
//
//		String id = list.stream().filter(one -> one.getName().equals("test-delete")).findFirst().get().getId();
//
//		vinesClient.deleteRuleChain(id);
//	}

	@Test
	void triggerRuleChain() throws Exception {
		String metaStr = """
				{
				     "deviceName": "Test Device",
				     "deviceType": "default",
				     "ts": "1693894387745"
				 }
				  """;

		String dataStr = """
					{
				      "temperature": 22.4,
				      "humidity": 78,
				      "nest": {
				          "userEmail": "Fangfang.Xu@geely.com"
				      },
				      "latitude": 0.01,
				      "longitude": 0.01
				  }
				""";

		TriggerRuleChainOpenapiDTO request = TriggerRuleChainOpenapiDTO.builder()//
				.entityId("d1b81c3e-d191-4aaf-868f-7970818742a2")//
				.entityType("DEVICE").metadata(JsonUtils.deserialize(metaStr, Map.class))//
				.data(JsonUtils.deserialize(dataStr, JsonNode.class))//
				.ruleTrace(true)//
				.build();

		TriggerRuleChainOpenapiVO vo = vinesClient.triggerRuleChain(request);

		System.out.println(vo);
	}
}
