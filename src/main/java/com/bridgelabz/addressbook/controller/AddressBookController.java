package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.sevice.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose : To implement Address Book Controller in Address Book AppApplication.
 *
 * @author : VAISHANAVI R. VISHWAKARMA.
 * @since : 16-12-2021
 */
@RestController
@RequestMapping(value = "/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    /**
     * Purpose : To get list of all addresses from database.
     *
     * @return List : List of address.
     */
    @GetMapping(value = "/all")
    public List<AddressBookDto> addrressList() {
        return addressBookService.getAllAddress();
    }

    /**
     * @purpose : To add address from address-book-app.
     *
     * @return : add address method from address-book service class.
     */
    @PostMapping(value = "/add")
    public String addAddress(@Valid @RequestBody AddressBookDto addressBookDto) {
        return addressBookService.addAddressBook(addressBookDto);
    }

    /**
     * @purpose : To update address by ID from address-book-app.
     *
     * @return : update address method by ID from address-book service class.
     */
    @PutMapping(value = "/update/{id}")
    public String updateAddress(@PathVariable(value = "id") int id,
                                @Valid @RequestBody AddressBookDto addressBookDto) {
        return addressBookService.updateAddressBook(id, addressBookDto);
    }

    /**
     * @purpose : To delete address by ID from address-book-app.
     *
     * @return : delete address method by ID from address-book service class.
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return addressBookService.deleteAddressBook(id);
    }
}