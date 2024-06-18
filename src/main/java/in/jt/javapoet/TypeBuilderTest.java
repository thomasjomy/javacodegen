package in.jt.javapoet;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

public class TypeBuilderTest {
    public static void main(String[] args) {

        FieldSpec name = FieldSpec
                .builder(String.class, "name")
                .addModifiers(Modifier.PRIVATE)
                .build();

        CodeBlock sumOfTenImpl = CodeBlock
                .builder()
                .addStatement("int sum = 0")
                .beginControlFlow("for (int i = 0; i <= 10; i++)")
                .addStatement("sum += i")
                .endControlFlow()
                .build();

        MethodSpec sumOfTen = MethodSpec
                .methodBuilder("sumOfTen")
                .addCode(sumOfTenImpl)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .build();

        TypeSpec person = TypeSpec
                .classBuilder("Person")
                .addModifiers(Modifier.PUBLIC)
                .addField(name)
                .addMethod(MethodSpec
                        .methodBuilder("getName")
                        .addAnnotation(Override.class)
                        .addModifiers(Modifier.PUBLIC)
                        .returns(String.class)
                        .addStatement("return this.name")
                        .build())
                .addMethod(MethodSpec
                        .methodBuilder("setName")
                        .addParameter(String.class, "name")
                        .addModifiers(Modifier.PUBLIC)
                        .returns(String.class)
                        .addStatement("this.name = name")
                        .build())
                .addMethod(sumOfTen)
                .build();
    }
}
