package org.example.Avatar.dto;

import lombok.NoArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.dto.response.FindAvatarResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class AvatarMapper {
    public FindAvatarResponse toDtoFind(List<Avatar> avatars){
        List<String> names=avatars.stream().map(Avatar::getName).toList();
        return new FindAvatarResponse(names);
    }
}
