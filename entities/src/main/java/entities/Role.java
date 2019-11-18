package entities;

import lombok.*;

public enum Role {
    ADMIN("admin"),
    OPERATOR("operator"),
    COURIER("courier"),
    СLIENT("client");

    Role(String name) {
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public static Role getRoleByName(String name){
        switch(name) {
            case "admin" : return Role.ADMIN;
            case "operator" : return Role.OPERATOR;
            case "courier" : return Role.COURIER;
            case "client" : return Role.СLIENT;
            default: break;
        }
        return null;
    }
}
