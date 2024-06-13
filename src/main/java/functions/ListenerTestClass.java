package functions;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTestClass implements ITestListener {
    @Override
    public void  onTestFailure(ITestResult result) {
        System.out.println("Test "+result.getMethod().getMethodName()+" was failed");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test "+result.getMethod().getMethodName()+ "was successed" );
    }
}
