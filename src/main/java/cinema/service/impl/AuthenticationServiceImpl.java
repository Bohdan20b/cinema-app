package cinema.service.impl;

import static cinema.model.Role.RoleName.USER;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Role.RoleName DEFAULT_ROLE = USER;
    private final RoleService roleService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public AuthenticationServiceImpl(RoleService roleService,
                                     UserService userService,
                                     ShoppingCartService shoppingCartService) {
        this.roleService = roleService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Role role = roleService.getByName(DEFAULT_ROLE.name());
        user.setRoles(Set.of(role));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
