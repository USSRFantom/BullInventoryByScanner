package ussrfantom.com.example.bullinventorybyscanner.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import ussrfantom.com.example.bullinventorybyscanner.pojo.EmployeeShop;


public interface ApiService {
    @GET("project_info.json")
    Observable<EmployeeShop> getEmployeesShop();
    //Observable <EmployeeShop> getEmployeesShop();

}
