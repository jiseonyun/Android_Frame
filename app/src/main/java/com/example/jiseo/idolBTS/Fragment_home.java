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
import android.widget.Toast;

import com.example.jiseo.idolBTS.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_home extends Fragment {
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


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);

        // tv= view.findViewById(R.id.t1);
        // tv.setText("hi");

        //set data
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_home);
        mLinearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        // MainActivity에서 RecyclerView의 데이터에 접근시 사용됩니다.
        mArrayList = new ArrayList<>();
        // RecyclerView를 위해 CustomAdapter를 사용합니다.
        mAdapter = new CustomAdapter(mArrayList, getActivity().getApplicationContext());
        DataLoad_home(pageNum);        //get data
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new CustomAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                try {
                    ButtonFunc(position);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //onScrolled 를 통해서 현재 스크롤되고 있는 이벤트에 대해서 받아볼 수 있습니다.
        mLinearLayoutManager.setOrientation(mLinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //last position
                int lastVisibleItemPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                int itemTotalCount = mRecyclerView.getAdapter().getItemCount() - 1;
                if (lastVisibleItemPosition == itemTotalCount) {
                    Toast.makeText(getContext(), "Last Position", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // RecyclerView의 줄(row) 사이에 수평선을 넣기위해 사용됩니다.
       /*
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),

                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        */

        //set data 후에 view return
        return view;
    }

   // button.setOnClickListener
    public void ButtonFunc(int position) throws IOException {
        // mArrayList.get(position).TEST(text +" : " + position);
        // datapair - method
        mArrayList.get(position).savdId(this.getContext());
        mAdapter.notifyItemChanged(position);

    }
    public void DataLoad_home(final int num) {
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