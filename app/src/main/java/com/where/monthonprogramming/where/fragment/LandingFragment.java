package com.where.monthonprogramming.where.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.where.monthonprogramming.where.R;

import static com.where.monthonprogramming.where.R.mipmap.a;



public class LandingFragment extends Fragment {
    ImageButton btnNfc, btnSearch, btnMap;
    android.support.v7.widget.CardView image;



    public interface Fragmentlistener{
        void onButtonClickNFC(ImageButton btnNfc);
        void onButtonClickSearch(ImageButton btnSearch);
        void onButtonClickMap(ImageButton btnMap);
    }


    public LandingFragment() {
        super();
    }

    public static LandingFragment newInstance() {
        LandingFragment fragment = new LandingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_landing, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(final View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        btnNfc = (ImageButton)rootView.findViewById(R.id.nfc_btn);
        btnSearch = (ImageButton)rootView.findViewById(R.id.nfc_search);
        btnMap = (ImageButton)rootView.findViewById(R.id.nfc_map);
        btnNfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton btnNfc = (ImageButton)rootView.findViewById(R.id.nfc_btn);//
                //handle fragment
                Fragmentlistener listener =(Fragmentlistener)getActivity();
                listener.onButtonClickNFC(btnNfc);
//                listener.onButtonClickSearch(btnSearch);
//                listener.onButtonClickMap(btnMap);

            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton btnSearch = (ImageButton)rootView.findViewById(R.id.nfc_search);//
                //handle fragment
                Fragmentlistener listener =(Fragmentlistener)getActivity();
                listener.onButtonClickSearch(btnSearch);
            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMap = (ImageButton)rootView.findViewById(R.id.nfc_map);
                Fragmentlistener listener =(Fragmentlistener)getActivity();
                listener.onButtonClickMap(btnMap);

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }
}
