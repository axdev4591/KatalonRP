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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : 'srai2018', ('loginName') : 'portal_manager2@retailer.local'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Menu/i_menu'))

WebUI.click(findTestObject('Object Repository/Menu/Expand_menu_marketplace'))

WebUI.click(findTestObject('Screens/siteWeight/a_SiteWeight'))

// Site - Weight

def sitesWeights = [
	['42', '0.17'],
	['43', '0.29'],
	['44', '0.47']
	]

for (def item : sitesWeights) {
	
WebUI.click(findTestObject('Screens/threshold/i_add_site_weight'))

WebUI.doubleClick(findTestObject('Screens/threshold/div_view_headline_site_weight'))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input'), 
    item[0])

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'), 
    Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'), 
    Keys.chord(Keys.TAB))

WebUI.doubleClick(findTestObject('Screens/siteWeight/AGGRID_WeightSite'))

WebUI.setText(findTestObject('Screens/siteWeight/AGGRID_WeightSite_input'), 
    item[1])

WebUI.sendKeys(findTestObject('Screens/siteWeight/AGGRID_WeightSite_input'), 
    Keys.chord(Keys.TAB))
}

WebUI.click(findTestObject('Screens/threshold/ButtonSave'))

WebUI.callTestCase(findTestCase('Common/LogoutScript'), [:], FailureHandling.STOP_ON_FAILURE)
