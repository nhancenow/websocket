/* Copyright © EasOfTech 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of EasOfTech. You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms and
* conditions entered into with EasOfTech.
*
* Id: NhanceConstant.java
*
* Date Author Changes
* 15 Jun, 2016 Saroj Created
*/
package com.nhance.websocket.WebSocketApp.constants;

/**
 * The Class NhanceConstants.
 */
public class NhanceConstants {
	
	/** The gcm serverkey merchant app. */
	public static String GCM_SERVERKEY_MERCHANT_APP = "AIzaSyBNNLLuiN_rS4hMl1czisfrxyA8XajiNek";
	
	/** The gcm serverkey customer app. */
	public static String GCM_SERVERKEY_CUSTOMER_APP = "AIzaSyCkiSm88tbYt0cKYZlD9AfyLVctOIjjIIM";
	
    /** The Constant FCM_SERVER_API_KEY. */
    public static final String FCM_SERVER_API_KEY    = "AAAAeZr-71E:APA91bFEaBAkR_ip9BLCRObXKcwOijrOgWSxcOS6_f6nJNrXp_TEXee7kQ9cA5glVNCwwh8c5qirRfkLCfsbKEklKoms3Vva1OMZiEcv1LEtpDKDrlh2ezpEWrZBtFwLczM-r37tGl8t";
	
	/** The notification service bean. */
	public static String NOTIFICATION_SERVICE_BEAN = "notificationService/process";
	
	/** The notification job group. */
	public static String NOTIFICATION_JOB_GROUP = "notification";
	
	/** The Constant ROLE_SUPER_USER. */
	public static final String ROLE_SUPER_USER = "SuperUser";
	
	/** The Constant ROLE_MERCHANT_ADMIN. */
	public static final String ROLE_MERCHANT_ADMIN = "Admin";
	
	/** The Constant ROLE_OUTLET_USER. */
	public static final String ROLE_OUTLET_USER = "OutletUser";
	
	/** The Constant ROLE_SUPPORT_MANAGER. */
	public static final String ROLE_SUPPORT_MANAGER = "SupportManager";
	
	/** The Constant ROLE_SUPPORT_USER. */
	public static final String ROLE_SUPPORT_USER = "SupportUser";
	
	/** The Constant DEFAULT_HELPDESK_EMAIL. */
	public static final String DEFAULT_HELPDESK_EMAIL = "support@nhancenow.com";
	
	/** The Constant DEFAULT_HELPDESK_PHONE. */
	public static final String DEFAULT_HELPDESK_PHONE = "08032529010";
	
	/** The sha algorithm key. */
	String SHA_ALGORITHM_KEY = "SHA-512";

	/** The Constant SHA1PRNG. */
	public static final String SHA1PRNG = "SHA1PRNG";

	/** The Constant ACCOUNT_ENABLE_YES. */
	public static final String ACCOUNT_ENABLE_YES = "Y";
	
	/** The Constant ACCOUNT_ENABLE_NO. */
	public static final String ACCOUNT_ENABLE_NO = "N";

	/** The Constant CREDENTIAL_EXPIRED. */
	public static final String CREDENTIAL_EXPIRED = "N";

	/** The Constant LOGIN_ATTEMPT. */
	public static final int LOGIN_ATTEMPT = 3;

	/** The Constant SECURITY_CODE_FORMAT. */
	public static final String SECURITY_CODE_FORMAT = "[A-Za-z0-9]{4,50}";

	/** The Constant ROWS_PER_PAGE. */
	public static final Integer RESULTS_PER_PAGE = 10;

	/** The Constant USER_NAME. */
	public static final String USER_CODE = "user_code";
	
	/** The Constant LOGIN_USER. */
	public static final String LOGIN_USER = "login_user";
	
	/** The Constant SUPER_USER. */
	public static final String SUPER_USER = "SuperUser";
	
	/** The padding char zero. */
	public static char PADDING_CHAR_ZERO = '0';

	/** The password expiry tenure. */
	public static final int PASSWORD_EXPIRY_TENURE = 90;
	
	/** The PI n_ has h_ algorithm. */
	public static final String PIN_HASH_ALGORITHM = "SHA-1";
	
	/** The otp expiry tenure. */
	public static final int OTP_EXPIRY_TENURE = 1;
	
	/** The Constant REPORT_TYPE_PDF. */
	public static final Integer REPORT_TYPE_PDF = 0;
	
	/** The Constant REPORT_TYPE_EXCEL. */
	public static final Integer REPORT_TYPE_EXCEL = 1;
	
	/** The Constant DEFAULT_DATE. */
	public static final String DEFAULT_DATE = "1971-01-01 00:00:00";
	
	/** The MO b_ res p_ statu s_ success. */
	public static final Integer RESP_STATUS_SUCCESS = 0 ;
	
	/** The MO b_ res p_ statu s_ failure. */
	public static final Integer RESP_STATUS_FAILURE = 1 ;
	
	/** The Constant EXT_ZIP. */
	public static final String EXT_ZIP = ".zip";
	
	/** The status sent. */
	public static final Integer STATUS_SENT = 1;
	
	/** The status failed. */
	public static final Integer STATUS_FAILED = 2;
	
	/** The status expiried. */
	public static final Integer STATUS_EXPIRIED = 3;
	
	/** The OT p_ typ e_ we b_ user. */
	public static final Integer OTP_TYPE_WEB_USER = 1;
	
	/** The OT p_ typ e_ customer. */
	public static final Integer OTP_TYPE_CUSTOMER = 2;

	/** The product info. */
	public static final String PRODUCT_INFO = "CREDIT";

	/** The inr. */
	public static final Long INR = 1L;	
	
	/** The Constant HTTP_SUCCESS. */
	public static final int HTTP_SUCCESS = 200;	
	
	/** The Constant CURRENCY_CODE_INDIA. */
	public static final String CURRENCY_CODE_INDIA = "INR";
	
	/** The Constant SYSTEM. */
	public static final String SYSTEM = "SYSTEM";
	
	/** The Constant RULE_WARRANTYTYPE_UNDERWARRANTY. */
	public static final Integer RULE_WARRANTYTYPE_UNDERWARRANTY = 1;
	
	/** The Constant RULE_WARRANTYTYPE_OUTOFWARRANTY. */
	public static final Integer RULE_WARRANTYTYPE_OUTOFWARRANTY = 2;
	
	/** The Constant PRODUCT_TYPE_OTHERS. */
	public static final String PRODUCT_TYPE_OTHERS = "Others";
	
	/** The Constant EXTENSION_PDF. */
	public static final String EXTENSION_PDF = "pdf";
	
	/** The action code issue digital kit. */
	public static String ACTION_CODE_ISSUE_DIGITAL_KIT		= "18000001";
	
	/** The action code service request. */
	public static String ACTION_CODE_SERVICE_REQUEST		= "18000002";
	
	/** The action code video call. */
	public static String ACTION_CODE_VIDEO_CALL				= "18000003";
	
	/** The action code modify dk. */
	public static String ACTION_CODE_MODIFY_DK				= "18000005";
	
	/** The action code de register device. */
	public static String ACTION_CODE_DE_REGISTER_DEVICE		= "18000006";
	
	/** The action code terminate video call. */
	public static String ACTION_CODE_TERMINATE_VIDEO_CALL	= "18000007";
	
	/** The action code navigate dashboard. */
	public static String ACTION_CODE_NAVIGATE_DASHBOARD		= "16000002";
	
	/** The action code offers. */
	public static String ACTION_CODE_OFFERS					= "18000008";
	
	/** The Constant FRESHDESK_API_END_POINT. */
	public static final String FRESHDESK_API_END_POINT = "freshdesk_apiEndpoint";
	
	/** The Constant FRESHDESK_API_KEY. */
	public static final String FRESHDESK_API_KEY = "freshdesk_apiKey";
	
	/** The Constant FRESHDESK_LOGIN_URL_SSO. */
	public static final String FRESHDESK_LOGIN_URL_SSO = "freshdesk_loginUrlSSO";
	
	/** The Constant FRESHDESK_SHARED_SECRET_SSO. */
	public static final String FRESHDESK_SHARED_SECRET_SSO = "freshdesk_sharedSecretSSO";
	
	/** The Constant IS_FILE_UPLOAD_YES. */
	public static final Integer IS_FILE_UPLOAD_YES = 1;
	
	/** The Constant IS_FILE_UPLOAD_NO. */
	public static final Integer IS_FILE_UPLOAD_NO = 2;
	
	/** The Constant PORTABLE_PRODUCT. */
	public static final Integer PORTABLE_PRODUCT = 1;
	
	/** The Constant NON_PORTABLE_PRODUCT. */
	public static final Integer NON_PORTABLE_PRODUCT = 2;
	
	/** The Constant COMMA_DELIMITER. */
	public static final String COMMA_DELIMITER = ",";
	
	/** The Constant IS_UNDER_WARRANTY_YES. */
	public static final Integer IS_UNDER_WARRANTY_YES = 1;
	
	/** The Constant IS_UNDER_WARRANTY_NO. */
	public static final Integer IS_UNDER_WARRANTY_NO = 2;
	
	/** The Constant FILTER_KEY_ANDROID. */
	public static final String FILTER_KEY_ANDROID = "Android";
	
	/** The Constant FILTER_KEY_IOS. */
	public static final String FILTER_KEY_IOS = "Mac";
	
	/** The Constant UPDATED_PRODUCT. */
	public static final Integer UPDATED_PRODUCT = 1;

	/** The Constant UPDATED_DK. */
	public static final Integer UPDATED_DK = 2;
	
	/** The Constant DELETE_DK. */
	public static final Integer DELETE_DK = 3;

	/** The Constant SENDGRID_KEY_NAME. */
	public static final String SENDGRID_KEY_NAME = "-name-";

	/** The Constant SENDGRID_KEY_VERIFICATION_LINK. */
	public static final String SENDGRID_KEY_VERIFICATION_LINK = "-verification-link-";

	/** The Constant SENDGRID_KEY_OTP. */
	public static final String SENDGRID_KEY_OTP = "-otp-";

	/** The Constant SENDGRID_KEY_PRODUCT. */
	public static final String SENDGRID_KEY_PRODUCT = "-product-";

	/** The Constant SENDGRID_KEY_MOBILE_NUMBER. */
	public static final String SENDGRID_KEY_MOBILE_NUMBER = "-mobile_number-";

	/** The Constant SENDGRID_KEY_PLAYSTORE. */
	public static final String SENDGRID_KEY_PLAYSTORE = "-playstore-";

	/** The Constant SENDGRID_KEY_IOS_STORE. */
	public static final String SENDGRID_KEY_IOS_STORE = "-iosstore-";
	
	/** The Constant PLAYSTORE_LINK. */
	public static final String PLAYSTORE_LINK = "https://play.google.com/store/apps/details?id=com.nhance.b2c&hl=en";
	
	/** The Constant IOS_STORE_LINK. */
	public static final String IOS_STORE_LINK = "https://itunes.apple.com/us/app/nhance/id1173807263";
	
	/** The Constant TEST_DRIVE_ELIGIBLE_PRODUCT. */
	public static final Integer TEST_DRIVE_ELIGIBLE_PRODUCT = 1;
	
	/** The Constant TEST_DRIVE_NOT_ELIGIBLE_PRODUCT. */
	public static final Integer TEST_DRIVE_NOT_ELIGIBLE_PRODUCT = 2;
	
	/** The Constant MAX_BULK_SIZE. */
	public static final int MAX_BULK_SIZE = 1000; 
	
	/** The Constant ATTRIBUTE_SCOPE_MUST. */
	public static final String ATTRIBUTE_SCOPE_MUST = "must";
	
	/** The Constant ATTRIBUTE_SCOPE_SHOULD. */
	public static final String ATTRIBUTE_SCOPE_SHOULD = "should";
	
}
