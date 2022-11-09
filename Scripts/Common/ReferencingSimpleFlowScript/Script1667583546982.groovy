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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

String format = 'yyyy-MM-dd'

SimpleDateFormat sdf = new SimpleDateFormat(format)

//Form descriptions and dates List
def FormDesc = [['AutoForm-1', sdf.format(new Date() + 1), sdf.format(new Date() + 10)], ['AutoForm-2', sdf.format(new Date() + 
            11), sdf.format(new Date() + 21)], ['AutoForm-3', sdf.format(new Date() + 22), sdf.format(new Date() + 32)]]

def startDateDay = '09'

def endDateDay = '25'

WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : GlobalVariable.password, ('loginName') : GlobalVariable.username], 
    FailureHandling.STOP_ON_FAILURE)

for (def item : FormDesc) {
    println(item[0])

    println(item[1])

    println(item[2])

    WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Home  G.O.L.D. Retail Portal/i_menu'))

    WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Home  G.O.L.D. Retail Portal/a_Referencing                  expand_more'))

    WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Home  G.O.L.D. Retail Portal/a_Forms'))

    WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Referencing Forms  G.O.L.D. Retail Portal/input_of_op'))

    //Label Description form
    WebUI.setText(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input_Description_form_type_label'), 
        item[0])


    WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/Page_Supplier referencing form  G.O.L.D. Retail Portal/input_Start date_form_type_start_date'))

    WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/Page_Supplier referencing form  G.O.L.D. Retail Portal/startdate', 
            [('startdateVar') : startDateDay]))

    //WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/Page_Supplier referencing form  G.O.L.D. Retail Portal/startdate'))
    WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/Page_Supplier referencing form  G.O.L.D. Retail Portal/input_End date_form_type_end_date'))

    WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/Page_Supplier referencing form  G.O.L.D. Retail Portal/enddate'))

    WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_General data'))

    WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/AttributDisable'))

    WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/summary_Contracts'))

    WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/CCOMdisable'))

    WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/PayCOMdisable'))

    WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/ServiceComDisbale'))

    //Validation Workflow
    WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Validation workflow'))

    WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/addWorkflow'))

    //Add step
    WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/StepWorkflowInput'))

    WebUI.delay(2)

    WebUI.sendKeys(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/StepWorkflowInput'), 
        Keys.chord('1'))

    //Add Workflow description
    WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/desciptionWorkflowInput'))

    WebUI.delay(2)

    WebUI.sendKeys(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/desciptionWorkflowInput'), 
        Keys.chord('Premiere etape WF'))

    //Add users of validation
    WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/DoubleclickWF'))

    WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/SelectUsersWF'))


    WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/SaveButtonWF'))
}

//Start date input
//WebUI.doubleClick(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/AGGRID_StartDate'))
/*WebUI.setText(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/edit-form-type-start-date'),
item[1])

WebUI.sendKeys(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input_of_datepicker-input'),
Keys.chord(Keys.TAB))

//End date input
//WebUI.doubleClick(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/AGGRID_EndDate'))

WebUI.setText(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/edit-form-type-start-date'),
item[2])

WebUI.sendKeys(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/input_of_datepicker-input'),
Keys.chord(Keys.TAB))

*/
//DATES
/*	WebUI.doubleClick(findTestObject('Screens/invitationToTender/AGGRID_StartDate'))

WebUI.setText(findTestObject('Screens/invitationToTender/input_of_datepicker-input'), item[3])

WebUI.sendKeys(findTestObject('Screens/invitationToTender/input_of_datepicker-input'), Keys.chord(Keys.TAB))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/i_event'))

WebUI.selectOptionByValue(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/form_type_start_date'),
	startdate, false)

WebUI.selectOptionByValue(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/form_type_end_date'),
	enddate, false)

WebUI.selectOptionByLabel(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/PaymentContractFiledsAgGrid'),
	PaymentContract, false)

WebUI.selectOptionByLabel(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/ServiceContractFiledsAgGrid'),
	ServiceContract, false)

WebUI.selectOptionByLabel(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/UserWorkflow'),
	userWorkflow, false)
WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/a_30'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Shops'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_General data'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/span_Enable Attributes_lever srai-lever'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_General data'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Addresses and Contacts'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Addresses and Contacts'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/summary_Contracts'))

WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/span_Enable Commercial contract_lever srai-lever'))

WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/addPayment'))

WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/DoubleclickPaymentInput'))

WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/SelectContractValue'))

WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/addServiceContract'))

WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/DoubleClickServiceInput'))

WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/selectServiceItem'))

WebUI.click(findTestObject('Object Repository/Screens/ReferencingFormSimpleFlow/Page_Supplier referencing form  G.O.L.D. Re_553a76/i_arrow_drop_down'))

*/
/**
 * Contratc bloc
 *
 * */
/* WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/summary_Contracts'))

WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/unableCommercialcontract_lever'))
*/
//Select payment contrat input
/*  WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/addPayment'))

WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/DClickPay'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/selectPayment1'),
	Keys.chord(PaymentContract))*/
/* WebUI.selectOptionByLabel(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/selectPayment1'),
	PaymentContract, false)*/
//Select service contrat input
/*  WebUI.click(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/addServiceContract'))

WebUI.doubleClick(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/DoubleClickServiceInput'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/SelectServcie1'),
	Keys.chord(ServiceContract))
*/
/* WebUI.selectOptionByLabel(findTestObject('Screens/FormReferencingElements/Page_Supplier referencing form  G.O.L.D. Retail Portal/SelectServcie1'),
	ServiceContract, false)*/
/*
 def today = new Date()
 
 day = (today + 20)
 
 def formattedDate = day.format(‘d-MMMM-yyy’)
 
 println(formattedDate)
 
 futureDate = formattedDate.toString()
 
 String futureDay = (futureDate.split(’-’)[0])
 println(futureDay)
 String futureMonth = (futureDate.split(’-’)[1])
 
 String currentMonth = WebUI.getText(findTestObject(‘Object Repository/theMonthInCalendar’))
 
 while (!(currentMonth).equalsIgnoreCase(futureMonth)) {
 WebUI.click(findTestObject(‘Object Repository/RezDesk/Page_New Trip Request/span_Next’))
 currentMonth = WebUI.getText(findTestObject(‘Object Repository/RezDesk/Page_New Trip Request/month’))
 
 }
 
	 WebDriver driver = DriverFactory.getWebDriver()
 
	 List<WebElement> el = driver.findElements(By.xpath('//a[@class=\'ui-state-default\']'))
 
	 for (WebElement e : el) {
		 if (e.getText().equals(item[1])) {
			 println(e.getText())
 
			 e.click()
 
			 break
		 }
	 }
	 
	 startdate = driver.findElement(By.xpath('//input[@id=\'edit-form-type-start-date\']'))
 
	 //startdate.sendKeys(item[1])
	 WebElement enddate = driver.findElement(By.xpath('//input[@id=\'edit-form-type-end-date\']'))
 
	 println(enddate.getText())
 */
