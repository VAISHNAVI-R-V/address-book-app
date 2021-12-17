package com.bridgelabz.addressbook.exception;

/**
 * Purpose : To implement Address book Custom Exception in Address book AppApplication.
 *
 * @author : VAISHANAVI R. VISHWAKARMA.
 * @since : 16-12-2021
 */
public class AddressBookCustomException extends RuntimeException {
    public AddressBookCustomException(String message) {
        super(message);
    }
}
