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


String formatX = 'yyyy-MM-dd'

SimpleDateFormat sdfX = new SimpleDateFormat(formatX)

String newStartDateX = sdfX.format(new Date() + 1)

String newEndDateX = sdfX.format(new Date() + 15)

String newStartDateY = sdfX.format(new Date() + 16)

String newEndDateY = sdfX.format(new Date() + 30)

def lists = [
	['11000', 1,'11A42001-2',2,newStartDateX,newEndDateX],
	['11000', 2,'11A42001-2',2,newStartDateX,newEndDateX],
	['11000', 1,'23S42001-2',2,newStartDateY,newEndDateY],
	['11000', 2,'23S42001-2',2,newStartDateX,newEndDateX],
]

for (item in lists) {
	
	println item
	println "startDate:"+item[4]
	println "startDate:"+item[5]
}

WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : 'srai2018', ('loginName') : 'portal_manager2@retailer.local'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Menu/i_menu'))

WebUI.click(findTestObject('Object Repository/Menu/Expand_menu_marketplace'))

WebUI.click(findTestObject('Screens/threshold/a_Auto supplier offer management'))

WebUI.click(findTestObject('Screens/threshold/i_add_auto_params'))

WebUI.doubleClick(findTestObject('Screens/threshold/div_view_headline_supplier_auto_params'))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input'), 
    '11000')

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'), 
    Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'), 
    Keys.chord(Keys.TAB))

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_Warehouse'))

WebUI.selectOptionByIndex(findTestObject('Screens/threshold/select_Warehouse_SupplierAuto'),
	1)


//----------------------------------------------------

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_Article'))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input'),
	'11A42001-2')

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.TAB))

//----------------------------------------

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_SU'))

WebUI.selectOptionByIndex(findTestObject('Screens/threshold/select_SU_SupplierAuto'),
	2)

//-----------------------------------------------------
WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_StartDate_SupplierAuto'))

String format = 'yyyy-MM-dd'

SimpleDateFormat sdf = new SimpleDateFormat(format)

String newStartDate = sdf.format(new Date() + 1)

WebUI.setText(findTestObject('Screens/threshold/input_of_datepicker-input'), 
    newStartDate)

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_EndDate_SupplierAuto'))

String newEndDate = sdf.format(new Date() + 15)

WebUI.setText(findTestObject('Screens/threshold/input_of_datepicker-input'), 
    newEndDate)

WebUI.sendKeys(findTestObject('Screens/threshold/input_of_datepicker-input'),
	Keys.chord(Keys.ENTER))

//-------------------------

WebUI.check(findTestObject('Screens/threshold/AGGRID_Monday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Tuesday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Wednesday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Thursday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Friday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Saturday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Sunday'))

//--------SECOND RECORD-----------------

WebUI.click(findTestObject('Screens/threshold/i_add_auto_params'))

WebUI.doubleClick(findTestObject('Screens/threshold/div_view_headline_supplier_auto_params'))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input'),
	'11000')

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.TAB))

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_Warehouse'))

WebUI.selectOptionByIndex(findTestObject('Screens/threshold/select_Warehouse_SupplierAuto'),
	2)


//----------------------------------------------------

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_Article'))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input'),
	'11A42001-2')

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.TAB))

//----------------------------------------

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_SU'))

WebUI.selectOptionByIndex(findTestObject('Screens/threshold/select_SU_SupplierAuto'),
	2)

//-----------------------------------------------------
WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_StartDate_SupplierAuto'))

String format2 = 'yyyy-MM-dd'

SimpleDateFormat sdf2 = new SimpleDateFormat(format2)

String newStartDate2 = sdf2.format(new Date() + 1)

WebUI.setText(findTestObject('Screens/threshold/input_of_datepicker-input'),
	newStartDate2)

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_EndDate_SupplierAuto'))

String newEndDate2 = sdf2.format(new Date() + 15)

WebUI.setText(findTestObject('Screens/threshold/input_of_datepicker-input'),
	newEndDate2)

WebUI.sendKeys(findTestObject('Screens/threshold/input_of_datepicker-input'),
	Keys.chord(Keys.ENTER))

//-------------------------

WebUI.check(findTestObject('Screens/threshold/AGGRID_Monday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Tuesday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Wednesday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Thursday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Friday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Saturday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Sunday'))

//--------THIRD RECORD-----------------

WebUI.click(findTestObject('Screens/threshold/i_add_auto_params'))

WebUI.doubleClick(findTestObject('Screens/threshold/div_view_headline_supplier_auto_params'))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input'),
	'11000')

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.TAB))

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_Warehouse'))

WebUI.selectOptionByIndex(findTestObject('Screens/threshold/select_Warehouse_SupplierAuto'),
	1)


//----------------------------------------------------

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_Article'))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input'),
	'23S42001-2')

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.TAB))

//----------------------------------------

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_SU'))

WebUI.selectOptionByIndex(findTestObject('Screens/threshold/select_SU_SupplierAuto'),
	2)

//-----------------------------------------------------
WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_StartDate_SupplierAuto'))

String format3 = 'yyyy-MM-dd'

SimpleDateFormat sdf3 = new SimpleDateFormat(format3)

String newStartDate3 = sdf3.format(new Date() + 16)

WebUI.setText(findTestObject('Screens/threshold/input_of_datepicker-input'),
	newStartDate3)

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_EndDate_SupplierAuto'))

String newEndDate3 = sdf3.format(new Date() + 30)

WebUI.setText(findTestObject('Screens/threshold/input_of_datepicker-input'),
	newEndDate3)

WebUI.sendKeys(findTestObject('Screens/threshold/input_of_datepicker-input'),
	Keys.chord(Keys.ENTER))

//-------------------------

WebUI.check(findTestObject('Screens/threshold/AGGRID_Monday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Tuesday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Wednesday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Thursday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Friday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Saturday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Sunday'))

//--------FOURTH RECORD-----------------

WebUI.click(findTestObject('Screens/threshold/i_add_auto_params'))

WebUI.doubleClick(findTestObject('Screens/threshold/div_view_headline_supplier_auto_params'))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input'),
	'11000')

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.TAB))

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_Warehouse'))

WebUI.selectOptionByIndex(findTestObject('Screens/threshold/select_Warehouse_SupplierAuto'),
	2)


//----------------------------------------------------

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_Article'))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input'),
	'23S42001-2')

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Screens/threshold/input_fiber_new_ui-autocomplete-input (1)'),
	Keys.chord(Keys.TAB))

//----------------------------------------

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_SU'))

WebUI.selectOptionByIndex(findTestObject('Screens/threshold/select_SU_SupplierAuto'),
	2)

//-----------------------------------------------------
WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_StartDate_SupplierAuto'))

String format4 = 'yyyy-MM-dd'

SimpleDateFormat sdf4 = new SimpleDateFormat(format4)

String newStartDate4 = sdf4.format(new Date() + 1)

WebUI.setText(findTestObject('Screens/threshold/input_of_datepicker-input'),
	newStartDate4)

WebUI.doubleClick(findTestObject('Screens/threshold/AGGRID_EndDate_SupplierAuto'))

String newEndDate4 = sdf4.format(new Date() + 15)

WebUI.setText(findTestObject('Screens/threshold/input_of_datepicker-input'),
	newEndDate4)

WebUI.sendKeys(findTestObject('Screens/threshold/input_of_datepicker-input'),
	Keys.chord(Keys.ENTER))

//-------------------------

WebUI.check(findTestObject('Screens/threshold/AGGRID_Monday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Tuesday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Wednesday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Thursday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Friday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Saturday'))

WebUI.check(findTestObject('Screens/threshold/AGGRID_Sunday'))



//-----------------------
WebUI.click(findTestObject('Screens/threshold/input_of_op'))

WebUI.callTestCase(findTestCase('Common/LogoutScript'), [:], FailureHandling.STOP_ON_FAILURE)
