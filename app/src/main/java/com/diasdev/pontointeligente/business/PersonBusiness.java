package com.diasdev.pontointeligente.business;

import android.content.Context;
import com.diasdev.pontointeligente.constants.Constants;
import com.diasdev.pontointeligente.entities.APIResponse;
import com.diasdev.pontointeligente.entities.FullParameters;
import com.diasdev.pontointeligente.infra.InternetNotAvailableException;
import com.diasdev.pontointeligente.infra.URLBuilder;
import com.diasdev.pontointeligente.infra.operation.OperationResult;
import com.diasdev.pontointeligente.manager.PersonManager;
import com.diasdev.pontointeligente.repository.api.ExternalRepository;

import java.util.AbstractMap;
import java.util.HashMap;

public class PersonBusiness {

    private ExternalRepository mExternalRepository;
    public PersonBusiness(Context context){
        this.mExternalRepository = new ExternalRepository(context);
    }

    public OperationResult<Boolean> create(String nome, String email, String password){
        OperationResult<Boolean> result = new OperationResult<>();

        try {
            URLBuilder builder = new URLBuilder(Constants.ENDPOINT.ROOT);
            builder.addResource(Constants.ENDPOINT.AUTHENTICATION_CREATE);

            AbstractMap<String ,String> params = new HashMap<>();
            params.put(Constants.API_PARAMETER.NOME, nome);
            params.put(Constants.API_PARAMETER.EMAIL, email);
            params.put(Constants.API_PARAMETER.PASSWORD, password);

            FullParameters full = new FullParameters(Constants.OPERATION_METHOD.POST, builder.getUrl(), (HashMap) params, null);

            APIResponse response =  this.mExternalRepository.execute(full);

        } catch (Exception e){
            return result;
        }

        return result;
    }
}
