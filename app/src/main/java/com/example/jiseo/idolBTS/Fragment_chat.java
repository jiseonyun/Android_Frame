package com.example.jiseo.idolBTS;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jiseo.retrofit.R;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Fragment_chat extends Fragment {
    View view;
    String text;
    FileOutputStream fos;
    TextView txtRead;
    TextView txtRead2;

    String line;
    ArrayList alist = new ArrayList();


    private static final String FILENAME = "LikeList.txt";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chat, null);

        return view;

    }
}
