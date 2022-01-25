package com.example.bluepill.User.Features.UserInfo;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.Common.UserLogInSignUp.UserStartUpScreen;
import com.example.bluepill.R;
import com.example.bluepill.User.UserDashboardActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfile extends AppCompatActivity {
    private BottomSheetDialog bottomSheetDialog;
    private Dialog dialog, emailDialog;
    Button positive, negative;
    Button yesBtn, noBtn;
    private RelativeLayout takePhoto, choosePhoto, removePhoto;

    private CircleImageView profilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_profile);

        // Hooks
        profilePicture = findViewById(R.id.dummy_doctor);

        profilePicture.setOnClickListener(v -> {
            bottomSheetDialog = new BottomSheetDialog(UserProfile.this, R.style.BottomSheetTheme);

            View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.profile_bottom_sheet,
                    findViewById(R.id.profile_sheet));

            bottomSheetDialog.setContentView(sheetView);

            bottomSheetDialog.show();

            // Hooks
            takePhoto = bottomSheetDialog.findViewById(R.id.take_photo);
            choosePhoto = bottomSheetDialog.findViewById(R.id.choose_photo);
            removePhoto = bottomSheetDialog.findViewById(R.id.remove_photo);

            takePhoto.setOnClickListener(v1 -> {
                //Open Camera app and take photo
                takePictureAndUpload();
                
            });

            choosePhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Open Gallery and choose photo
                    Intent galleryIntent = new Intent();
                    galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                    galleryIntent.setType("image/*");
                    startActivityForResult(galleryIntent, 2);

                    // Upload & Save Picture

                    bottomSheetDialog.dismiss();
                }
            });

            removePhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showConfirmationDialog();
                }
            });

        });
    }

    private void takePictureAndUpload() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null){
            Uri mImageUri = data.getData();

            profilePicture.setImageURI(mImageUri);
        }

    }

    private void showConfirmationDialog() {

        dialog = new Dialog(UserProfile.this, R.style.BottomSheetTheme);

        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.delete_profile_picture_confirmation_dialog,
                findViewById(R.id.confirm_popup));

        dialog.setContentView(dialogView);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.show();

        //Hooks
        yesBtn = dialogView.findViewById(R.id.positive);
        noBtn = dialogView.findViewById(R.id.negative);

        yesBtn.setOnClickListener(v -> {
            // Change logo to default dummy logo
            profilePicture.setBorderColor(getColor(R.color.signature_blue_darker));
            profilePicture.setImageResource(R.drawable.dummy_profile);

            // Upload the image to firebase
            pushToFirebase();

            dialog.dismiss();
            bottomSheetDialog.dismiss();
        });
        noBtn.setOnClickListener(v -> dialog.dismiss());

    }

    // Work on this method later on
    private void pushToFirebase() {
    }

    public void callUserDashboardActivity(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
    }

    private void verifyEmailPopup() {
        emailDialog = new Dialog(UserProfile.this, R.style.BottomSheetTheme);

        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.send_email_confirmation_popup, findViewById(R.id.send_email_confirmation));

        emailDialog.setContentView(dialogView);

        emailDialog.show();

        // Popup Hooks
        positive = emailDialog.findViewById(R.id.positive);
        negative = emailDialog.findViewById(R.id.negative);


        positive.setOnClickListener(v -> {
            // Start Email Verification Process
            //TO DO
            emailDialog.dismiss();
            finish();
        });
        negative.setOnClickListener(v -> {
            // Dismiss
            emailDialog.dismiss();
            finish();
        });

    }
}