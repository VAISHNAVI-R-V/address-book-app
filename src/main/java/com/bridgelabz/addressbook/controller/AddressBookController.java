package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.sevice.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/addressbook")
public class AddressBookController {

    public String welcomeMessage = "Success, Welcome to Address book app";

    @Autowired
    private AddressBookService addressBookService;

    /**
     * Purpose : To get list of all addresses from database.
     *
     * @return List : List of address.
     */
    @GetMapping(value = "/all")
    public List<AddressBookDto> adrressList() {
        return addressBookService.getAllAddress();
    }
    @PostMapping(value = "/add")
    public String addAddress(@Valid @RequestBody AddressBookDto addressBookDto) {
        return addressBookService.addAddressBook(addressBookDto);
    }
    @PutMapping(value = "/update/{id}")
    public String updateAddress(@PathVariable(value = "id") int id,
                                @Valid @RequestBody AddressBookDto addressBookDto) {
        return addressBookService.updateAddressBook(id, addressBookDto);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return addressBookService.deleteAddressBook(id);
    }
}