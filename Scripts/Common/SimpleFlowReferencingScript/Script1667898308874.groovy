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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

String format = 'yyyy-MM-dd'

SimpleDateFormat sdf = new SimpleDateFormat(format)

//Form descriptions and dates List
def FormDesc = ['AutoForm-1', 'AutoForm-2', 'AutoForm-3', 'AutoForm-4', 'AutoForm-5', 'AutoForm-6']

//Jours de la semaine
def DaysOfWeek = ['1', '2', '3', '4', '5', '6', '7' //Ag-grid calendar à 7 jours, dimache est le premier jour
]

//Semaine du mois: toujours travailler avec les semaines 2, 3 et 4
def WeekOfMonth = ['2', '3', '4', '5' // selection du 3ème jour de la 3ème semaine du mois(15/11/22): //div[@id='ui-datepicker-div']/table/tbody/tr[3]/td[3]/a
]

//Payment contract items
def PaymentItem = ['Induced additional start change', 'End change code', 'Induced additional start change']

//Service contract items
def ServiceItem = ['Communication of shipping note', 'Communication of purchase order', 'Communication of invoice sending']

//Steps of validation workflow
def Steps = ['1', '2', '3']

//dexcription of validation workflow steps
def descWF = ['Premiere etape WF', 'Deuxieme etape WF', 'troisième étape WF']

//Login
WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : GlobalVariable.password, ('loginName') : GlobalVariable.username], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Home  G.O.L.D. Retail Portal/i_menu'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Home  G.O.L.D. Retail Portal/a_Referencing                  expand_more'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Home  G.O.L.D. Retail Portal/a_Forms'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Referencing Forms  G.O.L.D. Retail Portal/input_of_op'))

//Form description
WebUI.setText(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input_Description_form_type_label'), 
    FormDesc[0])

//Dates picker: start date
WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/Page_Supplier referencing form  G.O.L.D. Retail Portal/input_Start date_form_type_start_date'))

WebUI.click(findTestObject('Screens/FormReferencingElements/itemDateStart', [('Sweek') : WeekOfMonth[0], ('Sday') : DaysOfWeek[
            3]]))

//Dates picker: end date
WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/Page_Supplier referencing form  G.O.L.D. Retail Portal/input_End date_form_type_end_date'))

WebUI.click(findTestObject('Screens/FormReferencingElements/itemDateEnd', [('Eweek') : WeekOfMonth[0], ('Eday') : DaysOfWeek[
            5]]))

//Disable bloc general data bloc
WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_General data'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/span_Enable Attributes_lever srai-lever'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_General data'))

//Disbale bloc Commercial contract
WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Contracts'))

WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/span_Enable Commercial contract_lever srai-lever'))
//Disable bloc Adresses and contacts bloc
WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Addresses and Contacts'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Addresses and Contacts'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Contracts'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/span_Enable Commercial contract_lever srai-lever'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/span_Enable Payment contract_lever srai-lever'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/span_Enable Service contract_lever srai-lever'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Contracts'))

/*
//Bloc add payment contract item
WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/addPayment'))

WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/DClickPay'))

WebUI.delay(1)

WebUI.click(findTestObject('Screens/FormReferencingElements/ItemPayment', [('itemPaymentContract') : PaymentItem[0]]))

//Bloc add service contract item
WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/addServiceContract'))

WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/ServiceDropDown'))

WebUI.delay(1)

WebUI.click(findTestObject('Screens/FormReferencingElements/itemService', [('itemServiceContract') : ServiceItem[0]]))



*
*/
//Create one step validation workflow
//Validation Workflow
WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Validation workflow'))

WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/addWorkflow'))

//Add step
WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/StepWorkflowInput'))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/StepWorkflowInput'), 
    Keys.chord(Steps[0]))

//Add Workflow description
WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/desciptionWorkflowInput'))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/desciptionWorkflowInput'), 
    Keys.chord(descWF[0]))

//Add users of validation
WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/DoubleclickWF'))

WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/SelectUsersWF'))

