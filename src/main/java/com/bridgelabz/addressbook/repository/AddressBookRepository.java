package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.entity.AddressBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Purpose : To implement Address Book Repository Interface in Address book AppApplication.
 *
 * @author : VAISHANAVI R. VISHWAKARMA.
 * @since : 16-12-2021
 */
@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookEntity, Integer> {

}
