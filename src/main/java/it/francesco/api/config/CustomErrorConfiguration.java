package it.francesco.api.config;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequest;

@Configuration
public class CustomErrorConfiguration {

    //private static final String DEFAULT_KEY_TIMESTAMP = "timestamp";
    private static final String DEFAULT_KEY_STATUS = "status";
    private static final String DEFAULT_KEY_ERROR = "error";
    private static final String DEFAULT_KEY_ERRORS = "errors";
    private static final String DEFAULT_KEY_MESSAGE = "message";
    //private static final String DEFAULT_KEY_PATH = "path";

    //

    @Bean
    public ErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes() {

            @Override
            public Map<String ,Object> getErrorAttributes(
                WebRequest webRequest
                ,boolean includeStackTrace
            ) {
                Map<String ,Object> defaultMap
                    = super.getErrorAttributes( webRequest ,includeStackTrace );

                Map<String ,Object> errorAttributes = new LinkedHashMap();
                errorAttributes.put("detail",  defaultMap.get("error"));
                errorAttributes.put("instance", UUID.randomUUID().toString());
                errorAttributes.put("status", defaultMap.get("status"));
                errorAttributes.put("title", defaultMap.get("message"));
                errorAttributes.put("type", "http://urilink....");
                
                return errorAttributes;
            }
        };
    }
}