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
import org.openqa.selenium.WebElement

public class Aggrid {

	@Keyword

	def getValue(String aggridName, Integer line, Integer col){

		String js = '''
				var css = "aggrid-offers-grid";

				console.log("css==>",css);
				return getAllElementsWithAttribute("col-id");

function getAllElementsWithAttribute(attribute)
{
  var matchingElements = [];
  var allElements = document.getElementsByTagName('*');
console.log("allElements==>",allElements);
  for (var i = 0, n = allElements.length; i < n; i++)
  {
    if (allElements[i].getAttribute(attribute) !== null)
    {
      // Element exists with attribute. Add to array.
      matchingElements.push(allElements[i]);
    }
  }
  return matchingElements;
}


			'''
		println "js: " + js
		budget = WebUI.executeJavaScript(js, null)
		println "Budget: " + budget
	}

	@Keyword
	def getAggridInfo() {

		String jsAggrid = '''
//var allElements = [];
		const allElements = document.querySelector("#aggrid-offers-grid > div > div.ag-root-wrapper-body.ag-layout-auto-height.ag-focus-managed > div.ag-root.ag-unselectable.ag-layout-auto-height > div.ag-body-viewport.ag-layout-auto-height.ag-row-animation > div.ag-center-cols-clipper > div > div").childNodes;


//const allElements = jQuery("#aggrid-offers-grid > div > div.ag-root-wrapper-body.ag-layout-auto-height.ag-focus-managed > div.ag-root.ag-unselectable.ag-layout-auto-height > div.ag-body-viewport.ag-layout-auto-height.ag-row-animation > div.ag-center-cols-clipper > div > div").children();

console.log("Hello allElements",allElements);
//console.log("Hello Hamid888",allElements[1]);
console.log("Hello allElements.length",allElements.length);

for (let i = 0; i < allElements.length; i++) {
    // access current element with nodeItems[i]
		console.log("here");
		console.log("ICI==>",allElements[i]);
}

		'''


		WebUI.executeJavaScript(jsAggrid, null)
		//println toto
	}
}

//*[@id="aggrid-offers-grid"]/div/div[2]/div[2]/div[3]/div[2]/div/div





