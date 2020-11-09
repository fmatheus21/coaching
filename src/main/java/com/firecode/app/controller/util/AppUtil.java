package com.firecode.app.controller.util;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.text.WordUtils;


public class AppUtil {
    
        public static String convertFirstUppercaseCharacter(String string) {
        return WordUtils.capitalizeFully(string).trim();
    }
    
      public static String convertsAllUppercaseCharacters(String string) {
        return string.toUpperCase().trim();
    }

    public static String convertAllLowercaseCharacters(String string) {
        return string.toLowerCase().trim();
    }

    public static String removeAllSpaces(String string) {
        return string.replaceAll(" ", "");
    }

    public static String removeDuplicateSpace(String string) {
        return string.replaceAll("\\s+", " ").trim();
    }

    public static String removeSpecialCharacters(String string) {
        return string.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static String removeAccent(String string) {
        String normalize = Normalizer.normalize(string, Normalizer.Form.NFD);
        normalize = normalize.replaceAll("[^\\p{ASCII}]", "");
        return normalize;
    }
    
    public static String formatMask(String valor, String mascara) {
        String dado = "";
        // remove caracteres nao numericos
        for (int i = 0; i < valor.length(); i++) {
            char c = valor.charAt(i);
            if (Character.isDigit(c)) {
                dado += c;
            }
        }
        int indMascara = mascara.length();
        int indCampo = dado.length();

        for (; indCampo > 0 && indMascara > 0;) {
            if (mascara.charAt(--indMascara) == '#') {
                indCampo--;
            }
        }
        String saida = "";
        for (; indMascara < mascara.length(); indMascara++) {
            saida += ((mascara.charAt(indMascara) == '#') ? dado.charAt(indCampo++) : mascara.charAt(indMascara));
        }
        return saida;
    }
    
    
    
     public static boolean validateEmail(String email) {
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }
    
    
}
