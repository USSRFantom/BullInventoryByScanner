package ussrfantom.com.example.bullinventorybyscanner.replacementke;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ussrfantom.com.example.bullinventorybyscanner.api.ApiFactory;
import ussrfantom.com.example.bullinventorybyscanner.api.ApiService;
import ussrfantom.com.example.bullinventorybyscanner.pojo.EmployeeShop;

public class EmployeeListReplacementPresenter {
    private CompositeDisposable compositeDisposable;
    private EmployeeReplacement view;

    public EmployeeListReplacementPresenter(EmployeeReplacement view) {
        this.view = view;
    }



    //загрузка данных ьиз интернета начало
    public void loadData(){
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        compositeDisposable = new CompositeDisposable();
        Disposable disposable = apiService.getEmployeesShop()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EmployeeShop>() {
                    @Override
                    public void accept(EmployeeShop employeeShop) throws Exception {
                        view.showData(employeeShop.getShop());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.showError();
                    }
                });
        compositeDisposable.add(disposable);
    }
    //загрузка данных ьиз интернета начало

    //останока потоков начало
    public void disposeDisposable(){
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
    //останока потоков конец
}
