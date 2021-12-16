package com.bridgelabz.addressbook.sevice;

import com.bridgelabz.addressbook.dto.AddressBookDto;
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
//    @Autowired
//    private AddressBuilder addressBuilder;

    public List<AddressBookDto> getAllAddress() {
        return addressBookRepository.findAll().stream()
                .map(addressBookEntity -> modelMapper
                        .map(addressBookEntity, AddressBookDto.class))
                .collect(Collectors.toList());
    }
}
