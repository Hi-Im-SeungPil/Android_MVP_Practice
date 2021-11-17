package org.jeonfeel.mvp_practice.presenter;

import android.util.Log;
import android.widget.Toast;

import org.jeonfeel.mvp_practice.Database.DB;
import org.jeonfeel.mvp_practice.Database.infoDTO;
import org.jeonfeel.mvp_practice.RecyclerViewAdapter;
import org.jeonfeel.mvp_practice.contract.contract;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements contract.Presenter {

    List<infoDTO> infoDTOS;

    @Override
    public void saveData(DB db,String name,String phoneNum) {
        db.infoDAO().insert(name,phoneNum);
    }

    @Override
    public RecyclerViewAdapter getDataAndGetAdapter(DB db, RecyclerViewAdapter adapter) {

        infoDTOS = new ArrayList<>();
        infoDTOS = db.infoDAO().getAll();
        adapter = new RecyclerViewAdapter(infoDTOS);

        return adapter;
    }

    @Override
    public void updateList(DB db) {
        if(infoDTOS == null) {
            Log.d("널","infoDTOS is null");
        }else{
            infoDTOS.add(db.infoDAO().getLast());
        }
    }
}
