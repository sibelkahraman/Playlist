package com.bootcamp.playlist.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwaggerControllerTest {
    @Test
    public void shouldReturnSwaggerURL(){
        //Arrange
        SwaggerController swagger = new SwaggerController();
        //Act
        String result = swagger.home();
        //Assert
        assertEquals("redirect:/swagger-ui.html",result);
    }
}
