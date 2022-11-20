package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActionAdapter extends RecyclerView.Adapter<RecyclerActionAdapter.ViewHolder>{
    Context context;
    ArrayList<ContactModel> arrAction;
    private static RecyclerActionAdapter.Listener listener;
    RecyclerActionAdapter(Context context, ArrayList<ContactModel> arrAction){
        this.context= context;
        this.arrAction= arrAction;

    }

    public static void setListener(RecyclerActionAdapter.Listener lis) {
        listener=lis;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.action_row,parent, false);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgAction.setImageResource(arrAction.get(position).img);
        holder.txtName.setText(arrAction.get(position).name);
    }

    @Override
    public int getItemCount() {
        return arrAction.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView imgAction;
        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.Name1);
            imgAction = itemView.findViewById(R.id.Img1);
        }
    }
   public static interface Listener{
        public void onClick(int position);
    }
}
