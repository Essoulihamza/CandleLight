package ma.youcode.candlelight.services.implementations;

import lombok.AllArgsConstructor;
import ma.youcode.candlelight.models.documents.Media;
import ma.youcode.candlelight.models.dto.Medias.MediaDtoReq;
import ma.youcode.candlelight.models.dto.Medias.MediaDtoResp;
import ma.youcode.candlelight.repositories.MediaRepository;
import ma.youcode.candlelight.services.MediaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MediaServiceImpl implements MediaService {
    private MediaRepository mediaRepository;
    private ModelMapper modelMapper;

    @Override
    public MediaDtoResp create(MediaDtoReq newElement) {
        return modelMapper.map(
                mediaRepository.save(modelMapper.map(newElement, Media.class)),
                MediaDtoResp.class
        );
    }

    @Override
    public MediaDtoResp update(Long aLong, MediaDtoReq elementBody) {
        return null;
    }

    @Override
    public MediaDtoResp findById(Long aLong) {
        return null;
    }

    @Override
    public MediaDtoResp delete(Long aLong) {
        return null;
    }
}
