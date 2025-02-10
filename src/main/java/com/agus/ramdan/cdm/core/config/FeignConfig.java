package com.agus.ramdan.cdm.core.config;

import com.agus.ramdan.cdm.core.interceptor.AuthorizationRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class FeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new AuthorizationRequestInterceptor();
    }
}
