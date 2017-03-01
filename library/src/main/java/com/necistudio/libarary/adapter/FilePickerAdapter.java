package com.necistudio.libarary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.necistudio.libarary.FilePickerActivity;
import com.necistudio.libarary.R;
import com.necistudio.libarary.item.Document;

import java.util.List;

/**
 * Created by vim on 01/03/17.
 */

public class FilePickerAdapter extends RecyclerView.Adapter<FilePickerAdapter.FilePickerHolder> {
    private Context context;
    private List<Document> feedlist;
    private FilePickerActivity activity;
    public FilePickerAdapter(Context context, FilePickerActivity activity,List<Document>feedlist){
        this.context = context;
        this.activity = activity;
        this.feedlist = feedlist;
    }
    @Override
    public FilePickerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_document, parent, false);
        return new FilePickerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FilePickerHolder holder, int position) {
        final Document document = feedlist.get(position);
        holder.imgIcon.setImageResource(document.getTypeDrawable());
        holder.txtName.setText(document.getTitle());
        holder.txtSize.setText(Formatter.formatShortFileSize(context, Long.parseLong(document.getSize())));
        holder.txtPath.setText(document.getPath());

        holder.relativeMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finishData(document.getPath());
            }
        });
    }

    @Override
    public int getItemCount() {
        return feedlist.size();
    }

    public class FilePickerHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView txtName,txtSize,txtPath;
        RelativeLayout relativeMain;
        public FilePickerHolder(View itemView) {
            super(itemView);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtSize = (TextView) itemView.findViewById(R.id.txtSize);
            txtPath = (TextView) itemView.findViewById(R.id.txtPath);
            relativeMain = (RelativeLayout)itemView.findViewById(R.id.relativeMain);
        }
    }
}
