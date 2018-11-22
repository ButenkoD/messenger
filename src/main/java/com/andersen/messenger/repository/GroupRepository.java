package com.andersen.messenger.repository;

import com.andersen.messenger.entity.Device;
import com.andersen.messenger.entity.Group;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository {
    Group findGroup(Integer id);
    boolean addGroup(Group group);
    boolean removeGroup(Integer id);
}
