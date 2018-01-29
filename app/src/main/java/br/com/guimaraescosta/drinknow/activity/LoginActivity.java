package br.com.guimaraescosta.drinknow.activity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import br.com.guimaraescosta.drinknow.R;

/**
 * Created by Diego on 22/01/2018.
 */

public class LoginActivity extends AppCompatActivity {

    private VideoView mVideoView;
    private Button loginButton;
    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mVideoView = (VideoView) findViewById(R.id.videoView);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video_drinks);
        mVideoView.setVideoURI(uri);
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(0,0);
            }
        });

        loginButton = (Button) findViewById(R.id.button);
        editText1 = (EditText)  findViewById(R.id.editText);
        editText2 = (EditText)  findViewById(R.id.editText2);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                // Inflate the Layout
                View layout = inflater.inflate(R.layout.my_custom_toast,
                        (ViewGroup) findViewById(R.id.custom_toast_layout));

                TextView text = (TextView) layout.findViewById(R.id.textToShow);
                text.setTextSize(18);
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);

                if (TextUtils.isEmpty(editText1.getText().toString())) {
                    // Set the Text to show in TextView
                    text.setText(" Preencha o seu nome para continuar ");
                    toast.show();

                } else if (TextUtils.isEmpty(editText2.getText().toString())) {
                    text.setText(" Preencha o código do evento para continuar ");
                    toast.show();

                } else {
                    Intent intentGoDrinksList = new Intent(LoginActivity.this, DrinksActivity.class);
                    startActivity(intentGoDrinksList);
                }
            }
        });

    }
}
