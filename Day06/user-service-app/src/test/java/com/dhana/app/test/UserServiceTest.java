package com.dhana.app.test;

import com.dhana.app.entity.User;
import com.dhana.app.repository.UserRepository;
import com.dhana.app.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserDetails() {

        User mockUser = new User(1, "Dhana");
        when(userRepository.findById(1)).thenReturn(Optional.of(mockUser));
        User result = userService.getUserDetails(1);
        assertNotNull(result);
        assertEquals("Dhana", result.getName());
        verify(userRepository).findById(1);
    }

    @Test
    public void testGetUserDetails_UserNotFound() {
        when(userRepository.findById(2)).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class, () -> userService.getUserDetails(2));
        assertEquals("User Not Found", exception.getMessage());
    }
}
