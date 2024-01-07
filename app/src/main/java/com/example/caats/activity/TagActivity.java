package com.example.caats.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.caats.R;
import com.example.caats.http.HttpService;
import com.example.caats.http.RetrofitBuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TagActivity extends AppCompatActivity {

    ImageView image;
    Button btn_generate;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);

        image = findViewById(R.id.img_bg);
        btn_generate = findViewById(R.id.btn_generate);
        progress = findViewById(R.id.progressBar);
        EditText tag = findViewById(R.id.field_text);


        RetrofitBuilder rb = new RetrofitBuilder();
        HttpService httpService = rb.RetrofitCLient();

        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progress.setVisibility(View.VISIBLE);
                image.setVisibility(View.VISIBLE);
                String tag_text = tag.getText().toString();
                Call<ResponseBody> call = httpService.getImageTag(tag_text);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Bitmap bmp = BitmapFactory.decodeStream(response.body().byteStream());
                        image.setImageBitmap(bmp);
                        progress.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("RESPONSE", t.getMessage());
                    }
                });
            }
        });
    }
}