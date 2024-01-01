package ma.youcode.candlelight.models.dto.reactions;

import lombok.Getter;
import lombok.Setter;
import ma.youcode.candlelight.models.enums.ReactionType;

@Getter
@Setter
public class ReactionDtoReq {
    protected Long id;
    protected Long reactor;
    protected ReactionType type;
}
