package com.wingjay.jianshi.network;

import com.google.gson.JsonObject;
import com.wingjay.jianshi.bean.ImagePoem;
import com.wingjay.jianshi.bean.ShareContent;
import com.wingjay.jianshi.bean.SyncModel;
import com.wingjay.jianshi.bean.User;
import com.wingjay.jianshi.bean.VersionUpgrade;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface UserService {

  @FormUrlEncoded
  @POST("user/signup")
  Observable<JsonDataResponse<User>> signup(@Field("email") String email,
                                            @Field("password") String password);

  @FormUrlEncoded
  @POST("user/login")
  Observable<JsonDataResponse<User>> login(@Field("email") String email,
                                           @Field("password") String password);

  @POST("sync")
  Observable<JsonDataResponse<SyncModel>> sync(@Body JsonObject jsonObject);

  @GET("home/image_poem")
  Observable<JsonDataResponse<ImagePoem>> getImagePoem(@Query("width") int width, @Query("height") int height);

  @POST("logs/sync")
  Observable<JsonDataResponse<JsonObject>> syncLog(@Body JsonObject jsonObject);

  @GET("app/share")
  Observable<JsonDataResponse<ShareContent>> getShareContent();

  @GET("user/upgrade")
  Observable<JsonDataResponse<VersionUpgrade>> checkUpgrade();
}
