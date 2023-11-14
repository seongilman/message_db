package com.message.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class LanguageRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LanguageRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Languages findByMessageKeyAndLocale(String key, String language) {
        return jdbcTemplate.queryForObject("select * from languages where message_key  = ? and locale = ?", languagesRowMapper(), key, language);
    }

    private RowMapper<Languages> languagesRowMapper() {
        return (rs, rowNum) -> {
            Languages languages = new Languages();
            languages.setId((int) rs.getInt("id"));
            languages.setLocale(rs.getString("locale"));
            languages.setMessageKey(rs.getString("message_key"));
            languages.setMessageContent(rs.getString("message_content"));
            return languages;
        };
    }
}
