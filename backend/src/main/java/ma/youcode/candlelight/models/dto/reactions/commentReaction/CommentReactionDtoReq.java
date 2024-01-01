package ma.youcode.candlelight.models.dto.reactions.commentReaction;

import lombok.Getter;
import lombok.Setter;
import ma.youcode.candlelight.models.dto.reactions.ReactionDtoReq;

@Getter
@Setter
public final class CommentReactionDtoReq extends ReactionDtoReq {
    private Long comment;
}
