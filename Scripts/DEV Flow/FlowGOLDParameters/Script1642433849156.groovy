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
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.common.RestfulClient as RestfulClient
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
/*------------*/ import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.assertj.core.api.Assertions as Assertions
import org.eclipse.persistence.sessions.serializers.JSONSerializer as JSONSerializer
import org.json.JSONObject as JSONObject
import com.kms.katalon.core.testdata.CSVData as CSVData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder as RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import groovy.json.JsonSlurper as JsonSlurper

//Generate the token for WS
def token = CustomKeywords.'WSToken.generateToken'()

//------------------ STEP 1 -----------------------------------
def queries = [
	'update parpostes set parvan1=2300, pardmaj=sysdate, parutil=\'RP_FLOW\' where partabl=7003 and parpost=4', 
	'update parpostes set parvan1=1, pardmaj=sysdate, parutil=\'RP_FLOW\' where partabl=7003 and parpost=5', 
	'update parpostes set parvan1=0, pardmaj=sysdate, parutil=\'RP_FLOW\' where partabl=7003 and parpost=10'
	]

for (def item : queries) {
    CustomKeywords.'executeSQL.executeQuery'(item)
}

WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : 'srai2018', ('loginName') : 'portal_admin@retailer.local'
        , ('url') : 'http://localhost:8080/rportal'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/PortalSettingPNG'))

WebUI.click(findTestObject('HomePage/GoldParametersTab'))

WebUI.click(findTestObject('HomePage/RefreshButton'))

def response4 = WS.sendRequest(findTestObject('WS/GetGOLDParamsValue', [('table') : '7003', ('entry') : '4', ('field') : 'NV1'
            , ('url') : GlobalVariable.PORTAL_URL, ('endpointGOLDParams') : GlobalVariable.ENDPOINT_GOLDPARAMS, ('token') : token]))

WebUI.verifyMatch(response4.getResponseBodyContent(), '"2300"', true)

def response5 = WS.sendRequest(findTestObject('WS/GetGOLDParamsValue', [('table') : '7003', ('entry') : '5', ('field') : 'NV1'
            , ('url') : GlobalVariable.PORTAL_URL, ('endpointGOLDParams') : GlobalVariable.ENDPOINT_GOLDPARAMS, ('token') : token]))

WebUI.verifyMatch(response5.getResponseBodyContent(), '"1"', true)

def response10 = WS.sendRequest(findTestObject('WS/GetGOLDParamsValue', [('table') : '7003', ('entry') : '10', ('field') : 'NV1'
            , ('url') : GlobalVariable.PORTAL_URL, ('endpointGOLDParams') : GlobalVariable.ENDPOINT_GOLDPARAMS, ('token') : token]))

WebUI.verifyMatch(response10.getResponseBodyContent(), '"0"', true)
