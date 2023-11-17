package org.example.MenuPesanan.controller.java;

import org.example.Topic4.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainTest {

    @Test
    public void testMain() {
        Assertions.assertThrows(NullPointerException.class, () -> Main.main(null));
    }

    @Test
    public void testScanner() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        org.example.topic4.Test t = new org.example.topic4.Test();
        t.testing();
    }
}
