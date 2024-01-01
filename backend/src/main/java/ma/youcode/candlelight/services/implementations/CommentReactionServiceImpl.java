package ma.youcode.candlelight.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.youcode.candlelight.exceptions.ResourceNotFound;
import ma.youcode.candlelight.models.documents.Comment;
import ma.youcode.candlelight.models.documents.CommentReaction;
import ma.youcode.candlelight.models.documents.User;
import ma.youcode.candlelight.models.dto.reactions.commentReaction.CommentReactionDtoReq;
import ma.youcode.candlelight.models.dto.reactions.commentReaction.CommentReactionDtoResp;
import ma.youcode.candlelight.models.enums.ReactionType;
import ma.youcode.candlelight.repositories.CommentReactionRepository;
import ma.youcode.candlelight.repositories.CommentRepository;
import ma.youcode.candlelight.repositories.UserRepository;
import ma.youcode.candlelight.services.CommentReactionService;
import ma.youcode.candlelight.services.SequenceGeneratorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class CommentReactionServiceImpl implements CommentReactionService {

    private final CommentReactionRepository commentReactionRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final SequenceGeneratorService sequenceGenerator;
    private final ModelMapper modelMapper;

    @Override
    public CommentReactionDtoResp create(CommentReactionDtoReq newElement) {
        log.info("Mapping the request comment reaction {} to a document comment reaction", newElement.getType());
        CommentReaction commentReaction = modelMapper.map(newElement, CommentReaction.class);
        log.info("Searching for the user and setting it to the comment reaction");
        commentReaction.setReactor(
                userRepository.findById(newElement.getReactor())
                        .orElseThrow(() -> new ResourceNotFound("User Not Found"))
        );
        log.info("Searching for the comment and setting it to the comment reaction");
        commentReaction.setComment(
                commentRepository.findById(newElement.getComment())
                        .orElseThrow(() -> new ResourceNotFound("Comment Not Found"))
        );
        log.info("Setting a sequence id to the new comment reaction");
        commentReaction.setId(sequenceGenerator.generateSequence(CommentReaction.getSequenceName()));
        log.info("Saving new comment reaction");
        return modelMapper.map(commentReactionRepository.save(commentReaction), CommentReactionDtoResp.class);
    }

    @Override
    public CommentReactionDtoResp update(CommentReactionDtoReq elementBody) {
        log.info("Checking if the comment reaction exists");
        CommentReaction commentReaction = commentReactionRepository.findById(elementBody.getId())
                .orElseThrow(() -> new ResourceNotFound("Comment reaction not found"));
        log.info("Checking if the user exists and setting it to the comment reaction");
        commentReaction.setReactor(
                userRepository.findById(elementBody.getReactor())
                        .orElseThrow(() -> new ResourceNotFound("User Not Found"))
        );
        log.info("Checking if the comment exists and setting it to the comment reaction");
        commentReaction.setComment(
                commentRepository.findById(elementBody.getComment())
                        .orElseThrow(() -> new ResourceNotFound("Comment Not Found"))
        );
        commentReaction.setType(
            ReactionType.valueOf(elementBody.getType().name())
        );
        log.info("Updating the comment reaction");
        return modelMapper.map(commentReactionRepository.save(commentReaction), CommentReactionDtoResp.class);
    }

    @Override
    public CommentReactionDtoResp findById(Long aLong) {
        log.info("Retrieving one comment reaction with the id {}", aLong);
        CommentReaction commentReaction = commentReactionRepository.findById(aLong)
                .orElseThrow(() -> new ResourceNotFound("Comment reaction not found"));
        return modelMapper.map(commentReaction, CommentReactionDtoResp.class);
    }

    @Override
    public String delete(Long aLong) {
        log.info("Checking if the comment reaction exists");
        CommentReaction commentReaction = commentReactionRepository.findById(aLong)
                .orElseThrow(() -> new ResourceNotFound("Comment reaction not found"));
        log.info("Deleting comment reaction {}", commentReaction.getId());
        commentReactionRepository.delete(commentReaction);
        return "Comment reaction with the id: " + aLong + "was deleted successfully";
    }
}
