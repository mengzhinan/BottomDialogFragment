package com.duke.dialoglib;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * @Author: duke
 * @DateTime: 2019-06-02 19:59
 * @Description:
 */
abstract public class BaseBottomDialogFragment extends DialogFragment {

    public BaseBottomDialogFragment() {
//        setStyle(STYLE_NO_FRAME, R.style.BottomDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Set to adjust screen height automatically, when soft keyboard appears on screen
        // getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        try {
            View view = inflater.inflate(getLayoutId(), container, false);
            if (view != null) {
                return view;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null && dialog.getWindow().getAttributes() != null) {
            reSetupDialog(dialog);
        }
    }

    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 设置对话框样式
     *
     * @param dialog
     */
    protected void reSetupDialog(Dialog dialog) {
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
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            layoutParams.width = displayMetrics.widthPixels - 20;
        }
        layoutParams.y = 10; // 新位置Y坐标
//        layoutParams.x = 10; // 新位置X坐标
        layoutParams.dimAmount = 0.5f;
        //设置透明度
//        layoutParams.alpha = 0.5f;
        // 设置对话框位置
//        layoutParams.gravity = Gravity.BOTTOM;
        window.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        window.getDecorView().setPadding(10, 10, 10, 10);

        //去除黑边
        window.setBackgroundDrawableResource(android.R.color.transparent);
        //去除系统自带的margin
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setWindowAnimations(R.style.BottomDialogAnimation);
        //再次设置出现动画
//        window.getAttributes().windowAnimations = R.style.BottomDialogAnimation;

        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        window.setAttributes(layoutParams);
    }

    /**
     * 获取屏幕宽、高
     *
     * @return Display
     */
    protected DisplayMetrics getDisplayMetrics() {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return null;
        }
        Window window = dialog.getWindow();
        if (window == null) {
            return null;
        }
        WindowManager windowManager = window.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        if (display == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        return displayMetrics;
    }
}
