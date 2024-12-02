package isetb.tp5.mindcoach;

public class Session {
    private Long id; // This is a Long type field (for example, session ID)
    private String title;
    private String description;
    private String status;
    private String notes;
    private String clientName;

    // Constructor for creating a new session
    public Session(String title, String description, String status, String notes, String clientName) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.notes = notes;
        this.clientName = clientName;
    }

    // Getter and Setter methods for each field (including id)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
