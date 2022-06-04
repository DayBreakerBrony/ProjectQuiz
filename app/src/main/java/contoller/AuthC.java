package contoller;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;

public class AuthC {

    private final FirebaseAuth auth;

    public AuthC(){
        auth = FirebaseAuth.getInstance();

    }

    public boolean isRegistered() {
        return auth.getCurrentUser() != null;
    }

    public FirebaseUser getUser() {
        return auth.getCurrentUser();
    }


    public void registerUser(String Email, String password, OnCompleteListener<AuthResult>
                             listener) {
        auth.createUserWithEmailAndPassword(Email, password).addOnCompleteListener(listener);
    }

}
