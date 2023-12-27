package ma.youcode.candlelight.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.youcode.candlelight.models.dto.Medias.MediaDtoReq;
import ma.youcode.candlelight.models.dto.Medias.MediaDtoResp;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import ma.youcode.candlelight.services.MediaService;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class MediaController {

    private final MediaService mediaService;

    @MutationMapping
    public MediaDtoResp createMedia(final @Valid @Argument MediaDtoReq newMedia) {
        return this.mediaService.create(newMedia);
    }

    @MutationMapping
    public MediaDtoResp updateMedia(final @Valid @Argument MediaDtoReq Media) {
        return this.mediaService.update(Media);
    }



}
