package in.jt.javapoet;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

public class InterfaceBuilderTest {
    public static void main(String[] args) {
        FieldSpec defaultName = FieldSpec
                .builder(String.class, "DEFAULT_NAME")
                .addModifiers(Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                .initializer("\"Alice\"")
                .build();
        
        TypeSpec person = TypeSpec
                .interfaceBuilder("Person")
                .addModifiers(Modifier.PUBLIC)
                .addField(defaultName)
                .addMethod(MethodSpec
                        .methodBuilder("getName")
                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                        .build())
                .addMethod(MethodSpec
                        .methodBuilder("getDefaultName")
                        .addModifiers(Modifier.PUBLIC, Modifier.DEFAULT)
                        .addCode(CodeBlock
                                .builder()
                                .addStatement("return DEFAULT_NAME")
                                .build())
                        .build())
                .build();
    }
}
