package com.etouch.cisco.pages.elements;

public interface MainPageElements{
	//login screen
	String UName_ID = "userInput";
	String PWD_ID ="passwordInput";
	String Login_BTN_ID ="login-button";
	
	//New Calculation - ECU Screen
	String ServerCount_XPATH = ".//*[@id='totalServers']";
	String CPUCount_XPATH = ".//*[@id='calculatePage1Setup']/table/tbody/tr/td[1]/div/input";
	String TotalECU_ID = "calculatePage1Review";
	String Back_XPATH = ".//*[@id='CalculatePage1']/a/img";
	
	//Purchase Tab
	String CostSolution_XPATH = ".//*[@id='calculatePage2PurchaseCAPEXTablet']/table/tbody/tr[1]/td[2]/div/input";
	String AdditionalInfra_XPATH = ".//*[@id='calculatePage2PurchaseCAPEXTablet']/table/tbody/tr[2]/td[2]/div/input";
	String CAS_XPATH = ".//*[@id='calculatePage2PurchaseCAPEXTablet']/table/tbody/tr[3]/td[2]/div/input";
	String OSLicensing_XPATH= ".//*[@id='calculatePage2PurchaseCAPEXTablet']/table/tbody/tr[4]/td[2]/div/input";
	String Depriciation_XPATH = ".//*[@id='calculatePage2PurchaseCAPEXTablet']/table/tbody/tr[7]/td[2]/div/input";
	String Power_XPATH = ".//*[@id='calculatePage2PurchaseOPEXTablet']/table/tbody/tr[1]/td[2]/div/input";
	String ITMgmt_XPATH = ".//*[@id='calculatePage2PurchaseOPEXTablet']/table/tbody/tr[2]/td[2]/div/input";
	String NetworkFee_XPATH = ".//*[@id='calculatePage2PurchaseOPEXTablet']/table/tbody/tr[3]/td[2]/div/input";
	String ReportName_XPATH = ".//*[@id='reportName']";
	String AI_XPATH = ".//*[@id='calculatePage2PurchaseCAPEXTablet']/table/tbody/tr[2]/td[3]/div/input";
	String CAPEX_XPATH = ".//*[@id='calculatePage2PurchaseCAPEXTablet']/table/tbody/tr[6]/td[2]/div/input";
	String CAPEXHR_XPATH = ".//*[@id='calculatePage2PurchaseCAPEXTablet']/table/tbody/tr[8]/td[2]/div/input";
	String POWER_XPATH = ".//*[@id='calculatePage2PurchaseOPEXTablet']/table/tbody/tr[1]/td[3]/div/input";
	String ITM_XPATH = ".//*[@id='calculatePage2PurchaseOPEXTablet']/table/tbody/tr[2]/td[3]/div/input";
	String NF_XPATH = ".//*[@id='calculatePage2PurchaseOPEXTablet']/table/tbody/tr[3]/td[3]/div/input";
	String OPEX_XPATH = ".//*[@id='calculatePage2PurchaseOPEXTablet']/table/tbody/tr[4]/td[2]/div/input";
	String OPEXHR_XPATH = ".//*[@id='calculatePage2PurchaseOPEXTablet']/table/tbody/tr[5]/td[2]/div/input";
	String TOTALECUHR_XPATH = ".//*[@id='calculatePage2PurchaseNavigation']/p/span";
	

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