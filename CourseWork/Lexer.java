package CourseWork;

import CourseWork.TokenTypes.Types;

// Класс разбивает входящий текст на токены
class Lexer {

    String text; // Текст для разбиения
    int pos; // Текущая позиция в тексте
    char currentChar; // Текущий символ
    TokenTypes tokenTypes = new TokenTypes(); // Типы токенов

    // Конструктор
    public Lexer(String text) {
        this.text = text;
        pos = 0;
        currentChar = text.charAt(pos);
    }

    // вывод ошибок
    private void dropError() {
        System.err.println("Не верный символ в позиции " + (pos + 1));
        System.exit(-1);
    }

    // Получение следующего символа
    private void getNextChar() {
        pos++;
        if (pos > text.length() - 1)
            currentChar = '\0';
        else
            currentChar = text.charAt(pos);
    }

    // Получение подряд идущих цифр
    private String integer() {
        String result = "";
        while (Character.isDigit(currentChar) && currentChar != '\0') {
            result += currentChar;
            getNextChar();
        }
        return result;
    }

    // Получение подряд идущих букв
    // Нужно для поиска названия переменных или зарезервированных слов
    private Token id() {
        String result = "";
        while (currentChar != '\0' && Character.isLetterOrDigit(currentChar)) {
            result += currentChar;
            getNextChar();
        }
        if (TokenTypes.contain(result))
            return TokenTypes.get(result);
        else
            return new Token(Types.ID, result);
    }

    // Получение следующего токена
    Token getNextToken() {
        while (currentChar != '\0') {
            // Пробелы пропускаем
            if (currentChar == ' ') {
                getNextChar();
                continue;
            } else if (Character.isLetter(currentChar)) {
                // Если это символ, парпсим подряд идущие символы
                return id();
            } else if (Character.isDigit(currentChar)) {
                // Если это число, парсим подряд идущие числа
                return new Token(Types.INT, integer());
            } else if (TokenTypes.contain(Character.toString(currentChar))) {
                // Если это единичный симовл, которому сопоставлен токен, возвращаем токен
                // Например, равно, умножение и т.п.
                Token tmp = TokenTypes.get(Character.toString(currentChar));
                getNextChar();
                return tmp;
            } else
                // Если ни один из всех вариантов не подходит, дропаем ошибку
                dropError();
        }
        // Когда все символы кончились, возврашаем исмовл конца строки
        return new Token(Types.EOF, "\0");
    }
}