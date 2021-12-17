package com.bridgelabz.addressbook.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Purpose : To implement Address Book Configuration in Address Book AppApplication.
 *
 * @author : VAISHANAVI R. VISHWAKARMA.
 * @since : 16-12-2021
 */
@Configuration
public class AddressBookConfiguration {

    /**
     * @purpose : To use model mapper for address book app.
     *
     * @return : Model mapper.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
