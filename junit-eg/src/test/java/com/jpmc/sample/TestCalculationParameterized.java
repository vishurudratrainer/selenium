package com.jpmc.sample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class TestCalculationParameterized {
private  int input;
private int result;
private Calculation calculation;

    public TestCalculationParameterized(int input, int result) {
        this.input = input;
        this.result = result;
    }

    @Before
    public void setUp() throws Exception {
        calculation=new Calculation();
    }

    @Parameterized.Parameters
    public static Collection input(){
        return Arrays.asList(new Object[][]{{1,1},{2,8},{3,27}});
    }

    @Test
    public void testCube(){
        assertEquals(this.result,Calculation.cube(input));
    }
}

