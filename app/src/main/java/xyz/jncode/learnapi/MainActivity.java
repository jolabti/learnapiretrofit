package xyz.jncode.learnapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.jncode.learnapi.Model.UserModel;
import xyz.jncode.learnapi.Retrofit.RetrofitClientInstance;
import xyz.jncode.learnapi.Retrofit.RetrofitRequest;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result_id);

        RetrofitRequest service = RetrofitClientInstance.getRetrofitInstance().create(RetrofitRequest.class);
        Call<List<UserModel>> call = service.getAllUsers();






        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {


                 if(response.isSuccessful()){
                     String tampung="";

                      for(int i = 0 ; i < response.body().size(); i++){

                            tampung += response.body().get(i).getUserEmail()+" "+response.body().get(i).getUserCreatedAt()+"\n";
                            tvResult.setText(tampung);


                      }


                 }



            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }
        });


    }
}