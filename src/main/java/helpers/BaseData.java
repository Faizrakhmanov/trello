package helpers;

public enum BaseData {
    LOGIN("testtrellouser553@mail.ru"),
    PASSWORD("yUypIIyHy-41"),

    API("45eba7634e86816c94ba41b7b95c1e4a"),
    TOKEN("07df655160724026ab7991f37311475b01344abac5d7a83e2605cc7ce206a389"),
    CRYPTO_KEY("f69db9bdcdd931f6b13ed91ab27ebdd5593f72637a880781f5bd1157479538b6"); //авторизация с помощью OAuth 1. Чтобы использовать ее, потребуется криптоключ

    public String value;

    BaseData(String value) {
        this.value = value;
    }
}