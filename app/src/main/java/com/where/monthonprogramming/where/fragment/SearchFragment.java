package com.where.monthonprogramming.where.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.dao.BooksDao;
import com.where.monthonprogramming.where.manager.HttpManager;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {

    TextView textView;

    private static String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    String result;
    com.lapism.searchview.SearchView searchView;

    public SearchFragment() {
        super();
    }

    public static SearchFragment newInstance(String result) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString("result", result);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        result = getArguments().getString("result");
        //Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
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



        searchView = (com.lapism.searchview.SearchView) rootView
                .findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new com.lapism
                .searchview
                .SearchView
                .OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(query != null && !query.isEmpty()){
                    //Toast.makeText(getActivity(),query,Toast.LENGTH_SHORT).show();
                    setQuery(query);
                    callService();

                    InputMethodManager inputManager = (InputMethodManager)
                            getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

                    inputManager.hideSoftInputFromWindow(searchView.getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;
                }
                else {
                    return false;
                }
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null && !newText.isEmpty()){return true;}
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

    private void callService() {

        Call<List<BooksDao>> call = HttpManager.getInstance()
                .getService()
                .all();

        call.enqueue(new Callback<List<BooksDao>>() {
            @Override
            public void onResponse(Call<List<BooksDao>> call,
                                   Response<List<BooksDao>> response) {

                String query = getQuery();
                for (int i =0;i<response.body().size();i++){

                    if(response.body().get(i).getBookId().equalsIgnoreCase(query)||
                            response.body().get(i).getName().equalsIgnoreCase(query)){

                        //@TODO Handle

                        String result = response.body().get(i).getName();
                        Toast.makeText(getContext(),result,
                                Toast.LENGTH_LONG).show();
                        break;

                    }else if(i==(response.body().size()-1)) {
                        Toast.makeText(getContext(),"Not Found",
                                Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }

            @Override
            public void onFailure(Call<List<BooksDao>> call, Throwable t) {
                t.printStackTrace();
                textView.setText(t.getMessage());
            }
        });
    }
}
