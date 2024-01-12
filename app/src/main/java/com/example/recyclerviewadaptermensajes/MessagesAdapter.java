package com.example.recyclerviewadaptermensajes;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {
    private AppCompatActivity context;

    private int resource;
    private Cursor cursor;

    public MessagesAdapter(Context context, int resource, Cursor cursor){
        this.context=(AppCompatActivity) context;
        this.resource=resource;
        this.cursor=cursor;
    }

    @NonNull
    @Override
    public MessagesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= context.getLayoutInflater().inflate(resource,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesAdapter.ViewHolder holder, int position) {
        cursor.moveToPosition(position);
        holder.txtUser.setText(cursor.getString(1));
        holder.txtMessage.setText(cursor.getString(2));
        holder.txtReceptor.setText(cursor.getString(3));

    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtUser,txtMessage,txtReceptor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtUser=itemView.findViewById(R.id.txtUser);
            this.txtMessage=itemView.findViewById(R.id.txtMensaje);
            this.txtReceptor=itemView.findViewById(R.id.txtReceptor);
        }
    }
}
