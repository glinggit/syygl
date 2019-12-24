package com.syygl.test.study.lombokTest;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.*;

import java.net.URI;
import java.util.Map;
import java.util.Set;

/**
 * Created by sunyy on 2019/12/20.
 */
@AllArgsConstructor
public abstract class FilterRestTemplate implements RestOperations {
    @Delegate
    protected volatile RestTemplate restTemplate;

    protected FilterRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//实现RestOperations所有的接口
}
