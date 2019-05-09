package com.byka.humanlibrary.constants;

public class RegistrationEventMassages {
    public static final String SESSION_IS_NOT_EXIST = "Невозможно найти сессию, попробуйте позже.";

    public static String REGISTRATION_IS_NOT_OPEN = "Регистрация поке не открыта";

    public static String ALREADY_REGISTERED = "Вы уже зарегистрированны на данную сессию";

    public static String OVERLIMIT = "Вы уже зарегистрированны на данную сессию";

    private RegistrationEventMassages() {
        throw new IllegalAccessError();
    }
}
