package com.vinsguru.tests.jsonutil;

import com.vinsguru.tests.flightreservation.model.FlightReservationTestData;
import com.vinsguru.util.JsonUtil;

public class JsonUtilTest {
    public static void main(String[] args) {
        FlightReservationTestData testData = JsonUtil.getTestData("src/test/java/com/vinsguru/tests/jsonutil/test-data.json", FlightReservationTestData.class);
        assert testData != null;
        System.out.println(testData.email());
    }
}
