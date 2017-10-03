package com.jcloud.cms.common.model;

public final class GlobalSessionField{
	
	public static final Integer PAGE_SIZE = 10;
	
	public static String SESSION = "userSession";

	public static String SESSION_ID = "JSESSIONID";
	
	public static int SESSION_TIMEOUT = 3600;

    public static String O2O_PC_PIN_COOKIE = "pin";
	public static String O2O_M_PIN_COOKIE = "pt_pin";
	public static String O2O_M_KEY_COOKIE = "pt_key";

	public static long O2O_PLATFORM_ID = 1;

    /**
     * jss Bucket name
     */
    public static String JSS_STORAGEFILES = "yq.jd.com/fengchuang";
    public static String JSS_HOSTNAME = "storage.jd.com";

    public static String PASSPORT_HOSTNAME = "http://passport.jd.com/common/loginPage?from=jcloud&";

    public static String DOMAIN_BASE_URL = "yq.jd.com/";
    public static String DOMAIN_PRE_URL = "t-yq.jd.com/";

    /**
     * 授权相关
     */

    public static String appkey1 = "B127F6721748077C745C6F336E896294";//test
    public static String appsecret1 = "78261f98f27511e5bede0050568742c1";
    public static String appkey2 = "76A1F1225E1C660D08F55A2A0779A6E9";//gmv
    public static String appsecret2 = "db2b24f6f27211e5bede0050568742c1";
    public static String appkey3 = "8D8048C27FC728CD8A4449218C22DBA3";//isv online
    public static String appsecret3 = "cd01bb6bf6ee11e5a393598bacbba715";
    public static String oauthUrl = "http://apioauth.jd.com/";
    public static String oauthInUrl = "http://oauth-in.jcloud.com/";// 授权内网域名
    public static String codeUrl =  oauthUrl + "getAuthCode";
    public static String tokenUrl = oauthInUrl + "ipaasAuth/authorization";// code走redirect,而token走服务间则需要内网域名
    public static String refreshUrl = oauthInUrl + "ipaasAuth/refreshToken";
    public static String redirectUrl = "http://yq.jd.com/oauth/init";

}
