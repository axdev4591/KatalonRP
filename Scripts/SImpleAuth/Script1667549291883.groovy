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

WebUI.openBrowser('')

 WebUI.navigateToUrl(GlobalVariable.url)
 
 WebUI.setText(findTestObject('Object Repository/SimpleAUth/Page_G.O.L.D. Retail Portal   Symphony Reta_6885a5/input_Email_name'),
	 GlobalVariable.username)
 
 WebUI.click(findTestObject('Object Repository/SimpleAUth/Page_G.O.L.D. Retail Portal   Symphony Reta_6885a5/input_Email_op'))
 
 WebUI.setEncryptedText(findTestObject('Object Repository/SimpleAUth/Page_G.O.L.D. Retail Portal   Symphony Reta_6885a5/input_Password_pass'),
	GlobalVariable.Encryptedpwd)
 
//WebUI.navigateToUrl(GlobalVariable.url)

println(findTestData("RetailPortal/rpData").getValue(3, 2));
/*
WebUI.setText(findTestObject('Object Repository/SimpleAUth/Page_G.O.L.D. Retail Portal   Symphony Reta_6885a5/input_Email_name'), 
    username)

WebUI.click(findTestObject('Object Repository/SimpleAUth/Page_G.O.L.D. Retail Portal   Symphony Reta_6885a5/input_Email_op'))

WebUI.setEncryptedText(findTestObject('Object Repository/SimpleAUth/Page_G.O.L.D. Retail Portal   Symphony Reta_6885a5/input_Password_pass'), 
    password)*/

WebUI.click(findTestObject('Object Repository/SimpleAUth/Page_G.O.L.D. Retail Portal   Symphony Reta_6885a5/input_Email_op'))

WebUI.click(findTestObject('Object Repository/SimpleAUth/Page_Home  G.O.L.D. Retail Portal/i_menu'))

WebUI.click(findTestObject('Object Repository/SimpleAUth/Page_Home  G.O.L.D. Retail Portal/i_menu'))

WebUI.click(findTestObject('Object Repository/SimpleAUth/Page_Home  G.O.L.D. Retail Portal/h6_portal_manager1 portal_manager1'))

WebUI.click(findTestObject('Object Repository/SimpleAUth/Page_Home  G.O.L.D. Retail Portal/a_Log out'))

WebUI.closeBrowser()

