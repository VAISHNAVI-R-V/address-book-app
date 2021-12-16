package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.builder.AddressBuilder;
import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.entity.AddressBookEntity;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import com.bridgelabz.addressbook.sevice.AddressBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressBookServiceTest {
    @InjectMocks
    private AddressBookService addressBookService;
    @Mock
    private AddressBookRepository addressBookRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private AddressBuilder addressBuilder;

    @Test
    void given2AddressBookDto_whenCalledGetAllMethod_shouldReturnListOfAddressBookDto() {
        List<AddressBookDto> addressBookDtoList = new ArrayList<>();
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Preksha");
        addressBookDto.setAddress("Yalhanka");
        addressBookDto.setCity("Banglore");
        addressBookDto.setState("Karnataka");
        addressBookDto.setPhoneNumber("800007890");
        addressBookDto.setZip("569130");
        addressBookDtoList.add(addressBookDto);
        AddressBookDto addressBookDto2 = new AddressBookDto();
        addressBookDto2.setName("Punam");
        addressBookDto2.setAddress("Guru-nanak colony");
        addressBookDto2.setCity("Bidar");
        addressBookDto2.setState("Karnataka");
        addressBookDto2.setPhoneNumber("8900000000");
        addressBookDto2.setZip("456000");
        addressBookDtoList.add(addressBookDto2);

        List<AddressBookEntity> addressBookEntities = new ArrayList<>();
        AddressBookEntity addressBookEntity = new AddressBookEntity();
        addressBookEntity.setName("Shiv");
        addressBookEntity.setAddress("Market Road");
        addressBookEntity.setCity("Gulbarga");
        addressBookEntity.setState("Karnataka");
        addressBookEntity.setPhoneNumber("9011111111");
        addressBookEntity.setZip("585333");
        addressBookEntities.add(addressBookEntity);
        AddressBookEntity addressBookEntity1 = new AddressBookEntity();
        addressBookEntity1.setName("Humera");
        addressBookEntity1.setAddress("Ram colony");
        addressBookEntity1.setCity("Kalaburgi");
        addressBookEntity1.setState("Karnataka");
        addressBookEntity1.setPhoneNumber("1234567890");
        addressBookEntity1.setZip("123456");
        addressBookEntities.add(addressBookEntity1);

        when(addressBookRepository.findAll()).thenReturn(addressBookEntities);
        when(modelMapper.map(addressBookEntities.get(0), AddressBookDto.class)).thenReturn(addressBookDto);
        when(modelMapper.map(addressBookEntities.get(1), AddressBookDto.class)).thenReturn(addressBookDto2);
        List<AddressBookDto> actualListOfAddressBook = addressBookService.getAllAddress();
        assertEquals(2, actualListOfAddressBook.size());
        assertEquals(addressBookDtoList, actualListOfAddressBook);
    }
}
