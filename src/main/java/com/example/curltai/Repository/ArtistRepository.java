package com.example.curltai.Repository;

import com.example.curltai.Model.Users.Artist;
import com.example.curltai.Model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
