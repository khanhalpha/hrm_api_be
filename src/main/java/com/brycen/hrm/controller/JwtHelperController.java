package com.brycen.hrm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.security.jwt.JwtUtils;

import io.jsonwebtoken.Claims;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/jwtdecode")
public class JwtHelperController {

    @Autowired
    private JwtUtils jwtUtils;

    
    @GetMapping("/roles")
    public ResponseEntity<List<String>> getRoles(HttpServletRequest request)
    {
        List<String> roles ;
        String jwt = parseJwt(request);
        if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
            Claims claims = jwtUtils.getClaimsToken(jwt);
            roles = (List<String>) claims.get("Roles");
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }
                
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }
}
