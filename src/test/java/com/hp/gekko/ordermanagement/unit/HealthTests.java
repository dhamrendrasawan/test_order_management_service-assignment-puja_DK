package com.hp.gekko.ordermanagement.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hp.gekko.ordermanagement.entity.Health;

@Tag("UnitTest")
public class HealthTests {

    @Test
    void healthTest() throws Exception {
        Health health = new Health("test-service", "healthy");

        Assertions.assertEquals("test-service", health.getName(), "Name had unexpected value.");
        Assertions.assertEquals("healthy", health.getStatus(), "Status had unexpected value.");

    }
}
