package com.bridgelabz.addressbook.builder;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.entity.AddressBookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Purpose : To implement Address Book Builder for Address Book AppApplication.
 *
 * @author : VAISHANAVI R. VISHWAKARMA.
 * @since : 16-12-2021
 */
@Component
public class AddressBuilder {
    private ModelMapper modelMapper = new ModelMapper();

    /**
     * @purpose : To build address book builder using model mapper.
     *
     * @param addressBookDto : address dto used to add the fields of dto as per regex pattern.
     * @param addressBookEntity : address entity is used to map data's from Employee Dto.
     * @return : address entity.
     */
    public AddressBookEntity buildAddressEntity(AddressBookDto addressBookDto,
                                                AddressBookEntity addressBookEntity) {
        modelMapper.map(addressBookDto, addressBookEntity);
        return addressBookEntity;
    }
}
