package com.directa24.main.challenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieData {
    @JsonProperty()
    private String Title;
    @JsonProperty()
    private String Year;
    @JsonProperty()
    private String Rated;
    @JsonProperty()
    private String Released;
    @JsonProperty()
    private String Runtime;
    @JsonProperty()
    private String Genre;
    @JsonProperty()
    private String Director;
    @JsonProperty()
    private String Writer;
    @JsonProperty()
    private String Actors;
    @JsonProperty()
    private String something;

}
