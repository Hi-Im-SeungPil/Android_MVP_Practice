package org.jeonfeel.mvp_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jeonfeel.mvp_practice.Database.DB;
import org.jeonfeel.mvp_practice.contract.contract;
import org.jeonfeel.mvp_practice.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements contract.MainView,View.OnClickListener{

    RecyclerView recyclerView;
    FloatingActionButton btn_add;
    RecyclerViewAdapter recyclerViewAdapter;
    DB db;
    MainPresenter presenter;
    public static Context main_context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindViewById();
        db = DB.getInstance(MainActivity.this);
        main_context = MainActivity.this;
        presenter = new MainPresenter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(presenter.getDataAndGetAdapter(db,recyclerViewAdapter));
        notifyList();
        btn_add.setOnClickListener(this);

    }

    private void FindViewById(){
        recyclerView = findViewById(R.id.recyclerView);
        btn_add = findViewById(R.id.btn_add);
    }

    @Override
    public void moveInsertClass() {
        Intent intent = new Intent(MainActivity.this,Activity_insert.class);
        startActivity(intent);
    }

    @Override
    public void notifyList() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                moveInsertClass();
                break;
        }

    }


}