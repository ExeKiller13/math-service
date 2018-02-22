package com.alokhin.math.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.alokhin.math.service.ParamCalculationService;

import static org.apache.commons.lang3.StringUtils.repeat;

@Service
public class ParamCalculationServiceImpl implements ParamCalculationService {

    // cos(1-cos(2+cos(3-cos(4+ ... cos(n)))) ...)
    @Cacheable ("paramsCache")
    @Override
    public String calculateParamA(Integer n) {
        int max = n.intValue();

        StringBuilder string = new StringBuilder();
        for (int i = 1; i <= max; i++) {
            String sign = (i != max) ? ((i % 2) != 0) ? "-" : "+" : "";
            string.append("cos(").append(i).append(sign);
        }
        return string.append(repeat(')', max)).toString();
    }
}
