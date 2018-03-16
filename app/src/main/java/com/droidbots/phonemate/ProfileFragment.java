package com.droidbots.phonemate;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment {


    private static final int REQUEST_CAMERA = 0;
    private static final int SELECT_FILE = 1;
    private ImageButton editButton;
    private Button saveButton;
    private EditText editName, editEmail, editPhone, editCity;
    private ImageView profileImageView;
    private ProgressBar progressBar;
    private String token,profpic,userChosenTask;
    private SharedPreferences sharedPreferences;
    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (getActivity() != null) {
            ((OnFragmentInteractionListener) getActivity()).onFragmentInteraction(R.id.nav_profile);
        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        editName = view.findViewById(R.id.profile_name);
        editEmail = view.findViewById(R.id.profile_email);
        editPhone = view.findViewById(R.id.profile_phone);
        editCity = view.findViewById(R.id.profile_city);
        editButton = view.findViewById(R.id.profile_editbtn);
        saveButton = view.findViewById(R.id.profile_savebtn);
        profileImageView = view.findViewById(R.id.profile_image);
        progressBar = view.findViewById(R.id.profile_progressbar);

        progressBar.setVisibility(View.GONE);

        sharedPreferences = this.getActivity().getSharedPreferences("login_pref", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");
        profpic = sharedPreferences.getString("profpic", null);
        boolean googlePhotoIsSet = sharedPreferences.getBoolean("googlePhoto", false);

        if((profpic != null && profpic.equals("")) || profpic == null) {
            profileImageView.setImageDrawable(getResources().getDrawable(R.drawable.default_profile_picture));
        } else if(googlePhotoIsSet) {
            Glide.with(this)
                    .load(Uri.parse(profpic))
                    .placeholder(R.drawable.default_profile_picture)
                    .error(R.drawable.default_profile_picture)
                    .override(150, 150)
                    .centerCrop()
                    .into(profileImageView);
        }
        else {
            profileImageView.setImageBitmap(decodeBase64(profpic));
        }

        APIService service = APIClient.getClient().create(APIService.class);

        Call<User> profileCall = service.getUserProfile(token);

        profileCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                editName.setText(response.body().getName());
                editEmail.setText(response.body().getEmail());
                editPhone.setText(response.body().getPhone());
                editCity.setText(response.body().getCity());
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                editName.setText("");
                editPhone.setText("");
                editCity.setText("");
                Toast.makeText(getActivity(), "Could not get your profile! Internet Connection was not established", Toast.LENGTH_SHORT).show();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editName.setEnabled(true);
                editPhone.setEnabled(true);
                editCity.setEnabled(true);
                saveButton.setEnabled(true);
                saveButton.setVisibility(View.VISIBLE);
                editButton.setVisibility(View.INVISIBLE);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validate()) {
                    Toast.makeText(getActivity(), "Invalid data entered", Toast.LENGTH_SHORT).show();
                    return;
                }

                saveToServer();

                editName.setEnabled(false);
                editPhone.setEnabled(false);
                editCity.setEnabled(false);
                editButton.setEnabled(true);
                saveButton.setVisibility(View.INVISIBLE);
                editButton.setVisibility(View.VISIBLE);
            }
        });

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        return view;
    }

    private void saveToServer() {
        showpBar();

        String name = editName.getText().toString();
        String[] fullName = name.split(" ", 2);
        String phone = editPhone.getText().toString();
        String city = editCity.getText().toString();

        APIService service = APIClient.getClient().create(APIService.class);

        User user = new User(null, null, fullName[0], fullName[1], city, phone, null, null);
        Call<ProfileMsg> updateCall = service.updateUserProfile(user, token);

        updateCall.enqueue(new Callback<ProfileMsg>() {
            @Override
            public void onResponse(@NonNull Call<ProfileMsg> call, @NonNull Response<ProfileMsg> response) {
                hidepBar();

                if (response.body().getStatus().equals("success")) {
                    Toast.makeText(getActivity(), "Profile updated successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Profile not found!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ProfileMsg> call, @NonNull Throwable t) {
                hidepBar();
                Toast.makeText(getActivity(), "Check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validate() {
        boolean valid = true;

        String name = editName.getText().toString();
        String phone = editPhone.getText().toString();
        String city = editCity.getText().toString();

        if (name.length() < 2) {
            editName.setError("At least 2 characters must be present");
            editName.requestFocus();
            valid = false;
        } else {
            editName.setError(null);
        }

        if (!isValidMobile(phone)) {
            editPhone.setError("Not a valid phone number");
            editPhone.requestFocus();
            valid = false;
        } else {
            editPhone.setError(null);
        }

        if (city.length() < 2) {
            editCity.setError("Not a valid city");
            editCity.requestFocus();
            valid = false;
        } else {
            editCity.setError(null);
        }
        return valid;
    }

    private boolean isValidMobile(String mobile) {
        boolean valid;
        valid = !Pattern.matches("[a-zA-Z]+", mobile) && mobile.length() == 10;
        return valid;
    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Remove Picture", "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean StorageResult= MarshmallowPermissions.checkStoragePermission(getActivity());
                boolean CameraResult = MarshmallowPermissions.checkCameraPermission(getActivity());
                if (items[item].equals("Take Photo")) {
                    userChosenTask="Take Photo";
                    if(CameraResult)
                        cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    userChosenTask="Choose from Library";
                    if(StorageResult)
                        galleryIntent();
                } else if(items[item].equals("Remove Picture")) {
                    removePicture();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(getCropIntent(intent), REQUEST_CAMERA);
    }

    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(getCropIntent(intent), "Select File"),SELECT_FILE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MarshmallowPermissions.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(getCropIntent(data));
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(getCropIntent(data));
        }
    }

    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(this.getActivity().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profpic", encodeTobase64(bm));
        editor.apply();
        profileImageView.setImageBitmap(bm);
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        if (thumbnail != null) {
            thumbnail.compress(Bitmap.CompressFormat.PNG, 100, bytes);
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profpic", encodeTobase64(thumbnail));
        editor.apply();
        profileImageView.setImageBitmap(thumbnail);
    }

    public static String encodeTobase64(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }

    public static Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    private Intent getCropIntent(Intent intent) {
        intent.putExtra("crop", "true");
        intent.putExtra("scale", "true");
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("return-data", true);
        return intent;
    }

    private void removePicture() {
        profileImageView.setImageDrawable(getResources().getDrawable(R.drawable.default_profile_picture));
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(profpic != null) {
            editor.putString("profpic", "");
            editor.apply();
        }
        if(sharedPreferences.getBoolean("googlePhoto", false))
            editor.putBoolean("googlePhoto", false);
    }

    private void showpBar() {
        editName.setEnabled(false);
        editPhone.setEnabled(false);
        editCity.setEnabled(false);
        saveButton.setEnabled(false);
        editButton.setEnabled(false);
        profileImageView.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hidepBar() {
        editButton.setEnabled(true);
        profileImageView.setEnabled(true);
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int id);
    }
}
