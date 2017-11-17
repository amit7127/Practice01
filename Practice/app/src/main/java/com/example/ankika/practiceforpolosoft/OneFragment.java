package com.example.ankika.practiceforpolosoft;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class OneFragment extends Fragment implements GetUserListener {

    List<UserModelForOne> userModelForOnes = null;
    View view = null;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_one, container, false);

        OneAsyncTask asyncTask = new OneAsyncTask(getContext());
        asyncTask.setListener(OneFragment.this);
        asyncTask.execute();

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void userFetched(List<UserModelForOne> forOneList) {

        if (forOneList != null) {

            RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
            UserAdapter mAdapter = new UserAdapter(forOneList);
            //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            //recyclerView.setLayoutManager(mLayoutManager);
            //recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        }

    }
}
