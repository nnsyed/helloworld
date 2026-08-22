package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

// This starts the server on a random free port for safety
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloworldApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testHelloEndpoint() {
        // 1. Construct the local URL dynamically
        String url = "http://localhost:" + port + "/hello";
        
        // 2. Make an actual local network request
        String response = this.restTemplate.getForObject(url, String.class);
        
        // 3. Assert the result matches perfectly
        assertThat(response).isEqualTo("Hello World");
    }
}
