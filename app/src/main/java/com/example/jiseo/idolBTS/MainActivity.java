package com.example.jiseo.idolBTS;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.jiseo.retrofit.R;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    Retrofit retrofit;
    ApiService apiService;
    ArrayList<DataPair> DataPairs;
    String result;
    static int NUM=10;
    // recycler view
    private ArrayList<DataPair> mArrayList;
    private CustomAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private static final String TAG = MainActivity.class.getSimpleName(); // delete

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bottom bar
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
       //fragment set
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new Fragment_home())
                .commit();
        //FCM
        FirebaseInstanceId.getInstance().getToken();

        if (FirebaseInstanceId.getInstance().getToken() != null) {
            Log.d(TAG, "token = " + FirebaseInstanceId.getInstance().getToken());
        }
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment !=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.navigation_home:
                fragment= new Fragment_home();
                FragmentManager manager= getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
                break;
            case R.id.navigation_like:
                fragment= new Fragment_like();
                break;
            case R.id.navigation_chat:
                fragment= new Fragment_chat();
                break;
            case R.id.navigation_setting:
                fragment= new Fragment_setting();
                break;
        }
        return loadFragment(fragment);
    }

}
    /*
     mAdapter.setOnClick(new OnItemClicked() {
        @Override
        public void onItemClick(int position) {

        }
    });
    */
/*
//post부분
    Call<ResponseBody>comment2 = apiService.getPostComment(2);
        comment2.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                Log.v("Test", response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {

        }
    });
*/

/*

    public void initData(final int num){
        //recyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_home);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        // MainActivity에서 RecyclerView의 데이터에 접근시 사용됩니다.
        mArrayList = new ArrayList<>();
        // RecyclerView를 위해 CustomAdapter를 사용합니다.
        mAdapter = new CustomAdapter( mArrayList,this);
        mRecyclerView.setAdapter(mAdapter);
        // RecyclerView의 줄(row) 사이에 수평선을 넣기위해 사용됩니다.
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);





    Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Map map = new HashMap();
        map.put("name","map");

        ApiService retrofitService = retrofit.create(ApiService.class);
        Call<DataObject> call = retrofitService.getMovie(map);
        call.enqueue(new Callback<DataObject>() {
            @Override
            public void onResponse(Call<DataObject> call, Response<DataObject> response) {
                DataObject repo = response.body();
                for(int i=0;i<repo.getDatas().size();i++) {
                    if(i>num)
                        break;
                   //DataPair dict = new DataPair(repo.getDatas().get(i).getTitle(),repo.getDatas().get(i).getImage(),0 );
                    //temp embed
                    DataPair dict = new DataPair(repo.getDatas().get(i).getTitle(),"http://mblogthumb4.phinf.naver.net/20140813_187/thepianosam_1407904736320g5Qyz_PNG/%C0%A3%BD%C3%C4%DA%B1%E2_3.png?type=w2",0 );

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

 */