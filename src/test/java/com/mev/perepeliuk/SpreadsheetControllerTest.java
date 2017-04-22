package com.mev.perepeliuk;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0",
        "spring.datasource.url:jdbc:h2:mem:spreadsheet;DB_CLOSE_ON_EXIT=FALSE"})
public class SpreadsheetControllerTest {
    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testHello() throws Exception {
    }

    @Test
    public void testCalc() throws Exception {
    }
}