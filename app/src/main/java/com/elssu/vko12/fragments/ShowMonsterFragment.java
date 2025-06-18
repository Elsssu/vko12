package com.elssu.vko12.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elssu.vko12.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShowMonsterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowMonsterFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_monster, container, false);

        return view;
    }
}