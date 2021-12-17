package com.bridgelabz.addressbook.integration;

import com.bridgelabz.addressbook.controller.AddressBookController;
import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.sevice.AddressBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Purpose : To implement Integration Test cases of Address Book Controller
 * in Address Book App Application.
 *
 * @author : VAISHANAVI R. VISHWAKARMA.
 * @since : 16-12-2021
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(AddressBookController.class)
public class AddressBookITTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AddressBookService addressBookService;

    @Test
    void getAllAddressBookTest() throws Exception {
        when(addressBookService.getAllAddress()).thenReturn(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders.get("/addressbook/all"))
                .andExpect(status().isOk());
    }
    @Test
    void addAddressBookTest() throws Exception {
        when(addressBookService.addAddressBook(any())).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/addressbook/add")
                        .content("{\"name\":\"Punam\",\"address\":\"Khb-colony\",\"city\":\"Bidar\"," +
                                "\"state\":\"Karnataka\",\"phoneNumber\":\"9101122000\",\"zip\":\"585401\"}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
    @Test
    void updateAddressBookTest() throws Exception {
        int id = 1;
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Diksha");
        addressBookDto.setAddress("KHB-Colony");
        addressBookDto.setCity("Hubbali");
        addressBookDto.setState("Karnataka");
        addressBookDto.setPhoneNumber("9670000000");
        addressBookDto.setZip("585691");
        when(addressBookService.updateAddressBook(id,addressBookDto)).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/addressbook/update/1")
                        .content("{\"name\":\"Diksha\",\"address\":\"KHB-Colony\",\"city\":\"Bidar\"," +
                                "\"state\":\"Karnataka\",\"phoneNumber\":\"9670000003\",\"zip\":\"585691\"}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
    @Test
    void deleteAddressBookTest() throws Exception {
        when(addressBookService.deleteAddressBook(1)).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/addressbook/delete/1")
                        .content("{\"name\":\"Diksha\",\"address\":\"KHB-Colony\",\"city\":\"Bidar\"," +
                                "\"state\":\"Karnataka\",\"phoneNumber\":\"9670000003\",\"zip\":\"585691\"}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}
