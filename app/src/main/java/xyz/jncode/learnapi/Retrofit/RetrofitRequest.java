package xyz.jncode.learnapi.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import xyz.jncode.learnapi.GSON.GSONApi;
import xyz.jncode.learnapi.Model.UserModel;
import xyz.jncode.learnapi.Sharefile.Link;

public interface RetrofitRequest {

    @GET(Link.SHOW_USER)
    Call<List<UserModel>> getAllUsers();

}
