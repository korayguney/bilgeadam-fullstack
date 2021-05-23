package com.bilgeadam.bilgeadamfullstack.dto;

import com.bilgeadam.bilgeadamfullstack.model.Gender;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private String name;
    private String email;
    private Gender gender;

}
