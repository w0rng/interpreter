package CourseWork;

// Класс отвечающий за объекты токенов
public class Token {

    public TokenTypes.Types type; // Тип токена
    public String value; // Его значение

    // Конструктор
    public Token(TokenTypes.Types type, String value) {
        this.type = type;
        this.value = value;
    }

    // Нужно дла отладки
    public String toString() {
        return "Token(" + type.name() + " : '" + value.toString() + "')";
    }
}