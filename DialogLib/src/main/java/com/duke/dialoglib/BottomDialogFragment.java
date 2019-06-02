package com.duke.dialoglib;

import android.app.Dialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * @Author: duke
 * @DateTime: 2019-06-02 17:24
 * @Description:
 */
public class BottomDialogFragment extends BaseBottomDialogFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_content;
    }

    @Override
    protected void reSetupDialog(Dialog dialog) {
//        super.reSetupDialog(dialog);
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
        setStyle(STYLE_NO_FRAME, R.style.BottomDialogTheme);
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        layoutParams.dimAmount = 0.0f;
        //设置透明度
//        layoutParams.alpha = 0.5f;
        // 设置对话框位置
//        layoutParams.gravity = Gravity.BOTTOM;
        window.setGravity(Gravity.BOTTOM);
        window.getDecorView().setPadding(10, 10, 10, 10);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setWindowAnimations(R.style.BottomDialogAnimation);
        //再次设置出现动画
//        window.getAttributes().windowAnimations = R.style.BottomDialogAnimation;
        //去除黑边
//        window.setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        window.setAttributes(layoutParams);
    }

}
