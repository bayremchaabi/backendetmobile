package isetb.tp5.mindcoach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateSessionActivity extends AppCompatActivity {

    private EditText editTitle, editDescription, editStatus, editNotes, editClientName;
    private Button btnSave;
    private SessionApi sessionApi;

    private Long sessionId; // Store the session ID for updating

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_session);

        // Initialize views
        editTitle = findViewById(R.id.editTitle);
        editDescription = findViewById(R.id.editDescription);
        editStatus = findViewById(R.id.editStatus);
        editNotes = findViewById(R.id.editNotes);
        editClientName = findViewById(R.id.editClientName);
        btnSave = findViewById(R.id.btnSave);

        // Initialize Retrofit API
        sessionApi = ApiClient.getRetrofitInstance().create(SessionApi.class);

        // Get the session data passed from the previous activity (e.g., MainActivity or session list)
        Intent intent = getIntent();
        sessionId = intent.getLongExtra("session_id", -1); // Retrieve the session ID
        editTitle.setText(intent.getStringExtra("session_title"));
        editDescription.setText(intent.getStringExtra("session_description"));
        editStatus.setText(intent.getStringExtra("session_status"));
        editNotes.setText(intent.getStringExtra("session_notes"));
        editClientName.setText(intent.getStringExtra("session_client_name"));

        // Set up the Save button listener
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Collect the updated data from user input
                String title = editTitle.getText().toString();
                String description = editDescription.getText().toString();
                String status = editStatus.getText().toString();
                String notes = editNotes.getText().toString();
                String clientName = editClientName.getText().toString();

                // Create a new session object with updated data
                Session updatedSession = new Session(title, description, status, notes, clientName);

                // Call the update session API endpoint
                sessionApi.updateSession(sessionId, updatedSession).enqueue(new retrofit2.Callback<Void>() {
                    @Override
                    public void onResponse(retrofit2.Call<Void> call, retrofit2.Response<Void> response) {
                        if (response.isSuccessful()) {
                            // On success, show a toast and finish the activity
                            Toast.makeText(UpdateSessionActivity.this, "Session updated successfully!", Toast.LENGTH_SHORT).show();
                            finish(); // Close the activity
                        } else {
                            // On failure, show the error message
                            Toast.makeText(UpdateSessionActivity.this, "Failed to update session!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<Void> call, Throwable t) {
                        // On failure (e.g., no internet), show the error message
                        Toast.makeText(UpdateSessionActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
