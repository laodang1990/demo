/**
 *
 */
package com.jcloud.cms.common.model;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public enum ReturnCode {

    ACTIVE_EXCEPTION(-1, "异常"),
    ACTIVE_SUCCESS(0, "成功"),
    ACTIVE_FAILURE(1, "失败"),
    ERROR_PARAMS_NOT_NULL(2, "参数不能为空"),
    ERROR_PARAMS_SHORT(3, "缺少参数"),
    ERROR_NO_USER_INFO(4, "无法获取用户信息"),
    ERROR_UPDATE_USER(5,"更新用户失败"),
    ERROR_NO_PERMISSION(6, "无权限进行此操作"),
    ERROR_NO_LOGIN_INFO(7, "无法获取登录信息"),
    ERROR_PLATFORM_NOT_MATCH(8, "您不属于此园区，请确认网址是否正确"),
    ERROR_PARAMS_WRONG(9, "参数错误"),
    ERROR_PLATFORM_NOT_FOUND(10, "无法获取园区信息，请确认网址是否正确"),
    ERROR_USER_NO_CHECKED(11, "用户未审核"),
    ERROR_USER_NO_PERMISSION(12, "用户无权限"),
    ERROR_INTERCEPTOR_NO_COMPANY_INFO(20, "请填写企业信息"),
    ERROR_INTERCEPTOR_COMPANY_NOT_WORKING(21, "公司处于待审核或拒绝审核状态"),
    ERROR_INTERCEPTOR_NO_PERMISSION(22, "无权限进行此操作"),
    ERROR_INTERCEPTOR_NO_LOGIN_INFO(23,"无法获取登录信息"),
    ERROR_INTERCEPTOR_M_NO_LOGIN_INFO(30,"请先登录"),
    ERROR_INTERCEPTOR_M_NO_USER_INFO(31,"请先填写个人信息"),
    ERROR_INTERCEPTOR_M_NOT_WORKING(32, "您处于待审核或拒绝审核状态"),
    ERROR_UPLOAD_IMAGE_TOO_LARGE(40,"选择的图片超过了10M，请重新选择"), 
    ERROR_DATE_CHECK_START_EARLIER_THAN_NOW(50, "开始时间不得早于当前时间"),
    ERROR_DATE_CHECK_THIRTY_DAYS_LATER(51, "不可选择超过30天的日期"),
    ERROR_DATE_CHECK_START_LATER_THAN_END(52, "开始时间必须早于结束时间"),

    // park error code
    ERROR_PARK_GET_PARK_INFO(100,"获取园区信息失败"),
    ERROR_PARK_UPDATE_PARK(101,"更新园区信息失败"),
    ERROR_PARK_GET_COMPANY_LIST(102,"获取企业列表失败"),
    ERROR_PARK_GET_COMPANY_INFO(103,"获取企业信息失败"),
    ERROR_PARK_UPDATE_COMPANY(104,"更新企业失败"),
    ERROR_PARK_DELETE_COMPANY_WRONG_STATUS(105, "无法删除待审核或已入驻的企业"),
    ERROR_PARK_DELETE_COMPANY(106,"删除企业失败"),
    ERROR_PARK_GET_USER_LIST(107,"获取企业员工列表失败"),
    ERROR_PARK_GET_ADDRESS_LIST(108,"获取地址列表失败"),
    ERROR_PARK_MANSION_NAME_EMPTY(109,"大厦名不能为空"),
    ERROR_PARK_POSITION_FLOOR_EMPTY(110,"大厦楼层不能为空"),
    ERROR_PARK_POSITION_FLOOR_WRONG_FORMAT(111,"大厦楼层格式错误"),
    ERROR_PARK_UPDATE_USER_TYPE_NOT_WORKING(120,"只能设置在职状态的用户为园区管理员"),
    ERROR_PARK_UPDATE_USER_TYPE_NOT_SUPER_ADMIN(121,"只有园区超级管理员才允许此操作"),
    ERROR_PARK_UPDATE_USER_TYPE_UPDATE_SUPER_ADMIN(122,"不能更新超级管理员的用户类型"),
    ERROR_PARK_UPDATE_USER_TYPE_COMPANY_ID_NULL(123,"需要先在个人端加入所在企业"),
    ERROR_PARK_UPDATE_USER_TYPE_COMPANY_NOT_SAME(124,"只能设置同一企业的用户为园区管理员"),
    ERROR_PARK_GET_COMPANY_PERMISSION(130,"获取企业权限列表失败"),
    ERROR_PARK_UPDATE_COMPANY_PERMISSION(131,"更新企业权限失败"),

    ERROR_PARK_DOMAIN_URL_EMPTY(140,"域名不能为空"),
    ERROR_PARK_PARK_NAME_EMPTY(141,"园区名称不能为空"),
    ERROR_PARK_PARK_COMPANY_EMPTY(142,"园区企业名称不能为空"),
    ERROR_PARK_BUSINESS_ERP_EMPTY(143,"园区商务接口人不能为空"),
    ERROR_PARK_OPERATOR_ERP_EMPTY(144,"园区运营接口人不能为空"),
    ERROR_PARK_EXPIRE_DATE_EMPTY(145,"园区到期时间不能为空"),
    ERROR_PARK_MAIN_URL_EMPTY(146,"园区端首页调用链接不能为空"),
    ERROR_PARK_MAIN_URL_LENGTH(147,"园区端首页调用链接不能超过255字符"),

    // company error code
    ERROR_COMPANY_ADD_NO_NAME(200, "公司名称不能为空"),
    ERROR_COMPANY_ADD_NO_ADDRESS(201, "公司地址不能为空"),
    ERROR_COMPANY_ADD_NO_TELEPHONE(202, "公司电话不能为空"),
    ERROR_COMPANY_ADD_NO_LEGAL_PERSON(203, "公司法人为空"),
    ERROR_COMPANY_ADD_NO_LEGAL_PERSON_TELEPHONE(204, "公司法人电话为空"),
    ERROR_COMPANY_ADD_FAILURE(205, "新增公司失败"),
    ERROR_COMPANY_DELETE_USER_WRONG_STATUS(206, "无法删除待审核或在职的企业员工"),
    ERROR_COMPANY_DELETE_USER(207,"删除企业员工失败"),
    ERROR_COMPANY_INFO_NULL(208,"公司信息未提交"),
    ERROR_COMPANY_INFO_UNCHECKED(209,"公司信息待审核"),
    ERROR_COMPANY_UPDATE_USER_TYPE_NOT_WORKING(220,"只能设置在职状态的用户为企业管理员"),
    ERROR_COMPANY_UPDATE_USER_TYPE_NOT_SUPER_ADMIN(221,"只有企业超级管理员才允许此操作"),
    ERROR_COMPANY_UPDATE_USER_TYPE_UPDATE_SUPER_ADMIN(222,"不能更新企业超级管理员的用户类型"),
    ERROR_COMPANY_UPDATE_USER_TYPE_UPDATE_SELF(223,"不能更新自己的用户类型"),
    ERROR_COMPANY_UPDATE_USER_TYPE(224,"更新用户类型失败"),
    ERROR_COMPANY_UPDATE_USER_STATUS(230,"更新用户状态失败"),
    ERROR_COMPANY_UPDATE_USER_STATUS_UPDATE_SUPER_ADMIN(231,"不能更新企业超级管理员的用户状态"),
    ERROR_COMPANY_UPDATE_USER_STATUS_UPDATE_SELF(232,"不能更新自己的用户状态"),
    ERROR_COMPANY_MAIN_URL_EMPTY(233,"企业端首页调用链接不能为空"),
    ERROR_COMPANY_MAIN_URL_LENGTH(234,"企业端首页调用链接不能超过255字符"),

    // user error code
    ERROR_USER_SUBMIT_NO_COMPANY_ID(300, "企业不能为空"),
    ERROR_USER_SUBMIT_NO_NAME(301, "用户姓名不能为空"),
    ERROR_USER_SUBMIT_NO_TELEPHONE(302, "用户电话不能为空"),
    ERROR_USER_SUBMIT_FAILURE(303, "新增用户失败"),
    ERROR_USER_SUBMIT_WRONG_STATUS(304, "你已经处于在职状态"),
    ERROR_USER_UPDATE_USER(305, "更新信息失败"),
    ERROR_USER_GET_INFO(306, "查询个人信息失败"),
    ERROR_USER_GET_COMPANY_LIST(307, "获取公司列表失败"),
    ERROR_USER_MAIN_URL_EMPTY(308, "个人端首页调用链接不能为空"),
    ERROR_USER_MAIN_URL_LENGTH(309, "个人端首页调用链接不能超过255字符"),

    
    // activity error code
    ERROR_ACTIVITY_DELETE_ACTIVITY(407,"删除活动失败"),
    ERROR_ACTIVITY_NO_TYPE(408, "类型不能为空"),
    ERROR_ACTIVITY_NO_TITLE(409, "标题不能为空"),
    ERROR_ACTIVITY_NO_CONTENT(410, "活动内容不能为空"),
    ERROR_ACTIVITY_NO_PIC(411, "活动图片不能为空"),
    ERROR_ACTIVITY_NO_REMARK(412, "活动备注不能为空"),
    ERROR_ACTIVITY_NO_STARTTIME(413, "活动开始时间不能为空"),
    ERROR_ACTIVITY_NO_ENDTIME(414, "活动结束时间不能为空"),
    ERROR_ACTIVITY_STARTTIME_LARGGER(415, "活动开始时间必须小于活动结束时间"),
    ERROR_ACTIVITY_NO_USER(416, "请检查您是否已登陆,无法获取您的用户信息"),
    ERROR_ACTIVITY_NO_ACTIVITYID(417, "您没有选中活动,请重新选择"),
    ERROR_ACTIVITY_OUT_SIZE(418, "该活动报名人数已满,请选择其他活动"),
    ERROR_ACTIVITY_CLOSED(419, "该活动已经结束,或者被关闭,请选择其他活动"),
    ERROR_ACTIVITY_EXISTS_USERID(420, "您已成功报名，请勿重复报名"),
    ERROR_ACTIVITY_USER_CLOSED(421, "该活动已被关闭,请选择其他活动"),
    ERROR_ACTIVITY_OUT_DATE(422, "该活动已超出报名时间,请选择其他活动"),
    ERROR_ACTIVITY_NO_LIMIT(422, "您已经开启了报名,请填写报名限制人数"),
    ERROR_ACTIVITY_NO_APPLYENDDATE(423, "您已经开启了报名,请填写报名截止时间"),
    ERROR_ACTIVITY_APPLYTIMEBIG_ENDTIME(424, "报名结束时间应小于活动结束时间"),
    ERROR_ACTIVITY_CONTENT_OUTLENTH(425, "活动内容超出最大长度"),
    ERROR_ACTIVITY_APPLYTIMEBIG_STARTTIME(425, "报名结束时间应小于活动开始时间"),
    ERROR_ACTIVITY_SIGN_CHOOSEE(426, "请选择要删除的活动"),

    // visit error code
    ERROR_VISIT_ADD_VISIT_INFO(500, "添加访客信息失败"),
    ERROR_VISIT_ADD_VISIT_INFO_EMPTY_VISITOR_NAME(501, "访客姓名不能为空"),
    ERROR_VISIT_ADD_VISIT_INFO_EMPTY_VISITOR_PHONE(502, "访客电话不能为空"),
    ERROR_VISIT_ADD_VISIT_INFO_EMPTY_VISIT_START_TIME(503, "访问开始时间不能为空"),
    ERROR_VISIT_ADD_VISIT_INFO_EMPTY_VISIT_END_TIME(504, "访问结束时间不能为空"),
    ERROR_VISIT_ADD_VISIT_INFO_START_TIME_LATER_THAN_END_TIME(505, "到访时间不能晚于离开时间"),
    ERROR_VISIT_ADD_VISIT_INFO_COMPANY_STATUS_WRONG(506, "所在公司状态错误"),
    ERROR_VISIT_DELETE_VISIT_INFO(510, "删除访客信息失败"),
    ERROR_VISIT_GET_VISIT_INFO_FOR_USER(520, "查询个人访客信息失败"),
    ERROR_VISIT_GET_VISIT_INFO(521, "查询访客信息失败"),

    // 场馆error code
    ERROR_VENUE_NO_TIME(600, "预定时间时间不能为空"),
    ERROR_VENUE_TIME_WRONG(601, "开始时间不能大于结束时间"),
    ERROR_VENUE_STARTTIME_ISNULL(602, "开始时间不能为空"),
    ERROR_VENUE_ENDTIME_ISNULL(603, "结束时间不能为空"),
    ERROR_VENUE_NO_PHOTO(604, "请至少上传一张图片"),
    
    // indexView error code
    ERROR_INDEX_VIEW_LIST_NO_PLATFORMID(700, "无法获取平台id"),
    ERROR_INDEX_VIEW_LIST_ERROR(701, "查询操作失败，请重新尝试"),
    ERROR_INDEX_VIEW_ADD_SUCCESS(703, "新增模块成功"),
    ERROR_INDEX_VIEW_ADD_ERROR(704, "新增模块失败"),
    ERROR_INDEX_VIEW_DELETE_SUCCESS(705, "删除成功"),
    ERROR_INDEX_VIEW_DELETE_ERROR(706, "删除失败"),
    ERROR_INDEX_VIEW_SORT_NO_IDS(707, "无模块可排序，请先添加模块"),
    ERROR_INDEX_VIEW_SORT_SUCCESS(708, "操作成功"),
    ERROR_INDEX_VIEW_SORT_ERROR(709, "操作失败"),
    ERROR_INDEX_VIEW_EDIT_SUCCESS(710, "修改成功"),
    ERROR_INDEX_VIEW_EDIT_ERROR(711, "修改失败"),
    ERROR_INDEX_VIEW_NO_TEMPLATEANDMODULEID(712, "无法获取模板类型"),
    ERROR_WEB_INDEX_VIEW_BGPIC_BGCOLOR_BLANK(713, "背景图和背景颜色至少填写一个"),
    
    // advice 意见反馈
    ERROR_ADVICE_TYPE_NOTEXIST(800, "意见反馈类型不存在"),
    
    // ipaas对接
    ERROR_IPAAS_INVALID_USER(40001, "invalid user"),
    ERROR_IPAAS_INVALID_PARAM(40002, "invalid parameter"),
    ERROR_INFOMATION_NO_PIC(40003, "图片不能为空"),

    //hruser
    ERROR_HR_USER_NULL(50001, "无该员工信息"),
    ERROR_HR_USER_JSF_NET(50002, "调用hr_user接口异常"),
    ERROR_HR_USER_NO_PEMISSION(50003, "无该修改/添加员工信息权限"),
    ERROR_HR_USER_IS_EXITS(50004, "员工信息已添加"),
    ERROR_ADMIN_USER_IS_EXITS(50005, "该园区管理员已添加"),
    
    ERROR_APP_INFO_APPNAME_NULL(60001, "应用名称不能为空"),
    ERROR_APP_INFO_APPNAME_MAXLENGTH(60002, "应用名称不能超过6个汉字"),
    ERROR_APP_INFO_RETURNURL_NULL(60003, "调用链接不能为空！"),
    ERROR_APP_INFO_APPDESC_NULL(60004, "应用详情不能为空！"),
    ERROR_APP_INFO_APPDESC_MAXLENGTH(60005, "应用详情不能超过1000个字！"),
    ERROR_APP_INFO_SHOW_NULL(60005, " 展示端不能为空！"),
    ERROR_APP_INFO_ADD_EXCEPTION(60006, "参数异常！请检查应用名称是否已存在"),
	ERROR_APP_INFO_APP_TYPE(60007,"应用类型不正确"),
	ERROR_APP_INFO_APP_CENTER_URL_NULL(60008,"个人中心URL不能为空"),
	ERROR_APP_INFO_APP_CENTER_URL_MAX_LENGTH(60008,"个人中心URL不能超过255字符"),
    ERROR_APP_INFO_APPID_NULL(60009, "应用ID不能为空"),
    ERROR_APP_INFO_DEVELOPERID_NULL(60010, "开发者ID不能为空"),
    ERROR_APP_INFO_APPKEY_NULL(60011, "APPKEY不能为空"),
    ERROR_APP_INFO_APPSECRET_NULL(60012, "APPSECRET不能为空"),
    ERROR_APP_INFO_SIGN_WRONG(60013, "签名不正确"),
    ERROR_APP_INFO_APP_RUNNING(60014, "应用已被启用，请申请停用后再进行删除操作"),
    ERROR_APP_INFO_APP_STOP(60015, "应用未被启用，请申请启用后再进行上线操作"),
    ERROR_DEV_APP_INFO_APPNAME_MAXLENGTH(60016, "应用名称不能超过20个字符"),

    ERROR_APP_NAME_NULL(70001,"APP应用名称不能为空"),
    ERROR_APP_NAME_MAX_LENGTH(70002,"APP应用名称不能超过30个字"),
    ERROR_APP_DESCRIPTION_NULL(70003,"APP应用描述不能为空"),
    ERROR_APP_DESCRIPTION_MAX_LENGTH(70004,"APP应用描述不能超过200个字"),
    ERROR_APP_OSTYPE_NULL(70005,"APP应用平台类型不能为空"),
    ERROR_APP_ID_NULL(70006,"APP应用ID不能为空"),
    ERROR_APPVERSION_OSTYPE_NOT_VALID(70007,"APP应用版本操作类型无效"),
    ERROR_APPVERSION_ID_NULL(70008,"APP应用ID不能为空"),
    ERROR_APPVERSION_STATUS_NOT_VALID(70009,"APP应用版本状态无效"),
    ERROR_APPVERSION_VERSIONNAME_NULL(70010,"APP应用版本发布版本为空"),
    ERROR_APPVERSION_VERSIONCODE_NULL(70011,"APP应用版本版本编号为空"),
    ERROR_APPVERSION_ISFORCEUPGRADE_NOT_VALID(70012,"APP应用版本是否强制升级无效"),
    ERROR_APPVERSION_MINOSVERSION_NULL(70013,"APP应用版本最低操作系统为空"),
    ERROR_APPVERSION_PLATFORM_NULL(70014,"APP应用版本园区选择为空"),
    ERROR_APPVERSION_PLATFORM_NOT_VALID(70015,"APP应用版本园区选择无效"),
    ERROR_APPVERSION_UPGRADEPACKAGEURL_NULL(70016,"APP应用版本升级包地址为空"),
    ERROR_APPVERSION_UPGRADEPACKAGEURL_NOT_VALID(70017,"APP应用版本升级包地址无效"),
    ERROR_APPVERSION_OUTERDESCRIPTION_NULL(70018,"APP应用版本对外更新说明为空"),
    ERROR_APPVERSION_INNERDESCRIPTION_NULL(70019,"APP应用版本对内更新说明为空"),
    ERROR_APP_OSTYPE_IDENTIFIER_NOT_VALID(70020,"APP应用APP标识不能超过100个字"),
    ERROR_APP_NAME_IS_EXISTS(70021,"APP应用名称已经存在"),
    ERROR_APPVERSION_MINOSVERSION_NOT_VALID(70022,"APP应用版本最低操作系统长度不能超过10个字符"),
    ERROR_APP_HAVE_PUBLISH_VERSION(70023,"APP应用有已发布版本信息存在"),
    ERROR_APP_HAVE_PUBLISH_ANDROID_VERSION(70024,"APP应用有已发布android版本信息存在"),
    ERROR_APP_HAVE_PUBLISH_IOS_VERSION(70025,"APP应用有已发布ios版本信息存在"),
    ERROR_APP_HAVE_PUBLISH_WINDOWPHONE_VERSION(70026,"APP应用有已发布windowphone版本信息存在"),
    ;


    private static final Logger logger = Logger.getLogger(ReturnCode.class);

    private int code;
    private String msg;

    ReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ReturnCode codeToEnum(int code) {

        ReturnCode[] values = ReturnCode.values();
        for (ReturnCode returnCode : values) {
            if (returnCode.code == code) {
                return returnCode;
            }
        }
        return ACTIVE_EXCEPTION;
    }

    public int code() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String msg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, ?> Map() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", this.code);
        hashMap.put("msg", this.msg);
        logger.info(hashMap);
        return hashMap;
    }

    public Map<String, ?> Map(int code) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", code);
        hashMap.put("msg", this.msg);
        logger.info(hashMap);
        return hashMap;
    }

    public Map<String, ?> Map(Object msg) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", this.code);
        hashMap.put("msg", msg);
        logger.info(hashMap);
        return hashMap;
    }

    public Map<String, ?> Map(int code, Object msg) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", code);
        hashMap.put("msg", msg);
        logger.info(hashMap);
        return hashMap;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{\"code\":").append(this.code).append(",");
        sb.append("\"msg\":\"").append(this.msg).append("\"}");

        logger.info(sb.toString());
        return sb.toString();
    }

}
