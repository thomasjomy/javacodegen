package in.jt.javaassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.ClassFile;
import javassist.bytecode.DuplicateMemberException;
import javassist.bytecode.FieldInfo;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaAssistTest {
    private static final String BASE_PATH = ".";

    public static void main(String[] args) throws NotFoundException, CannotCompileException {
        ClassPool classPool = ClassPool.getDefault();
        String classPathIncorrect = BASE_PATH + "/target/classes";
        classPool.insertClassPath(classPathIncorrect);

        ClassFile cf = ClassPool.getDefault()
                .get("in.jt.javaassist.Point")
                .getClassFile();

        FieldInfo f = new FieldInfo(cf.getConstPool(), "id", "I");
        f.setAccessFlags(AccessFlag.PUBLIC);
        cf.addField(f);

        Field[] fields = classPool
                .makeClass(cf)
                .toClass()
                .getFields();

        List<String> fieldsList = Stream.of(fields)
                .map(Field::getName)
                .collect(Collectors.toList());

        System.out.println(fieldsList);


    }
}
