package com.yy.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class yyktException extends RuntimeException {
    private Integer code;
    private String msg;
}