package ir.rezacolonel.springTutorial1.service;

import ir.rezacolonel.springTutorial1.exception.ServiceException;
import ir.rezacolonel.springTutorial1.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Service
public class OrderDAO2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //Declarative Transaction Management
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, timeout = 40)
    public void updateTitle(Long postId, String title) throws ServiceException {
        int affected = jdbcTemplate.update("update posts set title = ? where id = ?;", title, postId);
        if (affected <= 0)
            throw new ServiceException("The Order ID does not exist");
    }

    @Transactional(readOnly = true)
    public List<Posts> findAll() {
        return jdbcTemplate.query("select id,title from posts", new RowMapper<Posts>() {
            @Override
            public Posts mapRow(ResultSet resultSet, int i) throws SQLException {
                Posts post = new Posts();
                post.setId(resultSet.getLong(1));
                post.setTitle(resultSet.getString(2));
                return post;
            }
        });
    }
}
