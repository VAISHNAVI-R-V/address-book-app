package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.sevice.AddressBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressBookControllerTest {
    @InjectMocks
    private AddressBookController addressBookController;

    @Mock
    private AddressBookService addressBookService;

    @Test
    void given2AddressBookDto_whenCalledGetAllMethod_shouldReturnListOfAddressBookDto() {
        List<AddressBookDto> addressBookDtoList = new ArrayList<>();
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Shivani");
        addressBookDto.setAddress("ShivNagar");
        addressBookDto.setCity("Bidar");
        addressBookDto.setState("Karnataka");
        addressBookDto.setPhoneNumber("8123746670");
        addressBookDto.setZip("585401");
        addressBookDtoList.add(addressBookDto);
        AddressBookDto addressBookDto2 = new AddressBookDto();
        addressBookDto2.setName("Shubham");
        addressBookDto2.setAddress("Jai-Nagar");
        addressBookDto2.setCity("Banglore");
        addressBookDto2.setState("Karnataka");
        addressBookDto2.setPhoneNumber("9612355456");
        addressBookDto2.setZip("58614");
        addressBookDtoList.add(addressBookDto2);

        when(addressBookService.getAllAddress()).thenReturn(addressBookDtoList);
        List<AddressBookDto> actualResponse = addressBookController.adrressList();
        for (int i = 0; i < actualResponse.size(); i++) {
            Assertions.assertEquals(addressBookDtoList.get(i).getName(), actualResponse.get(i).getName());
            Assertions.assertEquals(addressBookDtoList.get(i).getAddress(), actualResponse.get(i).getAddress());
            Assertions.assertEquals(addressBookDtoList.get(i).getCity(), actualResponse.get(i).getCity());
            Assertions.assertEquals(addressBookDtoList.get(i).getState(), actualResponse.get(i).getState());
            Assertions.assertEquals(addressBookDtoList.get(i).getPhoneNumber(), actualResponse.get(i).getPhoneNumber());
            Assertions.assertEquals(addressBookDtoList.get(i).getZip(), actualResponse.get(i).getZip());
        }
    }

    @Test
    void givenAddressBookDto_whenCalledAddAddressBookMethod_shouldReturnSuccessMessage() {
        String successString = "AddressBook Added Successfully";
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Divya");
        addressBookDto.setAddress("Hadpsar");
        addressBookDto.setCity("Pune");
        addressBookDto.setState("Maharastra");
        addressBookDto.setPhoneNumber("8000567890");
        addressBookDto.setZip("458812");
        when(addressBookService.addAddressBook(addressBookDto)).thenReturn(successString);
        String actualResponseString = addressBookController.addAddress(addressBookDto);
        assertEquals(successString, actualResponseString);
    }

    @Test
    void givenAddressBookDto_whenCalledUpdateAddressBookMethod_shouldReturnSuccessMessage() {
        String successString = "AddressBook Update Successfully";
        int id = 1;
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Damini");
        addressBookDto.setAddress("Mahasamund");
        addressBookDto.setCity("Raipur");
        addressBookDto.setState("Chhattishgarh");
        addressBookDto.setPhoneNumber("1234567890");
        addressBookDto.setZip("123456");
        when(addressBookService.updateAddressBook(id, addressBookDto)).thenReturn(successString);
        String actualResponseString = addressBookController.updateAddress(id, addressBookDto);
        assertEquals(successString, actualResponseString);
    }

    @Test
    void givenId_whenCalledDeleteAddressBookMethod_shouldReturnSuccessMessage() {
        String successString = "AddressBook Delete Successfully";
        int id = 1;
        when(addressBookService.deleteAddressBook(id)).thenReturn(successString);
        String actualResponseString = addressBookController.delete(1);
        assertEquals(successString, actualResponseString);
    }
}
