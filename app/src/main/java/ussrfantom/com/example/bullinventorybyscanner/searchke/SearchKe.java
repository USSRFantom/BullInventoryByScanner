package ussrfantom.com.example.bullinventorybyscanner.searchke;

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

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ussrfantom.com.example.bullinventorybyscanner.R;
import ussrfantom.com.example.bullinventorybyscanner.adapters.EmployeeAdapter;
import ussrfantom.com.example.bullinventorybyscanner.api.ApiFactory;
import ussrfantom.com.example.bullinventorybyscanner.api.ApiService;
import ussrfantom.com.example.bullinventorybyscanner.pojo.EmployeeShop;
import ussrfantom.com.example.bullinventorybyscanner.pojo.Shop;

public class SearchKe extends AppCompatActivity {


    private RecyclerView recyclerViewShop;
    private EmployeeAdapter adapter;
    private Button buttonSearch;
    private Spinner spinnerSearch;
    private List<Shop> arrayListShop;
    private ArrayList<Shop> arrayListShops;
    private Disposable disposable;
    private CompositeDisposable compositeDisposable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach_ke);
        spinnerSearch = findViewById(R.id.spinnerShops);
        buttonSearch = findViewById(R.id.buttonSearch);
        recyclerViewShop = findViewById(R.id.recyclerViewShop);
        adapter = new EmployeeAdapter();
        adapter.setShops(new ArrayList<>());
        recyclerViewShop.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewShop.setAdapter(adapter);
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        compositeDisposable = new CompositeDisposable();

        disposable = apiService.getEmployeesShop()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<EmployeeShop>() {
                        @Override
                        public void accept(EmployeeShop employeeShop) throws Exception {
                            arrayListShop = new ArrayList<>();
                            arrayListShops = (ArrayList<Shop>) employeeShop.getShop();
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Toast.makeText(SearchKe.this, "Ошибка получения данных", Toast.LENGTH_SHORT).show();
                        }
                    });
        compositeDisposable.add(disposable);


        //получаем магазин при нажатии кнопки начало
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = spinnerSearch.getSelectedItemPosition(); // получаем позицию элемента
                arrayListShop.add(arrayListShops.get(position)); //добавляем 1 обьект в массив List
                adapter.setShops(arrayListShop); // устанавливаем адаптеру наш обьект
            }
        });
        //получаем магазин при нажатии кнопки конец


        //Слушатель на нажатие на магазин и удалени его начало
        adapter.setOnShopClickListener(new EmployeeAdapter.OnShopClickListener() {
            @Override
            public void onShopClick(int position) {
                Toast.makeText(SearchKe.this, "Удерживайте палец 3 секунды, чтобы удалить элемент", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLogClick(int position) {
                remove(position);
            }
        });
        //Слушатель на нажатие на магазин и удалени его конец

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
    //удаление элемента из смписка начало
    private void remove (int position){
        arrayListShop.remove(position);
        adapter.notifyDataSetChanged();
    }
    //удаление элемента из смписка конец
    @Override
    protected void onDestroy() {
        if (compositeDisposable !=  null){
            compositeDisposable.dispose();
        }
        super.onDestroy();
    }
}