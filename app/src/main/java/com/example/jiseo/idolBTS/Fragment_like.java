package com.example.jiseo.idolBTS;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiseo.retrofit.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_like extends Fragment {
    /*
    // default set
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_like,null);
    }
    */
    @Nullable
    Retrofit retrofit;
    ApiService apiService;
    ArrayList<DataPair> DataPairs;
    String result;
    static int pageNum= 10;
    // recycler view
    private ArrayList<DataPair> mArrayList;
    private CustomAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    View view;
    TextView tv;
    String[] splitedId;
    private static final String FILENAME = "LikeList.txt";
    String readString; // the String, read likelist.txt

    TextView tempText;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_like, null);
        //set data
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_like);
        mLinearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        // MainActivity에서 RecyclerView의 데이터에 접근시 사용됩니다.
        mArrayList = new ArrayList<>();
        // RecyclerView를 위해 CustomAdapter를 사용합니다.
        mAdapter = new CustomAdapter(mArrayList, getActivity().getApplicationContext());
        DataLoad_like(pageNum);        //get data
        mRecyclerView.setAdapter(mAdapter);
        /*
        mAdapter.setOnItemClickListener(new CustomAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                try {
                    // 찜하기 해제 넣어야함
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        */
        readString= readFromFile();


      //  tempText = (TextView) view.findViewById(R.id.testTextview);
    // 왜 안되는지 모름

        return view;
    }
    public void test(){

        final String textToSaveString = "Hello Android";
        String textFromFileString =  readFromFile();
        textFromFileString =  readFromFile();
        tempText.setText(textFromFileString);
        splitIntoArray();
    }



    private String readFromFile() {

        String ret = "";

        try {
            InputStream inputStream =  getActivity().getApplicationContext().openFileInput(FILENAME);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        return ret;
    }
    private void splitIntoArray() {

        String ret = "";

        try {
            InputStream inputStream =  getActivity().getApplicationContext().openFileInput(FILENAME);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        splitedId= ret.split(",");

    }


    // button.setOnClickListener
    public void ButtonFunc(int position) throws IOException {

    }
    public void like_data_read(){


    }
    public void DataLoad_like(final int num) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Map map = new HashMap();
        map.put("name", "map");

        ApiService retrofitService = retrofit.create(ApiService.class);
        Call<DataObject> call = retrofitService.getMovie(map);
        call.enqueue(new Callback<DataObject>() {
            @Override
            public void onResponse(Call<DataObject> call, Response<DataObject> response) {
                DataObject repo = response.body();
                for (int i = 0; i < repo.getDatas().size(); i++) {
                    if (i > num)
                        break;
                    DataPair dict = new DataPair(repo.getDatas().get(i).getTitle(),repo.getDatas().get(i).getImage(),repo.getDatas().get(i).getId());
                    //temp embed
                    //DataPair dict = new DataPair(repo.getDatas().get(i).getTitle(), "http://mblogthumb4.phinf.naver.net/20140813_187/thepianosam_1407904736320g5Qyz_PNG/%C0%A3%BD%C3%C4%DA%B1%E2_3.png?type=w2", 0);

                    // embed url : https://www.youtube.com/embed/EFs7gWyPl_A


                    mArrayList.add(dict); // RecyclerView의 마지막 줄에 삽입
                }
                mAdapter.notifyDataSetChanged(); //recyclerview 변경된 데이터를 화면에 반영
            }

            @Override
            public void onFailure(Call<DataObject> call, Throwable t) {

            }
        });


    }



}
