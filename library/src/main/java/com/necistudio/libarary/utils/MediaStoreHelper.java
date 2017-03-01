package com.necistudio.libarary.utils;

import android.support.v4.app.FragmentActivity;

import com.necistudio.libarary.cursors.DocScannerTask;
import com.necistudio.libarary.cursors.loadercallback.FileResultCallback;
import com.necistudio.libarary.item.Document;

import java.util.List;

public class MediaStoreHelper {

  public static void getDocs(FragmentActivity activity, List<String> itemfilter, FileResultCallback<Document> fileResultCallback)
  {
    new DocScannerTask(activity,fileResultCallback,itemfilter).execute();
  }
}