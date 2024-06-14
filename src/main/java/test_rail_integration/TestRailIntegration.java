package test_rail_integration;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;
import com.codepine.api.testrail.model.Run;
import driver_init.DriverInit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TestRailIntegration implements ITestListener {
    static TestRail testRailClient;
    static Run run;
    static List<ResultField> resultFieldList;


    @Override
    public void onStart(ITestContext context) {

        String testRailUrl = "https://phnkvr.testrail.io/";
        String userName = "IlyaTravinUser@user.user";
        String password = "user1337Testvjeyn.user";
        testRailClient = TestRail.builder(testRailUrl, userName, password)
                .applicationName("TestRailIntegration")
                .build();

        String time = String.format("%1$tH:%1$tM", new Date());
        run = testRailClient.runs().add(1, new Run().setName("Idea Run " + time)).execute();
        resultFieldList = testRailClient.resultFields().list().execute();
    }


    public static void makeScreenShot(String name) {
        File screenshotFile = ((TakesScreenshot) DriverInit.startDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("./target/screenshots/" + name + ".png"));
        } catch (IOException e) {
        }
    }


    public static int returnCaseId(String methodName) {
        return Integer.parseInt(methodName.split("_C")[1]);
    }

    @Override
    public void onFinish(ITestContext context) {
        testRailClient.runs().close(run.getId()).execute();
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " skipped!!!");
        testRailClient.results().addForCase(run.getId(), returnCaseId(result.getMethod().getMethodName()), new Result().setStatusId(4), resultFieldList).execute();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " started");

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " passed");
        testRailClient.results().addForCase(run.getId(), returnCaseId(result.getMethod().getMethodName()), new Result().setStatusId(1), resultFieldList).execute();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenShot(result.getMethod().getMethodName());
        testRailClient.results().addForCase(run.getId(), returnCaseId(result.getMethod().getMethodName()), new Result().setStatusId(5), resultFieldList).execute();
    }
}

