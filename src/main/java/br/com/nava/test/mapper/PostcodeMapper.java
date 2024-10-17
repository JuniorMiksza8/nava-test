package br.com.nava.test.mapper;

import br.com.nava.test.dto.CorreiosPostcodeDto;
import br.com.nava.test.dto.PostcodeDto;
import br.com.nava.test.entity.Postcode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostcodeMapper {

    public static PostcodeDto fromCorreios(CorreiosPostcodeDto data){
        return PostcodeDto.builder()
                .postcode(data.getPostcode())
                .district(data.getDistrict())
                .location(data.getAddress())
                .region(data.getRegion())
                .city(data.getCity())
                .state(data.getState())
                .stateCode(data.getStateCode())
                .complement(data.getComplement())
                .build();
    }

    public static Postcode fromDto(PostcodeDto data) {
        return Postcode.builder()
                .id(data.getPostcode())
                .district(data.getDistrict())
                .location(data.getLocation())
                .region(data.getRegion())
                .city(data.getCity())
                .state(data.getState())
                .stateCode(data.getStateCode())
                .complement(data.getComplement())
                .build();
    }

}
