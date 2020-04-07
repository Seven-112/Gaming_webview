package org.webview.Model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.webview.CategoryActivity;
import org.webview.MainActivity;
import org.webview.R;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


    private final Integer[] imgid;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public MyViewHolder(final View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if(listener != null)
                    {
                        int position = getAdapterPosition();

                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.OnItemClicked(position, v);
                        }
                    }

                }
            });
        }
    }

    OnItemClickListener listener;

    public interface OnItemClickListener
    {
        void OnItemClicked(int position, View v);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.listener = listener;
    }


    public Adapter(CategoryActivity categoryActivity, Integer[] imgid) {

        this.imgid=imgid;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(imgid[position]);
    }

    @Override
    public int getItemCount() {
        return imgid.length;
    }

}
