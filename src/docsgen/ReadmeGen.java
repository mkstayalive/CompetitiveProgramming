package docsgen;

import com.sun.javadoc.*;

import java.text.MessageFormat;

/**
 * @author Manish Singh
 */
public class ReadmeGen {
    public static boolean start(RootDoc root) {
        //iterate over all classes.
        ClassDoc[] classes = root.classes();
        for (int i=0; i< classes.length; i++) {
            //iterate over all methods and print their names.
            out("Methods");
            out("-------");
            MethodDoc[] methods = classes[i].methods();
            Tag[] tags = classes[i].tags();
            out("Class: " + classes[i].name());
            for (int k=0; k<tags.length; k++) {
                out("\tClass Tag " + tags[k].name() + " = " + tags[k].text());
            }
            out("\tMethods");
            out("\t-------");
            for (int j=0; j<methods.length; j++) {
                out("\tMethod: name = " + methods[j].name() + ": " + methods[j].commentText());
                tags = methods[j].tags();
                for (int k=0; k<tags.length; k++) {
                    out("\t\tMethod Tag " + tags[k].name() + " = " + tags[k].text());
                }
            }
            out("Fields");
            out("------");
            //iterate over all fields, printing name, comment text, and type.
            FieldDoc[] fields = classes[i].fields();
            for (int j=0; j<fields.length; j++) {
                Object[] field_info = {fields[j].name(), fields[j].commentText(),
                        fields[j].type()};
                out(FIELDINFO.format(field_info));
                //iterate over all field tags and print their values.
                tags = fields[j].tags();
                for (int k=0; k<tags.length; k++) {
                    out("\t\tField Tag " + tags[k].name() + " = " + tags[k].text());
                }
            }
        }
        //No error processing done, simply return true.
        return true;
    }
    private static void out(String msg) {
        System.out.println(msg);
    }
    private static MessageFormat METHODINFO =
            new MessageFormat("Method: return type {0}, name = {1};");
    private static MessageFormat FIELDINFO =
            new MessageFormat("Field: name = {0}, comment = {1}, type = {2};");

    public static void main(String[] args) {

    }
}
