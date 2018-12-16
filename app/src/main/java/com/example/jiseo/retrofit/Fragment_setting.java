package com.example.jiseo.retrofit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment_setting extends Fragment {
    @Nullable

    Button button_usage;
    Button button_privacy;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, null);
       /*
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        button_usage = (Button) v.findViewById(R.id.tv_item_title);
        button_privacy = (Button) v.findViewById(R.id.button_privacy);

        button_usage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.naver.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.addCategory(Intent.CATEGORY_APP_BROWSER);

            }
        });

        button_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.naver.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.addCategory(Intent.CATEGORY_APP_BROWSER);

            }
        });

       */


    }


}
