package ma.youcode.candlelight.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.candlelight.models.dto.reactions.postReaction.PostReactionDtoReq;
import ma.youcode.candlelight.models.dto.reactions.postReaction.PostReactionDtoResp;
import ma.youcode.candlelight.services.PostReactionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PostReactionController {
    private final PostReactionService service;

    @MutationMapping
    public PostReactionDtoResp createPostReaction(final @Valid @Argument PostReactionDtoReq newPostReaction) {
        return service.create(newPostReaction);
    }
    @MutationMapping
    public PostReactionDtoResp updatePostReaction(final @Valid @Argument PostReactionDtoReq postReaction) {
        return service.update(postReaction);
    }
    @MutationMapping
    public String deletePostReaction(final @Argument Long id) {
        return service.delete(id);
    }
    @QueryMapping
    public PostReactionDtoResp findPostReactionById(final @Argument Long id) {
        return service.findById(id);
    }
}
