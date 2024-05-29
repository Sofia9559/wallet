package com.example.wallet;

import java.util.UUID;
import java.util.stream.IntStream;

import com.example.wallet.dto.ChangeWalletAccountDTO;
import com.example.wallet.entity.OperationType;
import org.json.JSONException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

@SpringBootTest()
class WalletTest {

//        static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
//                "postgres:15-alpine"
//        )
//                .withDatabaseName("wallet")
//                .withUsername("wallet")
//                .withPassword("12345");

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();


        @BeforeAll
        static void beforeAll() {
//            postgres.start();
        }

        @AfterAll
        static void afterAll() {
//            postgres.stop();
        }

        @BeforeEach
        void setUp() {

        }

        @Test
        void test() throws JSONException {
            ChangeWalletAccountDTO changeWalletAccountDTO = new ChangeWalletAccountDTO(
                    UUID.fromString("f7783e2a-f160-4f97-aa2c-278d99650588"),
                    100,
                    OperationType.DEPOSIT
            );

            HttpEntity<ChangeWalletAccountDTO> entity = new HttpEntity<>(changeWalletAccountDTO, headers);

            IntStream.range(0, 20).parallel().forEach(i ->
                    restTemplate.exchange(
                            "http://localhost:8080/api/v1/wallet",
                            HttpMethod.POST, entity, String.class)
                    );

            ResponseEntity<String> response2 = restTemplate.exchange(
                    "http://localhost:8080/api/v1/wallets/f7783e2a-f160-4f97-aa2c-278d99650588",
                    HttpMethod.GET, null, String.class);

            String expected = "{\"walletId\":\"f7783e2a-f160-4f97-aa2c-278d99650588\",\"account\":2000}";

            JSONAssert.assertEquals(expected, response2.getBody(), false);

        }
    }
