package com.bridgelabz.addressbook.exception;

import lombok.Data;

import java.util.Date;

/**
 * Purpose : To implement Error Response for errors in Address Book AppApplication.
 *
 * @author : VAISHANAVI R. VISHWAKARMA.
 * @since : 16-12-2021
 */
@Data
public class ErrorResponse {
    private int statusCode;
    private Date timestamp;
    private String errors;
}
