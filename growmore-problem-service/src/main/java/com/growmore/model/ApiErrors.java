package com.growmore.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrors {

    LocalDateTime timestamp;
    String message;
    int status;
    String error;

}
