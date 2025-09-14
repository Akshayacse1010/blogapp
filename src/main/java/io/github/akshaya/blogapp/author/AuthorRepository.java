package io.github.akshaya.blogapp.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Data Access Layer
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>
{

}
