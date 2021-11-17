package org.jeonfeel.mvp_practice.contract;

import org.jeonfeel.mvp_practice.Database.DB;
import org.jeonfeel.mvp_practice.Database.infoDTO;
import org.jeonfeel.mvp_practice.RecyclerViewAdapter;

import java.util.List;

public interface contract {

    interface MainView{

        void moveInsertClass();
        void notifyList();

    }

    interface Presenter{

        void saveData(DB db,String name,String phoneNum);
        RecyclerViewAdapter getDataAndGetAdapter(DB db , RecyclerViewAdapter adapter);
        void updateList(DB db);

    }

}
