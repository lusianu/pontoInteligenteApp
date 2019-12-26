package com.diasdev.pontointeligente.repository.api;

import android.content.Context;
import android.icu.text.Edits;
import android.provider.SyncStateContract;
import com.diasdev.pontointeligente.constants.Constants;
import com.diasdev.pontointeligente.entities.APIResponse;
import com.diasdev.pontointeligente.entities.FullParameters;
import com.diasdev.pontointeligente.infra.InternetNotAvailableException;
import com.diasdev.pontointeligente.utils.NetworkUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;

public class ExternalRepository {

    private Context mContext;

    public ExternalRepository(Context context){
        this.mContext = context;
    }

    public APIResponse execute(FullParameters parameters) throws InternetNotAvailableException {

        if (!NetworkUtils.isConnectionAvailable(this.mContext)){
            throw new InternetNotAvailableException();
        }

        APIResponse response;
        InputStream inputStream;
        HttpURLConnection conn;

        try {

            URL url;
            if (parameters.method == Constants.OPERATION_METHOD.GET){
                url = new URL(parameters.url + getQuery(parameters.parameters, parameters.method));
            } else {
                url = new URL(parameters.url);
            }

            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(1000000);
            conn.setConnectTimeout(150000);
            conn.setRequestMethod(parameters.method);
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            conn.setRequestProperty("charser","utf-8");
            conn.setUseCaches(false);

            if (parameters.headerParameters != null){
                Iterator it = parameters.headerParameters.entrySet().iterator();
                while (it.hasNext()){
                    Map.Entry pair = (Map.Entry) it.next();
                    conn.setRequestProperty(pair.getKey().toString(), pair.getValue().toString());
                    it.remove();
                }
            }

            if (parameters.method != Constants.OPERATION_METHOD.GET){
                String query = getQuery(parameters.parameters, parameters.method);
                byte[] postDataBytes = query.getBytes("UTF-8");
                int postDataBytesLength = postDataBytes.length;

                conn.setRequestProperty("Content-Length", Integer.toString(postDataBytesLength));
                conn.setDoInput(true);
                conn.getOutputStream().write(postDataBytes);
            }

            conn.connect();
            String json = "";
            if (conn.getResponseCode() == Constants.STATUS_CODE.SUCCESS){
                inputStream = conn.getInputStream();
                json = getStringFromInputStream(inputStream);
                response = new APIResponse(json, conn.getResponseCode());
            } else {
                inputStream = conn.getErrorStream();
                json = getStringFromInputStream(inputStream);
                response = new APIResponse(json, conn.getResponseCode());
            }

            inputStream.close();
            conn.disconnect();

        }catch (Exception e){
            response = new APIResponse("", Constants.STATUS_CODE.NOT_FOUND);
        }

        return response;
    }

    private String getStringFromInputStream(InputStream inputStream){
        if (inputStream == null)
            return "";

        BufferedReader br;
        StringBuilder builder = new StringBuilder();

        String line;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null){
                builder.append(line);
            }
            br.close();
        } catch (Exception e){
            return "";
        }

        return builder.toString();
    }

    private String getQuery(AbstractMap<String,String> params, String method) throws UnsupportedEncodingException{
        if (params == null)
            return  "";

        StringBuilder builder = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, String> e : params.entrySet()){
            if(first){
                if(method == Constants.OPERATION_METHOD.GET){
                    builder.append("?");
                }

                first = false;
            } else {
                builder.append("&");
            }

            builder.append(URLEncoder.encode(e.getKey(), "UTF-8"));
            builder.append("=");
            builder.append(URLEncoder.encode(e.getValue(), "UTF-8"));
        }

        return builder.toString();
    }
}
