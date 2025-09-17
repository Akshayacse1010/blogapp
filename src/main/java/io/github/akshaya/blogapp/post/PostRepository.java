package io.github.akshaya.blogapp.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>
{
/*The Magic: Derived Query Methods
When you extend JpaRepository, Spring Data JPA does something amazing at runtime. It reads the names of any new methods you define in your repository interface and automatically figures out the SQL query for you. This is called "derived query methods."

It follows a strict naming convention. If you name your method correctly, Spring can parse the name and build the query.

For our task, we want to find all Post entities by their author's ID. Let's look at the Post entity. It has a field named author, and that Author object has a field named id.

*/
   List<Post> findAllByAuthorId(Long id);

//   @Query(value = "SELECT p.* FROM posts p INNER JOIN authors a ON p.author_id = a.id WHERE a.id = :authorID and p.id = :postID", nativeQuery = true)
//   Post findPostByAuthorID(Long authorID,Long postID);
//The order of the parameters is wrong. Spring Data JPA is very strict about this. It expects the method's parameters to appear in the exact same order as the properties in the method name.
   Optional<Post> findByIdAndAuthorId(Long authorId, Long PostId);
}
