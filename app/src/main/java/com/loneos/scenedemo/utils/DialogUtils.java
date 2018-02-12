/*
 * Copyright (c) 2017.  PEOPLE INTERACTIVE INDIA PRIVATE LIMITED,  All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.loneos.scenedemo.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import com.loneos.scenedemo.R;

/**
 * Created by owaisI on 16/8/17.
 */

public class DialogUtils {

    //Progress Dialog
    public static ProgressDialog createProgressDialog(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context, ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.setMessage(message);
        return progressDialog;
    }

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    //List Dialog
    public static Dialog createListDialog(Context context, String title, String[] list, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (title != null)
            builder.setTitle(Html.fromHtml("<font color=" + ContextCompat.getColor(context, android.R.color.black)+ ">" + title + "</font>"));
        builder.setItems(list, listener);
        return builder.create();
    }

    //Yes/No Dialog
    public static Dialog createBinaryDialog(Context context, String title, String message, String positiveButtonText, String negativeButtonText, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        builder.setMessage(message);
        if (title != null)
            builder.setTitle(Html.fromHtml("<font color=" + ContextCompat.getColor(context,android.R.color.black) + ">" + title + "</font>"));
        builder.setNegativeButton(negativeButtonText, negativeListener);
        builder.setPositiveButton(positiveButtonText, positiveListener);
        Dialog dialog = builder.create();
        return dialog;
    }

    //Simple Information Dialog
    public static Dialog createSimpleInfoDialog(Context context, String title, String message, String positiveButtonText, DialogInterface.OnClickListener listener) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        if (title != null)
            builder.setTitle(Html.fromHtml("<font color=" + ContextCompat.getColor(context, android.R.color.black) + ">" + title + "</font>"));
        builder.setMessage(message);
        DialogInterface.OnClickListener onClickListener;
        if(listener != null) {
            onClickListener = listener;
        } else {
            onClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            };
        }
        builder.setPositiveButton(positiveButtonText, onClickListener);
        Dialog dialog = builder.create();
        return dialog;
    }
}
