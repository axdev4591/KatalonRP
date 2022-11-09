import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : 'srai2018', ('loginName') : 'portal_manager2@retailer.local'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Menu/i_menu'))

WebUI.click(findTestObject('Object Repository/Menu/Expand_menu_marketplace'))

WebUI.click(findTestObject('Screens/threshold/a_Quantity thresholds'))

String format = 'yyyy-MM-dd'

SimpleDateFormat sdf = new SimpleDateFormat(format)

String newStartDate = sdf.format(new Date() + 1)

String newEndDate = sdf.format(new Date() + 15)

// Merch. Struct. - Start Date - End Date - Quantity - Unit
def quantityThresholds = [['P01022301', newStartDate, newEndDate, '1000', 1], ['P01022302', newStartDate, newEndDate, '250'
        , 5]]

for (def item : quantityThresholds) {
    WebUI.click(findTestObject('Screens/threshold/i_add'))

    WebUI.doubleClick(findTestObject('Screens/threshold/div_view_headline'))

    WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input'), item[0])

    WebUI.delay(5)

    WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'), Keys.chord(Keys.ARROW_DOWN))

    WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'), Keys.chord(Keys.TAB))

    WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_StartDate'))

    WebUI.setText(findTestObject('Screens/threshold/input_of_datepicker-input'), item[1])

    WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_EndDate'))

    WebUI.setText(findTestObject('Screens/threshold/input_of_datepicker-input'), item[2])

    WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_Opportunity'))

    WebUI.setText(findTestObject('Screens/threshold/AGGRID_Opportunity_input'), item[3])

    WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_Unit'))

    WebUI.selectOptionByIndex(findTestObject('Screens/threshold/select_Unit'), item[4])
}

WebUI.click(findTestObject('Screens/threshold/input_of_op'))

WebUI.callTestCase(findTestCase('Common/LogoutScript'), [:], FailureHandling.STOP_ON_FAILURE)

