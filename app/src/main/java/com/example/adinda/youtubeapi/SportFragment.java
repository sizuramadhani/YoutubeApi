package com.example.adinda.youtubeapi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adinda.youtubeapi.ResponseYoutube.ItemsItem;
import com.example.adinda.youtubeapi.ResponseYoutube.ResponYoutube;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SportFragment extends Fragment {


    RecyclerView recyclerView;
    public SportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sport, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycle);

        //method baru
        ambilData();

        return v;

    }

    private void ambilData() {
        new ConfigRetrofit().service.getVideo("snippet","25","Sport","ID","Sport","AIzaSyBN7uRz3EXC4S0246R7hGdL2s4nc3KhqMI").
                enqueue(new Callback<ResponYoutube>() {
                    @Override
                    public void onResponse(Call<ResponYoutube> call, Response<ResponYoutube> response) {
                        //cek respon
                        if (response.isSuccessful()){
                            //ngambil semua json yang ada
                            ResponYoutube alljson = response.body();

                            //ambil item
                            List<ItemsItem> data = alljson.getItems();

                            Log.d("data:",data.toString());

                            //masukin ke adapter
                            AdapterRv adapter = new AdapterRv(data);

                            //set adapter ke recyce view
                            recyclerView.setAdapter(adapter);

                            //add layout adapter
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                            //buet ngecek
                            Log.d("respon json", alljson.toString());
                            Log.d("respon adapter", String.valueOf(adapter.getItemCount()));

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponYoutube> call, Throwable t) {

                        Log.d ("error : ", t.getMessage());

                    }
                });

    }

}
