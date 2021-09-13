package com.cybertek.tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

protected WebDriver driver;
protected Actions actions;
protected WebDriverWait wait;

    //this class is used for starting nad building reports
    //need to put all with protected modifier so that could be access in all project class n sub classes outside project with inheritance
    protected ExtentReports report;
    //this class is used to create HTML report file
    protected ExtentHtmlReporter htmlReporter;
    //this will  define a test, enables adding logs, authors, test steps
    //this will  define a test, enables adding logs, authors, test steps
    protected ExtentTest extentLogger;


    @BeforeTest  //before test cz v wnt to run reports aftr all test cases r done so v put all thngs rlted to reports in @before/after test
    public void setUpTest(){

        //initialize the classes..which imported globally
        report = new ExtentReports();

        //create a report path.....for report
        String projectPath = System.getProperty("user.dir");//dynamic n everyone has its own..with this code every one can get to its dynamic project location
        String path = projectPath + "/test-output/report.html";//test-output folder is created automatically when we create reports n we need to save both of these paths to get dynamic path
        //which can be used by all our collegues of work..dynamic path

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);//put path in bracket so that reporter gets reports from there

        //attach the html report to report object
        report.attachReporter(htmlReporter); //cpz htmlreporter has the location of our report..which v save in report object

        //title in report....to give a title to our report...
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information...by object
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));

    }

@BeforeMethod
    public void setup(){

    driver = Driver.get();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    actions = new Actions(driver);
    wait = new WebDriverWait(driver,10);
    driver.get(ConfigurationReader.get("url"));

}

    //ITestResult class describes the result of a test in TestNG
@AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {

    //if test fails...then we need screen shots n everything

    if(result.getStatus()==ITestResult.FAILURE){
        //record the name of failed test case
        extentLogger.fail(result.getName());

        //take the screenshot and return location of screenshot
        String screenShotPath = BrowserUtils.getScreenshot(result.getName());

        //add your screenshot to your report
        extentLogger.addScreenCaptureFromPath(screenShotPath);

        //capture the exception and put inside the report
        extentLogger.fail(result.getThrowable());

    }

    Thread.sleep(2000);
    Driver.closeDriver();//we are using configuration and we have singlton method working(one object pointing at multiple things)
    //so we cant use driver .quite anymore..instead v using Driver class which we created in utitlies and its closeDriver methof
    //driver(small letters) is for webDriverfactory class

}

@AfterTest
    public void tearDownTest(){

    //this is when the report is actually created...passed r failed
    report.flush();
   }

}
