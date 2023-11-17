package org.example.MenuPesanan.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pesanan {

    private String namaProduk;
    private int quantity;
    private int totalHarga;

}

