package com.example.curltai;

import org.springframework.boot.test.context.*;


@SpringBootTest
public class UserRepositoryTest {

    // @Test
    // public void create() throws Exception {
    //     User user1= new User(-1,"Alice", "sadasd",  Role.Receptionist, 1);
    //     User user2= new User(-1,"Privet", "sadasd", Role.Admin, 1);
    //     //save user, verify has ID value after save
    //     assertEquals(user1.getId(), -1);
    //     assertEquals(user2.getId(), -1);
    //     this.userRepository.save(user1);
    //     this.userRepository.save(user2);
    //     assertNotNull(user1.getId());
    //     assertNotNull(user2.getId());
    // }
    // @Test
    // public void testFetchData(){
    //     /*Test data retrieval*/
    //     User userA = userRepository.findByLogin("Alice");
    //     assertNotNull(userA);
    //     assertEquals(Role.Receptionist, userA.getRole());
    //     /*Get all products, list should only have two*/
    //     Iterable users = userRepository.findAll();
    //     int count = 0;
    //     for(Object p : users){
    //         count++;
    //     }
    //     assertEquals(count, 2);
    // }
}
