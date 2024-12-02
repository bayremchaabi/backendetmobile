package isetb.tp5.mindcoach;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.SessionViewHolder> {

    private List<Session> sessionList;
    private OnSessionActionListener actionListener;

    // Constructor
    public SessionAdapter(List<Session> sessionList, OnSessionActionListener actionListener) {
        this.sessionList = sessionList;
        this.actionListener = actionListener;
    }

    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_session, parent, false);
        return new SessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SessionViewHolder holder, int position) {
        Session session = sessionList.get(position);

        // Set data to views
        holder.title.setText("Title: " + session.getTitle());
        holder.description.setText("Description: " + session.getDescription());
        holder.status.setText("Status: " + session.getStatus());
        holder.notes.setText("Notes: " + session.getNotes());
        holder.clientName.setText("Client Name: " + session.getClientName());

        // Handle Edit Click
        holder.iconEdit.setOnClickListener(v -> {
            if (actionListener != null) {
                actionListener.onEditSession(session);
            }
        });

        // Handle Delete Click
        holder.iconDelete.setOnClickListener(v -> {
            if (actionListener != null) {
                actionListener.onDeleteSession(session);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sessionList.size();
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    // Method to update the session list in the adapter
    public void updateSessionList(List<Session> newSessionList) {
        sessionList.clear();
        sessionList.addAll(newSessionList);
        notifyDataSetChanged();
    }

    public static class SessionViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, status, notes, clientName;
        ImageView iconEdit, iconDelete;

        public SessionViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_title);
            description = itemView.findViewById(R.id.text_description);
            status = itemView.findViewById(R.id.text_status);
            notes = itemView.findViewById(R.id.text_notes);
            clientName = itemView.findViewById(R.id.text_client_name);
            iconEdit = itemView.findViewById(R.id.icon_edit);
            iconDelete = itemView.findViewById(R.id.icon_delete);
        }
    }

    // Interface for session actions
    public interface OnSessionActionListener {
        void onEditSession(Session session);
        void onDeleteSession(Session session);
    }
}
