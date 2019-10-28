package neaos.marathon.client;

import cloudnil.marathon.client.utils.MarathonException;
import cloudnil.marathon.client.utils.ModelUtils;
import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Response;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

/**
 * <p>ClassName: MarathonClient</p>
 * <p>Description: Marathon REST接口的实例工具类</p>
 * @author 史绍虎
 * <p>Date: 2015-11-16 下午5:28:33</p>
 */
public class MarathonClient {
	static class MarathonHeadersInterceptor implements RequestInterceptor {
		@Override
		public void apply(RequestTemplate template) {
			template.header("Accept", "application/json");
			template.header("Content-Type", "application/json");
		}
	}
	
	static class MarathonErrorDecoder implements ErrorDecoder {
		@Override
		public Exception decode(String methodKey, Response response) {
			return new MarathonException(response.status(), response.reason());
		}
	}
	
	public static Marathon getInstance(String endpoint) {
		JacksonDecoder decoder = ModelUtils.decoder();
		JacksonEncoder encoder = ModelUtils.encoder();
		return Feign.builder().encoder(encoder).decoder(decoder).errorDecoder(new MarathonErrorDecoder())
				.requestInterceptor(new MarathonHeadersInterceptor()).target(Marathon.class, endpoint);
	}
	
	public static Marathon getInstance(String endpoint, String userName, String password) {
		JacksonDecoder decoder = ModelUtils.decoder();
		JacksonEncoder encoder = ModelUtils.encoder();
		return Feign.builder().encoder(encoder).decoder(decoder).errorDecoder(new MarathonErrorDecoder())
				.requestInterceptor(new MarathonHeadersInterceptor())
				.requestInterceptor(new BasicAuthRequestInterceptor(userName, password)).target(Marathon.class, endpoint);
	}
}
