package com.shortenedUrl.dao;

import com.shortenedUrl.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Amisha Patel
 */

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {

    Optional<ShortUrl> findByLongUrl(String longUrl);

}
