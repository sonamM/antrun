package com.etouch.cisco.pages.elements;

public interface MainPageElements_iphoneEm{
	//login screen
	String UName_ID = "userInput";
	String UName_XPATH_ipad = "//window[1]/scrollview[1]/webview[1]/textfield[2]";
	
	String PWD_ID ="passwordInput";
	String PWD_XPATH_ipad = "//window[1]/scrollview[1]/webview[1]/secure[1]";
	
	String Login_BTN_ID ="login-button";
	String Login_BTN_XPATH_ipad = "//window[1]/scrollview[1]/webview[1]/button[3]";
	
	
	//New Calculation - ECU Screen
	String ServerCount_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[1]";
	
	String CPUCount_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[2]";
	
	String TotalECU_ID = "//window[1]/scrollview[1]/webview[1]/link[2]/text[1]";
	
	String Back_XPATH = "//window[1]/scrollview[1]/webview[1]/link[1]/image[1]";
	
	//Purchase Tab
	String CostSolution_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[1]";	
	String AdditionalInfra_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[2]";
	String CAS_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[4]";
	String OSLicensing_XPATH=  "//window[1]/scrollview[1]/webview[1]/textfield[5]";
	String Depriciation_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[8]";
	String Power_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[10]";
	String ITMgmt_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[12]";
	String NetworkFee_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[14]";
	
	String ReportName_XPATH = "";
	String AI_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[3]";
	String CAPEX_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[7]";
	String CAPEXHR_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[9]";
	String POWER_XPATH =  "//window[1]/scrollview[1]/webview[1]/textfield[11]";
	String ITM_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[13]";
	String NF_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[15]";
	String OPEX_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[16]";
	String OPEXHR_XPATH = "//window[1]/scrollview[1]/webview[1]/textfield[17]";
	String TOTALECUHR_XPATH = "";

	//Lease tab
	String MonthlyCost_XPATH = ".//*[@id='calculatePage2LeaseTablet']/table/tbody/tr[1]/td[2]/div/input";
	String HWCOST_XPATH = ".//*[@id='calculatePage2LeaseTablet']/table/tbody/tr[2]/td[2]/div/input";
	String PowerLease_XPATH = ".//*[@id='calculatePage2LeaseTablet']/table/tbody/tr[3]/td[3]/div/input";
	String ITMLease_XPATH = ".//*[@id='calculatePage2LeaseTablet']/table/tbody/tr[4]/td[3]/div/input";
	String NFLease_XPATH = ".//*[@id='calculatePage2LeaseTablet']/table/tbody/tr[5]/td[3]/div/input";
	String OPEXECULease_XPATH = ".//*[@id='calculatePage2LeaseTablet']/table/tbody/tr[6]/td[2]/div/input";
	String Pwer_XPATH = ".//*[@id='calculatePage2LeaseTablet']/table/tbody/tr[3]/td[2]/div/input";
	String Mgmt_XPATH = ".//*[@id='calculatePage2LeaseTablet']/table/tbody/tr[4]/td[2]/div/input";
	String NWFee_XPATH = ".//*[@id='calculatePage2LeaseTablet']/table/tbody/tr[5]/td[2]/div/input";
	
	//Share Report
	String To_ID = "toId";
	String Subject_ID ="subject";
	String Msg_ID = "message";
	
	//Feedback
	String Dashboard_XPATH = ".//*[@id='DashboardPage']/a[1]/img";
	String Dashboard_XPATH_ipad = "//window[1]/scrollview[1]/webview[1]/link[1]/image[1]";
	
	String Rating_XPATH = ".//*[@id='ratingStar3']";
	String FeedbackMsg_XPATH = ".//*[@id='feedbackText']";
	
	//Edit Report
	String SavedReportName_XPATH = ".//*[@id='reportsList']/li[2]/h3";
	String SavedReportName_XPATH_ipad = "//window[1]/scrollview[1]/webview[1]/text[6]";
	
	String Edit_XPATH = ".//*[@id='EditBtn']";
	
}