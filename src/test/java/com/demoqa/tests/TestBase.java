package com.demoqa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.config.WebDriverProvider;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        WebDriverProvider.setConfig();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void addedAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.addVideo();
    }
}
