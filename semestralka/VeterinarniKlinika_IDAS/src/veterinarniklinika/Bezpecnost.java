
package veterinarniklinika;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class Bezpecnost {
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
    
    public static boolean jeHesloDostatecne(String heslo){ 
        char ch;
        boolean velkeP = false;
        boolean maleP = false;
        boolean cislo = false;
        for(int i=0;i < heslo.length();i++) {
            ch = heslo.charAt(i);
            if( Character.isDigit(ch)) {
                cislo = true;
            }
            else if (Character.isUpperCase(ch)) {
                velkeP = true;
            } else if (Character.isLowerCase(ch)) {
                maleP = true;
            }
            if(cislo && maleP && velkeP)
                return heslo.length() >= 6;
        }
        return false;
    }
    
    public static boolean obsahujeNebezpecneZnaky(String text){
        String koment = "--";
        String drop = "DROP";
        String sel = "SELECT";
        String strednik = ";";
        String podm = "IF";
        String str = "'";
        String con = "CONCAT";
        String un = "UNION";
        if(text.contains(koment)) return true;
        if(text.contains(drop)) return true;
        if(text.contains(sel)) return true;
        if(text.contains(strednik)) return true;
        if(text.contains(podm)) return true;
        if(text.contains(str)) return true;
        if(text.contains(con)) return true;
        if(text.contains(un)) return true;
        return false;
    }
}
