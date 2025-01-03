package com.web.community.vo.schedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    private Long id;
    private String name;
    private String shortName;
    private String tla;
    private String crest;
}
