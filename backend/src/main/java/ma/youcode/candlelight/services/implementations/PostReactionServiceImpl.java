package ma.youcode.candlelight.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.youcode.candlelight.exceptions.ResourceNotFound;
import ma.youcode.candlelight.models.documents.PostReaction;
import ma.youcode.candlelight.models.dto.reactions.postReaction.PostReactionDtoReq;
import ma.youcode.candlelight.models.dto.reactions.postReaction.PostReactionDtoResp;
import ma.youcode.candlelight.models.enums.ReactionType;
import ma.youcode.candlelight.repositories.PostReactionRepository;
import ma.youcode.candlelight.repositories.PostRepository;
import ma.youcode.candlelight.repositories.UserRepository;
import ma.youcode.candlelight.services.PostReactionService;
import ma.youcode.candlelight.services.SequenceGeneratorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class PostReactionServiceImpl implements PostReactionService {

    private final PostReactionRepository postReactionRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final SequenceGeneratorService sequenceGenerator;
    private final ModelMapper modelMapper;
    @Override
    public PostReactionDtoResp create(PostReactionDtoReq newElement) {
        log.info("Mapping the request post reaction {} to a document post reaction", newElement.getType());
        PostReaction postReaction = modelMapper.map(newElement, PostReaction.class);
        log.info("Searching for the user and setting it to the post reaction");
        postReaction.setReactor(
                userRepository.findById(newElement.getReactor())
                        .orElseThrow(() -> new ResourceNotFound("User Not Found"))
        );
        log.info("Searching for the post and setting it to the post reaction");
        postReaction.setPost(
                postRepository.findById(newElement.getPost())
                        .orElseThrow(() -> new ResourceNotFound("Post Not Found"))
        );
        log.info("Setting a sequence id to the new post reaction");
        postReaction.setId(sequenceGenerator.generateSequence(PostReaction.getSequenceName()));
        log.info("Saving new post reaction");
        return modelMapper.map(postReactionRepository.save(postReaction), PostReactionDtoResp.class);
    }

    @Override
    public PostReactionDtoResp update(PostReactionDtoReq elementBody) {
        log.info("Checking if the post reaction exists");
        PostReaction postReaction = postReactionRepository.findById(elementBody.getId())
                .orElseThrow(() -> new ResourceNotFound("Post reaction not found"));
        log.info("Checking if the user exists and setting it to the post reaction");
        postReaction.setReactor(
                userRepository.findById(elementBody.getReactor())
                        .orElseThrow(() -> new ResourceNotFound("User Not Found"))
        );
        log.info("Checking if the post exists and setting it to the post reaction");
        postReaction.setPost(
                postRepository.findById(elementBody.getPost())
                        .orElseThrow(() -> new ResourceNotFound("Post Not Found"))
        );
        postReaction.setType(
                ReactionType.valueOf(elementBody.getType().name())
        );
        log.info("Updating the post reaction");
        return modelMapper.map(postReactionRepository.save(postReaction), PostReactionDtoResp.class);
    }

    @Override
    public PostReactionDtoResp findById(Long aLong) {
        log.info("Retrieving one post reaction with the id {}", aLong);
        PostReaction postReaction = postReactionRepository.findById(aLong)
                .orElseThrow(() -> new ResourceNotFound("Post reaction not found"));
        return modelMapper.map(postReaction, PostReactionDtoResp.class);
    }

    @Override
    public String delete(Long aLong) {
        log.info("Checking if the post reaction exists");
        PostReaction postReaction = postReactionRepository.findById(aLong)
                .orElseThrow(() -> new ResourceNotFound("Post reaction not found"));
        log.info("Deleting post reaction {}", postReaction.getId());
        postReactionRepository.delete(postReaction);
        return "Post reaction with the id: " + aLong + "was deleted successfully";
    }
}
