package com.favesolution.lntretrofit1.network;

import com.favesolution.lntretrofit1.entities.EmployeeList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
        @GET("list_employee")
        Call<EmployeeList> getEmployeeData();

}
