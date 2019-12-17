package enums;

public enum OrderStatusEnum {
    COURIER_DELIVERY("Доставка"),
    NEW("Новый"),
    TRANSFERRED_TO_THE_COURIER("Передан курьеру"),
    COMPLETED("Завершён");
    private String name;

    public String getName() {
        return name;
    }

    OrderStatusEnum(String name) {
        this.name = name;
    }

}
