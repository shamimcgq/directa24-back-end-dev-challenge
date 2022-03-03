package com.directa24.main.challenge;

import com.directa24.main.challenge.entity.MovieData;
import com.directa24.main.challenge.entity.Movies;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

   public static void main(String[] args) {
      List<String> directors = getDirectors(3);
      System.out.println(String.join("\n", directors));
   }

   /*
    * Complete the 'getDirectors' function below.
    *
    * The function is expected to return a List<String>.
    * The function accepts int threshold as parameter.
    *
    * URL
    * https://directa24-movies.mocklab.io/api/movies/search?page=<pageNumber>
    */

   public static List<String> getDirectors(int threshold) {
      RestTemplate template;
      final String GET_APIDATA = "https://directa24-movies.mocklab.io/api/movies/search?page=" + threshold;
      List<String> directors = new ArrayList<>();

      //Adding converter to the template for response data
      RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
      template = restTemplateBuilder.build();
      List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
      MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
      converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
      messageConverters.add(converter);
      template.setMessageConverters(messageConverters);
      Movies movies = template.getForObject(GET_APIDATA, Movies.class);
      assert movies != null;
      List<MovieData> movieData = movies.getData();

      // Adding the directors name to the list
      for (MovieData data : movieData) {
         directors.add(data.getDirector());
      }

      return directors;
   }





}
