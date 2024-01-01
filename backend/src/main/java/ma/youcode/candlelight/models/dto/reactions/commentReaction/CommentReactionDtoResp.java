package ma.youcode.candlelight.models.dto.reactions.commentReaction;

import lombok.Getter;
import lombok.Setter;
import ma.youcode.candlelight.models.documents.Comment;
import ma.youcode.candlelight.models.dto.reactions.ReactionDtoResp;

@Getter
@Setter
public class CommentReactionDtoResp extends ReactionDtoResp {
    private Comment comment;
}
