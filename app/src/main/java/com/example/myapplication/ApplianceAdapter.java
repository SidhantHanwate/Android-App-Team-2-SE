package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ApplianceAdapter extends RecyclerView.Adapter<ApplianceAdapter.ViewHolder>{
    Context context;
    ArrayList<ApplianceModel> arrAction;
    private static ApplianceAdapter.Listener listener;
    ApplianceAdapter(Context context, ArrayList<ApplianceModel> arrAction){
        this.context= context;
        this.arrAction= arrAction;
    }

    public static void setListener(ApplianceAdapter.Listener lis) {
        listener=lis;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.consume_row,parent, false);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt1.setText(arrAction.get(position).name);
        holder.txt2.setText(arrAction.get(position).textView);
        holder.txt3.setText(arrAction.get(position).name1);
        holder.txt4.setText(arrAction.get(position).textView1);
        holder.txt5.setText(arrAction.get(position).name2);
        holder.txt6.setText(arrAction.get(position).textView2);
    }

    @Override
    public int getItemCount() {
        return arrAction.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt1,txt2,txt3,txt4,txt5,txt6;
        public ViewHolder(View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.Name);
            txt2 = itemView.findViewById(R.id.textView);
            txt3 = itemView.findViewById(R.id.Name1);
            txt4= itemView.findViewById(R.id.textView1);
            txt5 = itemView.findViewById(R.id.Name2);
            txt6 = itemView.findViewById(R.id.textView2);
        }
    }
    public static interface Listener{
        public void onClick(int position);
    }
}