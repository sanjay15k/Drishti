package org.tensorflow.demo;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by starhawk on 31/07/18.
 */

public interface ApiInterface {

    @GET("{value}")
    Call<ResponseBody> getDetails(@Path("value") String objectToSearch);

}
