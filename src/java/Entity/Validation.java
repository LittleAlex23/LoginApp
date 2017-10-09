/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.ejb.Stateless;

@Stateless
public class Validation {
    public Validation(){}
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
        return true;
    }
    public boolean isEmailValid(String email){
        return true;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
