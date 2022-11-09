import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import groovy.sql.Sql
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import java.*

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

public class executeSQL {

	/**
	 * execute a SQL query (update) on database
	 * @param query SQL query string
	 */
	@Keyword

	def executeQuery(String query){

		String connectionString

		connectionString = "jdbc:oracle:thin:@" + GlobalVariable.DB_HOST + ":" + GlobalVariable.DB_PORT + ":" + GlobalVariable.DB_SID

		def sql = Sql.newInstance(connectionString, GlobalVariable.DB_USERNAME, GlobalVariable.DB_PASSWORD)

		try {
			sql.execute(query)
		} finally {

			sql.close()
		}
	}

	/**
	 * execute a SQL query (select) on database
	 * @param query SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */

	@Keyword

	def selectQuery(String query) {

		String url = "jdbc:oracle:thin:@" + GlobalVariable.DB_HOST + ":" + GlobalVariable.DB_PORT + ":" + GlobalVariable.DB_SID

		//@TODO : use try/catch
		Connection connection =	DriverManager.getConnection(url, GlobalVariable.DB_USERNAME, GlobalVariable.DB_PASSWORD)

		PreparedStatement ps = connection.prepareStatement(query)
		ResultSet rs = ps.executeQuery()

		return rs
	}





}