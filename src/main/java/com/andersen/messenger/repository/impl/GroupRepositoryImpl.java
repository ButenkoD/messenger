package com.andersen.messenger.repository.impl;

import com.andersen.messenger.entity.Group;
import com.andersen.messenger.repository.GroupRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GroupRepositoryImpl extends BaseRepositoryImpl implements GroupRepository {
    public Group findGroup(Integer id) {
        return (Group) findEntity(id);
    }

    public boolean addGroup(Group group) {
        return addEntity(group);
    }
    public boolean removeGroup(Integer id) {
        return removeEntity(id);
    }
}
