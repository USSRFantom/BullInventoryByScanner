package ussrfantom.com.example.bullinventorybyscanner.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeShop {

    @SerializedName("shop")
    @Expose
    private List<Shop> shop = null;

    public List<Shop> getShop() {
        return shop;
    }

    public void setShop(List<Shop> shop) {
        this.shop = shop;
    }
}
