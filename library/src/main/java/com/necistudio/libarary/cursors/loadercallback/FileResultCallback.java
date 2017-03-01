package com.necistudio.libarary.cursors.loadercallback;

import java.util.List;

public interface FileResultCallback<T> {
    void onResultCallback(List<T> files);
  }