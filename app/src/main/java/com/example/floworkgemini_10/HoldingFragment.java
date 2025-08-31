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
 * Use the {@link HoldingFragment#} factory method to
 * create an instance of this fragment.
 */
public class HoldingFragment extends Fragment {

    EditText hold_reason, scale_barcode;
    Button buttonHoldSubmit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_holding, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        scale_barcode = view.findViewById(R.id.scale_barcode);
        hold_reason = view.findViewById(R.id.hold_reason);
        buttonHoldSubmit = view.findViewById(R.id.buttonHoldSubmit);

        buttonHoldSubmit.setOnClickListener(v -> {
            String hold_reason1 = hold_reason.getText().toString();
            String scale_barcode1 = scale_barcode.getText().toString();
            sendDataToServer(scale_barcode1, hold_reason1);

        });
    }

    private void sendDataToServer( String scale_barcode, String hold_reason) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://192.168.1.145/flowork_gemini/hold_area.php",
                response -> Toast.makeText(getContext(), "Response: " + response, Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("scale_barcode", scale_barcode);
                params.put("hold_reason", hold_reason);
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(stringRequest);
    }
}