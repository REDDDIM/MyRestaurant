package dto;

public class RoleDto extends BaseDto {
    private String name;
    private String description;

    public RoleDto(Long id, String name, String description) {
        this.setId(id);
        this.name = name;
        this.description = description;
    }

    public RoleDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
