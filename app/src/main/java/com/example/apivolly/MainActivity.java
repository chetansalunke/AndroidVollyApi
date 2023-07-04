package com.example.apivolly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String url = "https://jsonplaceholder.typicode.com/photos";
    ArrayList<UserModel> allUsers;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        allUsers = new ArrayList<>();

        getData();
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONArray array = new JSONArray(response);
                            for(int i=0;i<array.length();i++)
                            {
                                JSONObject jsonObject = array.getJSONObject(i);
                                UserModel userModel = new UserModel(
                                       jsonObject.getInt("albumId"),
                                        jsonObject.getInt("id"),
                                       jsonObject.getString("title"),
                                        jsonObject.getString("url"),
                                        jsonObject.getString("thumbnailUrl")
                                        );
                                allUsers.add(userModel);
                            }

                            recyclerView.setAdapter(new UserAdapter(allUsers));
                            Log.e("size","Size"+allUsers.size());
                        } catch (JSONException e) {
                            Log.e("JSON RESPONSE ERROR","ERRORE IN THE PARSSING"+e.getLocalizedMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("API ERRORS ",""+error.getLocalizedMessage());
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}