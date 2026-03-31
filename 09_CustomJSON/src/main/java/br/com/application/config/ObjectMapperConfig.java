package br.com.application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig { // através dessa classe que eu consigo fazer um filtro para ocultar o campo sensitiveData.

    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper mapper =  new ObjectMapper();
        SimpleFilterProvider filters = new SimpleFilterProvider()
                .addFilter("PersonFilter",
                        SimpleBeanPropertyFilter.serializeAllExcept("sensitiveData"));
        mapper.setFilterProvider(filters);

        return  mapper;

    }

}
