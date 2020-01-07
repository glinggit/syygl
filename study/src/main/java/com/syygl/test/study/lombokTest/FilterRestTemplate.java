package com.syygl.test.study.lombokTest;

import lombok.experimental.Delegate;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sunyy on 2019/12/20.
 */
public abstract class FilterRestTemplate implements RestOperations {
    @Delegate
    protected volatile RestTemplate restTemplate;

    protected FilterRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//实现RestOperations所有的接口
}
