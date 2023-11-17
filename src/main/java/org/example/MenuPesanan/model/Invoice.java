package org.example.MenuPesanan.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    private List<Pesanan> pesananList;
    private Integer totalPembayaran;

}
