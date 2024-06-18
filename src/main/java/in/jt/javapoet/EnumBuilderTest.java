package in.jt.javapoet;

import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

public class EnumBuilderTest {
    public static void main(String[] args) {
        TypeSpec gender = TypeSpec
                .enumBuilder("Gender")
                .addModifiers(Modifier.PUBLIC)
                .addEnumConstant("MALE")
                .addEnumConstant("FEMALE")
                .addEnumConstant("UNSPECIFIED")
                .build();

        System.out.println(gender);
    }
}
