package com.e.chatme;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {

    private CircleImageView profile;
    private Button btUpload;
    private static final int PICK_IMAGE_REQUEST=1;
    private Uri profileUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        profile =(CircleImageView)findViewById(R.id.profile_image_id);
        profile.setCircleBackgroundColor(android.R.color.white);
        profile.setBorderColor(android.R.color.holo_blue_bright);
        profile.setBorderWidth(2);
        profile.setBorderOverlay(true);
        
        btUpload =(Button)findViewById(R.id.bt_upload_id);
        btUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });
        
        


    }

    private void chooseImage() {

        Intent chooseImageIntent = new Intent();
        chooseImageIntent.setType("image/*");

        chooseImageIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(chooseImageIntent,PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            profileUri = data.getData();
            profile.setImageURI(profileUri);
        }else{
            Toast.makeText(this, "No picture selected", Toast.LENGTH_SHORT).show();
        }
    }
}
