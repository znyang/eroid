package com.zen.android.center.sdk.injection.module;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zen.android.center.sdk.CenterConfig;
import com.zen.android.center.sdk.exception.CenterException;
import com.zen.android.center.sdk.exception.DataParseException;
import com.zen.android.center.sdk.model.ErrorEntry;
import com.zen.android.center.sdk.protocol.ClientApi;
import com.zen.android.center.sdk.protocol.IClientConfig;
import com.zen.android.eroid.data.ObjectMapperFactory;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.JacksonConverter;

/**
 * @author yangz
 * @version 2015/6/9.
 */
@Module
public class DataClientModule {

    @Provides
    @Singleton
    public ClientApi provideClientApi(IClientConfig config, RestAdapter.Log log, Converter converter,
                                      RequestInterceptor interceptor, ErrorHandler errorHandler,
                                      Client client) {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(config.getBaseUrl())
                .setLog(log)
                .setConverter(converter)
                .setClient(client)
                .setRequestInterceptor(interceptor)
                .setErrorHandler(errorHandler)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        return adapter.create(ClientApi.class);
    }

    @Provides
    @Singleton
    public Client provideClient() {
        return new OkClient();
    }

    @Provides
    @Singleton
    public IClientConfig provideConfig() {
        return new IClientConfig() {
            @Override
            public String getApplicationId() {
                return CenterConfig.APP_ID;
            }

            @Override
            public String getApplicationKey() {
                return CenterConfig.APP_KEY;
            }

            @Override
            public String getBaseUrl() {
                return CenterConfig.BASE_URL;
            }
        };
    }

    @Provides
    @Singleton
    public RequestInterceptor provideRequestInterceptor(final IClientConfig config) {
        return request -> {
            request.addHeader(ClientApi.KEY_APPLICATION_ID, config.getApplicationId());
            request.addHeader(ClientApi.KEY_APPLICATION_KEY, config.getApplicationKey());
        };
    }

    @Provides
    @Singleton
    public RestAdapter.Log providerLog() {
        return message -> Log.d(CenterConfig.LOG_TAG, message);
    }

    @Provides
    @Singleton
    public Converter provideConverter(ObjectMapper objectMapper) {
        return new JacksonConverter(objectMapper);
    }

    @Provides
    @Singleton
    public ObjectMapper provideObjectMapper() {
        return ObjectMapperFactory.getDefault();
    }

    @Provides
    @Singleton
    public ErrorHandler provideErrorHandler() {
        return err -> {
            switch (err.getKind()) {
                case NETWORK:
                    return new IOException("network error");
                default:
                    ErrorEntry entry = (ErrorEntry) err.getBodyAs(ErrorEntry.class);
                    if (entry != null) {
                        return new CenterException(entry.getError());
                    }
                    return new DataParseException("data parse fail, please retry");
            }
        };
    }

}
