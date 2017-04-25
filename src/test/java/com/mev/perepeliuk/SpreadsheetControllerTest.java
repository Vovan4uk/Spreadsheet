package com.mev.perepeliuk;

import com.mev.perepeliuk.controller.DefaultController;
import com.mev.perepeliuk.controller.SpreadsheetController;
import com.mev.perepeliuk.domain.Spreadsheet;
import com.mev.perepeliuk.domain.SpreadsheetCell;
import com.mev.perepeliuk.service.SpreadsheetService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SpreadsheetControllerTest {

    @Autowired
    private SpreadsheetController spreadsheetController;

    @Autowired
    private DefaultController defaultController;

    @Autowired
    private SpreadsheetService spreadsheetService;

    private List<Spreadsheet> spreadsheetList = new ArrayList<>();

    @Before
    public void setUp() {
        spreadsheetList.add(buildSpreadsheet(1L, "firstSpreadsheetName", new Date(), new HashSet<>()));
        spreadsheetList.add(buildSpreadsheet(2L, "secondSpreadsheetName", new Date(), new HashSet<>()));
        spreadsheetList.add(buildSpreadsheet(3L, "thirdSpreadsheetName", new Date(), new HashSet<>()));

        Mockito.when(this.spreadsheetService.getAllSpreasheetWithoutCells()).thenReturn(spreadsheetList);
        Mockito.when(this.spreadsheetService.getById(1L)).thenReturn(spreadsheetList.get(0));
    }

    @Test
    public void testContextLoads() throws Exception {
    }

    //in this class only for example
    @Test
    public void testApi() {
        assertNotNull(DefaultController.CHECK_API_STRING);
        assertEquals(DefaultController.CHECK_API_STRING, defaultController.api());
    }

    @Test
    public void testFindAllSpreadsheet() {
        assertEquals(wrapResponseEntity(spreadsheetList), spreadsheetController.findAllSpreadsheet());
    }

    @Test
    public void testFindSpreadsheet() {
        assertEquals(HttpStatus.OK, spreadsheetController.findSpreadsheetData(1L).getStatusCode());
    }

    @Test (expected = java.lang.NullPointerException.class)
    public void testGetSpreadsheetByNull() {
        spreadsheetController.findSpreadsheetData(null);
    }

    @After
    public void clear() {}

    @Configuration
    static class SpreadsheetControllerTestConfiguration {

        @Bean
        public SpreadsheetService spreadsheetService() {
            return Mockito.mock(SpreadsheetService.class);
        }

        @Bean
        public SpreadsheetController spreadsheetController() {
            return new SpreadsheetController();
        }

        @Bean
        public DefaultController defaultController() {
            return new DefaultController();
        }
    }

    private ResponseEntity<Object> wrapResponseEntity(Object object) {
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    private Spreadsheet buildSpreadsheet(Long id, String name, Date date, Set<SpreadsheetCell> spreadsheetCellSet) {
        Spreadsheet spreadsheet = new Spreadsheet();
        spreadsheet.setId(id);
        spreadsheet.setName(name);
        spreadsheet.setCreateDate(date);
        spreadsheet.setSpreadsheetCells(spreadsheetCellSet);
        return spreadsheet;
    }
}