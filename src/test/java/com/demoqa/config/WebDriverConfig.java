package com.demoqa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
})

public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String baseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();
}
