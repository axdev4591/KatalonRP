import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : 'srai2018', ('loginName') : 'portal_admin@retailer.local'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Menu/i_menu'))

WebUI.click(findTestObject('Object Repository/Menu/Expand_menu_marketplace'))

def menus = [
	"/rportal/auto-supplier-offer-management/buyer",
	"/rportal/auto-supplier-offer-management/supplier",
	"/rportal/auto-supplier-offer-management/read",
	"/rportal/daily-priced-offers/supplier-contract-management",
	"/rportal/daily-priced-offers/supplier-contract-review",
	"/rportal/daily-priced-offers/invitation-to-tender/display/retailer",
	"/rportal/daily-priced-offers/invitation-to-tender/display/supplier",
	"/rportal/daily-priced-offers/offer_ranking_param_management",
	"/rportal/supplier-offers/review-offers-in-creation",
	"/rportal/daily-priced-offers/price_variation_margins_management",
	"/rportal/daily-priced-offers/quantity-threshold-manager",
	"/rportal/daily-priced-offers/su-attachment-review-manager",
	"/rportal/daily-priced-offers/su-attachment-perimeter-manager",
	"/rportal/daily-priced-offers/su-visualization-manager",
	"/rportal/supplier-offers/review-submitted-offers",
	"/rportal/daily-priced-offers/supplier-appreciation",
	"/rportal/daily-priced-offers/supplier-offers-review",
	"/rportal/daily-priced-offers/site-weight-manager",
	"/rportal/supplier-offers/review-offers-in-creation"
	]

for (def item : menus){

verifyPortalMenuEntries(item)
}

WebUI.click(findTestObject('HomePage/PortalSettingPNG'))

WebUI.click(findTestObject('HomePage/RetailerUsersTab'))

CustomKeywords.'WebTable.clickValue'('//*[@id="block-srai-materialize-css-content"]/div/div/div[2]/table/tbody', 'portal_manager2@retailer.local',
	9)

WebUI.click(findTestObject('Droits/summary_Daily-Priced Offers'))

//@TODO Must check if checkbox is already checked or not before checking
//CustomKeywords.'TickCheck.tickCheck'('Droits/CheckBox_Poids des sites pour seuils pénuriques', true)
WebUI.check(findTestObject('Droits/CheckBox_Poids des sites pour seuils pénuriques'))

WebUI.check(findTestObject('Droits/CheckBox_Gestion du seuil pénurique'))

WebUI.check(findTestObject('Droits/CheckBox_Gestion de la marge de variation des prix'))

WebUI.check(findTestObject('Droits/Checkbox_Revue offres soumises'))

WebUI.check(findTestObject('Droits/Checkbox_Création d appel d offres'))

WebUI.check(findTestObject('Droits/Checkbox_Visualisation d appel d offres'))

WebUI.check(findTestObject('Droits/Checkbox_Gestion des paramètres offres automatiques'))

WebUI.click(findTestObject('ButtonActions/UpdateButton'))

WebUI.click(findTestObject('HomePage/SuppliersTab'))

CustomKeywords.'WebTable.clickValue'('//*[@id="block-srai-materialize-css-content"]/div/div/div/table/tbody', 'DANONE',
	4)

WebUI.click(findTestObject('HomePage/a_Users'))

CustomKeywords.'WebTable.clickValue'('//*[@id="block-srai-materialize-css-content"]/div/div/div/table/tbody', 'danone_user1@danone.local',
	7)

WebUI.click(findTestObject('Droits/summary_Daily-Priced Offers_users'))

WebUI.check(findTestObject('Droits/span_Create offers'))

WebUI.check(findTestObject('Droits/span_Review created offers'))

WebUI.click(findTestObject('ButtonActions/UpdateButton'))

WebUI.callTestCase(findTestCase('Common/LogoutScript'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : 'srai2018', ('loginName') : 'portal_manager2@retailer.local'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Menu/i_menu'))

WebUI.click(findTestObject('Object Repository/Menu/Expand_menu_marketplace'))

menus = [
	["/rportal/auto-supplier-offer-management/buyer", true],
	["/rportal/auto-supplier-offer-management/supplier", false],
	["/rportal/auto-supplier-offer-management/read", false],
	["/rportal/daily-priced-offers/supplier-contract-management", false],
	["/rportal/daily-priced-offers/supplier-contract-review", false],
	["/rportal/daily-priced-offers/invitation-to-tender/display/retailer", true],
	["/rportal/daily-priced-offers/invitation-to-tender/display/supplier", false],
	["/rportal/daily-priced-offers/offer_ranking_param_management", false],
	["/rportal/supplier-offers/review-offers-in-creation", false],
	["/rportal/daily-priced-offers/price_variation_margins_management", true],
	["/rportal/daily-priced-offers/quantity-threshold-manager", true],
	["/rportal/daily-priced-offers/su-attachment-review-manager", false],
	["/rportal/daily-priced-offers/su-attachment-perimeter-manager", false],
	["/rportal/daily-priced-offers/su-visualization-manager", false],
	["/rportal/supplier-offers/review-submitted-offers", false],
	["/rportal/daily-priced-offers/supplier-appreciation", false],
	["/rportal/daily-priced-offers/supplier-offers-review", true],
	["/rportal/daily-priced-offers/site-weight-manager", true],
	["/rportal/supplier-offers/review-offers-in-creation", false]
	]

	for (def item : menus){
		verifyPortalMenuEntries(item[0],item[1])
		}
	
	
	WebUI.callTestCase(findTestCase('Common/LogoutScript'), [:], FailureHandling.STOP_ON_FAILURE)

	
	WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : 'srai2018', ('loginName') : 'danone_user1@danone.local'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Object Repository/Menu/i_menu'))
	
	WebUI.click(findTestObject('Object Repository/Menu/Expand_menu_marketplace'))

	menus = [
		["/rportal/auto-supplier-offer-management/buyer", false],
		["/rportal/auto-supplier-offer-management/supplier", false],
		["/rportal/auto-supplier-offer-management/read", false],
		["/rportal/daily-priced-offers/supplier-contract-management", false],
		["/rportal/daily-priced-offers/supplier-contract-review", false],
		["/rportal/daily-priced-offers/invitation-to-tender/display/retailer", false],
		["/rportal/daily-priced-offers/invitation-to-tender/display/supplier", false],
		["/rportal/daily-priced-offers/offer_ranking_param_management", false],
		["/rportal/supplier-offers/review-offers-in-creation", true],
		["/rportal/daily-priced-offers/price_variation_margins_management", false],
		["/rportal/daily-priced-offers/quantity-threshold-manager", false],
		["/rportal/daily-priced-offers/su-attachment-review-manager", false],
		["/rportal/daily-priced-offers/su-attachment-perimeter-manager", false],
		["/rportal/daily-priced-offers/su-visualization-manager", false],
		["/rportal/supplier-offers/review-submitted-offers", false],
		["/rportal/daily-priced-offers/supplier-appreciation", false],
		["/rportal/daily-priced-offers/supplier-offers-review", false],
		["/rportal/daily-priced-offers/site-weight-manager", false]
		]
		
		for (def item : menus){
			verifyPortalMenuEntries(item[0],item[1])
			}

WebUI.click(findTestObject('Object Repository/Menu/Marketplace_Offersincreation'))

TestObject myNewObject = new TestObject('ObjectID')

	myNewObject.setSelectorMethod(SelectorMethod.BASIC)

	myNewObject.addProperty('id', ConditionType.EQUALS, "edit-create-offer")
	myNewObject.addProperty('type', ConditionType.EQUALS, "submit")
	myNewObject.addProperty('class', ConditionType.EQUALS, "waves-button-input")
	WebUI.verifyElementClickable(myNewObject)
	WebUI.verifyElementPresent(myNewObject, 0)
	WebUI.verifyElementVisible(myNewObject)
	
		WebUI.callTestCase(findTestCase('Common/LogoutScript'), [:], FailureHandling.STOP_ON_FAILURE)
		
def verifyPortalMenuEntries(String menu, Boolean exist = true) {
    TestObject myNewObject = new TestObject('ObjectID')

    myNewObject.setSelectorMethod(SelectorMethod.BASIC)

    myNewObject.addProperty('href', ConditionType.EQUALS, menu)

	if (exist) {
    
		WebUI.verifyElementClickable(myNewObject)

		WebUI.verifyElementPresent(myNewObject, 0)

    WebUI.verifyElementVisible(myNewObject)
	}
	else {

	WebUI.verifyElementNotPresent(myNewObject, 0)
	
	}
	
}



