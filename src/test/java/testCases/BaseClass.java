package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.apache.commons.lang3.RandomStringUtils;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups= {"Sanity","Regression","Master","Datadriven"})
    @Parameters({"os","browser"})
    public void setup(@Optional("windows") String os, @Optional("chrome") String br) throws IOException {

        FileReader file= new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());    
        
        if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
        	
        	DesiredCapabilities Capabilities= new DesiredCapabilities();
        	if(os.equalsIgnoreCase("windows")) 
        	{
        	Capabilities.setPlatform(Platform.WIN11);
        	}
        	else if(os.equalsIgnoreCase("linux"))
        	{
        		Capabilities.setPlatform(Platform.LINUX);
        	}
        	else if (os.equalsIgnoreCase("mac")) 
        	{
            	Capabilities.setPlatform(Platform.MAC);

        	}
        	else 
        	{
        		System.out.println("No matching os");
        		return;
        	}
        	 switch(br.toLowerCase()) {
        	 case "chrome" : Capabilities.setBrowserName("chrome"); break;
        	 case "edge" : Capabilities.setBrowserName("MicosoftEdge"); break;
        	 case "firefos" : Capabilities.setBrowserName("firefox"); break;
        	 default : System.out.println("No matching browser"); return;
        	 }
        	 driver=new RemoteWebDriver(new URL("http://localhost:64656/wd/hub"),Capabilities);
        	
        }
        
        if(p.getProperty("execution_env").equalsIgnoreCase("local")) 
        {
        switch(br.toLowerCase()) {
            case "chrome": driver = new ChromeDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default: 
                System.out.println("Invalid browser: " + br);
                return;
        }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(p.getProperty("appurl"));
        driver.manage().window().maximize();
    }

    @AfterClass(groups= {"Sanity","Regression","Master","Datadriven"})
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }

    public String randomstring() {
        return RandomStringUtils.randomAlphabetic(6);
    }

    public String randonnumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randonAlphanumeric() {
        String s = RandomStringUtils.randomAlphabetic(3);        
        String n = RandomStringUtils.randomNumeric(14);
        return s + "@" + n;
    }
    
    public String CaptureScreen(String tname) throws IOException {
    	String timeStamp=new SimpleDateFormat("yyyyMMddhhss").format(new Date());
    	TakesScreenshot takescreenshot=(TakesScreenshot) driver;
    	File sourceFile= takescreenshot.getScreenshotAs(OutputType.FILE);
    	
    	String targetFilepath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" +timeStamp + ".png";
    	File targetfile=new File(targetFilepath);
    	sourceFile.renameTo(targetfile);
    	return targetFilepath;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
