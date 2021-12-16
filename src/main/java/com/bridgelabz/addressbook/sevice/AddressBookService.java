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

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressBuilder addressBuilder;

    public List<AddressBookDto> getAllAddress() {
        return addressBookRepository.findAll().stream()
                .map(addressBookEntity -> modelMapper
                        .map(addressBookEntity, AddressBookDto.class))
                .collect(Collectors.toList());
    }

    public String addAddressBook(AddressBookDto addressBookDto) {
        AddressBookEntity addressBookEntity = modelMapper.map(addressBookDto, AddressBookEntity.class);
        addressBookRepository.save(addressBookEntity);
        return "Address Added Successfully!";
    }

    public AddressBookEntity getAddressBookById(int id) {
        AddressBookEntity addressBookEntity = addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookCustomException(
                        "Invalid AddressBook Id -> " + id));
        return addressBookEntity;
    }

    public String updateAddressBook(int id, AddressBookDto addressBookDto) {
        AddressBookEntity addressBookEntity = getAddressBookById(id);
        addressBookEntity = addressBuilder.buildAddressEntity(addressBookDto, addressBookEntity);
        addressBookRepository.save(addressBookEntity);
        return "AddressBook Updated Successfully";
    }
}
