package com.where.monthonprogramming.where.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.lapism.searchview.SearchView;
import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.activity.LandingActivity;
import com.where.monthonprogramming.where.activity.ResultActivity;
import com.where.monthonprogramming.where.activity.SearchActivity;
import com.where.monthonprogramming.where.dao.BooksDao;
import com.where.monthonprogramming.where.dao.NfcsDao;
import com.where.monthonprogramming.where.manager.HttpManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class SearchFragment extends Fragment {

    private ProgressBar progressBar;
    Animation myFadeInAnimation;
    View view;
    View view2;
    View view18;
    View view19;
    ImageView floor1,floor2,floor3,floor4, floor5, floor6, floor7;


    TextView textView;

    private static String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    String nfcFloor;
    String result;
    com.lapism.searchview.SearchView searchView;

    public SearchFragment() {
        super();
    }

    public static SearchFragment newInstance(String result,String nfcFloor) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString("result", result);//put id view
        args.putString("nfcFloor",nfcFloor);//put id floor of nfc tag
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        result = getArguments().getString("result"); //get id view
        nfcFloor = getArguments().getString("nfcFloor");//get id floor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search,
                container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {


        // Init 'View' instance(s) with rootView.findViewById here

        floor1 = (ImageView) rootView.findViewById(R.id.floor1);
        floor2 = (ImageView) rootView.findViewById(R.id.floor2);
        floor3 = (ImageView) rootView.findViewById(R.id.floor3);

        view = rootView.findViewById(R.id.view);
        view2 = rootView.findViewById(R.id.view2);
        view18 = rootView.findViewById(R.id.view18);
        view19 = rootView.findViewById(R.id.view19);

        //Create view from id view (Show location)
        if(result != null) {
            //if we press nfc button or we want to use nfc. (because result get from nfc tag.)

            myFadeInAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.blinking); //blinking animation
            if(nfcFloor.equals("1")){
                floor2.setAlpha((float) 0);
                floor3.setAlpha((float) 0);
                //floor 1st
                switch (result) {
                    case "view":
                        view18.setAlpha(0);
                        view19.setAlpha(0);
                        view2.setAlpha(0);
                        view.startAnimation(myFadeInAnimation);
                        break;
                    case "view2":
                        view18.setAlpha(0);
                        view19.setAlpha(0);
                        view.setAlpha(0);
                        view2.startAnimation(myFadeInAnimation);
                    //will have more case soon..
                }
            }
            if(nfcFloor.equals("2")){
                floor1.setAlpha((float) 0);
                floor3.setAlpha((float) 0);
                //floor 2nd
                switch (result) {
                    case "view18":
                        view.setAlpha(0);
                        view2.setAlpha(0);
                        view19.setAlpha(0);
                        view18.startAnimation(myFadeInAnimation);
                        break;
                    //will have more case soon..
                }
            }
            if(nfcFloor.equals("3")){
                floor1.setAlpha((float) 0);
                floor2.setAlpha((float) 0);
                //floor 3th
                switch (result) {
                    case "view19":
                        view.setAlpha(0);
                        view2.setAlpha(0);
                        view18.setAlpha(0);
                        view19.startAnimation(myFadeInAnimation);
                        break;
                    //will have more case soon..
                }
            }


        }else{

            //when we press search button or don't want to use nfc.
            floor1.setAlpha((float) 0);
            floor2.setAlpha((float) 0);
            floor3.setAlpha((float) 0);
            view18.setAlpha(0);
            view.setAlpha(0);
            view19.setAlpha(0);
            view2.setAlpha(0);

        }
        //loading for query id or name of book. (progressBar)
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.VISIBLE);
        progressBar.setVisibility(ProgressBar.INVISIBLE);


        //create search view
        searchView = (SearchView) rootView
                .findViewById(R.id.searchView);

        searchView.setHint("search your books");
        searchView.setOnQueryTextListener(new SearchView
                .OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //handle when we search
                progressBar.setVisibility(ProgressBar.VISIBLE);
                //query a book from service
                if (query != null && !query.isEmpty()) {

                    //ignore spacebar for search.
                    String s = query.toString().replaceAll(" ","");
                    setQuery(s);

                    //method calling service
                    callBooksService();

                    //hide keyboard
                    InputMethodManager inputManager = (InputMethodManager)
                            getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

                    inputManager.hideSoftInputFromWindow(searchView.getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;
                }
                else {
                    Toast.makeText(getContext(),"Please put a book name.",Toast.LENGTH_LONG).show();
                    return false;
                }
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null && !newText.isEmpty()){
                    return true;
                }
                else {return false;}
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }
//g4
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

    private void callBooksService() {
        //method call service
        Call<List<BooksDao>> call = HttpManager.getInstance()
                .getService()
                .all();

        call.enqueue(new Callback<List<BooksDao>>() {
            @Override
            public void onResponse(Call<List<BooksDao>> call,
                                   Response<List<BooksDao>> response) {

                String query = getQuery();
                for (int i =0;i<response.body().size();i++){
                    //We can query a book by a book id or a book name searching
                    if(response.body().get(i).getBookId().equalsIgnoreCase(query)||
                            response.body().get(i).getName().equalsIgnoreCase(query)){

                        //@TODO Handle
                        String idView = response.body().get(i).getViewId();
                        String bookFloor = response.body().get(i).getFloor();
                        String bookName = response.body().get(i).getName();
                        String isbn = response.body().get(i).getBookId();


                        //get idView ,Floor ,book name ,isbn from service.

                        if (idView != null && bookFloor != null && bookName != null && isbn != null) {
                            Intent intent = new Intent(getActivity(), ResultActivity.class);
                            intent.putExtra("var", idView);
                            intent.putExtra("bookFloor",bookFloor);
                            intent.putExtra("bookName",bookName);
                            intent.putExtra("isbn",isbn);
                            startActivity(intent);
                            break;
                        }

                    }else if(i==(response.body().size()-1)) {
                        // alert user
                        Toast.makeText(getContext(),"Not Found",
                                Toast.LENGTH_LONG).show();
                        break;
                    }

                    progressBar.setVisibility(ProgressBar.INVISIBLE);

                }
            }

            @Override
            public void onFailure(Call<List<BooksDao>> call, Throwable t) {
                //fail to connect service.
                t.printStackTrace();
                textView.setText(t.getMessage());
            }
        });
    }

}
