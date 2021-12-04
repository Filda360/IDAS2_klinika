
package veterinarniklinika;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class HashFunkce {
    //použitý algoritmus v databazove aplikaci: SHA-1
    public static String dejHash(byte[] inputBytes) throws Exception{ 
        String vytvorenyHash = "";
        try{ 
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(inputBytes);
            byte[] digestBytes = md.digest();
            vytvorenyHash = DatatypeConverter.printHexBinary(digestBytes).toLowerCase();
        }catch(Exception e){ 
            throw new Exception("HASH nelze vytvořit");
        }
        return vytvorenyHash;
    }
    
    public static boolean porovnejHash(String hash1, String hash2){ 
        if(hash1.compareTo(hash2)==0){ 
            return true;
        }else{ 
            return false;
        }  
    }
    
    public boolean jeHesloDostatecne(String heslo){ 
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for(int i=0;i < heslo.length();i++) {
            ch = heslo.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }
}
