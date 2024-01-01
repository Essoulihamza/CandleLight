package ma.youcode.candlelight.repositories;

import ma.youcode.candlelight.models.documents.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends MongoRepository<Comment, Long> {}
