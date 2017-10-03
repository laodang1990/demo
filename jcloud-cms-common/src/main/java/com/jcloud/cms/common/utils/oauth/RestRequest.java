package com.jcloud.cms.common.utils.oauth;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.*;

public class RestRequest
{
	private String uri = null;
	private boolean urlParameterEncode = true;
	private static final String SIGN = "open-sign";

	public String getUri()
	{
		return uri;
	}

	private String parseMap(Map bodyMap)
	{
		if (bodyMap.size() == 0) {
			return "";
		}
		Set<String> keySet = bodyMap.keySet();
		StringBuffer sb = new StringBuffer();
		for (String key : keySet) {
		if (bodyMap.get(key) == null || bodyMap.get(key).equals("")) {
                	sb.append(key).append("&");
		}
		else {
                	sb.append(key).append("=").append(bodyMap.get(key)).append("&");
            	}
        }
        return String.valueOf(sb.substring(0, sb.length() - 1));
    }

	private String request(String method, Map<String, Object> queryMap,
                           Map<String, Object> headerMap, Map<String, Object> bodyMap,
                           String jsonStr) throws Exception
	{
	        String resource = jsonStr;
	        if (null != queryMap) {
	            resource = parseMap(queryMap);
	            uri = uri + "?";
	        }
	        String urlStr=uri + resource;
            urlStr = urlStr.replace(" ", "%20");//%20代替url参数中的空格
            URL u = new URL(urlStr);
	        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
	        setHeader(conn, headerMap);
	        conn.setReadTimeout(30000);
	        conn.setRequestMethod(method);
	        if (method.equals("POST") || method.equals("PUT")) {
	            conn.setDoOutput(true);
	            OutputStream outStream = conn.getOutputStream();
	            String body = jsonStr;
	            if (null != bodyMap) {
	                body = parseMap(bodyMap);
	            }
	            outStream.write(body.getBytes());
	            outStream.flush();
	            outStream.close();
	        }
	        if (conn.getResponseCode() / 100 > 2) {
	            InputStream errStream = conn.getErrorStream();
	            String body = getResponseFromStream(errStream);
	            throw new Exception(conn.getResponseCode() + " "
	                    + conn.getResponseMessage() + " "
	                    + body);
	        }
	        InputStream inStream = conn.getInputStream();
	        String body = getResponseFromStream(inStream);
	        return body;
	}

	private void setHeader(HttpURLConnection conn, Map<String, Object>
            headerMap)
            throws Exception
	{
	        headerMap.put("Content-type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Time-Stamp",
	                String.valueOf(System.currentTimeMillis()));
	        if (headerMap != null) {
	            for (String key : headerMap.keySet()) {
	                conn.setRequestProperty(key,
	                        String.valueOf(headerMap.get(key)));
	            }
	        }
	}

	public String post(Map<String, Object> queryMap, Map<String, Object> headerMap,
                       Map<String, Object> bodyMap) throws Exception
	{
        	return request("POST", queryMap, headerMap, bodyMap, null);
	}

	public String post(Map<String, Object> queryMap, Map<String, Object> headerMap,
                       String jsonStr) throws Exception
	{
		return request("POST", queryMap, headerMap, null, jsonStr);
	}

	public String get(Map<String, Object> queryMap, Map<String, Object> headerMap,
                      Map<String, Object> bodyMap) throws Exception
	{
        	return request("GET", queryMap, headerMap, bodyMap, null);
	}

	public String get(Map<String, Object> queryMap, Map<String, Object> headerMap,
                      String jsonStr) throws Exception
	{
		return request("GET", queryMap, headerMap, null, jsonStr);
	}

//    public String put(String resource, Map<String, Object> headerMap,
//                      Map<String, Object> bodyMap) throws Exception {
//        return request("PUT", resource, headerMap, bodyMap, null);
//    }
//
//    public String PUT(String resource, Map<String, Object> headerMap,
//                      String jsonStr) throws Exception {
//        return request("PUT", resource, headerMap, null, jsonStr);
//    }
//
//    public String delete(String resource, Map<String, Object> headerMap,
//                         Map<String, Object> bodyMap) throws Exception {
//        return request("DELETE", resource, headerMap, bodyMap, null);
//    }
//
//    public String DELETE(String resource, Map<String, Object> headerMap,
//                         String jsonStr) throws Exception {
//        return request("DELETE", resource, headerMap, null, jsonStr);
//    }

	private String getResponseFromStream(InputStream inStream) throws
            Exception
	{
	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int length = 0;
	        while ((length = inStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, length);
	        }
        	return outStream.toString("UTF-8");
	}

	public String mapToQueryParameters(Map<String, Object> map)
            throws Exception
	{
	        StringBuffer sb = new StringBuffer();
	        for (String key : map.keySet()) {
	            if (sb.length() > 0) {
	                sb.append("&");
	            }
	            sb.append(key).append("=").append(String.valueOf(map.get(key)));
	        }
	        if (isUrlParameterEncode()) {
	            return URLEncoder.encode(sb.toString(), "utf-8");
	        }
			else {
	            return sb.toString();
	        }
	}

	public void setUri(String uri)
	{
        	this.uri = uri;
	}

    	public RestRequest(String url)
	{
		uri = url;
	}

	public boolean isUrlParameterEncode()
	{
        	return urlParameterEncode;
	}

	public void setUrlParameterEncode(boolean urlParameterEncode)
	{
        	this.urlParameterEncode = urlParameterEncode;
	}

	public String generateSign(Map headerMap, Map queryMap, Map bodyMap, String secret)
	{
	        Map paramMap = new HashMap();
	        if (headerMap != null) {
	            paramMap.putAll(headerMap);
	        }
	        if (queryMap != null) {
	            paramMap.putAll(queryMap);
	        }
	        if (bodyMap != null) {
	            paramMap.putAll(bodyMap);
	        }
	        Set<String> keySet = paramMap.keySet();
	        List<String> list = new ArrayList<String>(keySet.size());
	        for (String s : keySet) {
	            if (s.equals(SIGN)) {
	                continue;
	            }
	            list.add(s);
	        }
	        Collections.sort(list);
	        StringBuffer sb = new StringBuffer(secret);
	        for (String s : list) {
	            sb.append(s).append(paramMap.get(s));
	        }
	        sb.append(secret);
	//      return DigestUtils.md5Hex(sb.toString()).toUpperCase();
	        return MD5(sb.toString());
	}

	public String MD5(String s)
	{
    		char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    		try {
    			byte[] btInput = s.getBytes();
    			// 获得MD5摘要算法的 MessageDigest 对象
    			MessageDigest mdInst = MessageDigest.getInstance("MD5");
    			// 使用指定的字节更新摘要
    			mdInst.update(btInput);
    			// 获得密文
    			byte[] md = mdInst.digest();
    			// 把密文转换成十六进制的字符串形式
    			int j = md.length;
    			char[] str = new char[j * 2];
    			int k = 0;
    			for (int i = 0; i < j; i++) {
    				byte byte0 = md[i];
    				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
    				str[k++] = hexDigits[byte0 & 0xf];
    			}
    			return new String(str);
    		}
			catch (Exception e) {
    			e.printStackTrace();
    			return null;
    		}
    	}
}
