package com.diasdev.pontointeligente.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.diasdev.pontointeligente.R;
import com.diasdev.pontointeligente.adapter.ListAdapter;
import com.diasdev.pontointeligente.entities.TaskEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements View.OnClickListener {

    private Context mContext;
    private List<TaskEntity> mTaskEntityList;
    private ListAdapter mTaskListAdapter;
    private ViewHolder mViewHolder = new ViewHolder();

    public static com.diasdev.pontointeligente.views.ListFragment newInstance() {
        com.diasdev.pontointeligente.views.ListFragment fragment = new com.diasdev.pontointeligente.views.ListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Infla o layout
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        // Incializa as variáveis
        this.mContext = rootView.getContext();

        // Inicializa elementos
        this.mViewHolder.floatAddTask = (FloatingActionButton) rootView.findViewById(R.id.float_add_task);

        // Inicializa eventos
        this.mViewHolder.floatAddTask.setOnClickListener(this);

        // 1 - Obter a recyclerview
        this.mViewHolder.recylerTaskList = (RecyclerView) rootView.findViewById(R.id.recycler_task_list);

        // 2 - Definir adapter passando listagem de itens
        this.mTaskEntityList = new ArrayList<>();
        this.mTaskListAdapter = new ListAdapter(this.mTaskEntityList);
        this.mViewHolder.recylerTaskList.setAdapter(mTaskListAdapter);

        // 3 - Definir um layout
        this.mViewHolder.recylerTaskList.setLayoutManager(new LinearLayoutManager(this.mContext));

        return rootView;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.float_add_task) {
            startActivity(new Intent(this.mContext, FormActivity.class));
        }
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        private FloatingActionButton floatAddTask;
        private RecyclerView recylerTaskList;
    }
}
