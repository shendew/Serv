package com.kingdew.serv.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kingdew.serv.Job;
import com.kingdew.serv.R;

import java.util.ArrayList;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.ViewHolder> {

    Context context;
    ArrayList<Job> jobs;

    public JobAdapter(Context context, ArrayList<Job> jobs) {
        this.context = context;
        this.jobs = jobs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.job_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ttitle.setText(jobs.get(position).getJobName());
        holder.tprice.setText(jobs.get(position).getJobPrice());

    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ttitle,tprice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ttitle=itemView.findViewById(R.id.title);
            tprice=itemView.findViewById(R.id.price);
        }
    }
}
