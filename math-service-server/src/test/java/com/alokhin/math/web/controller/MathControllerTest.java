package com.alokhin.math.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.alokhin.math.service.MathService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith (SpringRunner.class)
@WebMvcTest (MathController.class)
@ComponentScan ("com.alokhin")
public class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MathService mathService;

    @Test
    public void testIncorrectParams() throws Exception {

        mockMvc.perform(get("/math/cos/sequence?n=0")).andExpect(status().isExpectationFailed());
        mockMvc.perform(get("/math/cos/sequence?n=-1")).andExpect(status().isExpectationFailed());
        mockMvc.perform(get("/math/cos/sequence?n=ASD")).andExpect(status().isBadRequest());
        mockMvc.perform(get("/math/cos/sequence")).andExpect(status().isBadRequest());
    }

    @Test
    public void testCosSequence() throws Exception {

        when(mathService.generateSequence(3)).thenReturn("((cos(1)+3)cos(1-cos(2))+2)cos(1-cos(2+cos(3)))+1");
        mockMvc.perform(get("/math/cos/sequence?n=3"))
               .andExpect(status().isOk())
               .andExpect(content().string("((cos(1)+3)cos(1-cos(2))+2)cos(1-cos(2+cos(3)))+1"))
               .andDo(print());
    }
}
