package io.github.akshaya.blogapp.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>
{
/*The Magic: Derived Query Methods
When you extend JpaRepository, Spring Data JPA does something amazing at runtime. It reads the names of any new methods you define in your repository interface and automatically figures out the SQL query for you. This is called "derived query methods."

It follows a strict naming convention. If you name your method correctly, Spring can parse the name and build the query.

For our task, we want to find all Post entities by their author's ID. Let's look at the Post entity. It has a field named author, and that Author object has a field named id.

*/
   List<Post> findAllByAuthorId(Long id);

}
