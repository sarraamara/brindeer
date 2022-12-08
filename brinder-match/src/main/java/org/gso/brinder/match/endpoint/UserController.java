package org.gso.brinder.match.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gso.brinder.match.model.Coordonnee;
import org.gso.brinder.match.model.User;
import org.gso.brinder.match.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(

        value = UserController.PATH,
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class UserController {
    public static final String PATH = "/api/v1/matchs";
    public static int MAX_PAGE_SIZE = 200;

    private final UserService userService;

    public void updateUserLocation(JwtAuthenticationToken token) { userService.updateUserLocation(token); }

//    public List<User> searchSurroundingUsers(JwtAuthenticationToken token) {userService.searchSurroundingUsers(token)}

    public List<User> getAllUsers() { return userService.getAllUsers(); }

    @GetMapping("/address/{address}")
    private Coordonnee addressToCoordinate(@PathVariable("address") String address) { return userService.addressToCoordinate(address); }
    }
