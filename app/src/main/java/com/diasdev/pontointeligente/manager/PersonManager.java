package com.diasdev.pontointeligente.manager;

import android.content.Context;
import android.os.AsyncTask;
import com.diasdev.pontointeligente.business.PersonBusiness;
import com.diasdev.pontointeligente.infra.operation.OperationListener;
import com.diasdev.pontointeligente.infra.operation.OperationResult;

public class PersonManager {

    private PersonBusiness mPersonBusiness;
    public PersonManager(Context context){
        this.mPersonBusiness = new PersonBusiness(context);
    }

    public void create(final String nome, final String email, final String password, final OperationListener listener){
        AsyncTask<Void, Void, OperationResult<Boolean>> task = new AsyncTask<Void, Void, OperationResult<Boolean>>() {
            @Override
            protected OperationResult<Boolean> doInBackground(Void... voids) {
                return mPersonBusiness.create(nome,email,password);
            }

            @Override
            protected void onPostExecute(OperationResult<Boolean> result){
                int error = result.getError();
                if (error != OperationResult.NO_ERROR){
                    listener.onError(error, result.getErrorMessage());
                } else {
                    listener.onSuccess(result.getResult());
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
