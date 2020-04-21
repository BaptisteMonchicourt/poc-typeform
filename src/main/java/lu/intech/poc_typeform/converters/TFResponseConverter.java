package lu.intech.poc_typeform.converters;

import lu.intech.poc_typeform.api.TFResponseDto;
import lu.intech.poc_typeform.models.TFResponse;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TFResponseConverter implements Converter<TFResponse, TFResponseDto> {

    @Override
    public TFResponseDto convert(TFResponse tfresponse) {
        ModelMapper modelMapper = new ModelMapper();
        TFResponseDto dto = modelMapper.map(tfresponse, TFResponseDto.class);
        return dto;
    }

}
