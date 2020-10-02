package com.example.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.modal.BatchExpert;

public class BatchAdapter extends RecyclerView.Adapter<BatchAdapter.MyViewHolder>
{
    private Context context;
    public BatchExpert batchExpert;

    public BatchAdapter(Context context, BatchExpert batchExpert)
    {
        this.context = context;
        this.batchExpert = batchExpert;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.listitem_student_list, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        View view = holder.view;
        TextView name = view.findViewById(R.id.Studentname);
        TextView average = view.findViewById(R.id.StudentAvg);

        name.setText(batchExpert.getStudentName(position));
        average.setText(batchExpert.getStudentAverage(position) + "%");
    }

    @Override
    public int getItemCount()
    {
        return batchExpert.getStudentCount();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        View view;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            this.view = itemView;
            view.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View view)
                {
                    BatchExpert batchExpert = new BatchExpert();
                    TextView name = view.findViewById(R.id.Studentname);
                    TextView average = view.findViewById(R.id.StudentAvg);
                    if(getAdapterPosition() < batchExpert.getStudentCount())
                    {
                        name.setText(batchExpert.getStudentName(getAdapterPosition() + 1));
                        average.setText(batchExpert.getStudentAverage(getAdapterPosition() + 1) + "%");
                    }
                    else
                    {
                        name.setText("");
                        average.setText("");
                    }
                    return false;
                }
            });
        }

    }
}
