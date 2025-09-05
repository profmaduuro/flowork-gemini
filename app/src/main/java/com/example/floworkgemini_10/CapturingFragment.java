package com.example.floworkgemini_10;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialog;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CapturingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CapturingFragment extends Fragment {

BottomSheetDialog bottomSheetDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_capturing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonShowDialog = view.findViewById(R.id.buttonShowDialog);


        buttonShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog = new BottomSheetDialog(getContext());
                bottomSheetDialog.setContentView(R.layout.capturing_bottomsheet);
                bottomSheetDialog.setCancelable(true);
                bottomSheetDialog.setCanceledOnTouchOutside(true);
                bottomSheetDialog.show();

            }
        });
    }


}