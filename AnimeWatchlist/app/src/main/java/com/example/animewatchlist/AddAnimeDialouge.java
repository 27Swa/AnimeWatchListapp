package com.example.animewatchlist;

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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AddAnimeDialouge extends AppCompatDialogFragment {
    private EditText addAnimeEditText;
//    private AddAnimeDialogListener animeListener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater=getActivity().getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.add_anime_dialogue,null);
        builder.setView(view)
                .setTitle("Add anime")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String addAnimeName=addAnimeEditText.getText().toString();
                    }
                });
        addAnimeEditText=view.findViewById(R.id.add_anime_id);
        return builder.create();
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        try {
//            animeListener=(AddAnimeDialogListener)context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString()+"must implement add anime dialogue");
//        }
//    }

    public interface AddAnimeDialogListener
    {
        void applyText(String addAnime);
    }
}
