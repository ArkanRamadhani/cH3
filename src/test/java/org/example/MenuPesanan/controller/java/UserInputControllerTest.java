package org.example.MenuPesanan.controller;

import org.example.MenuPesanan.model.Invoice;
import org.example.MenuPesanan.model.Pesanan;
import org.example.MenuPesanan.model.Product;
import org.example.MenuPesanan.service.PesananService;
import org.example.MenuPesanan.view.MenuView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserInputControllerTest {

    @Mock
    private Scanner scanner;

    @Mock
    private PesananService pesananService;

    @InjectMocks
    private UserInputController userInputController;

    @BeforeEach
    public void setUp() {
        userInputController = new UserInputController();
    }

    @Test
    public void testInputMainMenuWhenUserEntersZeroThenExit() {
        when(scanner.nextInt()).thenReturn(0);
        Invoice invoice = userInputController.inputMainMenu();
        assertThat(invoice).isNull();
        verify(scanner, times(1)).nextInt();
    }

    @Test
    public void testInputMainMenuWhenUserEntersValidOptionThenInputMenuDetail() {
        when(scanner.nextInt()).thenReturn(1, 2);
        Product product = MenuView.PRODUCTS.get(0);
        List<Pesanan> pesananList = new ArrayList<>();
        pesananList.add(Pesanan.builder()
                .namaProduk(product.getNamaProduk())
                .quantity(2)
                .totalHarga(2 * product.getHarga())
                .build());
        when(pesananService.totalPembayaran(pesananList)).thenReturn(2 * product.getHarga());
        Invoice invoice = userInputController.inputMainMenu();
        assertThat(invoice.getPesananList()).isEqualTo(pesananList);
        assertThat(invoice.getTotalPembayaran()).isEqualTo(2 * product.getHarga());
        verify(scanner, times(2)).nextInt();
    }

    @Test
    public void testInputMainMenuWhenUserEntersInvalidOptionThenNoAction() {
        when(scanner.nextInt()).thenReturn(99);
        Invoice invoice = userInputController.inputMainMenu();
        assertThat(invoice.getPesananList()).isEmpty();
        assertThat(invoice.getTotalPembayaran()).isEqualTo(0);
        verify(scanner, times(1)).nextInt();
    }
}