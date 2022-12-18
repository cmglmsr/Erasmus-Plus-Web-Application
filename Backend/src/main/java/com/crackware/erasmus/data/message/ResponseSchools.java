package com.crackware.erasmus.data.message;

import com.crackware.erasmus.data.model.School;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * Class which contains properties and functions for response of School class
 */
public class ResponseSchools {
    private Set<School> schools;
}
