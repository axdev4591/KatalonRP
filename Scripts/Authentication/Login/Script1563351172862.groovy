import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.CSVData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.testng.Assert as Assert

// For debug purpose
// println('GlobalVariable.dataFileName    : ' + GlobalVariable.dataFileName);
// println('GlobalVariable.dataFileIndex   : ' + GlobalVariable.dataFileIndex);

CSVData connectInfos = findTestData(GlobalVariable.dataFileName)
Number dataFileIndex = GlobalVariable.dataFileIndex

String url = connectInfos.internallyGetValue("Url", dataFileIndex)
String user = connectInfos.internallyGetValue("User", dataFileIndex)
String password = connectInfos.internallyGetValue("Password", dataFileIndex)

// For debug purpose
// println('URL    : ' + url);
// println('User   : ' + user);
// println('Passwd : ' + password);

WebUI.openBrowser('')

// Need to maximize the window, otherwise some HTML elements may become unreachable.
WebUI.maximizeWindow()

WebUI.navigateToUrl(url)

// Enter the username
WebUI.setText(findTestObject('Authentication/Page_Login_Step1/input_email'), user)

// Click on the 'Next' button
WebUI.click(findTestObject('Authentication/Page_Login_Step1/button_email'))

// Enter the password
WebUI.setEncryptedText(findTestObject('Authentication/Page_Login_Step2/input_password'), password)

// Submit the form
WebUI.click(findTestObject('Authentication/Page_Login_Step2/button_password'))

// Mark the test as 'Failed' if the button 'Login' is not present
if (!WebUI.verifyElementPresent(findTestObject('Authentication/Page_Welcome/link_logout'), 5, FailureHandling.STOP_ON_FAILURE)) {
  KeywordUtil.markFailed('ERROR: the button "Logout" should be present')
}
