package ma.youcode.candlelight.models.dto.reactions.postReaction;

import lombok.Getter;
import lombok.Setter;
import ma.youcode.candlelight.models.documents.Post;
import ma.youcode.candlelight.models.dto.reactions.ReactionDtoResp;

@Getter
@Setter
public class PostReactionDtoResp extends ReactionDtoResp {
    private Post post;
}
