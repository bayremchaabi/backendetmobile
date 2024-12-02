package isetb.tp5.mindcoach;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddSessionActivity extends AppCompatActivity {

    private EditText editTitle, editDescription, editStatus, editNotes, editClientName;
    private Button btnAddSession;
    private SessionApi sessionApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_session);

        // Initialize views
        editTitle = findViewById(R.id.edit_title);
        editDescription = findViewById(R.id.edit_description);
        editStatus = findViewById(R.id.edit_status);
        editNotes = findViewById(R.id.edit_notes);
        editClientName = findViewById(R.id.edit_client_name);
        btnAddSession = findViewById(R.id.btn_add_session);

        // Initialize Retrofit API
        sessionApi = ApiClient.getRetrofitInstance().create(SessionApi.class);

        // Set up the Add button listener
        btnAddSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Collect input data
                String title = editTitle.getText().toString();
                String description = editDescription.getText().toString();
                String status = editStatus.getText().toString();
                String notes = editNotes.getText().toString();
                String clientName = editClientName.getText().toString();

                // Validate inputs
                if (title.isEmpty() || description.isEmpty() || status.isEmpty() || notes.isEmpty() || clientName.isEmpty()) {
                    Toast.makeText(AddSessionActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create a new Session object
                Session newSession = new Session(title, description, status, notes, clientName);

                // Use Retrofit to add the new session
                sessionApi.addSession(newSession).enqueue(new Callback<Session>() {
                    @Override
                    public void onResponse(Call<Session> call, Response<Session> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(AddSessionActivity.this, "Session added successfully!", Toast.LENGTH_SHORT).show();
                            finish(); // Close the activity after adding the session
                        } else {
                            Toast.makeText(AddSessionActivity.this, "Failed to add session", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Session> call, Throwable t) {
                        Toast.makeText(AddSessionActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
