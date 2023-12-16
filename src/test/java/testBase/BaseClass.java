package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;//logging
	public ResourceBundle rb;//java.util pkg 
	
@Parameters("browser")
	@BeforeClass
public void setup(String br){
	rb=ResourceBundle.getBundle("config");
	logger=LogManager.getLogger(this.getClass());
	if(br.equals("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}else {
	   WebDriverManager.edgedriver().setup();
	   driver=new EdgeDriver();
	}
	
	    driver.manage().deleteAllCookies();//because any pre populated info which is stored in 
	    //the browser that will deleted
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appUrl"));
		driver.manage().window().maximize();
		
	}
/*
@AfterClass
public void tearDown() {
	driver.quit();
}
*/
@Test
public String randomString() {
	String generatedString1=RandomStringUtils.randomAlphabetic(5);
	return (generatedString1);
	
}
@Test
public String randomNumber() {
	String generatedString2=RandomStringUtils.randomNumeric(10);
	return (generatedString2);
	
}
@Test
public String randomAlphaNumeric() {
	String str=RandomStringUtils.randomAlphabetic(4);
	String num=RandomStringUtils.randomNumeric(3);
	return (str+"@"+num);
	
}

public String captureScreen(String tname) throws IOException {//here tname means test which is currently executing
	//that we will passing as a parameter in captureString()

	
	String timeStamp = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());//generate time stamp
			
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

	try {
		FileUtils.copyFile(source, new File(destination));
	} catch (Exception e) {
		e.getMessage();
	}
	return destination;

}



}

 