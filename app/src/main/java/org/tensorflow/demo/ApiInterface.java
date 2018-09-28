package org.tensorflow.demo;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by starhawk on 31/07/18.
 */

public interface ApiInterface {

    @GET("api.php")
    Call<JsonObject> getDetails(@Query("action") String query,@Query("list") String list,@Query("srsearch") String search,@Query("utf8") String utf,@Query("format") String format);

}
