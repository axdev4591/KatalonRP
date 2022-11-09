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

String format = 'yyyy-MM-dd'

SimpleDateFormat sdf = new SimpleDateFormat(format)

String newStartDate = sdf.format(new Date())

String newEndDate = sdf.format(new Date() + 2)

WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : 'srai2018', ('loginName') : 'danone_user1@danone.local'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Menu/i_menu'))

WebUI.click(findTestObject('Object Repository/Menu/Expand_menu_marketplace'))

WebUI.click(findTestObject('Screens/OfferCreation/a_created-suppliers-offers'))

CustomKeywords.'Aggrid.getAggridInfo'()

// ARTICLE - SITE - OFFER LABEL - STARTDATE - ENDDATE - QTY - QTY UNIT - PRICE - CARRIAGE - PRICE UNIT
def supplierOffers = [
	['23S42001-1','42','OFF_MANUAL42-01' ,newStartDate, newEndDate, '150', '181', '0.75', '1.24', '181'],
	['36ING42047','42','OFF_MANUAL42-02' ,newStartDate, newEndDate, '200', '1', '0.83', '1.24', '1'],
	]

	for (def item : supplierOffers) {

WebUI.click(findTestObject('Screens/OfferCreation/CreateOfferButton'))

WebUI.sendKeys(findTestObject('Screens/OfferCreation/ArticleInput'),
	item[0])

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Screens/OfferCreation/ArticleInput'),
	Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Screens/OfferCreation/ArticleInput'),
	Keys.chord(Keys.TAB))

WebUI.delay(5)

WebUI.click(findTestObject('Screens/OfferCreation/selectSite'))

WebUI.sendKeys(findTestObject('Screens/OfferCreation/inputSite'),
	item[1])

WebUI.sendKeys(findTestObject('Screens/OfferCreation/inputSite'),
	Keys.chord(Keys.TAB))

WebUI.setText(findTestObject('Screens/OfferCreation/offerLabelInput'), item[2])

WebUI.setText(findTestObject('Screens/OfferCreation/inputStartDate'), item[3])

WebUI.setText(findTestObject('Screens/OfferCreation/inputEndDate'), item[4])

WebUI.setText(findTestObject('Screens/OfferCreation/dailyQty'), item[5])

WebUI.click(findTestObject('Screens/OfferCreation/selectQtyUnit'))

WebUI.sendKeys(findTestObject('Screens/OfferCreation/inputQtyUnit'),
	item[6])

WebUI.sendKeys(findTestObject('Screens/OfferCreation/inputQtyUnit'),
	Keys.chord(Keys.TAB))

WebUI.setText(findTestObject('Screens/OfferCreation/startPriceInput'), item[7])

WebUI.setText(findTestObject('Screens/OfferCreation/carriagePaidPriceInput'), item[8])

WebUI.click(findTestObject('Screens/OfferCreation/selectPriceApplicationUnit'))

WebUI.sendKeys(findTestObject('Screens/OfferCreation/inputPriceApplicationUnit'),
	item[9])

WebUI.sendKeys(findTestObject('Screens/OfferCreation/inputPriceApplicationUnit'),
	Keys.chord(Keys.TAB))

WebUI.click(findTestObject('Screens/OfferCreation/SubmitOfferButton'))

	}

	WebUI.callTestCase(findTestCase('Common/LogoutScript'), [:], FailureHandling.STOP_ON_FAILURE)