package com.demoqa.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

public class WebDriverProvider {
    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void setConfig() {
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();


        String remoteUrl = WebDriverProvider.config.getRemoteUrl();
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
        }
    }
}
