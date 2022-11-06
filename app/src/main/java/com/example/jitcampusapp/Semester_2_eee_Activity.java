package com.example.jitcampusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Semester_2_eee_Activity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoreList;

    private FirestoreRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_2_eee_);

        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.sem_2_recycler);

        //Query
        Query query = firebaseFirestore.collection("SEMESTER_2_EEE");

        //Recycler Options
        FirestoreRecyclerOptions<firestore_examDetails_access> options = new FirestoreRecyclerOptions.Builder<firestore_examDetails_access>()
                .setQuery(query, firestore_examDetails_access.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<firestore_examDetails_access, Semester_2_eee_Activity.ProductsViewHolder>(options) {
            @NonNull
            @Override
            public Semester_2_eee_Activity.ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.examdetails_list, parent, false);

                return new Semester_2_eee_Activity.ProductsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull Semester_2_eee_Activity.ProductsViewHolder holder, int position, @NonNull firestore_examDetails_access model) {
                holder.subjectname.setText(model.getExamName());
                holder.date.setText(model.getExamDate());
                holder.time.setText(model.getExamTime());
                holder.regno.setText(model.getRegisterNumber());
                holder.regno2.setText(model.getRegisterNumber2());
                holder.regno3.setText(model.getRegisterNumber3());
                holder.regno4.setText(model.getRegisterNumber4());
                holder.room.setText(model.getRoomNumber());
                holder.room2.setText(model.getRoomNumber2());
                holder.room3.setText(model.getRoomNumber3());
                holder.room4.setText(model.getRoomNumber4());
            }
        };

        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);

    }
    private class ProductsViewHolder extends RecyclerView.ViewHolder {

        private TextView subjectname;
        private TextView date;
        private TextView time;
        private TextView regno;
        private TextView regno2;
        private TextView regno3;
        private TextView regno4;
        private TextView room;
        private TextView room2;
        private TextView room3;
        private TextView room4;


        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);

            subjectname = itemView.findViewById(R.id.txt1);
            date = itemView.findViewById(R.id.txt2);
            time = itemView.findViewById(R.id.txt3);
            regno = itemView.findViewById(R.id.txt4);
            regno2 = itemView.findViewById(R.id.txt6);
            regno3 = itemView.findViewById(R.id.txt8);
            regno4 = itemView.findViewById(R.id.txt10);
            room = itemView.findViewById(R.id.txt5);
            room2 = itemView.findViewById(R.id.txt7);
            room3 = itemView.findViewById(R.id.txt9);
            room4 = itemView.findViewById(R.id.txt11);


        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}