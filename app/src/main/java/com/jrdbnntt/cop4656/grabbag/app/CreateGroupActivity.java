package com.jrdbnntt.cop4656.grabbag.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jrdbnntt.cop4656.grabbag.R;

import java.util.Random;
import java.lang.StringBuilder;

public class CreateGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
    }

    public void clickCreateGroup(View view)
    {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, GroupScreenActivity.class);
        String genID = generateID();
        if(true)//genID not in DB) //create the group
        {
            bundle.putString("ID", genID);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else
        {//get new group ID
            String newID = generateID();
            /*while(newID in DB)
              {
                  newID = generateID(); //keep generating new IDs if they are in the DB already
              }
            */
            bundle.putString("ID", newID);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    public String generateID()
    {
        StringBuilder temp = new StringBuilder();
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int nums = alphabet.length();
        Random rand = new Random();
        for(int i = 0; i < 10; i++)
        {
            temp.append(alphabet.charAt(rand.nextInt(nums)));
        }
        String generatedID = temp.toString();

        return generatedID;
    }
}
