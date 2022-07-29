package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		Log.info("++++++++++++++++++++++++++++++++++++++++++++");
		Log.info(" Started method " + result.getName());
		Log.info("++++++++++++++++++++++++++++++++++++++++++++");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("Strated time :" + timeStamp);
		Log.info("++++++++++++++++++++++++++++++++++++++++++++");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("++++++++++++++++++++++++++++++++++++++++++++");
		Log.info(" PASSED method " + result.getName());
		Log.info("++++++++++++++++++++++++++++++++++++++++++++");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("FINISH time :" + timeStamp);
		Log.info("++++++++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Log.error("++++++++++++++++++++++++++++++++++++++++++++");
		Log.error(" FAILED method " + result.getName());
		Log.error("++++++++++++++++++++++++++++++++++++++++++++");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.error("FAILED time :" + timeStamp);
		Log.error("++++++++++++++++++++++++++++++++++++++++++++");
		Log.error(result.getThrowable());
	}

	
	
	
	
}
