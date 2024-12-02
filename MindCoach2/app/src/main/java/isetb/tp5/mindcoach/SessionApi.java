package isetb.tp5.mindcoach;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.List;

public interface SessionApi {

    @POST("sessions")  // Adjust the endpoint as needed
    Call<Session> addSession(@Body Session session);


    @GET("sessions")
    Call<List<Session>> getAllSessions();

    @DELETE("sessions/{id}")
    Call<Void> deleteSession(@Path("id") Long sessionId);  // Changed to Long

    @PUT("sessions/{id}")
    Call<Void> updateSession(@Path("id") Long sessionId, @Body Session session);
}
