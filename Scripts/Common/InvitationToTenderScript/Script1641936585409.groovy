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

String descITT = 'Functional flow'

String format = 'yyyy-MM-dd'

SimpleDateFormat sdf = new SimpleDateFormat(format)

String newStartDate = sdf.format(new Date())

String newEndDate = sdf.format(new Date() + 10)

//ARTICLE - VL - SITE - STARTDATE - ENDATE - QUANTITY - QUANTITY UNIT - PRICE - PRICE_UNIT
def invitationTT = [['11A42001-1', 2, '42', newStartDate, newEndDate, '200', 2, '1.20', 2], ['11A42001-1', 2, '43', newStartDate
        , newEndDate, '1.3', 3, '0.75', 2], ['23S42001-1', 2, '43', newStartDate, newEndDate, '757', 2, '0.33', 2]]

// SUPPLIER
WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : 'srai2018', ('loginName') : 'portal_manager2@retailer.local'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Menu/i_menu'))

WebUI.click(findTestObject('Object Repository/Menu/Expand_menu_marketplace'))

WebUI.click(findTestObject('Screens/invitationToTender/a_Invitation to tender'))

WebUI.click(findTestObject('Screens/invitationToTender/input_of_op'))

WebUI.click(findTestObject('Screens/invitationToTender/label_Description'))

WebUI.setText(findTestObject('Screens/invitationToTender/input_Description_itt_description'), descITT)

//-------------------------------------
for (def item : invitationTT) {
    WebUI.click(findTestObject('Screens/invitationToTender/i_add'))

    //WebUI.click(findTestObject('Screens/invitationToTender/div_view_headline'))
    WebUI.doubleClick(findTestObject('Screens/invitationToTender/div_view_headline'))

    //---ARTICLE
    WebUI.sendKeys(findTestObject('Screens/invitationToTender/input_Currency_ui-autocomplete-input'), item[0])

    WebUI.delay(5)

    WebUI.sendKeys(findTestObject('Screens/invitationToTender/input_Currency_ui-autocomplete-input'), Keys.chord(Keys.ARROW_DOWN))

    WebUI.sendKeys(findTestObject('Screens/invitationToTender/input_Currency_ui-autocomplete-input'), Keys.chord(Keys.TAB))

    //--VL
    WebUI.doubleClick(findTestObject('Screens/invitationToTender/AGGRIDLV_ARTICLE'))

    WebUI.selectOptionByIndex(findTestObject('Screens/invitationToTender/select_LV_Article'), item[1])

    //--SITE
    WebUI.doubleClick(findTestObject('Screens/invitationToTender/AGGRID_DIV_SITE'))

    WebUI.sendKeys(findTestObject('Screens/invitationToTender/AGGRID_DIV_SITE_INPUT'), item[2])

    WebUI.delay(5)

    WebUI.sendKeys(findTestObject('Screens/invitationToTender/AGGRID_DIV_SITE_INPUT'), Keys.chord(Keys.ARROW_DOWN))

    WebUI.sendKeys(findTestObject('Screens/invitationToTender/AGGRID_DIV_SITE_INPUT'), Keys.chord(Keys.TAB))

    //DATES
    WebUI.doubleClick(findTestObject('Screens/invitationToTender/AGGRID_StartDate'))

    WebUI.setText(findTestObject('Screens/invitationToTender/input_of_datepicker-input'), item[3])

    WebUI.sendKeys(findTestObject('Screens/invitationToTender/input_of_datepicker-input'), Keys.chord(Keys.TAB))

    WebUI.doubleClick(findTestObject('Screens/invitationToTender/AGGRID_EndDate'))

    WebUI.setText(findTestObject('Screens/invitationToTender/input_of_datepicker-input'), item[4])

    WebUI.sendKeys(findTestObject('Screens/invitationToTender/input_of_datepicker-input'), Keys.chord(Keys.TAB))

    //--QTY
    WebUI.doubleClick(findTestObject('Screens/invitationToTender/div_event_ag-cell ag-cell-not-inline-editin_4af7f9'))

    WebUI.setText(findTestObject('Screens/invitationToTender/quantity_input'), item[5])

    /*WebUI.setText(findTestObject('Screens/invitationToTender/input_1'), 
    '200')
*/
    //--QTY-UNIT
    /*
WebUI.click(findTestObject('Screens/invitationToTender/i_arrow_drop_down'))

WebUI.doubleClick(findTestObject('Screens/invitationToTender/div_event_ag-cell ag-cell-not-inline-editin_4af7f9'))
*/
    WebUI.doubleClick(findTestObject('Screens/invitationToTender/div_aggrid_quantity_unit'))

    WebUI.selectOptionByIndex(findTestObject('Screens/invitationToTender/select_qty_unit'), item[6])

    //--PRICE
    WebUI.doubleClick(findTestObject('Screens/invitationToTender/aggrid_price'))

    WebUI.setText(findTestObject('Screens/invitationToTender/price_input'), item[7])

    WebUI.sendKeys(findTestObject('Screens/invitationToTender/price_input'), Keys.chord(Keys.TAB))

    //WebUI.delay(5)
    //--PRICE UNIT
    WebUI.selectOptionByIndex(findTestObject('Screens/invitationToTender/select_price_unit'), item[8])
}

//--SUPPLIER
def suppliers = ['11000', '10322']

for (def item : suppliers) {
    WebUI.click(findTestObject('Screens/invitationToTender/i_add_suppliers'))

    WebUI.doubleClick(findTestObject('Screens/invitationToTender/div_supplier'))

    WebUI.sendKeys(findTestObject('Screens/invitationToTender/div_supplier_input'), item)

    WebUI.delay(5)

    WebUI.sendKeys(findTestObject('Screens/invitationToTender/div_supplier_input'), Keys.chord(Keys.ARROW_DOWN))

    WebUI.sendKeys(findTestObject('Screens/invitationToTender/div_supplier_input'), Keys.chord(Keys.TAB))
}

WebUI.click(findTestObject('Screens/invitationToTender/ValidateButton'))

WebUI.click(findTestObject('Screens/invitationToTender/PopUp_Confirm_Button'))

WebUI.callTestCase(findTestCase('Common/LogoutScript'), [:], FailureHandling.STOP_ON_FAILURE)

