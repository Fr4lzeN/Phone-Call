package com.example.phonecall;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.phonecall.databinding.ActivityPhoneBookBinding;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook extends AppCompatActivity {
    private ActivityPhoneBookBinding binding;
    private List<PhoneBookItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneBookBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //data for recycler view
        {
            list = new ArrayList<>();
            list.add(new PhoneBookItem(R.drawable.b, "Roshandiatellineshyaunneveshank Koyaanfskvatsiuti Williams", "Friend"));
            list.add(new PhoneBookItem(R.drawable.c, "Anonymous", "Error!!!"));
            list.add(new PhoneBookItem(R.drawable.no, "Frank P.", "Doctor"));
            list.add(new PhoneBookItem(R.drawable.no, "Lily", "Sister"));
            list.add(new PhoneBookItem(R.drawable.d, "Mr. Black", "Boss"));
            list.add(new PhoneBookItem(R.drawable.no, "Mark", ""));
            list.add(new PhoneBookItem(R.drawable.e, "Leon", "Brother"));
            list.add(new PhoneBookItem(R.drawable.no, "Mother", ""));
            list.add(new PhoneBookItem(R.drawable.no, "Nill Kiggers", "Basketball player"));
            list.add(new PhoneBookItem(R.drawable.no, "Massage therapist", ""));
            list.add(new PhoneBookItem(R.drawable.f, "Mike", "Best Friend"));
            list.add(new PhoneBookItem(R.drawable.no, "Klaus", "Colleague"));
            list.add(new PhoneBookItem(R.drawable.g, "Walter", "Colleague"));
            list.add(new PhoneBookItem(R.drawable.no, "Ann", "Fitness trainer"));
            list.add(new PhoneBookItem(R.drawable.no, "Mrs. Bulk", "Neighbour"));
            list.add(new PhoneBookItem(R.drawable.dd, "Nancy", "Cousin"));
            list.add(new PhoneBookItem(R.drawable.a, "Peter", "Colleague"));
            list.add(new PhoneBookItem(R.drawable.no, "Mrs. Williams", "Mother-in-law"));
            list.add(new PhoneBookItem(R.drawable.no, "Mr. Williams", "Father-in-law"));
            list.add(new PhoneBookItem(R.drawable.no, "Veterinarian", ""));
        }
        //создание recycler view
        PhoneBookItemAdapter adapter = new PhoneBookItemAdapter(list);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        //кнопка возврата в начальную активность
        binding.arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}