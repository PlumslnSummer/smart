package com.example.teacherdata.api;



import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface HttpbinService {

//    @GET("get")
//    Call<ResponseBody> get(@Query("title") String title,@Query("images") String images);
    @GET("get")
    Call<ResponseBody> get();

    @POST("post")
    @FormUrlEncoded
    Call<ResponseBody> postForm(@Field("title") String title,@Field("images") String images);

    @POST("post")
    @FormUrlEncoded
    Call<ResponseBody> postBody(@Body RequestBody body);

    //使用上面
//    FormBody formbody=new FormBody.Builder().add("a","1").add("b","2").build();
//    Response<ResponseBody> res=httpbinServices.postBody(formbody).execute();
//    sout(res.body().string());

    /**
     * pageNUm=1,2,3...，可以加用户名和密码
     * 1,android,name,pwd
     * @param path
     * @return
     */
    @POST("/xxx/{pageNum}")
    @FormUrlEncoded
    Call<ResponseBody> postpath(@Path("pageNum")String path, @Header("os")String os,@Field("username") String username,@Field("pwd") String pwd);

    /**
     * Call<ResponseBody> res=httpbinservices.postWithHeaders();
     * @return
     */
    @POST("post")
    @Headers({"os:android","version:1.0"})
    Call<ResponseBody> postWithHeaders();


    /**
     * Response<ResponseBody> res=httpbinServices.postUrl("url").execute();
     * @param url
     * @return
     */
    @POST
    Call<ResponseBody> postUrl(@Url String url);

    /**
     *
     * @param category
     * @param type
     * @param page
     * @param count
     * @return
     */
    @POST("v2/data/category/{category}/type/{type}/page/{page}/count/{count}")
    Call<ResponseBody> posttypepath(@Path("category")String category,@Path("type")String type,@Path("page")String page,@Path("count")String count);

    @GET("v2/data/category/{category}/type/{type}/page/{page}/count/{count}")
    Call<ResponseBody> getArticle(@Path("category")String category, @Path("type")String type, @Path("page")int page, @Path("count")int count);

    @GET("v2/categories/Article")
    Call<ResponseBody> getAClass();

    @GET("v2/banners")
    Call<ResponseBody> getBanner();
}
