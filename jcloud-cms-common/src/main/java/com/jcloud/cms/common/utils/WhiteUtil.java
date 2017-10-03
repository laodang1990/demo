package com.jcloud.cms.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: swh
 * Date: 15-12-23
 * Time: 下午4:21
 */
public class WhiteUtil {
	private static final Logger log = LoggerFactory.getLogger(WhiteUtil.class);
	/**
	 * 验证用户是否在内网，在内网是否在白名单中
	 * @param requestURL
	 * @return true：访问合法；false ：访问非法
	 * @throws UnknownHostException
	 */
	public static boolean validateAccessLegal(String requestURL,String whitelist) throws UnknownHostException {
		String host = DomainUtil.getHost(requestURL);
		Validate.notNull(host);
		if(host.contains(":")) {
			host = host.split(":")[0];
		}
		log.info("the host is =={}",host);
		String ip = DomainUtil.getIPByDomain(host);
		log.info("the ip is =={}",ip);
		if(DomainUtil.isInner(ip)){
			//内网ip，判断是否在白名单中
			String[] split = whitelist.split(",");
			List<String> whiteArrayList = Arrays.asList(split);
			log.info("all the white list ip is {}", JSONObject.toJSONString(whiteArrayList));
			return whiteArrayList.contains(ip) ? true : (whiteArrayList.contains(host) ? true : false);
		}
		log.info("the ip  =={} is out",ip);
		return false;
	}

}
