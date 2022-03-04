package com.directa24.main.challenge;

import com.directa24.main.challenge.entity.Movies;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetData {

    public  Movies GetMovies(String url, int pageNo){
        RestTemplate template;
        final String GET_APIDATA = url +pageNo;

        //Adding converter to the template for response data
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        template = restTemplateBuilder.build();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        template.setMessageConverters(messageConverters);
        Movies movies = template.getForObject(GET_APIDATA, Movies.class);
        return movies;
    }

}
