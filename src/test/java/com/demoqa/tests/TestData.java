package com.demoqa.tests;

import com.demoqa.utils.UtilForData;
import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en-US"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            number = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(10, 25)),
            month = String.valueOf(UtilForData.randomMonth()),
            year = String.valueOf(faker.number().numberBetween(1980, 2001)),
            subject = "Maths",
            hobby = "Sports",
            picture = "image.jpg",
            address = faker.address().streetAddress(),
            state = "Haryana",
            city = "Panipat";
}
