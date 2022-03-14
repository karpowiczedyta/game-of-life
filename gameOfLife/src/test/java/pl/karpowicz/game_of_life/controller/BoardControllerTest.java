package pl.karpowicz.game_of_life.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BoardControllerTest {

        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void shouldGenerateNextStep() {
            //given
            String json = "[[{\"state\":false,\"newState\":false}]]";
            //and
            var headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            var entity = new HttpEntity<>(json, headers);
            //when
            var response = restTemplate.exchange("/next-step", HttpMethod.POST, entity, Void.class);
            //then
            assertTrue(response.getStatusCode().is2xxSuccessful());
        }

}