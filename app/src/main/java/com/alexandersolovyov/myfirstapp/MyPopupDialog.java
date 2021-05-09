package com.alexandersolovyov.myfirstapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class MyPopupDialog extends DialogFragment {
    public static String TAG = MyPopupDialog.class.getSimpleName();

    public static void show(FragmentManager fragmentManager) {
        MyPopupDialog dialog = new MyPopupDialog();
        dialog.show(fragmentManager, TAG);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflater = getActivity().getLayoutInflater().inflate(R.layout.my_popup_dialog, null);
        //mEditText = inflate.findViewById(R.id.et_info);

        builder.setTitle("Info")
                .setView(inflater)
                .setPositiveButton("ok", null);
                //.setNegativeButton("false", null);

        return builder.create();
        //return super.onCreateDialog(savedInstanceState);
    }
}
