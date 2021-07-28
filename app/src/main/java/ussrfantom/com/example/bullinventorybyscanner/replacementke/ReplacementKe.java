package ussrfantom.com.example.bullinventorybyscanner.replacementke;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

import ussrfantom.com.example.bullinventorybyscanner.R;
import ussrfantom.com.example.bullinventorybyscanner.adapters.EmployeeReplacementAdapter;
import ussrfantom.com.example.bullinventorybyscanner.pojo.Shop;

public class ReplacementKe extends AppCompatActivity implements EmployeeReplacement {

    private RecyclerView recyclerViewReplacementEmployees;
    private EmployeeReplacementAdapter adapter;
    private Button buttonSearch1;
    private Spinner spinnerSearch1;
    private List<Shop> arrayListShop1;
    private List<Shop> arrayListShops1;
    private EmployeeListReplacementPresenter presenter;
    private Shop shop;
    final Activity activity = this;
    private String searchResultCode;
    private int myPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replacement_ke);
        presenter = new EmployeeListReplacementPresenter(this);
        spinnerSearch1 = findViewById(R.id.spinnerShops1);
        buttonSearch1 = findViewById(R.id.buttonSearch1);
        recyclerViewReplacementEmployees = findViewById(R.id.recyclerViewShopReplacement);
        adapter = new EmployeeReplacementAdapter();
        adapter.setShops(new ArrayList<>());
        recyclerViewReplacementEmployees.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewReplacementEmployees.setAdapter(adapter);
        presenter.loadData();
        arrayListShop1 = new ArrayList<>();





        //проверка на нажите одной из кнопок начало
        adapter.setOnButtonClick(new EmployeeReplacementAdapter.OnButtonClick() {
            @Override
            public void OnButtonClickShop(int position) {
                scan();
                switch (position){
                    case (1):
                        myPosition = 1;

                    case (2):
                        myPosition = 2;
                    default:
                        Toast.makeText(ReplacementKe.this, "Ошибка", Toast.LENGTH_SHORT).show();

                        break;
                }
            }
        });





        //проверка на нажите одной из кнопок конец

        //получаем магазин при нажатии кнопки начало
        buttonSearch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = spinnerSearch1.getSelectedItemPosition(); // получаем позицию элемента
                arrayListShop1.add(arrayListShops1.get(position));
                adapter.setShops(arrayListShop1);
            }
        });

        //конец

        //Удаление свайпом начало
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                remove(viewHolder.getAdapterPosition());
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerViewReplacementEmployees);
        //Удаление свайпом конец
    }



    //установка данных начало
    public void showData(List<Shop> employeeShop1){
        arrayListShops1 = employeeShop1;
        adapter.setShops(arrayListShop1);
    }
    //установка данных конец

    //удаление элемента из смписка начало
    private void remove (int position){
        arrayListShop1.remove(position);
        adapter.notifyDataSetChanged();
    }
    //удаление элемента из смписка конец

    //сканирование кода начало
    private  void scan(){
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scan");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Алярма", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                searchResultCode = result.getContents();
                showDataScanner(myPosition, searchResultCode);

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    public void showDataScanner(int position, String result){
        switch (position){
            case (1):
                shop = arrayListShop1.get(0);
                shop.setPcdSerialNumber(result);
                arrayListShop1.add(shop);
                remove(0);
                showData(arrayListShop1);
                adapter.notifyDataSetChanged();

            case (2):
                shop = arrayListShop1.get(0);
                shop.setPcdSerialNumber(result);
                arrayListShop1.add(shop);
                remove(0);
                showData(arrayListShop1);
                adapter.notifyDataSetChanged();
            default:
                Toast.makeText(ReplacementKe.this, "Ошибка", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    //сканирование кода конец


    //отсутсвие интернета начало
    public void showError(){
        Toast.makeText(this, "Ошибка подключения к интернету! Вылези из бочки", Toast.LENGTH_SHORT).show();
    }
    //отсутсвие интернета конец

    //закрытие приложение и остановка загрузки данных начало
    @Override
    protected void onDestroy() {
        presenter.disposeDisposable();
        super.onDestroy();
    }
    //закрытие приложение и остановка загрузки данных конец


}