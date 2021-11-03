package com.richieoscar.chatty;

import com.richieoscar.chatty.service.UserRegistrationService;
import com.richieoscar.chatty.storage.UserStorageService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChattyApplicationTests {

    @Test
    void testRegisterUser() {
        try {
            UserStorageService.getInstance().addUSer("Oscar");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
