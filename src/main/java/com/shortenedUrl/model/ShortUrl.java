package com.shortenedUrl.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Amisha Patel
 */

@Entity
@Table(name = "TBL_SHORT_URL", indexes = @Index(name = "index_long_url", columnList = "long_url", unique = true), uniqueConstraints = @UniqueConstraint(columnNames = "short_key", name = "short_url_uq_short_key"))
public class ShortUrl {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Long_URL")
    private String longUrl;

    @Column(name = "SHORT_KEY")
    private String shortKey;

    @CreationTimestamp
    @Column(name = "create_time_stamp", updatable = false)
    private LocalDateTime createTimeStamp;

    public ShortUrl() {
    }

    public ShortUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public ShortUrl(String longUrl, String shortUrl) {
        this.longUrl = longUrl;
        this.shortKey = shortUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortKey() {
        return shortKey;
    }

    public void setShortKey(String shortKey) {
        this.shortKey = shortKey;
    }

    public LocalDateTime getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(LocalDateTime createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }
}
