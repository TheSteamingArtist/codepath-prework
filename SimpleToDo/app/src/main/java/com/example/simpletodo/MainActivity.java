package com.example.simpletodo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import org.apache.commons.io.FileUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    public static final String KEY_ITEM_TEXT = "item text";
    public static final String KEY_ITEM_POSITION = "item position";
    public static final int EDIT_TEXT_CODE = 20;


    List<String> items;

    Button btnAdd;
    EditText etItem;
    RecyclerView rvItems;

    ItemsAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.AddButton);
        etItem = findViewById(R.id.editTextItem);
        rvItems = findViewById(R.id.Items);

        loadItems();

        ItemsAdapter.OnLongClickListener onLongClickListener = new ItemsAdapter.OnLongClickListener() {
            @Override
            public void onItemLongClicked(int position) {
                    //Delete the item from the model
                items.remove(position);
                //Notify the adapter at the position we deleted the item
                itemsAdapter.notifyItemRemoved(position);
                Toast.makeText(getApplicationContext(), "Task successfully removed", Toast.LENGTH_SHORT).show();
                saveItems();
            }
        };

        ItemsAdapter.OnClickListener onClickListener = new ItemsAdapter.OnClickListener() {
            @Override
            public void OnItemClicked(int position)
            {
                Log.d("MainActivity", "Single click at position" + position);
                //Create the new activity
                Intent i = new Intent(MainActivity.this, EditActivity.class);
                // pass the data being edited
                i.putExtra(KEY_ITEM_TEXT, items.get(position));
                i.putExtra(KEY_ITEM_POSITION, position);
                // display the activity

                startActivityForResult(i, EDIT_TEXT_CODE);
            }
        };
        itemsAdapter = new ItemsAdapter(items, onLongClickListener, onClickListener);

        rvItems.setAdapter(itemsAdapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toDoItem = etItem.getText().toString();
                //add item to model

                items.add(toDoItem);
                //Notify adapter that item is inserted

                itemsAdapter.notifyItemInserted(items.size()-1);

                etItem.setText("");

                Toast.makeText(getApplicationContext(), "Task successfully added", Toast.LENGTH_SHORT).show();
                saveItems();
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == EDIT_TEXT_CODE) {
            //Retrieve updated txt value
            String itemText = data.getStringExtra(KEY_ITEM_TEXT);
            // extract original position of editted item from position key
            int position = data.getExtras().getInt(KEY_ITEM_POSITION);

            //update the model at the right position with the new item text
            items.set(position, itemText);
            //notify adapter
            itemsAdapter.notifyItemChanged(position);

            //persist changes
            saveItems();

            Toast.makeText(getApplicationContext(), "Task successfully updated!", Toast.LENGTH_SHORT).show();

        } else {
            Log.w("MainActivity", "Unknown call to OnActivityResult");
        }
    }

    private File getDataFile()
    {
        return new File(getFilesDir(), "data.txt");
    }

    //This function will load items by reading every line of the data file

    private void loadItems()
    {
        try {
            items = new ArrayList<>(FileUtils.readLines(getDataFile(), Charset.defaultCharset()));
        }
        catch (IOException e)
        {
            Log.e("MainActivity", "Error reading items", e);
            items = new ArrayList<>();
        }
    }

    //This function saves items by writing them into the data file
    private void saveItems()
    {
        try {
            FileUtils.writeLines(getDataFile(), items);
        } catch (IOException e) {
            Log.e("MainActivity", "Error writing items", e);
        }
    }
}