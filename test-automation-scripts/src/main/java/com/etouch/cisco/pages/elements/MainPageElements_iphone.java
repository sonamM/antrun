package com.etouch.cisco.pages.elements;

public interface MainPageElements_iphone{
	//login screen
	String UName_ID = "userInput";
	String UName_XPATH_ipad ="//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]"; //"//UIAApplication[1]/UIAWindow[1]//UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]";
	//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]
	String PWD_ID ="passwordInput";
	String PWD_XPATH_ipad = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]";
	String Login_BTN_ID ="login-button";
	String Login_BTN_XPATH_ipad = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[3]";
	//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[3]
	
	//New Calculation - ECU Screen
	String ServerCount_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]";
	String CPUCount_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[2]";
	String TotalECU_ID = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]/text[1]";
	String Input_Cost="//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]";
			//"//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]";
	
	String Back_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[1]/image[1]";
	
	//Purchase Tab
	String CostSolution_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]";	
	String AdditionalInfra_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[2]";
	String CAS_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[4]";
	String OSLicensing_XPATH=  "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[5]";
	String Depriciation_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[8]";
	String Power_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[10]";
	String ITMgmt_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[12]";
	String NetworkFee_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[14]";
	
	String ReportName_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]";
	String AI_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[3]";
	String CAPEX_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[7]";
	String CAPEXHR_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[9]";
	String POWER_XPATH =  "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[11]";
	String ITM_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[13]";
	String NF_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[15]";
	String OPEX_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[16]";
	String OPEXHR_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[17]";
	String TOTALECUHR_XPATH = "";

	//Lease tab
	String MonthlyCost_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]//UIAScrollView[1]/UIAWebView[1]/UIATextField[1]";
	String HWCOST_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[2]";
	String PowerLease_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[3]";
	String ITMLease_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[5]";
	String NFLease_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[7]";
	String OPEXECULease_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[9]";
	String Pwer_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[4]";
	String Mgmt_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[6]";
	String NWFee_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[8]";
	
	//Share Report
	String To_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[2]";
	String Subject_XPATH ="//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[3]";
	String Msg_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[4]";
	String SendReport_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[3]";
	String CancelReport_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]";
	
	//Feedback
	String Dashboard_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[1]/image[1]";
	
	String Rating_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/image[3]";
	String FeedbackMsg_XPATH = "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]";
	
	//Edit Report
	String SavedReportName_XPATH= "//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIAText[6]";
	
	String Edit_XPATH = ".//*[@id='EditBtn']";
	
}