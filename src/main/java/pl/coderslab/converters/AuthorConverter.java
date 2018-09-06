package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    AuthorDao authorDao;

    @Override
    public Author convert(String source) {
        Author author = authorDao.findById(Long.parseLong(source));
        return  author;
    }
}
