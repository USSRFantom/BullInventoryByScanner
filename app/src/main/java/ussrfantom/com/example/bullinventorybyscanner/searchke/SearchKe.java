package ussrfantom.com.example.bullinventorybyscanner.searchke;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
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
                            //adapter.setShops(employeeShop.getShop());
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Log.i("Ошбика", "<------------------");
                            Toast.makeText(SearchKe.this, "Ошибка получения данных", Toast.LENGTH_SHORT).show();
                        }
                    });
        compositeDisposable.add(disposable);






        //получаем магазин при нажатии кнопки начало
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = spinnerSearch.getSelectedItemPosition();
                arrayListShop.add(arrayListShops.get(position));
                Log.i("Зашли", "<------------------");
                adapter.setShops(arrayListShop);
            }
        });
        //получаем магазин при нажатии кнопки конец



    }

    @Override
    protected void onDestroy() {
        if (compositeDisposable !=  null){
            compositeDisposable.dispose();
        }
        super.onDestroy();
    }
}