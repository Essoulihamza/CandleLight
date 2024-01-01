package ma.youcode.candlelight.models.documents;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.candlelight.models.documents.abstracts.Reaction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Document(collection = "postReactions")
public final class PostReaction extends Reaction {
    @Transient
    private static final String SEQUENCE_NAME = "post_reaction_sequence";

    public static String getSequenceName() {
        return SEQUENCE_NAME;
    }
    
    private Post post;
}
