import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.internal.PathUtil as PathUtil
import com.kms.katalon.core.appium.driver.AppiumDriverManager
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.mobile.driver.MobileDriverType


Mobile.comment('Story: Verify correct alarm message')

Mobile.comment('Given that user has started an application')

// Set the Browserstack credentials: USERNAME and ACCESS_KEY
String browserStackServerURL = "https://siddharthamdemo1:3iskPrkpEsseiwerAxKB@hub-cloud.browserstack.com/wd/hub";

DesiredCapabilities capabilities = new DesiredCapabilities();

capabilities.setCapability("device", "Samsung Galaxy S8");

//Set the app_url (returned on uploading app on Browserstack) in the 'app' capability
capabilities.setCapability('app', 'bs://a72c2d7a326405ce8a7779ef39d59d49b1070248');

AppiumDriverManager.createMobileDriver(MobileDriverType.ANDROID_DRIVER, capabilities, new URL(browserStackServerURL));


Mobile.comment('And he navigates the application to Graphics form')

CustomKeywords.'bstack.bstackKeywords.tap'(findTestObject('Application/android.widget.TextView - Graphics'), GlobalVariable.G_Timeout)

//Mobile.tap(findTestObject('Application/android.widget.TextView - Graphics'), GlobalVariable.G_Timeout)

Mobile.comment('When he scroll to Xfermodes text')

Mobile.scrollToText('Xfermodes')

Mobile.comment('Then the current screen should show Xfermodes text after scrolling')

'Get item\'s label'
def itemText = Mobile.getText(findTestObject('Application/Graphics/android.widget.TextView - Xfermodes'), GlobalVariable.G_Timeout)

Mobile.verifyEqual(itemText, 'Xfermodes')

Mobile.closeApplication()

