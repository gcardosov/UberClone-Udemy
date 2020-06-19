package com.gcardoso.uberclone.providers;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

//ESTE ARCHIVO TRAE TODA LA LOGICA DE LA AUTENTICACION

public class AuthProvider {

    FirebaseAuth mAuth;

    public AuthProvider(){
        mAuth = FirebaseAuth.getInstance();
    }

    public Task<AuthResult> register(String email, String password){
        return  mAuth.createUserWithEmailAndPassword(email, password);
    }

    public Task<AuthResult> login(String email, String password){
        return  mAuth.signInWithEmailAndPassword(email, password);
    }

    //Con este metodo cerramos la sesión del usuario
    public void logout(){
        mAuth.signOut();

    }


}
