package org.example.ini;

import java.util.List;
import java.util.Map;

public interface OrderService {

    Boolean order(String order, Integer qtyPesanan);
    Boolean payment(Map<String, Integer> pesanan, String pemesan);
    Integer jumlahPesanan(List<String> orders);

}