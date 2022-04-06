package br.com.activecampaign3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;


public class ActiveCampaignConnection {

	private static final String	BASE_URL	= "https://codetec.api-us1.com/api/3/users";
	private static final String	TOKEN		= "41141d404d12fbef0b73ad81454db0824036b738b69dcfc41526d9d30cb0871b6a6a9e55";

	public static String get(String path) throws Exception {
		return get(path, null);
	}

	/*
	 * M�todo onde �  feito uma requisição  HTTP da url definida e seu conte�do 
	 * � lido pelo BufferedReader.
	 */
	public static String get(String path, Map<String, String> queryParams) throws Exception {

		HttpClient request = new HttpClient();
		Integer statusCode = null;
		String responseBody = null;

		String url = BASE_URL + path;
		
		if(queryParams == null) {
			queryParams = new HashMap<String, String>();
		}
//		queryParams.put("api-token", TOKEN);

		String initQuery = "?";
		String delim = "";
		for (Entry<String, String> query : queryParams.entrySet()) {
			url += initQuery + delim + query.getKey() + "=" + query.getValue();
			initQuery = "";
			delim = "&";
		}

		/* O m�todo GET significa recuperar qualquer informa��o (na forma de uma entidade) 
		 * � identificado pelo Request-URI. Se o Request-URI se referir a um processo de produ��o de dados, 
		 * s�o os dados produzidos que ser�o devolvidos como a entidade na resposta e n�o o texto-fonte do processo, 
		 * a menos que esse texto seja a sa�da do processo.
		 */
		GetMethod getMethod = new GetMethod(url);
//		getMethod.addRequestHeader("content-type", "application/json");
		getMethod.addRequestHeader("Api-Token", TOKEN);

		try {
			
			Thread.sleep(500);

			getMethod.addRequestHeader(new Header("Content-Encoding", "gzip"));
			statusCode = request.executeMethod(getMethod);
			
//			HttpClient.getParams().setParameter(HttpClientParams.COOKIE_POLICY, CookiePolicy.RFC_2109);


			StringBuffer out = new StringBuffer();
			if (!"204".equals(statusCode.toString())) {
				InputStream stream = getMethod.getResponseBodyAsStream();
				InputStreamReader reader = new InputStreamReader(stream, Charset.forName("UTF-8"));
				BufferedReader in = new BufferedReader(reader);
				String linha;
				while ((linha = in.readLine()) != null) {
					out.append(linha).append("\n");
				}
			}

			responseBody = out.toString();
			
			//System.out.println(responseBody);

		} catch (Exception e) {
			
//		return "N�o conectou!";
		e.printStackTrace();
			throw e;
		}

		return responseBody;
	}
	
/*
	public static void getStart(String url) {
		
*/
	
}


