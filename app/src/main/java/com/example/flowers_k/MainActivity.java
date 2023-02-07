package com.example.flowers_k;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView errors;
    private ProgressBar pBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errors= (TextView) findViewById(R.id.errors);
        pBar = (ProgressBar)findViewById(R.id.progressBar);
        pBar.setVisibility(View.INVISIBLE);

        pBar.setVisibility(View.VISIBLE);
        PetsAPI petAPI = PetsAPI.retrofit.create(PetsAPI.class);

        final Call<Pet> call = petAPI.getData("1024");

        call.enqueue(new Callback<Pet>() {
            @Override
            public void onResponse(Call<Pet> call, Response<Pet> response) {
                if (response.isSuccessful()) {
                    Pet result = response.body();
                    final TextView petName = (TextView) findViewById(R.id.petName);
                    petName.setText(result.getName());
                    pBar.setVisibility(View.INVISIBLE);
                } else {

                    ResponseBody errorBody = response.errorBody();
                    try {
                        Toast.makeText(MainActivity.this, errorBody.string(),
                                Toast.LENGTH_SHORT).show();
                        pBar.setVisibility(View.INVISIBLE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Pet> call, Throwable t) {
                errors.setText("Ошибка.");
                pBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}