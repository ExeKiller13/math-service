package com.alokhin.math.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alokhin.math.service.MathService;
import com.alokhin.math.service.ParamCalculationService;

@Service
public class MathServiceImpl implements MathService {
//123
    private final ParamCalculationService paramCalculationService;

    @Autowired
    public MathServiceImpl(ParamCalculationService paramCalculationService) {
        this.paramCalculationService = paramCalculationService;
    }

    @Override
    public String generateSequence(Integer n) {
        int max = n.intValue();

        StringBuilder sequence = new StringBuilder();
        for (int i = 1; i <= max; i++) {
            int v = max - i + 1;
            sequence.append(paramCalculationService.calculateParamA(i)).append("+").append(v).append(i != max ? ")" : "");
        }
        return StringUtils.repeat('(', max - 1) + (sequence).toString();
    }
}
