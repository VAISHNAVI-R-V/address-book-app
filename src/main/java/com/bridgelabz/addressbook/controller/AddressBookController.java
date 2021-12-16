package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.sevice.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<AddressBookDto> getAdrressList() {
        return addressBookService.getAllAddress();
    }
}