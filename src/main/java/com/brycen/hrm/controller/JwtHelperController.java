package com.brycen.hrm.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.Department;
import com.brycen.hrm.model.ERole;
import com.brycen.hrm.model.Role;
import com.brycen.hrm.model.RoleScreen;
import com.brycen.hrm.model.Screen;
import com.brycen.hrm.repository.RoleScreenReposiroty;
import com.brycen.hrm.repository.ScreenRepository;
import com.brycen.hrm.security.jwt.JwtUtils;

import io.jsonwebtoken.Claims;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/jwtdecode")
public class JwtHelperController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    ScreenRepository screenRepository;
    
    @Autowired
    RoleScreenReposiroty roleScreen;
    
    @GetMapping("/roles")
    public ResponseEntity<List<String>> getRoles(HttpServletRequest request) {
        List<String> roles;
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

    @GetMapping("/checkrole")
    public boolean checkRole(@RequestParam(required = false) String url, HttpServletRequest request) {       
        if (url.equals(""))
            return false;
        else
        {
            List<String> rolesUser;
            String jwt = parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                Claims claims = jwtUtils.getClaimsToken(jwt);
                rolesUser = (List<String>) claims.get("Roles");
                Optional<Screen> screenData = screenRepository.findByscreenURL(url);
                List<RoleScreen> roleScreen = screenData.get().getRoleScreens();
                for(int iRoleScr = 0 ; iRoleScr < roleScreen.size(); iRoleScr ++)
                {
                    for(int iRoleUser = 0; iRoleUser < rolesUser.size(); iRoleUser ++)
                    {
                        String roleName =  roleScreen.get(iRoleScr).getRole().getName() + "";
                        System.out.println(rolesUser.get(iRoleUser));
                        System.out.println(roleName);
                        if(roleName.equals(rolesUser.get(iRoleUser)))
                            return true;
                    }
                }
                return false;
            }
            else
                return false;
        }
        
    }
}
