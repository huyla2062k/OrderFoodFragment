package com.laduchuy.oderfood.ui;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.laduchuy.oderfood.AdapterContact;
import com.laduchuy.oderfood.Contact;
import com.laduchuy.oderfood.IOnClickContact;

import com.laduchuy.oderfood.R;
import com.laduchuy.oderfood.databinding.OrderfragmentLayoutBinding;

import java.util.ArrayList;
import java.util.List;


public class OrderFragment extends Fragment {
    public static int sl = 0;
    public static float price = 0;
    OrderfragmentLayoutBinding binding;
    public static List<Contact> contactList, contactListOrder;
    Contact contact1, contact2, contact3, contact4, contact5,
            contact6;
    AdapterContact adapterContact;

    public static OrderFragment newInstance() {

        Bundle args = new Bundle();

        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.orderfragment_layout, container, false);

        contactList = new ArrayList<>();
        contactListOrder = new ArrayList<>();

        contact1 = new Contact("Pizza Panda", R.drawable.pizza, 20);
        contact2 = new Contact("KFC Super", R.drawable.kfc_super, 35);
        contact3 = new Contact("Bread Eggs", R.drawable.bread_eggs, 15);
        contact4 = new Contact("Coca Cola", R.drawable.coca_cola, 5);
        contact5 = new Contact("Chicken Super", R.drawable.chicken, 20);
        contact6 = new Contact("Cup Cake", R.drawable.cupcake, 10);
        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);
        contactList.add(contact6);

        adapterContact = new AdapterContact(contactList);
        adapterContact.setIonClickContact(new IOnClickContact() {
            @Override
            public void onClickImg(int img, int i) {
                int sli = contactList.get(i).getSl();
                sl++;
                sli++;
                contactList.get(i).setSl(sli);
                out:if(contactListOrder.size()==0){
                    contactListOrder.add(contactList.get(i));
                }else {
                    for (int j = 0; j < contactListOrder.size(); j++) {
                        if (contactListOrder.get(j).getName().equals(contactList.get(i).getName())) {
                            contactListOrder.remove(contactListOrder.get(j));
                            contactListOrder.add(j,contactList.get(i));
                            break out;
                        }
                    }
                    contactListOrder.add(contactList.get(i));
                }
                price += contactList.get(i).getPrice();
                binding.tvPrice.setText(Float.toString(price) + "$");
                Toast.makeText(getContext(), "Order Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void conClickName(String name, int i) {
                int sli = contactList.get(i).getSl();
                sl++;
                sli++;
                contactList.get(i).setSl(sli);
                out:if(contactListOrder.size()==0){
                    contactListOrder.add(contactList.get(i));
                }else {
                    for (int j = 0; j < contactListOrder.size(); j++) {
                        if (contactListOrder.get(j).getName().equals(contactList.get(i).getName())) {
                            contactListOrder.remove(contactListOrder.get(j));
                            contactListOrder.add(j,contactList.get(i));
                            break out;
                        }
                    }
                    contactListOrder.add(contactList.get(i));
                }
                price += contactList.get(i).getPrice();
                binding.tvPrice.setText(Float.toString(price) + "$");
                Toast.makeText(getContext(), "Order Success", Toast.LENGTH_LONG).show();
            }

        });

        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactListOrder.clear();
                sl = 0;
                price = 0;
                binding.tvPrice.setText(Float.toString(price) + "$");
                Toast.makeText(getContext(), "Payment success", Toast.LENGTH_LONG).show();

            }
        });

        binding.rvFood.setAdapter(adapterContact);
        RecyclerView.LayoutManager layoutManager =
                new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false);
        binding.rvFood.setLayoutManager(layoutManager);
        return binding.getRoot();


    }
}
