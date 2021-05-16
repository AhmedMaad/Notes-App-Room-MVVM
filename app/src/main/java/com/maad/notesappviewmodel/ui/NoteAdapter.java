package com.maad.notesappviewmodel.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maad.notesappviewmodel.R;
import com.maad.notesappviewmodel.database.NoteModel;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private Activity activity;
    private List<NoteModel> notes;
    private OnItemClickListener onItemClickListener;

    public NoteAdapter(Activity activity, List<NoteModel> notes) {
        this.activity = activity;
        this.notes = notes;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, NoteModel note);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public List<NoteModel> getNotes() {
        return notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new NoteViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.titleTV.setText(notes.get(position).getTitle());
        holder.descTV.setText(notes.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private final TextView titleTV;
        private final TextView descTV;

        public NoteViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.tv_title);
            descTV = itemView.findViewById(R.id.tv_description);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                onItemClickListener.onItemClick(position, notes.get(position));
            });
        }
    }
}
