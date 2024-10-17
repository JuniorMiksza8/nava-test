package br.com.nava.test.mapper;

import br.com.nava.test.dto.PostcodeDto;
import br.com.nava.test.entity.PostcodeRequestLog;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostcodeRequestLogMapper {

    public static PostcodeRequestLog create(PostcodeDto data, LocalDateTime requestDate,LocalDateTime responseDate,String errorMessage) {
        return PostcodeRequestLog.builder()
                .postcode(data != null ? PostcodeMapper.fromDto(data) : null)
                .requestDate(requestDate.toString())
                .responseDate(responseDate.toString())
                .errorMessage(errorMessage)
                .build();
    }

}
