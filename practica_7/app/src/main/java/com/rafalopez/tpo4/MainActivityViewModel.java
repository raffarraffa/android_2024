package com.rafalopez.tpo4;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {
    private User usuario = new User("admin@admin.com", "1234");
    private MutableLiveData<Boolean> mutAuth ;
    private MutableLiveData<Boolean> mutExit ;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }
//    public MutableLiveData<Boolean> getAuth(){
//        if(mutAuth == null){
//            mutAuth = new MutableLiveData<>(false);
//        }
//        return mutAuth;
//    }
    public MutableLiveData<Boolean> getExit(){

        if(mutExit == null){
            mutExit = new MutableLiveData<>(false);
        }
        return mutExit;
    }

    public void isValidUser(String user, String pass){
        if (user == null || user.isEmpty()) {
            Toast.makeText(getApplication(), "Usuario vacio, ingrese email",
                    Toast.LENGTH_SHORT).show();
            return ;
        }


        if (pass == null || pass.isEmpty()) {
            Toast.makeText(getApplication(), "Password vacio, ingrese password",
                    Toast.LENGTH_SHORT).show();
            return ;
        }

        if(pass.equalsIgnoreCase(usuario.password) && user.equalsIgnoreCase(usuario.user)){
            // pasar al otro activity
         //   mutAuth.setValue(true);
            Toast.makeText(getApplication(), "Usuario Autenticado", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplication(),FarmaciasActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
        }else{
            Toast.makeText(getApplication(), "Error de autenticacion",
                    Toast.LENGTH_SHORT).show();


        }


    }
    private boolean isValidMail(String email){
        return email.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,63}$");
    }

    private class User{
        private String user;
        private String password;

        public User(String user, String password) {
            this.user = user;
            this.password = password;
        }
    }

}
