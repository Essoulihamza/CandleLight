package ma.youcode.candlelight.models.dto.reactions;

import lombok.Getter;
import lombok.Setter;
import ma.youcode.candlelight.models.documents.User;
import ma.youcode.candlelight.models.enums.ReactionType;

@Getter
@Setter
public class ReactionDtoResp {
    protected Long id;
    protected User reactor;
    protected ReactionType type;
}
