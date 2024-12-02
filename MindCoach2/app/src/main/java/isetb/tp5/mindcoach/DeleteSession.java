package isetb.tp5.mindcoach;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteSession {

    private SessionApi sessionApi;

    public DeleteSession(SessionApi sessionApi) {
        this.sessionApi = sessionApi;
    }

    public void deleteSession(Long sessionId, final DeleteSessionCallback callback) {
        sessionApi.deleteSession(sessionId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess();
                } else {
                    callback.onFailure("Failed to delete session");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure("Error: " + t.getMessage());
            }
        });
    }

    public interface DeleteSessionCallback {
        void onSuccess();
        void onFailure(String error);
    }
}
