package com.duke.dialoglib;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * @Author: duke
 * @DateTime: 2019-06-02 17:24
 * @Description:
 */
public class BottomDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Set to adjust screen height automatically, when soft keyboard appears on screen
//        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        View view = inflater.inflate(R.layout.dialog_content, container, false);
        if (view != null) {
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.BOTTOM;
//        window.setGravity(Gravity.BOTTOM);
        window.getDecorView().setPadding(10, 10, 10, 10);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setWindowAnimations(R.style.BottomDialogWindowAnim);
//        dialog.onWindowAttributesChanged(layoutParams);//设置点击外围解散
        dialog.setCanceledOnTouchOutside(true);
        window.setAttributes(layoutParams);
    }
}
