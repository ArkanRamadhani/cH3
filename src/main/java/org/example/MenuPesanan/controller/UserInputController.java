package org.example.MenuPesanan.controller;



import org.example.MenuPesanan.model.Invoice;
import org.example.MenuPesanan.model.Pesanan;
import org.example.MenuPesanan.model.Product;
import org.example.MenuPesanan.service.PesananService;
import org.example.MenuPesanan.view.MenuView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInputController {

    Scanner scanner = new Scanner(System.in);
    List<Pesanan> pesananList = new ArrayList<>();
    PesananService pesananService = new PesananService();

    public UserInputController() {
//        this.inputMainMenu();
    }

    public Invoice inputMainMenu() {
        MenuView.showMainMenu();
        int userInput = scanner.nextInt();
        if(userInput == 0) {
            System.exit(0);
        }
        if(userInput != 99) {
            try {
                this.inputMenuDetail(userInput);
            } catch (InputMismatchException e) {
//                e.printStackTrace();
            }
        }
        Invoice invoice = new Invoice(pesananList, pesananService.totalPembayaran(pesananList));
        MenuView.showPembayaran(invoice);
        return invoice;
    }

    public void inputMenuDetail(int input) throws InputMismatchException {
        Product product = MenuView.PRODUCTS.get(input-1);
        MenuView.showMenuDetail(product);
        int userInput = scanner.nextInt();
        if(userInput > 0) {
            pesananList.add(Pesanan.builder()
                    .namaProduk(product.getNamaProduk())
                    .quantity(userInput)
                    .totalHarga(userInput * product.getHarga())
                    .build());
        }
        this.inputMainMenu();
    }
}
