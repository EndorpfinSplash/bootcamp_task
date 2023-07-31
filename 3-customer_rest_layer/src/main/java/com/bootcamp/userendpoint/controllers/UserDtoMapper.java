package com.bootcamp.userendpoint.controllers;

import com.bootcamp.userendpoint.model.UserModel;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    UserDto toDto(UserModel userModel);
    UserModel toModel(UserDto userDto);

    List<UserModel> toModelList(List<UserDto> userDtos);
    Iterable<UserDto> toDtoList(Iterable<UserModel> userModels);
}