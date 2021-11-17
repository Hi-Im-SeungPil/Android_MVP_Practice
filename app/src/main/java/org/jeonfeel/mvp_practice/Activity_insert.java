package org.jeonfeel.mvp_practice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jeonfeel.mvp_practice.Database.DB;
import org.jeonfeel.mvp_practice.presenter.MainPresenter;

public class Activity_insert extends AppCompatActivity implements View.OnClickListener {

    DB db;
    EditText et_phoneNum;
    EditText et_name;
    Button btn_save;
    MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        FindViewById();
        presenter = new MainPresenter();
        db = DB.getInstance(Activity_insert.this);
        btn_save.setOnClickListener(this);

    }
    public void FindViewById(){

        et_phoneNum = findViewById(R.id.et_phoneNum);
        et_name = findViewById(R.id.et_name);
        btn_save = findViewById(R.id.btn_save);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_save){
            presenter.saveData(db,et_name.getText().toString(),et_phoneNum.getText().toString());
            ((MainActivity)MainActivity.main_context).presenter.updateList(db);
            ((MainActivity)MainActivity.main_context).notifyList();
            finish();
        }
    }
}
