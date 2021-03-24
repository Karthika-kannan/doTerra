import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginSteps {
	@Given("User navigates to the login page")
	def navigateToLoginPage() {
		println("\n I am in the login page")
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://www.amazon.com/')
		WebUI.click(findTestObject('Object Repository/Page_Amazon.com Online Shopping for Electro_1f0c68/span_Sign in'))
	}
	
	@When("User enters (.*) and (.*)")
	def enterCredentials(String username, String password) {
		println("\n I am in the login page to enter credentials")
		println("Username" +username)
		println("Password" +password)
		WebUI.setText(findTestObject('Object Repository/Page_Amazon Sign-In/input_Email or mobile phone number_email'), username)
		WebUI.click(findTestObject('Object Repository/Page_Amazon Sign-In/input_Enter your email or mobile phone numb_fc7402'))
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_Amazon Sign-In/input_Forgot your password_password'), password)
		
	}
	
	@And("Clicks on login button")
	def clickSubmit() {
		println("\n I am in the login page to click submit")
		WebUI.click(findTestObject('Object Repository/Page_Amazon Sign-In/input_Enter your password_signInSubmit'))
		
	}
	
	@Then("User is taken to the home page")
	def verifyHomePage() {
		println("\n I am in the home page")
		WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Amazon.com Online Shopping for Electro_1f0c68/a_.us'))
		WebUI.closeBrowser()
	}
}