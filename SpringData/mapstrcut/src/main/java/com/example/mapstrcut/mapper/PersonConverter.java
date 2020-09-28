package com.example.mapstrcut.mapper;

import com.example.mapstrcut.domain.Person;
import com.example.mapstrcut.dto.PersonDTO;
import com.example.mapstrcut.utils.BooleanStrFormat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: PersonConverter
 * Author:   YJ
 * Date:     2020/9/28 13:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/28 13:27        1.0              描述
 */
@Mapper(componentModel = "spring",uses = {BooleanStrFormat.class})
public interface PersonConverter {
    @Mappings({
            @Mapping(source = "user.age",target = "age"),
            @Mapping(source = "birthday",target = "birthDateFormat",dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "enable",target = "enable",qualifiedByName ={"BooleanStrFormat","toStr"} )
    })
    PersonDTO toDto(Person person);

    @Mappings({
            @Mapping(source = "age",target = "user.age")
    })
    Person toEntity(PersonDTO dto);
}
