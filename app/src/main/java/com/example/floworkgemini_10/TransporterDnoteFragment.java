package com.example.floworkgemini_10;

import static java.security.AccessController.getContext;

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
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;


public class TransporterDnoteFragment extends Fragment {
    EditText transporter_name, transporter_id,truck_number,delivery_location,transporter_contact,sale_date;
    Button button;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transporter_dnote, container, false);

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        transporter_name = view.findViewById(R.id.transporter_name);
        transporter_id = view.findViewById(R.id.transporter_id);
        truck_number = view.findViewById(R.id.truck_number);
        delivery_location = view.findViewById(R.id.delivery_location);
        transporter_contact = view.findViewById(R.id.transporter_contact);
        sale_date = view.findViewById(R.id.sale_date);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(v -> {
            String transporter_name1 = transporter_name.getText().toString();
            String transporter_id1 = transporter_id.getText().toString();
            String truck_number1 = truck_number.getText().toString();
            String transporter_contact1 = transporter_contact.getText().toString();
            String delivery_location1 = delivery_location.getText().toString();
            String sale_date1 = sale_date.getText().toString();
            sendDataToServer(transporter_name1, transporter_id1, truck_number1, transporter_contact1, delivery_location1, sale_date1);

        });
    }

    private void sendDataToServer(String transporter_name, String transporter_id, String truck_number, String transporter_contact, String delivery_location, String sale_date) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168..128/flowork_gemini/submit.php",
                response -> Toast.makeText(getContext(), "Response: " + response, Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("transporter_name", transporter_name);
                params.put("transporter_id", transporter_id);
                params.put("truck_number", truck_number);
                params.put("transporter_contact", transporter_contact);
                params.put("delivery_location", delivery_location);
                params.put("sale_date", sale_date);
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(stringRequest);
    }


}