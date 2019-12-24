package com.syygl.test.study.lombokTest;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sunyy on 2019/12/20.
 */
public class ExtractRestTemplate extends FilterRestTemplate {
    private RestTemplate restTemplate;

    public ExtractRestTemplate(RestTemplate restTemplate) {
        super(restTemplate);
        this.restTemplate = restTemplate;
    }

    public <T> RestResponseDTO<T> postForEntityWithNoException(String url, Object request, Class<T> responseType, Object... uriVariables)
            throws RestClientException {
        RestResponseDTO<T> restResponseDTO = new RestResponseDTO<T>();
        ResponseEntity<T> tResponseEntity;
        try {
            tResponseEntity = restTemplate.postForEntity(url, request, responseType, uriVariables);
            restResponseDTO.setData(tResponseEntity.getBody());
            restResponseDTO.setMessage(tResponseEntity.getStatusCode().name());
            restResponseDTO.setStatusCode(tResponseEntity.getStatusCodeValue());
        } catch (Exception e) {
            restResponseDTO.setStatusCode(RestResponseDTO.UNKNOWN_ERROR);
            restResponseDTO.setMessage(e.getMessage());
            restResponseDTO.setData(null);
        }
        return restResponseDTO;
    }
}

@Data
class RestResponseDTO<T> {
    public static int UNKNOWN_ERROR = 102;
    private T data;
    private String message;
    private int statusCode;


}
