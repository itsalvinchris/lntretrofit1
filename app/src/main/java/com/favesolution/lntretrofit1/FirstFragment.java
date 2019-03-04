package com.favesolution.lntretrofit1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.favesolution.lntretrofit1.entities.Employee;
import com.favesolution.lntretrofit1.entities.EmployeeList;
import com.favesolution.lntretrofit1.network.ApiService;
import com.favesolution.lntretrofit1.network.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {
    View v;
    ApiService service;
    Call<EmployeeList> call;
    RecyclerView recyclerView;
    EmployeeAdapter adapter;
    ArrayList<Employee> empDataList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_first, container, false);
        recyclerView = v.findViewById(R.id.recycler_view_employee_list);
        adapter = new EmployeeAdapter(empDataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        service = RetrofitBuilder.createService(ApiService.class);
        call = service.getEmployeeData();
        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                empDataList.addAll(response.body().getEmployeeArrayList());
                adapter.notifyDataSetChanged();
                Log.w("MainActivity", "Success " + empDataList );
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Log.w("MainActivity", "onFailure: " + t.getMessage() );
            }
        });
        return v;
    }
}
