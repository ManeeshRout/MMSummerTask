package com.example.hp.mondaymorning;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//Our class extending fragment
public class This_Week extends Fragment  {
    private static final String URL_DEPARTMENT = "http://mondaymorning.nitrkl.ac.in/api/post/get/tab/departments";

    private static final String URL_CAMPUS = "http://mondaymorning.nitrkl.ac.in/api/post/get/tab/campus";

    private static final String URL_VIEWS = "http://mondaymorning.nitrkl.ac.in/api/post/get/tab/views";

    private static final String URL_CAREER = "http://mondaymorning.nitrkl.ac.in/api/post/get/tab/career";

    private static final String URL_ALUMNI = "http://mondaymorning.nitrkl.ac.in/api/post/get/tab/alumni";



    private static final String URL_DDCWWC = "http://mondaymorning.nitrkl.ac.in/api/post/get/tab/dd-cwc";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> departmentList;

    private List<ListItem> campusList;

    private List<ListItem> viewsList;

    private List<ListItem> careerList;

    private List<ListItem> alumniList;

    private List<ListItem> ddcwcList;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        View view =  inflater.inflate(R.layout.categories, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.thisweekRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        return view;
        listItems= new ArrayList<>();

        loadRecyclerViewData();



    }

    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog( this );
        progressDialog.setMessage( "Loading data..." );
        progressDialog.show();
        StringRequest stringRequest = new StringRequest( Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            JSONArray array = jsonObject.getJSONArray( "posts" );
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject( i );
                                ListItem item = new ListItem(
                                        o.getString( "authors" ),
                                        o.getString( "post_title" ),
                                        o.getInt( "post_hits" ),
                                        o.getString( "post_publish_date" ),
                                        o.getString( "featured_image" )
                                );
                                listItems.add( item );
                            }

                            adapter = new MyAdapter( listItems, getApplicationContext() );
                            recyclerView.setAdapter( adapter );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                } );
        RequestQueue requestQueue = Volley.newRequestQueue( this );
        requestQueue.add( stringRequest );
    }

    private void departmentFn()

    {

        StringRequest request = new StringRequest(Request.Method.GET, URL_DEPARTMENT, new Response.Listener<String>() {

            @Override

            public void onResponse(String response) {

                try {

                    JSONObject obj = new JSONObject(response);

                    JSONArray arr = obj.getJSONArray("posts");

                    String authors[] = new String[arr.length()];

                    String categories[] = new String[arr.length()];

                    //Toast.makeText(MyContext.getContext(), "working", //Toast.LENGTH_SHORT).show();



                    for (int i = 0; i < arr.length(); ++i) {

                        JSONObject o = arr.getJSONObject(i);



                        ListItem data = new ListItem(

                                o.getString("post_title"),

                                //o.getJSONArray("authors").toString(),


                                o.getString("post_publish_date"),

                                o.getString("featured_image"),

                                o.getString("post_id"));

                        departmentList.add(data);

                    }


                } catch (JSONException e) {

                    //Toast.makeText(MyContext.getContext(), "Not working", //Toast.LENGTH_SHORT).show();

                    e.printStackTrace();

                }
}