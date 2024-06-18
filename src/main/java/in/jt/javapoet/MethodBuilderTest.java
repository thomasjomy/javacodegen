package in.jt.javapoet;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;

public class MethodBuilderTest {

    public static void main(String[] args) {
        MethodSpec sumOfTen = MethodSpec
                .methodBuilder("sumOfTen")
                .addStatement("int sum = 0")
                .beginControlFlow("for (int i = 0; i <= 10; i++)")
                .addStatement("sum += i")
                .endControlFlow()
                .build();

        CodeBlock sumOfTenImpl = CodeBlock
                .builder()
                .addStatement("int sum = 0")
                .beginControlFlow("for (int i = 0; i <= 10; i++)")
                .addStatement("sum += i")
                .endControlFlow()
                .build();

        MethodSpec sumOfTen2 = MethodSpec
                .methodBuilder("sumOfTen")
                .addCode(sumOfTenImpl)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .build();

        FieldSpec name = FieldSpec
                .builder(String.class, "name")
                .addModifiers(Modifier.PRIVATE)
                .build();



    }
}
