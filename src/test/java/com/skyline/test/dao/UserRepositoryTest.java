package com.skyline.test.dao;

import com.skyline.dao.UserRepository;
import com.skyline.entity.UserEntity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    // Mock de la dependencai del repositorio
//    @Mock
//    EntityManager em;
    // Instancia del repository
//    @InjectMocks
//    UserRepository userRepository;

    @Test
    public void testShouldGetDataAccessExceptionWhenParameterNull() {
//        // Configuramos el mock para lanzar una excepción
//        when(em.find(UserEntity.class, null)).thenThrow(new DataAccessException("Error al acceder a la base de datos") {});
//        // Verificamos que se lanza la excepción esperada
//        DataAccessException dataAccessException = assertThrows(DataAccessException.class, () ->
//                userRepository.getUserById(null)
//        );
//        assertEquals("Error al acceder a la base de datos", dataAccessException.getMessage());
    }

    @Test
    public void testShouldGetNullUserWhenParameterNull() {
//        UserEntity userEntity = null;
//        // Configuramos el mock para devolver un null
//        when(em.find(UserEntity.class, null)).thenReturn(null);
//        // Verificamos que el objeto devuelto sea null
//        userEntity = userRepository.getUserById(null);
//        assertNull(userEntity);
    }

    @Test
    public void testShouldGetUserWhenParameterNotNull() {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(1L);
//        userEntity.setName("Skyline");
//        // Configuramos el mock para devolver un objeto user
//        when(em.find(UserEntity.class, 1L)).thenReturn(userEntity);
//        userEntity = userRepository.getUserById(1L);
//        // Verificamos que el objeto devuelto es el esperado
//        assertNotNull(userEntity);
//        assertEquals( 1L, userEntity.getId());
//        assertEquals("Skyline", userEntity.getName());
    }
}
