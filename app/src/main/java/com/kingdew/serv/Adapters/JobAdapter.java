package com.kingdew.serv.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kingdew.serv.Job;
import com.kingdew.serv.JobViewActivity;
import com.kingdew.serv.R;

import java.util.ArrayList;

import io.paperdb.Paper;

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
        Paper.init(context);
        holder.ttitle.setText(jobs.get(position).getJobName());
        holder.tprice.setText(jobs.get(position).getJobPrice());

        holder.itemView.setOnClickListener(view -> {
            //Toast.makeText(context, ""+jobs.get(position).getJobID(), Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(context, JobViewActivity.class);
            intent.putExtra("jobID",jobs.get(position).getJobID());
            Paper.book().write("jobID",String.valueOf(jobs.get(position).getJobID()));
            context.startActivity(intent);

        });

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
