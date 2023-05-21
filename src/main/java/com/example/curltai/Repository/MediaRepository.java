package com.example.curltai.Repository;

import com.example.curltai.Model.Community.Media;
import com.example.curltai.Model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
