package com.example.additionlibrary;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AdditionLibrary {

//    public static void toastMessage(Context c, String message){
//
//        Toast.makeText(c,message, Toast.LENGTH_SHORT).show();
//
//    }

    public static void startAdditionActivity(Context context){

        Intent intent = new Intent(context,AdditionActivity.class);
        context.startActivity(intent);
    }


    public static void resultMessage(Context c, Double result){

        Toast.makeText(c,String.valueOf(result), Toast.LENGTH_SHORT).show();

    }



}
