package com.necistudio.libarary;

import android.Manifest;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.necistudio.libarary.adapter.FilePickerAdapter;
import com.necistudio.libarary.cursors.loadercallback.FileResultCallback;
import com.necistudio.libarary.item.Document;
import com.necistudio.libarary.utils.MediaStoreHelper;
import com.necistudio.libarary.utils.PermissionUtils;
import com.necistudio.libarary.view.FilterFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vim on 01/03/17.
 */

public class FilePickerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FilePickerAdapter adapter;
    private Toolbar toolbar;
    private TextView txtNull;
    private FloatingActionButton btnFilter;
    private List<String> itemfilter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.clrPrimaryDrakLib));
        }
        setContentView(R.layout.activitymain);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtNull = (TextView) findViewById(R.id.txtNull);
        btnFilter = (FloatingActionButton) findViewById(R.id.btnFilter);
        setSupportActionBar(toolbar);
        itemfilter = new ArrayList<>();
        itemfilter.add(".pdf");
        itemfilter.add(".txt");
        itemfilter.add(".docx");
        itemfilter.add(".doc");
        if (PermissionUtils.requestPermission(this, 1, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            getDocument();
        }

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = FilterFragment.newInstance((ArrayList<String>) itemfilter);
                dialogFragment.show(getFragmentManager(), "filter");
            }
        });
    }

    public void finishData(String path) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", "ok");
        returnIntent.putExtra("path", path);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    public void getDocument() {
        MediaStoreHelper mediaStoreHelper = new MediaStoreHelper();
        mediaStoreHelper.getDocs(this,itemfilter, new FileResultCallback<Document>() {
            @Override
            public void onResultCallback(List<Document> files) {
                recyclerView = (RecyclerView) findViewById(R.id.recycleMain);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new FilePickerAdapter(getApplicationContext(), FilePickerActivity.this, files);
                recyclerView.setAdapter(adapter);
                if (files.isEmpty()) {
                    txtNull.setVisibility(View.VISIBLE);
                }
                Log.e("data","loadagain");
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (PermissionUtils.permissionGranted(requestCode, 1, grantResults)) {
            getDocument();
        }
    }
}
