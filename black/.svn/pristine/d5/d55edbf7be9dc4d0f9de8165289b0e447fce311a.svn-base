package com.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtils {
	public static String sendHttptoServer(Map<String, Object> params, String URL) {
		StringBuffer sub = new StringBuffer();
		String params_str = null;
		if (params != null) {
			for (Entry<String, Object> entry : params.entrySet()) {
				sub.append(entry.getKey());
				sub.append("=");
				sub.append(entry.getValue());
				sub.append("&");
			}
			params_str = sub.substring(0, sub.length() - 1);
		}
		StringBuilder buffer = new StringBuilder();
		String gson = null;
		try {
			URL url = new URL(URL);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

			httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setConnectTimeout(30000); // 设置延迟为30秒
			httpURLConnection.setReadTimeout(30000);
			httpURLConnection.connect();
			OutputStreamWriter reqOut = null;
			if (params_str != null) {
				reqOut = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
				BufferedWriter out = new BufferedWriter(reqOut);
				out.write(params_str.toString());
				out.flush();
				out.close();
			}
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
			}
			// 接收服务器的返回：
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));

			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			gson = buffer.toString();
		} catch (Exception e) {
		}
		return gson;
	}
}
