import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.xml.xpath.XPathFactory

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
/*------------*/ 

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
//------------------ STEP 1 -----------------------------------

def queryCheckInterface = 'select * from intcdjopo where cjpdesc = \'OFF_MANUAL42-01\''

WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : 'srai2018', ('loginName') : 'portal_manager2@retailer.local'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Menu/i_menu'))

WebUI.click(findTestObject('Object Repository/Menu/Expand_menu_marketplace'))

WebUI.click(findTestObject('Screens/OfferReview/a_SupplierOfferReview'))

/*
 * Connected to Portal as portal_manager2@retailer.local, menu entry Marketplace / Supplier offers						
Select offer "OFF_INVIT42",  site 42, article 11A42001, SU 1						
Reject the offer						
 * 
 */



/*
Select offer "OFF_MANUAL42_1", Article 23S42001, LV 1, SU 1
Validate the offer
Verify the transfert to GCO, use query Q3
*/
//*[@id="aggrid-offers"]/div/div[2]/div[2]/div[3]/div[2]/div/div


WebDriver driver = DriverFactory.getWebDriver()
WebElement aggrid = driver.findElement(By.xpath('//*[@id="aggrid-offers"]/div/div[2]/div[2]/div[3]/div[2]/div/div'))
List<WebElement> children = aggrid.findElements(By.xpath("*"))

def coordAggrid = new String[2]
found="null"
println 'SIZE'+children.size()
label:
for(int i = 0; i < children.size(); i++){

	List<WebElement> childrenDeeper = children[i].findElements(By.xpath("*"))
	println 'SIZECHILDREN'+childrenDeeper.size()
	for(int j = 0; j < childrenDeeper.size(); j++){
		
		if (childrenDeeper[j].getText().contains("OFF_MANUAL42-01")) {
			
			//i++
			//j++
			//(line,col)=f1(i,j)
			coordAggrid = getCoord(i,j)
			//println "line is ${line} , col is ${col}"
			//KeywordUtil.logInfo(coordAggrid[0])
			//found = i.toString()+"-"+j.toString()
			break label;
		}
		
	}
	
	}
	//line = i++
	KeywordUtil.logInfo(coordAggrid[0])
	TestObject tObj = new TestObject()
	tObj.addProperty("xpath", ConditionType.EQUALS, '//*[@id="aggrid-offers"]/div/div[2]/div[2]/div[3]/div[1]/div['+coordAggrid[0]+']/div[3]')

	WebUI.click(tObj)
	//KeywordUtil.logInfo(found)
	//*[@id="aggrid-offers"]/div/div[2]/div[2]/div[3]/div[1]/div[1]/div[3]
	//*[@id="aggrid-offers"]/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[3]
	
def getCoord(int x, int y) {
	def coord = new String[2]
	//println "x:"+x
	//println "y:"+y
	def line=x+1
	def col=y+1
	coord[0] = line.toString() 
	coord[1] = col.toString()

  return coord
}
	
	
WebUI.click(findTestObject('Screens/OfferReview/ValidateButton'))

WebUI.click(findTestObject('Screens/OfferReview/BoutonOkValidationPopUp'))

ResultSet resultQuery = CustomKeywords.'executeSQL.selectQuery'(queryCheckInterface)

if (resultQuery.next() == false) {
	KeywordUtil.markFailed('The offer is not in GOLD interface Table')
	assert false : 'The offer is not in GOLD interface Table'
	}



while (resultQuery.next())
	 {
	 System.out.println(resultQuery.getObject("CJPNOG"));
	 KeywordUtil.markPassed('The offer is in GOLD interface Table')
	 assert true : 'The offer is in GOLD interface Table'
	 }
	 WebUI.callTestCase(findTestCase('Common/LogoutScript'), [:], FailureHandling.STOP_ON_FAILURE)