package com.example.webapp.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import spark.Request;
import spark.Spark;



/**
 * The Class BaseController.
 */
public class BaseController extends Spark {




	/**
	 * Gets the integer param.
	 *
	 * @param request the request
	 * @param param the param
	 * @return the integer param
	 */
	protected static int getIntegerParam( Request request, String param ) {
		String idstring = request.params(param);

		int id = 0;
		try {
			id = Integer.parseInt(idstring);
		} catch (NumberFormatException nfe) {
			Spark.halt(401, "Need to pass valid parameter for " + param);
		}
		return id;
	}



	/**
	 * Gets the string param.
	 *
	 * @param request the request
	 * @param param the param
	 * @return the string param
	 */
	protected static String getStringParam( Request request, String param ) {
		String id = request.params(param);

		return id;
	}



	/**
	 * Gets the post params.
	 *
	 * @param request the request
	 * @param param   the param
	 * @return the post params
	 */
	protected static Map<String, String> getPostParams( Request request ) {
		String body = request.body();

		Map<String, String> params = null;

		if (body != null && !(body.isEmpty())) {
			List<NameValuePair> pairs = URLEncodedUtils.parse(body, Charset.defaultCharset());
			params = toMap(pairs);
		}

		return params;
	}



	/**
	 * To map.
	 *
	 * @param pairs the pairs
	 * @return the map
	 */
	private static Map<String, String> toMap( List<NameValuePair> pairs ) {
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < pairs.size(); i++) {
			NameValuePair pair = pairs.get(i);
			map.put(pair.getName(), pair.getValue());
		}
		return map;
	}

}
