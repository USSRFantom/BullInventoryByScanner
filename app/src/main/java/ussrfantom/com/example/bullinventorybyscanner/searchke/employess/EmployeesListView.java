package ussrfantom.com.example.bullinventorybyscanner.searchke.employess;

import java.util.List;

import ussrfantom.com.example.bullinventorybyscanner.pojo.Shop;

public interface EmployeesListView {
    void showData (List<Shop> employees);
    void showError();
}

