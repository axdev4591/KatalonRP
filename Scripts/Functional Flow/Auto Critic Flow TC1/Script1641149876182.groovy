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
def queries = ['update parpostes set parvan1=2300, pardmaj=sysdate, parutil=\'RP_FLOW\' where partabl=7003 and parpost=4'
    , 'update parpostes set parvan1=1, pardmaj=sysdate, parutil=\'RP_FLOW\' where partabl=7003 and parpost=5', 'update parpostes set parvan1=0, pardmaj=sysdate, parutil=\'RP_FLOW\' where partabl=7003 and parpost=10']

for (def item : queries) {
    CustomKeywords.'executeSQL.executeQuery'(item)
}

WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : 'srai2018', ('loginName') : 'portal_admin@retailer.local'], FailureHandling.STOP_ON_FAILURE)

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

//------------------ STEP 2 -----------------------------------
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

WebUI.click(findTestObject('HomePage/PortalSettingPNG'))

WebUI.click(findTestObject('HomePage/SuppliersTab'))

CustomKeywords.'WebTable.clickValue'('//*[@id="block-srai-materialize-css-content"]/div/div/div/table/tbody', 'HARIBO', 
    4)

WebUI.click(findTestObject('HomePage/a_Users'))

CustomKeywords.'WebTable.clickValue'('//*[@id="block-srai-materialize-css-content"]/div/div/div/table/tbody', 'haribo_user1@haribo.local', 
    7)

WebUI.click(findTestObject('Droits/summary_Daily-Priced Offers_users'))

WebUI.check(findTestObject('Droits/span_Create offers'))

WebUI.check(findTestObject('Droits/span_Review created offers'))

WebUI.click(findTestObject('ButtonActions/UpdateButton'))

WebUI.callTestCase(findTestCase('Common/LogoutScript'), [:], FailureHandling.STOP_ON_FAILURE)

//------------------ STEP 3 -----------------------------------
def deleteCDJSUFOULINK = 'delete from cdjsufoulink k\nwhere cousite in (42,43)\nand k.coucfin = 80\n'

CustomKeywords.'executeSQL.executeQuery'(deleteCDJSUFOULINK)

def newCDJSUFOULINK = 'insert into cdjsufoulink(cousite, coucinr, coucinv, coucfin, couccin, couaflag, coumod, couddeb, coudfin, coutime, coudcre, coudmaj, couutil, couaores) \nselect socsite, arvcinr, arvcinv, foucfin, fccccin, 0, 1, trunc(sysdate), trunc(sysdate)+10, 2200, sysdate, sysdate, \'RP_FLOW\', 1 \nfrom artuv, foudgene, sitdgene, fouccom \nwhere (socsite, arvcexr, arvcexv, foucnuf, fccnum ) in (\n(42, \'11A42001\', 1, \'11000\', \'CTCOM01\'), (43, \'11A42001\', 1, \'11000\', \'CTCOM01\'),\n(42, \'11A42001\', 2, \'11000\', \'CTCOM01\'), (42, \'21S42001\', 1, \'11000\', \'CTCOM01\'),\n(43, \'23S42001\', 1, \'11000\', \'CTCOM02\'), (43, \'36ING42047\', 1, \'11000\', \'CTCOM01\'),\n(42, \'23S42001\', 1, \'11000\', \'CTCOM02\'), (42, \'36ING42047\', 1, \'11000\', \'CTCOM01\'))\n'

CustomKeywords.'executeSQL.executeQuery'(newCDJSUFOULINK)

//------------------ STEP 4 -----------------------------------
//Quantity thresold
WebUI.callTestCase(findTestCase('Common/thresoldScript'), [:], FailureHandling.STOP_ON_FAILURE)

//------------------ STEP 5 -----------------------------------
//Site Weight
WebUI.callTestCase(findTestCase('Common/siteWeightScript'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'WSToken.generateToken'()

