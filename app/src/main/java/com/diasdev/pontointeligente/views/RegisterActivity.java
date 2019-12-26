package com.diasdev.pontointeligente.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.diasdev.pontointeligente.R;
import com.diasdev.pontointeligente.infra.operation.OperationListener;
import com.diasdev.pontointeligente.manager.PersonManager;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private PersonManager mPersonManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.mPersonManager = new PersonManager(this);

        // Inicializa elementos
        this.mViewHolder.editName = (EditText) this.findViewById(R.id.edit_name);
        this.mViewHolder.editEmail = (EditText) this.findViewById(R.id.edit_email);
        this.mViewHolder.editPassword = (EditText) this.findViewById(R.id.edit_password);
        this.mViewHolder.buttonSave = (Button) this.findViewById(R.id.button_save);

        // Inicializa eventos
        this.mViewHolder.buttonSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_save) {
            this.handleSave();
        }
    }

    private void handleSave(){
        String nome = this.mViewHolder.editName.getText().toString();
        String email = this.mViewHolder.editEmail.getText().toString();
        String password = this.mViewHolder.editPassword.getText().toString();

        this.mPersonManager.create(nome, email, password, registerListener());
    }

    private OperationListener registerListener(){
        return new OperationListener<Boolean>(){
          @Override
          public void onSuccess(Boolean result){

          }

          @Override
          public void onError(int errorCode, String erroMessage){

          }
        };
    }
    /**
     * ViewHolder
     */

    private static class ViewHolder {
        private ImageView imageBack;
        private EditText editName;
        private EditText editEmail;
        private EditText editPassword;
        private Button buttonSave;
    }
}
