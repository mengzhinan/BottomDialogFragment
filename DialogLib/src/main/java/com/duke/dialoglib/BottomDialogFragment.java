package com.duke.dialoglib;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * @Author: duke
 * @DateTime: 2019-06-02 17:24
 * @Description:
 */
public class BottomDialogFragment extends BaseBottomDialogFragment {
    private TextView closeTV;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        closeTV = view.findViewById(R.id.close);
        closeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomDialogFragment.this.dismiss();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_content;
    }

    @Override
    protected void reSetupDialog(Dialog dialog) {
        super.reSetupDialog(dialog);
//        if (dialog == null) {
//            return;
//        }
//        Window window = dialog.getWindow();
//        if (window == null) {
//            return;
//        }
//        WindowManager.LayoutParams layoutParams = window.getAttributes();
//        if (layoutParams == null) {
//            return;
//        }
//
//        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
//        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        DisplayMetrics displayMetrics = getDisplayMetrics();
//        if (displayMetrics != null) {
//            layoutParams.width = displayMetrics.widthPixels - 20;
//        }
////        layoutParams.x = 10; // 新位置X坐标
//        layoutParams.y = 10; // 新位置Y坐标
//        layoutParams.dimAmount = 0.5f;
//        //设置透明度
//        layoutParams.alpha = 0.5f;
//        // 设置对话框位置
////        layoutParams.gravity = Gravity.BOTTOM;
//        window.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
//        window.getDecorView().setPadding(10, 10, 10, 10);
//        //去除黑边
//        window.setBackgroundDrawableResource(android.R.color.transparent);
//        //去除系统自带的margin
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        window.setWindowAnimations(R.style.BottomDialogAnimation);
//
//        window.setAttributes(layoutParams);
//
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(true);
    }

}
