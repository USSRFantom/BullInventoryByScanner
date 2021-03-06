package ussrfantom.com.example.bullinventorybyscanner.searchke.employess;

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

import java.util.ArrayList;
import java.util.List;

import ussrfantom.com.example.bullinventorybyscanner.R;
import ussrfantom.com.example.bullinventorybyscanner.adapters.EmployeeAdapter;
import ussrfantom.com.example.bullinventorybyscanner.pojo.Shop;

public class SearchKe extends AppCompatActivity  implements EmployeesListView{


    private RecyclerView recyclerViewShop;
    private EmployeeAdapter adapter;
    private Button buttonSearch;
    private Spinner spinnerSearch;
    private List<Shop> arrayListShop;
    private List<Shop> arrayListShops;
    private EmployeeListPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach_ke);
        presenter = new EmployeeListPresenter(this);
        spinnerSearch = findViewById(R.id.spinnerShops);
        buttonSearch = findViewById(R.id.buttonSearch);
        recyclerViewShop = findViewById(R.id.recyclerViewShop);
        adapter = new EmployeeAdapter();
        adapter.setShops(new ArrayList<>());
        recyclerViewShop.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewShop.setAdapter(adapter);
        presenter.loadData();
        arrayListShop = new ArrayList<>();

        //получаем магазин при нажатии кнопки начало
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = spinnerSearch.getSelectedItemPosition(); // получаем позицию элемента
                arrayListShop.add(arrayListShops.get(position));
                adapter.setShops(arrayListShop);
            }
        });

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
        itemTouchHelper.attachToRecyclerView(recyclerViewShop);
        //Удаление свайпом конец
    }

    //установка данных начало
    public void showData(List<Shop> employeeShop1){
        arrayListShops = employeeShop1;
        adapter.setShops(arrayListShop);
    }
    //установка данных конец

    //удаление элемента из смписка начало
    private void remove (int position){
        arrayListShop.remove(position);
        adapter.notifyDataSetChanged();
    }
    //удаление элемента из смписка конец

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