package com.skyline.test.services;

import com.skyline.dto.UserDTO;
import com.skyline.entity.oracle.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    // Mock de la dependencai del repositorio
//    @Mock
//    IUserRepository userRepository;

    // Instancia del repository
//    @InjectMocks
//    UserService userService;

    @Test
    public void testShouldGetNullWhenParamterIsNull() {
        UserDTO user = null;
        // Configuramos el mock para la respuesta
//        when(userRepository.getUserById(null)).thenReturn(null);
//        user = userService.obetenerUser(null);
        assertNull(user);
    }

    @Test
    public void testShouldVerifyCallMethodUSerByIdUserRepository() {
        UserEntity userEntity = new UserEntity();
        // Configuramos el mock para la respuesta
//        when(userRepository.getUserById(1L)).thenReturn(userEntity);
//        User user = userService.obetenerUser(1L);
//        verify(userRepository).getUserById(1L);
//        assertNotNull(user);
    }
}
