package com.bridgelabz.addressbook.sevice;

import com.bridgelabz.addressbook.builder.AddressBuilder;
import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.entity.AddressBookEntity;
import com.bridgelabz.addressbook.exception.AddressBookCustomException;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Purpose : To implement Address book Service in Address book AppApplication.
 *
 * @author : VAISHANAVI R. VISHWAKARMA.
 * @since : 16-12-2021
 */
@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressBuilder addressBuilder;

    /**
     * @purpose : To get list of Address-book.
     *
     * @return : List of Addresses.
     */
    public List<AddressBookDto> getAllAddress() {
        return addressBookRepository.findAll().stream()
                .map(addressBookEntity -> modelMapper
                        .map(addressBookEntity, AddressBookDto.class))
                .collect(Collectors.toList());
    }

    /**
     * @purpose : To Add Address in Address Book App.
     *
     * @param addressBookDto : addressBookDto is used to add address in repository.
     * @return : String Message.
     */
    public String addAddressBook(AddressBookDto addressBookDto) {
        AddressBookEntity addressBookEntity = modelMapper.map(addressBookDto, AddressBookEntity.class);
        addressBookRepository.save(addressBookEntity);
        return "Address Added Successfully";
    }

    /**
     * @purpose : To get Address by By ID.
     *
     * @param id : I'd is used to search existing Adress data.
     * @return : String Message.
     */
    public AddressBookEntity getAddressBookById(int id) {
        AddressBookEntity addressBookEntity = addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookCustomException(
                        "Invalid AddressBook Id -> " + id));
        return addressBookEntity;
    }

    /**
     * @purpose : To Update Employee in address book app.
     *
     * @param id : I'd is used to search existing address data.
     * @param addressBookDto : addressBookDto is used to upload address in repository.
     * @return : String Message.
     */
    public String updateAddressBook(int id, AddressBookDto addressBookDto) {
        AddressBookEntity addressBookEntity = getAddressBookById(id);
        addressBookEntity = addressBuilder.buildAddressEntity(addressBookDto, addressBookEntity);
        addressBookRepository.save(addressBookEntity);
        return "AddressBook Updated Successfully";
    }

    /**
     * @purpose : To Delete address in Address payroll.
     *
     * @param id : I'd is used to search existing address data.
     * @return : String Message.
     */
    public String deleteAddressBook(int id) {
        AddressBookEntity addressBookEntity = getAddressBookById(id);
        addressBookRepository.delete(addressBookEntity);
        return "AddressBook Deleted Successfully";
    }
}
