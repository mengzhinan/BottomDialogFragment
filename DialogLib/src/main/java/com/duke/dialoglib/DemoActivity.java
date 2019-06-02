package com.duke.dialoglib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DemoActivity extends AppCompatActivity {

    private Button button;

    BottomDialogFragment bottomDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo);
        button = findViewById(R.id.button_test);

        bottomDialogFragment = new BottomDialogFragment();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开对话框
//                bottomDialogFragment.show(getActivity().getSupportFragmentManager(), dialogFlag);
                bottomDialogFragment.show(DemoActivity.this.getSupportFragmentManager(), BottomDialogFragment.class.getSimpleName());
            }
        });
    }
}
