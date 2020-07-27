package com.laduchuy.oderfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ViewHolder> {

    List<Contact> contactList;
    IOnClickContact ionClickContact;

    public void setIonClickContact(IOnClickContact ionClickContact) {
        this.ionClickContact = ionClickContact;
    }

    public AdapterContact(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public AdapterContact.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view  = inflater.inflate(R.layout.item_contact,parent,false);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContact.ViewHolder holder, final int position) {
        final Contact contact = contactList.get(position);
        String price = Float.toString(contactList.get(position).getPrice())+"$";
        holder.tvName.setText(contactList.get(position).getName());
        holder.tvPrice.setText(price);
        holder.imgFood.setImageResource(contactList.get(position).getImg());

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ionClickContact.conClickName(contact.getName(),position);
            }
        });
        holder.imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ionClickContact.onClickImg(contact.getImg(),position);
            }
        });


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
