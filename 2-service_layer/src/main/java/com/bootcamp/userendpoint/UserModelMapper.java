package com.bootcamp.userendpoint;

import com.bootcamp.userendpoint.model.UserEntity;
import com.bootcamp.userendpoint.model.UserModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserModelMapper {

    UserEntity toEntity(UserModel model);
    UserModel toModel(UserEntity entity);

    Iterable<UserModel> toModelList(Iterable<UserEntity> userEntities);
    Iterable<UserEntity> toEntityList(Iterable<UserModel> userModels);
}
