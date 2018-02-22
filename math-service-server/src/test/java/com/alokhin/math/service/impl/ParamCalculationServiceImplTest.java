package com.alokhin.math.service.impl;

import org.junit.Before;
import org.junit.Test;
import com.alokhin.math.service.ParamCalculationService;

import static org.junit.Assert.assertEquals;

public class ParamCalculationServiceImplTest {

    private ParamCalculationService paramCalculationService;

    @Before
    public void setUp() throws Exception {

        paramCalculationService = new ParamCalculationServiceImpl();
    }

    @Test
    public void testParamCalculation() throws Exception {

        assertEquals("cos(1)", paramCalculationService.calculateParamA(1));
        assertEquals("cos(1-cos(2))", paramCalculationService.calculateParamA(2));
        assertEquals("cos(1-cos(2+cos(3)))", paramCalculationService.calculateParamA(3));
        assertEquals("cos(1-cos(2+cos(3-cos(4))))", paramCalculationService.calculateParamA(4));
    }
}
