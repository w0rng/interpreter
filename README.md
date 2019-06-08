# Interpreter

## F.A.Q.
Q: Что это?  
A: Это моя курсовая работа. Простой интерпретатор. 

Q: Зачем это?  
A: Учусь делать инетерпретаторы. Ну и чтобы не исключили с вуза.  

Q: Какой язык интерпретирует сия чудо?  
A: Выдуманный, сиподобный язык.

## Описание языка
В кончном итоге интерпретатор должем уметь выполнять следующий код:
``` 
int main () {
    int x = 1;
    int y = 2;
    for (i: 1..10) {
        print(i, x);
        int tmp = x;
        x = y;
        y = tmp + y;
    }
}
```
Да, не много, но зато свое.

## Литература
1. [Let's Build a Compiler, by Jack Crenshaw](https://compilers.iecc.com/crenshaw/)
2. [Let’s Build A Simple Interpreter.](https://ruslanspivak.com/lsbasi-part1/)