package com.example.ec.explorecali.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by m.karandish on 4/28/2019.
 */
@Converter(autoApply = true)
public class RegionConverter  implements AttributeConverter<Region,String>{
    @Override
    public String convertToDatabaseColumn(Region region) {
        return region.getLabel();
    }

    @Override
    public Region convertToEntityAttribute(String s) {
        return Region.findByLabel(s);
    }
}
