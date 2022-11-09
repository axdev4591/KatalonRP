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

WebUI.navigateToUrl('http://srai-gold-sid3:8083/rportal/user/login')

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_G.O.L.D. Retail Portal   Symphony Reta_6885a5/div_Email'))

WebUI.setText(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_G.O.L.D. Retail Portal   Symphony Reta_6885a5/input_Email_name'), 
    'portal_manager1@retailer.local')

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_G.O.L.D. Retail Portal   Symphony Reta_6885a5/input_Email_op'))

WebUI.setEncryptedText(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_G.O.L.D. Retail Portal   Symphony Reta_6885a5/input_Password_pass'), 
    'NHBwr8Fhs1F1hhv+gptQ3A==')

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_G.O.L.D. Retail Portal   Symphony Reta_6885a5/input_Email_op'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Home  G.O.L.D. Retail Portal/i_menu'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Home  G.O.L.D. Retail Portal/a_Referencing                  expand_more'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Home  G.O.L.D. Retail Portal/a_Forms'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Referencing Forms  G.O.L.D. Retail Portal/input_of_op'))

WebUI.setText(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input_Description_form_type_label'), 
    'Form1')

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/i_event'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/a_9'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/i_event'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/a_11'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_General data'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/span_Enable Attributes_lever srai-lever'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_General data'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Addresses and Contacts'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Addresses and Contacts'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Contracts'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/span_Enable Commercial contract_lever srai-lever'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/span_Enable Payment contract_lever srai-lever'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/span_Enable Service contract_lever srai-lever'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Contracts'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Validation workflow'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/i_add'))

WebUI.doubleClick(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/div_fiber_new_ag-cell ag-cell-not-inline-ed_ef9559_1'))

WebUI.setText(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input'), 
    '1')

WebUI.setText(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input_1'), 
    '1')

WebUI.doubleClick(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/div_fiber_new_ag-cell ag-cell-not-inline-ed_ef9559_1_2'))

WebUI.setText(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input_fiber_new_ag-404-input'), 
    'permiere étape du WF')

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/i_arrow_drop_down'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input_of_op'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input_of_op'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input_of_op'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input_of_op'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input_of_op'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/form_Code                                  _e25c70'))

