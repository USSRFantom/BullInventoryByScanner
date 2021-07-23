package ussrfantom.com.example.bullinventorybyscanner.searchke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ussrfantom.com.example.bullinventorybyscanner.R;
import ussrfantom.com.example.bullinventorybyscanner.adapters.EmployeeAdapter;
import ussrfantom.com.example.bullinventorybyscanner.pojo.Shop;

public class SearchKe extends AppCompatActivity {

    private RecyclerView recyclerViewShop;
    private EmployeeAdapter adapter;
    private Button buttonSearch;
    private Spinner spinnerSearch;
    private String stringShop;
    private String[] stringsShops;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach_ke);
        spinnerSearch = findViewById(R.id.spinnerShops);
        buttonSearch = findViewById(R.id.buttonSearch);
        recyclerViewShop = findViewById(R.id.recyclerViewShop);
        adapter = new EmployeeAdapter();
        recyclerViewShop.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewShop.setAdapter(adapter);
        List<Shop> shops = new ArrayList<>();
        Shop shop1 = new Shop();
        shop1.setName("Каджары");
        shop1.setNamePcd("Кмопьютер директора");
        shop1.setPcdSerialNumber("2312312");
        shop1.setPcdKe("2312312");
        shop1.setNameServer("Сервер");
        shop1.setServerSerialNumber("2312312");
        shop1.setServerKe("2312312");
        shop1.setRouterMaster("Роутер Мастер");
        shop1.setRouterMasterSerialNumber("2312312");
        shop1.setRouterMasterKe("2312312");
        shop1.setRouterReserve("Роутер резерв");
        shop1.setRouterReserveSerialNumber("2312312");
        shop1.setRouterReserveKe("2312312");
        shop1.setUpsPcd("ИБП ПКД");
        shop1.setUpsPcdSerialNumber("2312312");
        shop1.setUpsPcdKe("2312312");
        shop1.setUpsServer("ИБП сервер");
        shop1.setUpsServerSerialNumber("2312312");
        shop1.setUpsServerKe("2312312");
        shop1.setMonitorPcd("Монитор");
        shop1.setMonitorPcdSerialNumber("2312312");
        shop1.setMonitorPcdKe("2312312");
        shop1.setPrintPcd("Принтер");
        shop1.setPrintPcdSerialNumber("2312312");
        shop1.setPrintPcdKe("2312312");
        shop1.setTsd1("ТСД1");
        shop1.setTsd1SerialNumber("2312312");
        shop1.setTsd1PcdKe("2312312");
        shop1.setTsd2("ТСД2");
        shop1.setTsd2SerialNumber("2312312");
        shop1.setTsd2PcdKe("2312312");
        shop1.setTsd3("ТСД3");
        shop1.setTsd3SerialNumber("1241241421");
        shop1.setTsd3PcdKe("3123123121");
        shops.add(shop1);
        adapter.setShops(shops);











        //получаем магазин при нажатии кнопки начало
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = spinnerSearch.getSelectedItemPosition();
                stringsShops = getResources().getStringArray(R.array.shops);
                stringShop = stringsShops[position];
                Log.i("Проверка ->>>>>", stringShop);
            }
        });
        //получаем магазин при нажатии кнопки конец

    }
}