package com.example.ososassignment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class dialog extends AppCompatDialogFragment {
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextRoll;
    private  dialogListerner listerner;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.layout_dialogue,null);
        builder.setView(view)
                .setTitle("add")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name=editTextName.getText().toString();
                        String age=editTextAge.getText().toString();
                        String roll=editTextRoll.getText().toString();
                        listerner.applyTexts(name,age,roll);
                    }
                });
        editTextAge=view.findViewById(R.id.age);
        editTextName=view.findViewById(R.id.name);
        editTextRoll=view.findViewById(R.id.roll);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listerner=(dialogListerner) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+
                    "Must implement dialoglistener");
        }
    }

    public interface dialogListerner{
        void applyTexts(String name,String age,String roll);


    }
}
