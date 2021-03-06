package Entity;

import java.util.HashMap;
import javax.ejb.Stateless;

@Stateless
public class Validation {
    public Validation(){}
    public HashMap<Integer,String> getResult(String[] paramList){
        HashMap<Integer,String> message = new HashMap<>();
        if(!paramList[0].equals(paramList[1])){
            message.put(0, "current password invalid");
            return message;
        }
        if(!isPassValid(paramList[2]))
            message.put(1, "invalid password");
        return message;
    }
    public boolean isPassValid(String pass){
        boolean isValid = true;
        if(pass.length() <= 3)
            return false;
        for(int i = 0; i < pass.length(); i++){
            char c = pass.charAt(i);
            if(hasSymbol(c) && hasNumber(c)){
                isValid = true;
                break;
            }
        }
        return isValid;
    }
    private boolean hasSymbol(int s){
        return 33 <= s && s <= 47 || 58 <= s && s <= 68 || 91 <= s && s <= 96; 
    }
    private boolean hasNumber(int s){
        return 48 <= s && s <= 57;
    }
    public boolean isUsernameValid(String username){
        return username.length() >= 3 && username.length() <= 12;
    }
    public boolean isEmailValid(String email){
        return true;
    }
}
