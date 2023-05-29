package nep.timeline.tgar;

import java.util.HashMap;
import java.util.Map;

public class ObfuscateHelper {
    // Nekogram
    private static final Map<String, String> nekogramClass = new HashMap<>();
    private static final Map<String, String> nekogramMethod = new HashMap<>();

    // Nullgram
    private static final Map<String, String> nullgramClass = new HashMap<>();
    private static final Map<String, String> nullgramMethod = new HashMap<>();

    static {
        // Nekogram
        nekogramClass.put("org.telegram.messenger.MessageObject", "ac0");
        nekogramClass.put("org.telegram.tgnet.TLRPC$TL_updateDeleteMessages", "Ga1");
        nekogramClass.put("org.telegram.tgnet.TLRPC$TL_updateDeleteChannelMessages", "Fa1");
        nekogramMethod.put("isChatNoForwards", "i1");
        nekogramMethod.put("canForwardMessage", "n");

        // Nullgram
        nullgramClass.put("org.telegram.messenger.MessagesController", "kK0");
    }

    public static String resolveNekogramClass(String classPathAndName)
    {
        if (!nekogramClass.containsKey(classPathAndName))
            return classPathAndName;

        return nekogramClass.get(classPathAndName);
    }

    public static String resolveNekogramMethod(String methodName)
    {
        if (!nekogramMethod.containsKey(methodName))
            return methodName;

        return nekogramMethod.get(methodName);
    }

    public static String resolveNullgramClass(String classPathAndName)
    {
        if (!nullgramClass.containsKey(classPathAndName))
            return classPathAndName;

        return nullgramClass.get(classPathAndName);
    }

    public static String resolveNullgramMethod(String methodName)
    {
        if (!nullgramMethod.containsKey(methodName))
            return methodName;

        return nullgramMethod.get(methodName);
    }
}