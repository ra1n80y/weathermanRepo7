package com.WEATHER.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course extends RepresentationModel<Course>
{
    private String cid;
    private String cname;
    private Double price;
    private String instructorName;
}
