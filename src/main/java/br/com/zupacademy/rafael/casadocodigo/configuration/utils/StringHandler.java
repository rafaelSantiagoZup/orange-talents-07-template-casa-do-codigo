package br.com.zupacademy.rafael.casadocodigo.configuration.utils;


import org.apache.commons.lang3.StringUtils;

public class StringHandler {
    public static String getStringBetweenChars(String initial,String begin,String end){
        return StringUtils.substringBetween(initial,begin,end);
    }
}
