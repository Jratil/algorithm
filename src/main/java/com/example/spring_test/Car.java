package com.example.spring_test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @date 2019-08-09 13:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Car {

    private int width;

    private int height;

    private String name;
}
