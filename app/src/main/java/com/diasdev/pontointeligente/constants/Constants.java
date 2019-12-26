package com.diasdev.pontointeligente.constants;

public class Constants {

    public static class HEADER {
        public static final String TOKEN_KEY = "token";
        public static final String PERSON_KEY = "personkey";
    }

    public static class ENDPOINT {
        public static final String ROOT = "http://www.devmasterteam.com/CursoAndroidAPI";
        public static final String AUTHENTICATION_CREATE = "Authentication/Create";
        public static final String AUTHENTICATION_LOGIN = "Authentication/Login";

        public static final String TASK_GET_LIST_NO_FILTER = "Task";
        public static final String TASK_DELETE = "Task";
        public static final String TASK_UPDATE = "Task";
        public static final String TASK_INSERT = "Task";
    }

    public static class API_PARAMETER{
        public static final String NOME = "nome";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
    }

    public static class OPERATION_METHOD {
        public static final String GET = "GET";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
        public static final String POST = "POST";
    }

    public static class STATUS_CODE {
        public static final int SUCCESS = 200;
        public static final int FORBIDDEN = 403;
        public static final int NOT_FOUND = 404;
        public static final int INTERNALSERVER_ERRO = 500;
        public static final int INTERNET_NOT_AVAILABLE = 900;
    }
}
