package itsol_project.itsolwebserver.util;

import itsol_project.itsolwebserver.config.JwtConfig;
import itsol_project.itsolwebserver.dto.ProductDto;
import org.modelmapper.ModelMapper;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class AppUtil {

    public static <T> T mapperEntAndDto(Object source, Class<T> result){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(source, result);
    }

    public static Boolean isNullOrEmpty(String s){
        if (s == null || s.isEmpty() || "".equals(s) || s.length() == 0){
            return true;
        }
        return false;
    }

    public static Boolean isNullOrEmpty(List list){
        if (list == null || list.isEmpty() || list.size() == 0){
            return true;
        }
        return false;
    }

    public static Long NVL(Long n){
        return n == null ? 0L : n;
    }

    public static Integer NVL(Integer n){
        return n == null ? 0 : n;
    }

    public static Double NVL(Double n){
        return n == null ? 0.0 : n;
    }

//    public static String getJwt(HttpServletRequest request, JwtConfig jwtConfig) {
//        String jwtHeader = request.getHeader(jwtConfig.getHeader());
//        if (jwtHeader != null && jwtHeader.startsWith(jwtConfig.getPrefix())) {
//            return jwtHeader.replace(jwtConfig.getPrefix() + " ", "");
//        }
//        return null;
//    }

    public static String generateOrderCode(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER");
        sb.append(new SimpleDateFormat("ddMMyy").format(new Date()));
        sb.append(random.nextInt(10));
        return sb.toString();
    }

    public static String getJwt(HttpServletRequest request, JwtConfig jwtConfig) {
        return null;
    }
}
