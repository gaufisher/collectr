package com.catalyst.collector.SeleniumFramework;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by derekdelaney on 11/13/15.
 */
public class SeleniumSettings {

    private WebDriver driver;

    private String CHROME_MAC = "src/test/java/com/catalyst/collector/PageObjectFramework/Drivers/chromedriver";
    private String CHROME_WIN = "src/test/java/com/catalyst/collector/PageObjectFramework/Drivers/chromedriver.exe";

    public SeleniumSettings(){
        if (SystemUtils.IS_OS_MAC)
            System.setProperty("webdriver.chrome.driver", CHROME_MAC);
        if (SystemUtils.IS_OS_WINDOWS)
            System.setProperty("webdriver.chrome.driver", CHROME_WIN);
        //ToDo: add driver for linux

        driver = new ChromeDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

}
