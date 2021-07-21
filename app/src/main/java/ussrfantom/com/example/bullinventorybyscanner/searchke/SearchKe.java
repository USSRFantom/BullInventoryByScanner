package ussrfantom.com.example.bullinventorybyscanner.searchke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import ussrfantom.com.example.bullinventorybyscanner.R;

public class SearchKe extends AppCompatActivity {

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