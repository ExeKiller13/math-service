package com.alokhin.math.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.alokhin.math.service.MathService;
import com.alokhin.math.service.ParamCalculationService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith (MockitoJUnitRunner.class)
public class MathServiceImplTest {

    @Mock
    private ParamCalculationService paramCalculationService;

    private MathService mathService;

    @Before
    public void setUp() throws Exception {
        mathService = new MathServiceImpl(paramCalculationService);
    }

    @Test
    public void testSequence() throws Exception {

        when(paramCalculationService.calculateParamA(1)).thenReturn("cos(1)");
        when(paramCalculationService.calculateParamA(2)).thenReturn("cos(1-cos(2))");
        when(paramCalculationService.calculateParamA(3)).thenReturn("cos(1-cos(2+cos(3)))");
        when(paramCalculationService.calculateParamA(4)).thenReturn("cos(1-cos(2+cos(3-cos(4))))");

        assertEquals("cos(1)+1", mathService.generateSequence(1));
        assertEquals("(cos(1)+2)cos(1-cos(2))+1", mathService.generateSequence(2));
        assertEquals("((cos(1)+3)cos(1-cos(2))+2)cos(1-cos(2+cos(3)))+1", mathService.generateSequence(3));
        assertEquals("(((cos(1)+4)cos(1-cos(2))+3)cos(1-cos(2+cos(3)))+2)cos(1-cos(2+cos(3-cos(4))))+1", mathService.generateSequence(4));
    }
}
