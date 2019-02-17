package com.project.coding101.my.studentBoard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.coding101.my.R;

import java.util.List;

public abstract class BaseEntryChoiceActivity extends AppCompatActivity {

    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_choice);

        mRecycler = findViewById(R.id.choices_recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(new ChoiceAdapter(this, getChoices()));
    }

    protected abstract List<Choice> getChoices();
}
