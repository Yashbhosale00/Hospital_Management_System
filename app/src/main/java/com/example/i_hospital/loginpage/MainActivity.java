package com.example.i_hospital.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.i_hospital.R;
import com.example.i_hospital.admin.AdminHomeActivity;
import com.example.i_hospital.retrofitinstance.RetrofitInstance;
import com.example.i_hospital.retrofitinstance.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Spinner userTypeSpinner;
    private Button loginButton;
    private RetrofitInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        userTypeSpinner = findViewById(R.id.userTypeSpinner);
        loginButton = findViewById(R.id.LoginButton);


        apiService = RetrofitInstance.getRetrofit().create(RetrofitInterface.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String username = usernameEditText.getText().toString().trim();
//                String password = passwordEditText.getText().toString().trim();
//                String role = userTypeSpinner.getSelectedItem().toString();
//
//                if (!username.isEmpty() && !password.isEmpty()) {
//                    loginUser(username, password, role);
//                } else {
//                    Toast.makeText(MainActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
//                }
                Intent intent = new Intent(MainActivity.this, AdminHomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser(String username, String password, String role) {
        Call<String> call = apiService.checkLoginUser(username, password, role);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String responseBody = response.body();
                    if (responseBody != null && responseBody.equals("1")) {
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        // Handle successful login
                    } else {
                        Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Failed to connect to server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("Login Error", "Error: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Failed to connect to server", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

//retrofitcall
// btn.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        CRUDWorkType(addActivity.this);
//        }
//        });
//
//
//
//
//        }
//
//public void CRUDWorkType(Context context){
//
//        RetrofitInterface retrofitInterface = RetrofitInstance.getSeviceData();
//        retrofitInterface.DoctorLogin("Insert","",UserFname.getText().toString().trim(),"UserLastName.getText().toString().trim()")
//        .enqueue(new Callback<Map<String, String>>() {
//@Override
//public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
//        Log.d("response", response.toString());
//        if (response.isSuccessful()) {
//        if (response.body().get("status").equals("1")) {
//        Toast.makeText(context, "Successful", Toast.LENGTH_SHORT).show();
//        }
//
//        } else {
//        Toast.makeText(context, "Failed to update data", Toast.LENGTH_SHORT).show();
//        }
//        }
//
//        @Override
//        public void onFailure(Call<Map<String, String>> call, Throwable t) {
//        Log.e("YourTag", "API Call Error: " + t.getMessage()); // Log the API call error message
//        Toast.makeText(context, "Check Internet Connection", Toast.LENGTH_SHORT).show();
//        }
//        });
//        }