package com.example.ec.explorecali.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by m.karandish on 4/28/2019.
 */
@Converter(autoApply = true)
public class DifficultyConverter implements AttributeConverter<Difficulty,String> {
    @Override
    public String convertToDatabaseColumn(Difficulty difficulty) {
        return difficulty.getLabel();
    }

    @Override
    public Difficulty convertToEntityAttribute(String s) {
        return Difficulty.findByLabel(s);
    }
}
