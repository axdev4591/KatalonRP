import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement


/*------------*/ 
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


public class WebTable {

	@Keyword

	def clickValue(String xpathTable, String ExpectedValue, Integer indexCol){

		WebDriver driver = DriverFactory.getWebDriver()

		'To locate table'
		WebElement Table = driver.findElement(By.xpath(xpathTable))

		'To locate rows of table it will Capture all the rows available in the table '
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))


		Boolean foundValue = false

		table: for (int i = 0; i < Rows.size(); i++) {

			if (!foundValue) {

				'To locate columns(cells) of that specific row'
				List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

				for (int j = 0; j < Cols.size(); j++) {
					'Verifying the expected text in the each cell'
					if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue)) {

						'To locate anchor in the expected value matched row to perform action'

						Cols.get(indexCol).findElement(By.tagName('a')).click()
						foundValue = true
						break
					}
				}
			}
		}
	}
	
	@Keyword
	
		def selectValue(String xpathTable, String ExpectedValue, Integer indexCol){
	
			WebDriver driver = DriverFactory.getWebDriver()
	
			'To locate table'
			WebElement Table = driver.findElement(By.xpath(xpathTable))
	
			'To locate rows of table it will Capture all the rows available in the table '
			List<WebElement> Rows = Table.findElements(By.tagName('tr'))
	
	
			Boolean foundValue = false
	
			table: for (int i = 0; i < Rows.size(); i++) {
	
				if (!foundValue) {
	
					'To locate columns(cells) of that specific row'
					List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
	
					for (int j = 0; j < Cols.size(); j++) {
						'Verifying the expected text in the each cell'
						if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue)) {
	
							'To locate anchor in the expected value matched row to perform action'
	
							Cols.get(indexCol).findElement(By.tagName('a')).click()
							foundValue = true
							break
						}
					}
				}
			}
		}
	
	
}
