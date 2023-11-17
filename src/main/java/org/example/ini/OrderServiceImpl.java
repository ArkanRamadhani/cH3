package org.example.ini;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    @Override
    public Boolean order(String order, Integer qtyPesanan) {
        return null;
    }

    @Override
    public Boolean payment(Map<String, Integer> pesanan, String pemesan) {
        pesanan.forEach((k, v) -> {
            // TODO : buat logic untuk payment
        });
        return null;
    }

    @Override
    public Integer jumlahPesanan(List<String> orders) {
        return orders.size();
    }

}
