package com.rishabh.techsenze;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Events extends Fragment implements View.OnClickListener {

    private LinearLayout technical;

    private LinearLayout nontechnical;

    private LinearLayout online;

    public Events() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_events, container, false);

        technical = (LinearLayout) view.findViewById(R.id.technical);

        nontechnical = (LinearLayout) view.findViewById(R.id.nontechnical);

        online = (LinearLayout) view.findViewById(R.id.online);

        technical.setOnClickListener(this);

        nontechnical.setOnClickListener(this);

        online.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View view) {

        if (view == technical) {

            Intent go = new Intent(getActivity(), Technical.class);

            startActivity(go);

        } else if (view == nontechnical) {

            Intent go = new Intent(getActivity(), NonTechnical.class);

            startActivity(go);

        } else if (view == online) {

            Intent go = new Intent(getActivity(), Online.class);

            startActivity(go);

        }

    }


}
