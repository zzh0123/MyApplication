package com.zzh.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    ApprovalAdapter approvalAdapter;
    List<Bean> datalist = new ArrayList<>();
    List<Bean> datatemplist = new ArrayList<>();
    Button bt;
    int focus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datatemplist.remove(focus);
                focus++;

//                focus += 10;

                datalist.clear();
                datalist.addAll(datatemplist);

                if (focus >= datalist.size()){
                    approvalAdapter.setFocusPos(0);
                } else {
                    approvalAdapter.setFocusPos(focus);
                }
                approvalAdapter.notifyDataSetChanged();
            }
        });

        rv = findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(manager);

        approvalAdapter = new ApprovalAdapter(datalist);
        rv.setAdapter(approvalAdapter);

        for (int i=0; i<100; i++){
            Bean bean = new Bean();
            bean.name = i + "";
            datalist.add(bean);

            datatemplist.add(bean);
        }

        approvalAdapter.setFocusPos(6);

        approvalAdapter.notifyDataSetChanged();
    }
}