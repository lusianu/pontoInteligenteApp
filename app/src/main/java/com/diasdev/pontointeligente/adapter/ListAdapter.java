package com.diasdev.pontointeligente.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.diasdev.pontointeligente.R;
import com.diasdev.pontointeligente.entities.TaskEntity;
import com.diasdev.pontointeligente.viewholder.ViewHolder;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<TaskEntity> mListTaskEntities;

    /**
     * Construtor
     */
    public ListAdapter(List<TaskEntity> taskList) {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        // Infla o layout da linha e faz uso na listagem
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
