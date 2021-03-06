package com.diasdev.pontointeligente.views;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.diasdev.pontointeligente.R;


public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Inicializa variáveis
        this.mViewHolder.editDescription = (EditText) this.findViewById(R.id.edit_description);
        this.mViewHolder.checkComplete = (CheckBox) this.findViewById(R.id.check_complete);
        this.mViewHolder.spinnerPriority = (Spinner) this.findViewById(R.id.spinner_priority);
        this.mViewHolder.buttonDate = (Button) this.findViewById(R.id.button_date);
        this.mViewHolder.buttonSave = (Button) this.findViewById(R.id.button_save);
        this.mViewHolder.progressDialog = new ProgressDialog(this);

        // Atribui eventos
        this.mViewHolder.buttonSave.setOnClickListener(this);
        this.mViewHolder.buttonDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.button_save) {
            // TODO
        } else if (id == R.id.button_date) {
            // TODO
        }
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        private EditText editDescription;
        private CheckBox checkComplete;
        private Spinner spinnerPriority;
        private Button buttonDate;
        private Button buttonSave;
        private ProgressDialog progressDialog;
    }
}
