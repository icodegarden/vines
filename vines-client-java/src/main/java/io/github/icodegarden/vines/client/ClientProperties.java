package io.github.icodegarden.vines.client;

import io.github.icodegarden.vines.client.security.Authentication;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@Getter
@Setter
@ToString
public class ClientProperties {

	private String serverAddress;

	private Authentication authentication;

	private Exchange exchange = new Exchange();

	public ClientProperties(String serverAddress, Authentication authentication) {
		this.serverAddress = serverAddress;
		this.authentication = authentication;
	}

	public static class Exchange {
		private int connectTimeout = -1;
		private int readTimeout = -1;

		public int getConnectTimeout() {
			return connectTimeout;
		}

		public void setConnectTimeout(int connectTimeout) {
			this.connectTimeout = connectTimeout;
		}

		public int getReadTimeout() {
			return readTimeout;
		}

		public void setReadTimeout(int readTimeout) {
			this.readTimeout = readTimeout;
		}

		@Override
		public String toString() {
			return "Exchange [connectTimeout=" + connectTimeout + ", readTimeout=" + readTimeout + "]";
		}

	}
}