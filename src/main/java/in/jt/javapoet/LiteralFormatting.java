package in.jt.javapoet;

import com.squareup.javapoet.MethodSpec;

public class LiteralFormatting {
    public static void main(String[] args) {
        MethodSpec method = generateSumMethod("sumOfOneHundred", 0, 100, "+");
        System.out.println(method);
    }

    private static MethodSpec generateSumMethod(String name, int from, int to, String operator) {
        return MethodSpec
                .methodBuilder(name)
                .returns(int.class)
                .addStatement("int sum = 0")
                .beginControlFlow("for (int i = $L; i <= $L; i++)", from, to)
                .addStatement("sum = sum $L i", operator)
                .endControlFlow()
                .addStatement("return sum")
                .build();
    }
}
