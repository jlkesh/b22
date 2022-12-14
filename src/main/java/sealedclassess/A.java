package sealedclassess;

public sealed class A permits B, C {}

final class B extends A {}

sealed class C extends A permits D, E {}

final class D extends C {

}

non-sealed class E extends C {

}

class F extends E {

}

