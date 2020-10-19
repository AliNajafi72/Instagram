package ir.maktabsharif.bootstrap;
import ir.maktabsharif.controller.Controller;
import org.reflections.Reflections;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

public class SiteController {
    private static final String controllerPackageAddress = "ir.maktabsharif.controller";
    public void index(String url) {
        Reflections reflections = new Reflections(controllerPackageAddress);
        Set<Class<? extends Controller>> classes = reflections.getSubTypesOf(Controller.class);
        HashMap<String, Class<? extends Controller>> controllerHashMap = new HashMap<>();
        for (Class<? extends Controller> cls : classes) {
            controllerHashMap.put(cls.getSimpleName(), cls);
        }
        String[] urlArray = url.split("/");
        Class<? extends Controller> selectedClass = controllerHashMap.get(urlArray[0]);
        Method[] methods = selectedClass.getMethods();
        HashMap<String, Method> methodsHashMap = new HashMap<>();
        for (Method method : methods) {
            methodsHashMap.put(method.getName(), method);
        }
        Method selectedMethod = methodsHashMap.get(urlArray[1]);
        try {
            selectedMethod.invoke(selectedClass.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
