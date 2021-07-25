package ussrfantom.com.example.bullinventorybyscanner.replacementke;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ussrfantom.com.example.bullinventorybyscanner.R;
import ussrfantom.com.example.bullinventorybyscanner.adapters.EmployeeReplacementAdapter;
import ussrfantom.com.example.bullinventorybyscanner.pojo.Shop;

public class ReplacementKe extends AppCompatActivity {

    private RecyclerView recyclerViewReplacementEmployees;
    private EmployeeReplacementAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replacement_ke);
        recyclerViewReplacementEmployees = findViewById(R.id.recyclerViewShopReplacement);
        adapter = new EmployeeReplacementAdapter();
        recyclerViewReplacementEmployees.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewReplacementEmployees.setAdapter(adapter);
        List<Shop> shops = new ArrayList<>();
        Shop shop1 = new Shop();
        shop1.setName("12312312312");
        shop1.setNamePcd("12312312312");
        shop1.setPcdSerialNumber("12312312312");
        shop1.setPcdKe("12312312312");
        shop1.setNameServer("12312312312");
        shop1.setServerSerialNumber("12312312312");
        shop1.setServerKe("12312312312");
        shop1.setRouterMaster("12312312312");
        shop1.setRouterMasterSerialNumber("12312312312");
        shop1.setRouterMasterKe("12312312312");
        shop1.setRouterReserve("12312312312");
        shop1.setRouterReserveSerialNumber("12312312312");
        shop1.setRouterReserveKe("12312312312");
        shop1.setUpsPcd("12312312312");
        shop1.setUpsPcdSerialNumber("12312312312");
        shop1.setUpsPcdKe("12312312312");
        shop1.setUpsServer("12312312312");
        shop1.setUpsServerSerialNumber("12312312312");
        shop1.setUpsServerKe("12312312312");
        shop1.setMonitorPcd("12312312312");
        shop1.setMonitorPcdSerialNumber("12312312312");
        shop1.setMonitorPcdKe("12312312312");
        shop1.setPrintPcd("12312312312");
        shop1.setPrintPcdSerialNumber("12312312312");
        shop1.setPrintPcdKe("12312312312");
        shop1.setTsd1("12312312312");
        shop1.setTsd1SerialNumber("12312312312");
        shop1.setTsd1PcdKe("12312312312");
        shop1.setTsd2("12312312312");
        shop1.setTsd2SerialNumber("12312312312");
        shop1.setTsd2PcdKe("12312312312");
        shop1.setTsd3("12312312312");
        shop1.setTsd3SerialNumber("12312312312");
        shop1.setTsd3PcdKe("12312312312");
        shops.add(shop1);
        adapter.setShops(shops);


    }
}