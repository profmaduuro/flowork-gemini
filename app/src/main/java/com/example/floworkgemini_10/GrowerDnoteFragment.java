package com.example.floworkgemini_10;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GrowerDnoteFragment#} factory method to
 * create an instance of this fragment.
 */
public class GrowerDnoteFragment extends Fragment {

    EditText grower_number, bale_group, bale_lot, scale_barcode;
    Button buttonReceiveBale;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grower_dnote, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        grower_number = view.findViewById(R.id.grower_number);
        bale_group = view.findViewById(R.id.bale_group);
        bale_lot = view.findViewById(R.id.bale_lot);
        scale_barcode = view.findViewById(R.id.scale_barcode);
        buttonReceiveBale = view.findViewById(R.id.buttonReceiveBale);

        buttonReceiveBale.setOnClickListener(v -> {
            String grower_number1 = grower_number.getText().toString();
            String bale_group1 = bale_group.getText().toString();
            String bale_lot1 = bale_lot.getText().toString();
            String scale_barcode1 = scale_barcode.getText().toString();
            sendDataToServer(grower_number1,bale_group1, bale_lot1,scale_barcode1);

        });
    }

    private void sendDataToServer(String grower_num, String bale_group, String bale_lot, String scale_barcode) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.48.128/flowork_gemini/grower_dnote.php",
                response -> Toast.makeText(getContext(), "Response: " + response, Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("grower_number", grower_num);
                params.put("bale_group", bale_group);
                params.put("bale_lot", bale_lot);
                params.put("scale_barcode", scale_barcode);
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(stringRequest);
    }
}