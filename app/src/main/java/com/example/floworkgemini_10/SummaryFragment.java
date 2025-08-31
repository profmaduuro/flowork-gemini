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
 * Use the {@link SummaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SummaryFragment extends Fragment {

   EditText sellingPoint, bale_location, bale_barcode, floor_row;

   Button buttonFloorSum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_summary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sellingPoint = view.findViewById(R.id.sellingPoint);
        bale_location = view.findViewById(R.id.bale_location);
        bale_barcode = view.findViewById(R.id.bale_barcode);
        floor_row = view.findViewById(R.id.floor_row);
        buttonFloorSum = view.findViewById(R.id.buttonFloorSum);

        buttonFloorSum.setOnClickListener(v -> {
            String sellingPoint1 = sellingPoint.getText().toString();
            String bale_location1 = bale_location.getText().toString();
            String bale_barcode1 = bale_barcode.getText().toString();
            String floor_row1 = floor_row.getText().toString();
            sendDataToServer(sellingPoint1, bale_location1, bale_barcode1, floor_row1);

        });
    }

    private void sendDataToServer( String sellingPoint, String bale_location, String bale_barcode, String floor_row ) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://192.168.48.128/flowork_gemini/floor_summary.php",
                response -> Toast.makeText(getContext(), "Response: " + response, Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("sellingPoint", sellingPoint);
                params.put("bale_location", bale_location);
                params.put("bale_barcode", bale_barcode);
                params.put("floor_row", floor_row);
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(stringRequest);
    }
}