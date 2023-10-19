package com.demonapptilus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoNapptilusApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoNapptilusApplicationTests {

    @Test
    @DisplayName("When run then application "
            + "Then the context is loaded correctly")
    void main() {
        DemoNapptilusApplication.main(new String[]{});
    }

}

