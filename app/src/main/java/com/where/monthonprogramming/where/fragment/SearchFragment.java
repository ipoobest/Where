package com.where.monthonprogramming.where.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.Util.Contextor;
import com.where.monthonprogramming.where.dao.BookItemDao;
import com.where.monthonprogramming.where.dao.PhotoItemCollectionDao;
import com.where.monthonprogramming.where.manager.HttpManager;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {

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
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here

        searchView = (com.lapism.searchview.SearchView) rootView.findViewById(R.id.searchView);
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
                    return true;
                }
                else {
                    return false;
                }
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null && !newText.isEmpty()){

                    return true;
                }
                else {
                    return false;
                }
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

        Call<BookItemDao> call = HttpManager.getInstance()
                .getService()
                .loadPhotolist();

        call.enqueue(new Callback<BookItemDao>() {
            @Override
            public void onResponse(Call<BookItemDao> call,
                                   Response<BookItemDao> response) {
                String query = getQuery();

                if(response.isSuccessful()){
                    BookItemDao dao = response.body();



                        if (dao.getBookName().equals(query)||
                                dao.getId().equals(query)) {
                            Toast.makeText(getContext(),
                                    dao.getBookName(),
                                    Toast.LENGTH_SHORT)
                                    .show();

                        }else {
                            //Toast.makeText(getActivity(),"NOT FOUND",Toast.LENGTH_SHORT).show();
                            new AlertDialog.Builder(getContext())
                                    .setTitle("Not found")
                                    .setMessage("Please check name or id book again.")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                                  }).setIcon(android.R.drawable.ic_dialog_alert)
                                    .show();



                    }

                }else{
                    try {
                        Toast.makeText(getContext(),response
                                        .errorBody()
                                        .string(),
                                Toast.LENGTH_SHORT)
                                .show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<BookItemDao> call,
                                  Throwable t) {

                Toast.makeText(getContext(),t.toString(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
