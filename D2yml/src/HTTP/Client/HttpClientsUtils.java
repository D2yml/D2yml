//package HTTP.Client;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.GetMethod;
//import org.apache.commons.httpclient.params.HttpMethodParams;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.lang.StringUtils;
//
//
//import DyUtil.StringUtil;
//import net.sf.json.JSONObject;
//
///**
// * Created by Administrator on 2016/8/3 0003上午 9:53.
// */
//@SuppressWarnings({ "rawtypes", "unchecked" })
//public class HttpClientsUtils {
//
//	public static void main(String[] args) {
//		// String url =
//		// "http://platform.lieshimall.com:8082/balance/getBalanceById.action";
//		// param =
//		// "customerId=64&balanceType=ODkyMjFGODcxQzlGODQ1ODBBQkNGQ0UwQzQ1NTBDM0Q0MzdDNDFENEU2M0VBOThBODcyRTM4MkQyMDE1NTVGRQ==";
//		// System.out.println("result = " +
//		// AESUtils.decrypt(HttpRequestUtils.sendPost(url, param)));
//
//		// System.out.println(sendPost("http://192.168.1.193/impl/open/ListProductInfo.action",
//		// "pageSize=3"));
//		// System.out.println(sendPost(
//		// "http://192.168.1.188:808/Utiles/SendProductNotify", "result=111"));
//		String customFormateDate = StringUtil.customFormateDate("yyyy-MM-dd", new Date());
//		Map<String, String> map = new HashMap<>();
//		map.put("comtent_name", "wx_transaction");
//		map.put("param", "热心人提现通知#;#" + customFormateDate + "#;#体现#;#100#;#hhh");
//		map.put("users", "oY05lwT-eD8YEvo1Ie_bt0sDysMg");
//		map.put("sysuser", "nluser");
//		map.put("syspass", "nlpass");
//
//		String sendPost = sendPost("http://192.168.1.199:8090/SendNotify", mapToString(map));
//		System.out.println(sendPost);
//
//	}
//
//	/**
//	 * map转字符串
//	 * 
//	 * @author WXJ
//	 * @date 2017-8-31
//	 */
//	public static String mapToString(Map map) {
//		String result = "";
//		// 获取map，查看map是否为空
//		if (StringUtil.mapIsEmpty(map)) {
//			return "";
//		}
//		// 遍历
//		for (Object key : map.keySet()) {
//			result += key + "=" + map.get(key) + "&";
//		}
//
//		return result;
//	}
//
//	/**
//	 * 向指定 URL 发送POST方法的请求
//	 * 
//	 * @param url
//	 *            发送请求的 URL
//	 * @param param
//	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
//	 * @return 所代表远程资源的响应结果
//	 */
//	public static String sendPost(String url, String param) {
//		// System.out.println("HttpRequestUtils.sendPost=" + url + "?" + param);
//		List formparams = params2Map(param);
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		HttpPost post = new HttpPost(url);
//		String result = ""; // post结果
//		RequestConfig config = RequestConfig.custom()
//				.setConnectionRequestTimeout(1000) // 设置连接请求超时
//				.setConnectTimeout(1000) // 设置连接超时
//				.setSocketTimeout(5000) // 设置请求超时
//				.build();
//		CloseableHttpResponse response = null;
//		try {
//			post.setEntity(new UrlEncodedFormEntity(formparams, "UTF-8"));
//			post.setConfig(config);
//			response = httpClient.execute(post);
//			HttpEntity entity = response.getEntity();
//			result = EntityUtils.toString(entity);
//			EntityUtils.consume(entity);
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//		} finally {
//			closeResponse(response);
//		}
//		return result;
//	}
//
//	/**
//	 * 向指定 URL 发送 GET 方法的请求
//	 * 
//	 * @param url
//	 *            发送请求的 URL
//	 * @return 所代表远程资源的响应结果
//	 */
//	public static String sendGet(String url) {
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		HttpGet get = new HttpGet(url);
//		String result = ""; // post结果
//		RequestConfig config = RequestConfig.custom() // 自定义请求参数
//				.setConnectionRequestTimeout(10000) // 设置连接请求超时
//				.setConnectTimeout(10000) // 设置连接超时
//				.setSocketTimeout(10000) // 设置请求超时
//				.build();
//		CloseableHttpResponse response = null;
//		try {
//			get.setConfig(config);
//			response = httpClient.execute(get);
//			HttpEntity entity = response.getEntity();
//			result = EntityUtils.toString(entity);
//			EntityUtils.consume(entity);
//		} catch (ClientProtocolException e) {
//		} catch (IOException e) {
//		} finally {
//			closeResponse(response);
//		}
//		return result;
//	}
//
//	/**
//	 * &符号隔开的请求参数字符串，转Map
//	 * 
//	 * @param param
//	 * @return
//	 */
//	private static List params2Map(String param) {
//		List formparams = new ArrayList();
//		String[] paramAry = param.split("&");
//		for (int i = 0; i < paramAry.length; i++) {
//			String str = paramAry[i];
//			String key = str.substring(0, str.indexOf("="));
//			String value = str.substring(str.indexOf("=") + 1, str.length());
//			formparams.add(new BasicNameValuePair(key, value));
//		}
//		return formparams;
//	}
//
//	/**
//	 * 关闭 http响应实例
//	 * 
//	 * @param response
//	 */
//	public static void closeResponse(CloseableHttpResponse response) {
//		try {
//			if (response != null && !"".equals(response)) {
//				response.close();
//			}
//		} catch (IOException e) {
//		}
//	}
//
//	/**
//	 * 发送文件
//	 *
//	 * @author WXJ
//	 * @date 2018年4月9日
//	 */
//	public static String sendFile(String url, String param, String file) {
//		// System.out.println("HttpRequestUtils.sendPost=" + url + "?" + param);
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		HttpPost post = new HttpPost(url);
//		String result = ""; // post结果
//		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000) // 设置连接请求超时
//				.setConnectTimeout(10000) // 设置连接超时
//				.setSocketTimeout(10000) // 设置请求超时
//				.build();
//		CloseableHttpResponse response = null;
//		try {
//			FileBody imageFile = new FileBody(new File(file));
//			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//			for (String para : param.split("&")) {
//				String[] par = para.split("=");
//				StringBody parameter = new StringBody(par[1], ContentType.MULTIPART_FORM_DATA);
//				builder.addPart(par[0], parameter);
//			}
//			builder.addPart("file", imageFile);
//			HttpEntity entity = builder.build();
//			post.setEntity(entity);
//			post.setConfig(config);
//			response = httpClient.execute(post);
//			HttpEntity entity1 = response.getEntity();
//			result = EntityUtils.toString(entity1);
//			EntityUtils.consume(entity1);
//		} catch (ClientProtocolException e) {
//		} catch (IOException e) {
//		} finally {
//			closeResponse(response);
//		}
//		return result;
//	}
//
//	/**
//	 * 发送流
//	 * 
//	 * @author WXJ
//	 * @date 2017-9-5
//	 */
//	public void inputStreamUpload(String url, InputStream inputStream) {
//		// 创建HttpClient对象
//		CloseableHttpClient client = HttpClients.createDefault();
//		// 构建POST请求 请求地址请更换为自己的。
//		// 1)
//		HttpPost post = new HttpPost(url);
//		try {
//			// 文件路径请换成自己的
//			// 2)
//			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//			// 第一个参数为 相当于 Form表单提交的file框的name值 第二个参数就是我们要发送的InputStream对象了
//			// 第三个参数是文件名
//			// 3)
//			builder.addBinaryBody("uploadFile", inputStream, ContentType.create("multipart/form-data"), "text01.txt");
//			// 4)构建请求参数 普通表单项
//			StringBody stringBody = new StringBody("12", ContentType.MULTIPART_FORM_DATA);
//			builder.addPart("id", stringBody);
//			HttpEntity entity = builder.build();
//			post.setEntity(entity);
//			// 发送请求
//			HttpResponse response = client.execute(post);
//			entity = response.getEntity();
//			if (entity != null) {
//				inputStream = entity.getContent();
//				// 转换为字节输入流
//				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, Consts.UTF_8));
//				String body = null;
//				while ((body = br.readLine()) != null) {
//					System.out.println(body);
//				}
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (inputStream != null) {
//				try {
//					inputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//	public static String sendPostPay(String url, String param) {
//		// System.out.println("HttpRequestUtils.sendPost=" + url + "?" + param);
//		List formparams = params2Map(param);
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		HttpPost post = new HttpPost(url);
//		String result = ""; // post结果
//		RequestConfig config = RequestConfig.custom().build();
//		CloseableHttpResponse response = null;
//		try {
//			post.setEntity(new UrlEncodedFormEntity(formparams, "UTF-8"));
//			post.setConfig(config);
//			response = httpClient.execute(post);
//			HttpEntity entity = response.getEntity();
//			result = EntityUtils.toString(entity);
//			EntityUtils.consume(entity);
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//		} finally {
//			closeResponse(response);
//		}
//		return result;
//	}
//
//	/**
//	 * HttpPost请求
//	 * 
//	 * @author WXJ
//	 * @date 2017-5-2
//	 */
//	public static JSONObject post(String url, Map<String, String> parasMap) {
//		if (StringUtil.isEmpty(url)) {
//			throw new NullPointerException("请求路径为空");
//		}
//		// 返回结果对象
//		JSONObject ret = null;
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		HttpPost httppost = new HttpPost(url);
//
//		// 参数封装对象
//		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
//		if (parasMap != null && parasMap.size() > 0) {
//			for (Entry<String, String> entry : parasMap.entrySet()) {
//				formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
//			}
//		}
//		UrlEncodedFormEntity uefEntity = null;
//		try {
//			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
//			httppost.setEntity(uefEntity);
//
//			// 执行post请求
//			CloseableHttpResponse response = httpclient.execute(httppost);
//			try {
//				// 获取响应内容
//				HttpEntity entity = response.getEntity();
//				if (entity != null) {
//					ret = JSONObject.fromObject(EntityUtils.toString(entity, "UTF-8"));
//				}
//			} finally {
//				response.close();
//			}
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			// 关闭连接,释放资源
//			try {
//				httpclient.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return ret;
//	}
//
//	/**
//	 * HttpPost请求
//	 * 
//	 * @author WXJ
//	 * @date 2017-5-2
//	 */
//	public static JSONObject post(String url, String param) {
//		if (StringUtil.isEmpty(url)) {
//			throw new NullPointerException("请求路径为空");
//		}
//		// 返回结果对象
//		JSONObject ret = null;
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		HttpPost httppost = new HttpPost(url);
//
//		// 参数封装对象
//		List formparams = params2Map(param);
//		UrlEncodedFormEntity uefEntity = null;
//		try {
//			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
//			httppost.setEntity(uefEntity);
//
//			// 执行post请求
//			CloseableHttpResponse response = httpclient.execute(httppost);
//			try {
//				// 获取响应内容
//				HttpEntity entity = response.getEntity();
//				if (entity != null) {
//					ret = JSONObject.fromObject(EntityUtils.toString(entity, "UTF-8"));
//				}
//			} finally {
//				response.close();
//			}
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			// 关闭连接,释放资源
//			try {
//				httpclient.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return ret;
//	}
//
//	/**
//	 *
//	 * @author WXJ
//	 * @date 2018年11月12日
//	 */
//	public static byte[] sendGet(String url, Map<String, String> headerMap, String proxyUrl, int proxyPort) {
//		byte[] content = null;
//		HttpClient httpClient = new HttpClient();
//
//		if (headerMap != null) {
//
//			// 头部请求信息
//			if (headerMap != null) {
//
//				Iterator iterator = headerMap.entrySet().iterator();
//				while (iterator.hasNext()) {
//
//					Entry entry = (Entry) iterator.next();
//					// getMethod.addRequestHeader(entry.getKey().toString() ,
//					// entry.getValue().toString());
//					url = url + ((url.indexOf("?") > -1) ? "&" : "?") + entry.getKey().toString() + "="
//							+ entry.getValue().toString();
//				}
//			}
//		}
//		GetMethod getMethod = new GetMethod(url);
//
//		if (StringUtils.isNotBlank(proxyUrl)) {
//
//			httpClient.getHostConfiguration().setProxy(proxyUrl, proxyPort);
//		}
//
//		// 设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
//		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 10000);
//		// postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER ,
//		// new DefaultHttpMethodRetryHandler());
//		InputStream inputStream = null;
//		try {
//
//			if (httpClient.executeMethod(getMethod) == HttpStatus.SC_OK) {
//
//				// 读取内容
//				inputStream = getMethod.getResponseBodyAsStream();
//				content = IOUtils.toByteArray(inputStream);
//			} else {
//
//				System.err.println("Method failed: " + getMethod.getStatusLine());
//			}
//		} catch (IOException ex) {
//
//			ex.printStackTrace();
//		} finally {
//
//			IOUtils.closeQuietly(inputStream);
//			getMethod.releaseConnection();
//		}
//		return content;
//	}
//
//}