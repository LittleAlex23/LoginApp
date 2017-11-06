/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        boolean hasSymbol = false;
        boolean hasNumber = false;
        if(pass.length() <= 3)
            return false;
        for(int i = 0; i < pass.length(); i++){
            char c = pass.charAt(i);
            if(!hasSymbol && hasSymbol(c))
                hasSymbol = true;
            if(!hasNumber && hasNumber(c))
                hasNumber = true;
        }
        return hasSymbol && hasNumber;
    }
    public boolean hasSymbol(int s){
        return 33 <= s && s <= 47 || 58 <= s && s <= 68 || 91 <= s && s <= 96; 
    }
    public boolean hasNumber(int s){
        return 48 <= s && s <= 57;
    }
    public boolean isUsernameValid(String username){
        return username.length() >= 3 && username.length() <= 12;
    }
    public boolean isEmailValid(String email){
        return true;
    }
}
