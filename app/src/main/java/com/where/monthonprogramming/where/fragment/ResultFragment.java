package com.where.monthonprogramming.where.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.where.monthonprogramming.where.R;



public class ResultFragment extends Fragment {

    String viewId;
    View view;

    public ResultFragment() {
        super();
    }

    public static ResultFragment newInstance(String var) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString("var", var);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_result, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        viewId = getArguments().getString("var");
//        Toast.makeText(getContext(),viewId,Toast.LENGTH_SHORT).show();

        switch (viewId){
            case "view1":{
                view = rootView.findViewById(R.id.view1);
                view.setBackgroundColor(Color.RED);
                break;
            }case "view2":{
                view =  rootView.findViewById(R.id.view2);
                view.setBackgroundColor(Color.RED);
                break;
            }case "view3":{
                view =  rootView.findViewById(R.id.view3);
                view.setBackgroundColor(Color.RED);
                break;
            }case "view4":{
                view =  rootView.findViewById(R.id.view4);
                view.setBackgroundColor(Color.RED);
                break;
            }case "view5":{
                view =  rootView.findViewById(R.id.view5);
                view.setBackgroundColor(Color.RED);
                break;
            }case "view6":{
                view = rootView.findViewById(R.id.view6);
                view.setBackgroundColor(Color.RED);
                break;
            }case "view7":{
                view =  rootView.findViewById(R.id.view7);
                view.setBackgroundColor(Color.RED);
                break;
            }case "view8":{
                view = rootView.findViewById(R.id.view8);
                view.setBackgroundColor(Color.RED);
                break;
            }case "view9":{
                view = rootView.findViewById(R.id.view5);
                view.setBackgroundColor(Color.BLACK);
                break;
            }case "view10":{
                view = rootView.findViewById(R.id.view10);
                view.setBackgroundColor(Color.BLACK);
                break;
            }case "view11":{
                view = rootView.findViewById(R.id.view11);
                view.setBackgroundColor(Color.BLACK);
                break;
            }case "view12":{
                view = rootView.findViewById(R.id.view12);
                view.setBackgroundColor(Color.BLACK);
                break;
            }case "view13":{
                view = rootView.findViewById(R.id.view13);
                view.setBackgroundColor(Color.BLACK);
                break;
            }case "view14":{
                view = rootView.findViewById(R.id.view14);
                view.setBackgroundColor(Color.BLACK);
                break;
            }case "view15":{
                view = rootView.findViewById(R.id.view15);
                view.setBackgroundColor(Color.BLACK);
                break;
            }case "view16":{
                view = rootView.findViewById(R.id.view16);
                view.setBackgroundColor(Color.BLACK);
                break;
            }





        }
        View view = (View) rootView.findViewById(R.id.view1);
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
