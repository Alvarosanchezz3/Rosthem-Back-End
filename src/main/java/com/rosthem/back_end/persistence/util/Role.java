package com.rosthem.back_end.persistence.util;

import java.util.Arrays;
import java.util.List;

public enum Role {

    ADMINISTRATOR(Arrays.asList(
        RolePermission.READ_ALL_APARTMENTS,
        RolePermission.READ_ONE_APARTMENT,
        RolePermission.CREATE_ONE_APARTMENT,
        RolePermission.UPDATE_ONE_APARTMENT,
        RolePermission.DELETE_ONE_APARTMENT,

        RolePermission.READ_MY_PROFILE,
        RolePermission.READ_ALL_USERS
    )),

    CUSTOMER(Arrays.asList(
        RolePermission.READ_ALL_APARTMENTS,
        RolePermission.READ_ONE_APARTMENT,
        RolePermission.CREATE_ONE_APARTMENT,
        RolePermission.UPDATE_ONE_APARTMENT,
        RolePermission.DELETE_ONE_APARTMENT,

        RolePermission.READ_MY_PROFILE
    ));

    private List<RolePermission> permissions;

    // Constructor, Getters y Setters

    Role(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

    public List<RolePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RolePermission> permissions) {
        this.permissions = permissions;
    }
}