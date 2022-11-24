package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestStudentRegistrationForm extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData td = new TestData();

    @DisplayName("Fill full form")
    @Test
    @Tag("fill_full_form")
    void fillFormTest() {
        step("Open registrations form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            registrationFormPage.setFirstName(td.firstName)
                    .setLastName(td.lastName)
                    .setEmail(td.email)
                    .setGender(td.gender)
                    .setNumber(td.number)
                    .setBirthDate(td.day, td.month, td.year)
                    .setSubjects(td.subject)
                    .setHobbie(td.hobby)
                    .pictureUpload(td.picture)
                    .setCurrentAddress(td.address)
                    .setStateAndCity(td.state, td.city)
                    .clickSubmit();
        });
        step("Check form results", () -> {
            registrationFormPage
                    .checkResultsTableVisible()
                    .checkResult("Student Name", td.firstName + " " + td.lastName)
                    .checkResult("Student Email", td.email)
                    .checkResult("Gender", td.gender)
                    .checkResult("Mobile", td.number)
                    .checkResult("Date of Birth", td.day + " " + td.month + "," + td.year)
                    .checkResult("Subjects", td.subject)
                    .checkResult("Hobbies", td.hobby)
                    .checkResult("Picture", td.picture)
                    .checkResult("Address", td.address)
                    .checkResult("State and City", td.state + " " + td.city);
        });
    }

    @DisplayName("Fill minimum fields form")
    @Test
    @Tag("fill_minimum_fields_form")
    void fillFormWithMinimumTest() {

        step("Open registrations form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill minimum fields for form", () -> {
            registrationFormPage.setFirstName(td.firstName)
                    .setLastName(td.lastName)
                    .setEmail(td.email)
                    .setGender(td.gender)
                    .setNumber(td.number)
                    .clickSubmit();
        });
        step("Check form results", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", td.firstName + " " + td.lastName)
                    .checkResult("Student Email", td.email)
                    .checkResult("Gender", td.gender)
                    .checkResult("Mobile", td.number);
        });
    }
}
