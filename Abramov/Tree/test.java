package Abramov.Tree;

class Test {

}

class Test2 extends Test {
    int value = 0;
}

class main {

    Test gen() {
        return new Test();
    }

    void test() {
        Test test = gen();
        test = new Test();
    }
}