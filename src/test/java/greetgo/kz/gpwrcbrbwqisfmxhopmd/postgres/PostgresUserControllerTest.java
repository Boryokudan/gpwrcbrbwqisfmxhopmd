package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.Filter;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.controller.PostgresUserController;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.PostgresUserDtoService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.PostgresUserDto;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class PostgresUserControllerTest {

    @Mock
    private PostgresUserDtoService mockUserService;

    private PostgresUserController userController;

    private final List<PostgresUserDto> userDtos = new ArrayList<>(List.of(
            new PostgresUserDto(1L, "Bagdat Ruslan", LocalDate.of(1990, 9, 3), LocalDate.of(2023, 10, 18), "+7(747)120-22-55", null),
            new PostgresUserDto(2L, "Dinara Mukhitovna", LocalDate.of(1982, 12, 10), LocalDate.of(2023, 10, 17), "+7(778)100-20-07", "+7(702)133-11-92"),
            new PostgresUserDto(3L, "Elena Ivanovna", LocalDate.of(1988, 6, 25), LocalDate.of(2023, 10, 16), "+7(702)219-10-01", "+7(705)119-59-10"),
            new PostgresUserDto(4L, "Emir Kurmanov", LocalDate.of(1995, 3, 5), LocalDate.of(2023, 10, 15), "+7(707)122-81-10", null),
            new PostgresUserDto(5L, "Gulnaz Bakhytzhanovna", LocalDate.of(1980, 10, 31), LocalDate.of(2023, 10, 14), "+7(775)133-12-55", "+7(777)233-01-29"),
            new PostgresUserDto(6L, "Ilya Petrovich", LocalDate.of(1972, 9, 20), LocalDate.of(2023, 10, 13), "+7(775)600-22-10", null),
            new PostgresUserDto(7L, "Karina Askarovna", LocalDate.of(1987, 2, 15), LocalDate.of(2023, 10, 12), "+7(775)131-50-27", null),
            new PostgresUserDto(8L, "Madi Amirovich", LocalDate.of(1984, 8, 11), LocalDate.of(2023, 10, 11), "+7(705)124-10-00", "+7(702)163-23-26"),
            new PostgresUserDto(9L, "Michael Ivanovich", LocalDate.of(1975, 5, 17), LocalDate.of(2023, 10, 10), "+7(775)232-32-32", "+7(778)236-46-28"),
            new PostgresUserDto(10L, "Nargiza Meiramovna", LocalDate.of(1989, 12, 23), LocalDate.of(2023, 10, 9), "+7(747)352-27-16", "+7(777)475-84-94")
    ));

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userController = new PostgresUserController(mockUserService);
    }

    @Test
    public void testGetFilteredUsersWithValidFilter() {
        Filter filter = new Filter(0, 5);

        when(mockUserService.getFilteredUserDtos(filter)).thenReturn(userDtos.subList(0, 5));

        ResponseEntity<List<PostgresUserDto>> responseEntity = userController.getFilteredUsers(filter);

        assertEquals(responseEntity.getBody(), userDtos.subList(0, 5));
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetFilteredUsersWithValidFilterButUsersNotFound() {
        Filter filter = new Filter(1000, 100);

        when(mockUserService.getFilteredUserDtos(filter)).thenReturn(null);

        ResponseEntity<List<PostgresUserDto>> responseEntity = userController.getFilteredUsers(filter);

        assertNull(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetFilteredUsersWithInvalidFilter() {
        Filter filter = new Filter(-1, -10);

        when(mockUserService.getFilteredUserDtos(filter)).thenThrow(IllegalArgumentException.class);

        ResponseEntity<List<PostgresUserDto>> responseEntity = userController.getFilteredUsers(filter);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testGetUserByValidId() {
        Long id = 5L;

        when(mockUserService.getUserDtoById(id)).thenReturn(userDtos.get(5));

        ResponseEntity<PostgresUserDto> responseEntity = userController.getUserById(id);

        assertEquals(responseEntity.getBody(), userDtos.get(5));
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetUserByInvalidId() {
        Long id = 100L;

        when(mockUserService.getUserDtoById(id)).thenReturn(null);

        ResponseEntity<PostgresUserDto> responseEntity = userController.getUserById(id);

        assertNull(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetUserByValidPhoneNumber() {
        String phoneNumber = "+7(775)133-12-55";

        when(mockUserService.getUserDtoByPhoneNumber(phoneNumber)).thenReturn(userDtos.get(5));

        ResponseEntity<PostgresUserDto> responseEntity = userController.getUserByPhoneNumber(phoneNumber);

        assertEquals(responseEntity.getBody(), userDtos.get(5));
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetUserByInvalidPhoneNumber() {
        String phoneNumber = "+7(965)000-00-00";

        when(mockUserService.getUserDtoByPhoneNumber(phoneNumber)).thenReturn(null);

        ResponseEntity<PostgresUserDto> responseEntity = userController.getUserByPhoneNumber(phoneNumber);

        assertNull(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void testUpdateUserByValidId() {
        Long id = 1L;
        PostgresUserDto updatedUserDto = new PostgresUserDto(
                1L, "Bagdat Ruslan",
                LocalDate.of(2000, 1, 1),
                LocalDate.of(2021, 1, 1),
                "+7(700)700-00-00",
                null);
        PostgresUserDto returnedUserDto = new PostgresUserDto(
                1L, "Bagdat Ruslan",
                LocalDate.of(2000, 1, 1),
                LocalDate.of(2021, 1, 1),
                "+7(700)700-00-00",
                null);

        when(mockUserService.updateUserDtoById(id, updatedUserDto)).thenReturn(returnedUserDto);

        ResponseEntity<PostgresUserDto> responseEntity = userController.updateUserById(id, updatedUserDto);

        assertEquals(responseEntity.getBody(), returnedUserDto);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdateUserByInvalidId() {
        Long id = 1_000_000L;
        PostgresUserDto updatedUserDto = new PostgresUserDto(
                1_000_000L, "Bagdat Ruslan",
                LocalDate.of(2000, 1, 1),
                LocalDate.of(2021, 1, 1),
                "+7(700)700-00-00",
                null);

        when(mockUserService.updateUserDtoById(id, updatedUserDto)).thenReturn(null);

        ResponseEntity<PostgresUserDto> responseEntity = userController.updateUserById(id, updatedUserDto);

        assertNull(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void testUpdateUserByValidPhoneNumber() {
        String phoneNumber = "+7(700)700-00-00";
        PostgresUserDto updatedUserDto = new PostgresUserDto(
                1L, "Bagdat Ruslan",
                LocalDate.of(2000, 1, 1),
                LocalDate.of(2021, 1, 1),
                "+7(700)700-00-00",
                null);
        PostgresUserDto returnedUserDto = new PostgresUserDto(
                1L, "Bagdat Ruslan",
                LocalDate.of(2000, 1, 1),
                LocalDate.of(2021, 1, 1),
                "+7(700)700-00-00",
                null);

        when(mockUserService.updateUserDtoByPhoneNumber(phoneNumber, updatedUserDto)).thenReturn(returnedUserDto);

        ResponseEntity<PostgresUserDto> responseEntity = userController.updateUserByPhoneNumber(phoneNumber, updatedUserDto);

        assertEquals(responseEntity.getBody(), returnedUserDto);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdateUserByInvalidPhoneNumber() {
        String phoneNumber = "+7(965)000-00-00";
        PostgresUserDto updatedUserDto = new PostgresUserDto(
                1_000_000L, "Bagdat Ruslan",
                LocalDate.of(2000, 1, 1),
                LocalDate.of(2021, 1, 1),
                "+7(965)000-00-00",
                null);

        when(mockUserService.updateUserDtoByPhoneNumber(phoneNumber, updatedUserDto)).thenReturn(null);

        ResponseEntity<PostgresUserDto> responseEntity = userController.updateUserByPhoneNumber(phoneNumber, updatedUserDto);

        assertNull(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
    }
}
