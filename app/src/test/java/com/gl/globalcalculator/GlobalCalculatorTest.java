package com.gl.globalcalculator;

import com.gl.globalcalculator.ServiceImpl.GlobalCalculatorServicceImpl;
import com.gl.globalcalculator.service.GlobalCalculatorService;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlobalCalculatorTest {


    private GlobalCalculatorService globalCalculatorService=null;

    @Before
    public void before(){
        globalCalculatorService  = new GlobalCalculatorServicceImpl();

    }

    @Test
    public void additionTest(){

        Double result = globalCalculatorService.addNumber(20.0,10.0);
        assertEquals(30.0,result,0);
    }

    @Test
    public void substractionTest(){

        Double result = globalCalculatorService.substractionNumber(20.0,10.0);
        assertEquals(10,result, 0);
    }

    @Test
    public void divisionTest(){

        Double result = globalCalculatorService.divisionNumber(30.0,10.0);
        assertEquals(3.0,result, 0);
    }
    @Test
    public void multiplicationTest(){

        Double result = globalCalculatorService.multiplicationNumber(10.0,30.0);
        assertEquals(300.0,result, 0);
    }

    @Test
    public void logTest(){

        Double result = globalCalculatorService.logNumber(10.0);
        assertEquals(2.3,result, 0);
    }

    @Test
    public void lognTest(){

        Double result = globalCalculatorService.lognNumber(10.0);
        assertEquals(1,result, 0);
    }
}
