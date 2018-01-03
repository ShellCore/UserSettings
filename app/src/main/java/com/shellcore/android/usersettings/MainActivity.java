package com.shellcore.android.usersettings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // Constantes
    private static final String NAME = "userSharedPreferences";
    private static final String UNKNOWN = "Desconocido";

    // Variables
    private User user = User.getSharedInstance();

    // Components
    @BindView(R.id.til_building)
    TextInputLayout tilBuilding;
    @BindView(R.id.til_floor)
    TextInputLayout tilFloor;
    @BindView(R.id.til_desk)
    TextInputLayout tilDesk;
    @BindView(R.id.til_phone)
    TextInputLayout tilPhone;
    @BindView(R.id.til_email)
    TextInputLayout tilEmail;

    @BindView(R.id.main_container)
    CoordinatorLayout mainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        onClickBtnSave();
    }

    @OnClick(R.id.btn_preview)
    public void onClickBtnPreview() {
        StringBuilder sb = new StringBuilder()
                .append(user.getBuilding()).append(", ")
                .append(user.getFloor()).append(", ")
                .append(user.getDesk()).append(", ")
                .append(user.getPhone()).append(", ")
                .append(user.getEmail()).append(".");

        Snackbar.make(mainContainer, sb.toString(), Snackbar.LENGTH_LONG)
                .show();
    }

    @OnClick(R.id.btn_load)
    public void onClickBtnLoad() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences(NAME, MODE_PRIVATE);

        user.setBuilding(preferences.getString(User.BUILDING_KEY, UNKNOWN));
        user.setFloor(preferences.getString(User.FLOOR_KEY, UNKNOWN));
        user.setDesk(preferences.getString(User.DESK_KEY, UNKNOWN));
        user.setPhone(preferences.getString(User.PHONE_KEY, UNKNOWN));
        user.setEmail(preferences.getString(User.EMAIL_KEY, UNKNOWN));
    }

    @OnClick(R.id.btn_save)
    public void onClickBtnSave() {
        loadDataFromLayout();
        saveUserPreferences();
    }

    private void loadDataFromLayout() {
        user.setBuilding(tilBuilding.getEditText().getText().toString());
        user.setFloor(tilFloor.getEditText().getText().toString());
        user.setDesk(tilDesk.getEditText().getText().toString());
        user.setPhone(tilPhone.getEditText().getText().toString());
        user.setEmail(tilEmail.getEditText().getText().toString());
    }

    private void saveUserPreferences() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences(NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(User.BUILDING_KEY, user.getBuilding());
        editor.putString(User.FLOOR_KEY, user.getFloor());
        editor.putString(User.DESK_KEY, user.getDesk());
        editor.putString(User.PHONE_KEY, user.getPhone());
        editor.putString(User.EMAIL_KEY, user.getEmail());

        editor.apply();

    }
}
