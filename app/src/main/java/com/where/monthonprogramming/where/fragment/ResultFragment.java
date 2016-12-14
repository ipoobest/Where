package com.where.monthonprogramming.where.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.activity.ResultActivity;


public class ResultFragment extends Fragment {

    String bookFloor;
    String viewId;
    String bookName;
    String isbn;
    View view;
    ImageView floor4,floor5,floor6;
    TextView tvBookName;
    TextView tvIsbn;
    TextView tvFloor;
    RelativeLayout rl;
    LinearLayout ll;
    LinearLayout lldes;

    public ResultFragment() {
        super();
    }

    public static ResultFragment newInstance(String var,String bookFloor,String bookName,String isbn) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString("var", var); //put id view to argument
        args.putString("bookFloor", bookFloor); //put id floor to argument
        args.putString("bookName", bookName); //put book name to argument
        args.putString("isbn", isbn); //put isbn to argument
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
        viewId = getArguments().getString("var"); //get id view
        bookFloor = getArguments().getString("bookFloor"); //get id floor
        bookName = getArguments().getString("bookName"); //get book name
        isbn = getArguments().getString("isbn"); //get isbn

        floor4 = (ImageView) rootView.findViewById(R.id.floor4);
        floor5 = (ImageView) rootView.findViewById(R.id.floor5);
        floor6 = (ImageView) rootView.findViewById(R.id.floor6);

        Animation myFadeInAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.blinking);

        //floor 4th
        if(bookFloor.equals("4")) {
            RelativeLayout relativeLayout56 = (RelativeLayout) rootView.findViewById(R.id.sf56);
            relativeLayout56.setAlpha((float) 0);
            floor5.setAlpha((float) 0);
            floor6.setAlpha((float) 0);
            //Change view color from view id that we get.
            switch (viewId) {
                case "view1": {
                    view = rootView.findViewById(R.id.view1);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view2": {
                    view = rootView.findViewById(R.id.view2);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view3": {
                    view = rootView.findViewById(R.id.view3);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view4": {
                    view = rootView.findViewById(R.id.view4);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view5": {
                    view = rootView.findViewById(R.id.view5);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view6": {
                    view = rootView.findViewById(R.id.view6);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view7": {
                    view = rootView.findViewById(R.id.view7);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view8": {
                    view = rootView.findViewById(R.id.view8);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view9": {
                    view = rootView.findViewById(R.id.view5);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view10": {
                    view = rootView.findViewById(R.id.view10);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view11": {
                    view = rootView.findViewById(R.id.view11);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view12": {
                    view = rootView.findViewById(R.id.view12);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view13": {
                    view = rootView.findViewById(R.id.view13);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view14": {
                    view = rootView.findViewById(R.id.view14);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view15": {
                    view = rootView.findViewById(R.id.view15);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view16": {
                    view = rootView.findViewById(R.id.view16);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }

            }
        }
        //floor 5th &6th (same position)
        if(bookFloor.equals("5")||bookFloor.equals("6")) {
            RelativeLayout relativeLayout4 = (RelativeLayout) rootView.findViewById(R.id.sf4);
            relativeLayout4.setAlpha((float) 0);
            floor4.setAlpha((float) 0);
            if(bookFloor.equals("5")) {
                floor6.setAlpha((float) 0);
            }
            if(bookFloor.equals("6")){
                floor5.setAlpha((float) 0);
            }
            //Change view color from view id that we get.
            switch (viewId) {
                case "view17": {
                    view = rootView.findViewById(R.id.view17);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view18": {
                    view = rootView.findViewById(R.id.view18);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view19": {
                    view = rootView.findViewById(R.id.view19);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view20": {
                    view = rootView.findViewById(R.id.view20);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view21": {
                    view = rootView.findViewById(R.id.view21);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view22": {
                    view = rootView.findViewById(R.id.view22);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view23": {
                    view = rootView.findViewById(R.id.view23);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view24": {
                    view = rootView.findViewById(R.id.view24);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view25": {
                    view = rootView.findViewById(R.id.view25);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view26": {
                    view = rootView.findViewById(R.id.view26);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view27": {
                    view = rootView.findViewById(R.id.view27);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view28": {
                    view = rootView.findViewById(R.id.view28);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view29": {
                    view = rootView.findViewById(R.id.view29);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view30": {
                    view = rootView.findViewById(R.id.view30);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view31": {
                    view = rootView.findViewById(R.id.view31);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }
                case "view32": {
                    view = rootView.findViewById(R.id.view32);
                    view.setBackgroundColor(Color.RED);
                    view.startAnimation(myFadeInAnimation);
                    break;
                }

            }
        }
        tvBookName = (TextView) rootView.findViewById(R.id.tvBookName);
        tvIsbn = (TextView) rootView.findViewById(R.id.tvBookId);
        tvFloor = (TextView) rootView.findViewById(R.id.tvFloor);
        //put description of book
        tvBookName.setText("Title: "+bookName);
        tvIsbn.setText("ISBN: "+isbn);
        tvFloor.setText("Floor: "+bookFloor);
        rl = (RelativeLayout) rootView.findViewById(R.id.rl);
        ll = (LinearLayout) rootView.findViewById(R.id.detail);
        lldes = (LinearLayout) rootView.findViewById(R.id.description) ;
        ll.setAlpha((float)0);

        //touch on screen for turn off description and tell me location detail.
        rl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        // touch down code
                        ll.setAlpha((float)1);
                        lldes.setAlpha((float)0);
                        break;

                    case MotionEvent.ACTION_MOVE:
                        // touch move code
                        break;

                    case MotionEvent.ACTION_UP:
                        // touch up code
                        ll.setAlpha((float)0);
                        lldes.setAlpha((float)1);
                        break;
                }
                return true;
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
