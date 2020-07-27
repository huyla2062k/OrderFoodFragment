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
import com.laduchuy.oderfood.AdapterContactNew;
import com.laduchuy.oderfood.Contact;
import com.laduchuy.oderfood.MainActivity;
import com.laduchuy.oderfood.R;
import com.laduchuy.oderfood.databinding.BuyfragmentLayoutBinding;
import com.laduchuy.oderfood.databinding.OrderfragmentLayoutBinding;

import java.util.List;

public class BuyFragment extends Fragment {
    BuyfragmentLayoutBinding binding;

    AdapterContactNew adapterContactNew;

    public static BuyFragment newInstance() {
        
        Bundle args = new Bundle();
        
        BuyFragment fragment = new BuyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.buyfragment_layout,container,false);

        adapterContactNew = new AdapterContactNew(OrderFragment.contactListOrder);
        binding.rvFoodOrder.setAdapter(adapterContactNew);
        RecyclerView.LayoutManager layoutManager =
                new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false);
        binding.rvFoodOrder.setLayoutManager(layoutManager);

        binding.tvPriceOrder.setText(Float.toString(OrderFragment.price)+"$");

        binding.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                OrderFragment.contactListOrder.clear();
                adapterContactNew =new AdapterContactNew(OrderFragment.contactListOrder);
                OrderFragment.sl = 0;
                OrderFragment.price = 0;
                binding.tvPriceOrder.setText("0.0$");
                Toast.makeText(getContext(), "Payment success", Toast.LENGTH_LONG).show();
            }
        });
        return binding.getRoot();

    }
}
