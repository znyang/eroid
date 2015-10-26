package com.zen.android.center.sdk.protocol;


import com.zen.android.center.sdk.model.LoginSession;
import com.zen.android.center.sdk.model.UserSession;
import com.zen.android.center.sdk.protocol.entry.UserEntry;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * @author zeny
 * @version 2015.10.26
 */
public interface ClientApi {

    String KEY_APPLICATION_ID  = "X-AVOSCloud-Application-Id";
    String KEY_APPLICATION_KEY = "X-AVOSCloud-Application-Key";

    String FIELD_USERNAME = "username";
    String FIELD_PASSWORD = "password";

    /**
     * 注册
     *
     * @return
     */
    @POST("/users")
    Observable<UserSession> register(@Body UserEntry userEntry);

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @GET("/login")
    Observable<LoginSession> login(@Query(FIELD_USERNAME) String username,
                                   @Query(FIELD_PASSWORD) String password);

}
