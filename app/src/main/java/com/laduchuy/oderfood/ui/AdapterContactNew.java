package com.laduchuy.oderfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContactNew extends RecyclerView.Adapter<AdapterContactNew.ViewHolder> {

    List<Contact> contactList;

    public AdapterContactNew(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public AdapterContactNew.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view  = inflater.inflate(R.layout.item_contact,parent,false);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull AdapterContactNew.ViewHolder holder, int position) {
        Float price = contactList.get(position).getSl() * contactList.get(position).getPrice();
        holder.tvName.setText(contactList.get(position).getName()+"("+
                contactList.get(position).getSl()+")");
        holder.tvPrice.setText(Float.toString(price));
        holder.imgFood.setImageResource(contactList.get(position).getImg());


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvPrice;
        ImageView imgFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            imgFood=itemView.findViewById(R.id.imageFood);
        }
    }
}

