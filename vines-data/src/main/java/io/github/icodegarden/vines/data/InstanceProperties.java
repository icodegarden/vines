package io.github.icodegarden.vines.data;

import java.util.Map;

import io.github.icodegarden.nutrient.lang.util.SystemUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Fangfang.Xu
 *
 */
//@ConfigurationProperties(prefix = AppConstants.APP_NAME)
@Setter
@Getter
@ToString
public class InstanceProperties {
	public static final String APP_NAME = "vines";

	private Rule rule = new Rule();
	private Security security = new Security();
	private Transport transport = new Transport();
	private Cache cache = new Cache();
	private Queue queue = new Queue();
	private Schedule schedule = new Schedule();

	@Setter
	@Getter
	@ToString
	public static class Rule {
		private String[] scanPackages = { "io.github.icodegarden.vines.rule.node" };
	}

	@Setter
	@Getter
	@ToString
	public static class Transport {
		/**
		 * 内部通讯绑定ip
		 */
		private String bindHost = SystemUtils.getIp();
		/**
		 * 内部通讯绑定端口
		 */
		private int bindPort = 5455;

		private long timeoutMillis = 3000;
	}

	@Setter
	@Getter
	@ToString
	public static class Cache {
		private RuleChain ruleChain = new RuleChain();
		private Script script = new Script();
		private Other other = new Other();

		private long removeDelayMillis = 1000;

		@Setter
		@Getter
		@ToString
		public static class RuleChain {
			/**
			 * 规则链缓存专用，规则链很多对象不适合序列化
			 */
			private long maxSize = 100 * 1000;// 假设每个占10k，共1G

			private int expireSeconds = 7 * 24 * 3600;
		}

		@Setter
		@Getter
		@ToString
		public static class Script {
			private long maxSize = 100 * 1000;// 假设每个占1k，共100M

			private int expireSeconds = Integer.MAX_VALUE;// 不过期
		}

		@Setter
		@Getter
		@ToString
		public static class Other {
			private long maxHeapMemoryKeySize = 100 * 1000;// 假设每个占1k，共100M

			private long maxDirectMemoryBytes = 500 * 1024 * 1024;// 500M

			private int expireSeconds = 7 * 24 * 3600;

			private long upgradeMinUsedTimes = 5;
		}
	}

	@Setter
	@Getter
	@ToString
	public static class Queue {
		private int corePoolSize = 50;
		private int maximumPoolSize = 200;
		private int keepAliveMs = 600 * 1000;
		private int queueSize = 1000;

		private int orderedQueueSize = 10000;
	}

	@Setter
	@Getter
	@ToString
	public static class Security {
		private FreeLogin freeLogin = new FreeLogin();
		private OAuth2 oAuth2 = new OAuth2();
//		private BasicAuth basicAuth = new BasicAuth();

		@Setter
		@Getter
		@ToString
		public static class FreeLogin {
			private String signKey = "vines_freelogin_signkey_0123456789";
		}

		@Setter
		@Getter
		@ToString
		public static class OAuth2 {
			private String loginProcessingUrl = "/login/oauth2/code/";
			private Map<String, String> githubMapper;
		}

//		@Setter
//		@Getter
//		@ToString
//		public static class BasicAuth {
//			private int maxUserCacheSeconds = 1800;
//		}
	}

	@Setter
	@Getter
	@ToString
	public static class Schedule {
		/**
		 * 每月15日02:00执行
		 */
		private String optStorageScheduleCron = "0 0 2 15 * ?";
		
		private int optStorageDeleteBeforeDays = 30;
	}
}