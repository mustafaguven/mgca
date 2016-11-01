package com.mgcleanarchitecture.di.module.network;

import com.mgcleanarchitecture.network.EndPoints;
import com.mgcleanarchitecture.network.TestService;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module public class RestServicesModule {

  @Provides @Singleton Converter.Factory provideGsonFactory(Gson gson) {
    return GsonConverterFactory.create(gson);
  }

  @Provides @Singleton CallAdapter.Factory provideRxCallAdapterFactory() {
    return RxJavaCallAdapterFactory.create();
  }

  @Provides @Singleton public OkHttpClient provideOkHttpClient(
  ) {
    return new OkHttpClient.Builder()
        //.addInterceptor(headerInterceptor)
        //.addInterceptor(loggingInterceptor)
        .build();
  }

  @Provides @Singleton public TestService provideTestService(
      CallAdapter.Factory callAdapterFactory, Converter.Factory converterFactory,
      OkHttpClient okHttpClient
  ) {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(EndPoints.TEST_SERVICE)
        .addCallAdapterFactory(callAdapterFactory)
        .addConverterFactory(converterFactory)
        .client(okHttpClient)
        .build();
    return retrofit.create(TestService.class);
  }
}
