package com.dugun.network;

import com.dugun.model.TestModel;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface TestService {
  @GET("/posts/{id}") Observable<TestModel> getTestModel(
      @Path("id") String id
  );
}
