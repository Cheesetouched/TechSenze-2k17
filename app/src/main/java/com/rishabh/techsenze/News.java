package com.rishabh.techsenze;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class News extends Fragment implements View.OnClickListener {

    private Button watch;

    private Button register;

    public News() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_news, container, false);

        watch = (Button) view.findViewById(R.id.watch);

        register = (Button) view.findViewById(R.id.register);

        watch.setOnClickListener(this);

        register.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View view) {

        if (view == watch) {

            Intent go = new Intent(getActivity(), Video.class);

            startActivity(go);

        }

        else if (view == register) {

            Intent go = new Intent(getActivity(), Register.class);

            startActivity(go);

        }

    }


}
