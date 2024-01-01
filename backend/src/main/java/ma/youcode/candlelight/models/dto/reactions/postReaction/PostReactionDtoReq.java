package ma.youcode.candlelight.models.dto.reactions.postReaction;

import lombok.Getter;
import lombok.Setter;
import ma.youcode.candlelight.models.dto.reactions.ReactionDtoReq;

@Getter
@Setter
public final class PostReactionDtoReq extends ReactionDtoReq {
    private Long post;
}
