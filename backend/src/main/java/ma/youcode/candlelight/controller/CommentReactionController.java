package ma.youcode.candlelight.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.candlelight.models.dto.reactions.commentReaction.CommentReactionDtoReq;
import ma.youcode.candlelight.models.dto.reactions.commentReaction.CommentReactionDtoResp;
import ma.youcode.candlelight.services.CommentReactionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CommentReactionController {
    private final CommentReactionService service;

    @MutationMapping
    public CommentReactionDtoResp createCommentReaction(final @Valid @Argument CommentReactionDtoReq newCommentReaction) {
        return service.create(newCommentReaction);
    }
    @MutationMapping
    public CommentReactionDtoResp updateCommentReaction(final @Valid @Argument CommentReactionDtoReq commentReaction) {
        return service.update(commentReaction);
    }
    @MutationMapping
    public String deleteCommentReaction(final @Argument Long id) {
        return service.delete(id);
    }
    @QueryMapping
    public CommentReactionDtoResp findCommentReactionById(final @Argument Long id) {
        return service.findById(id);
    }
}
