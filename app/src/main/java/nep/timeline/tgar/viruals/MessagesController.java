package nep.timeline.tgar.viruals;

import android.util.SparseArray;

import de.robv.android.xposed.XposedHelpers;
import nep.timeline.tgar.Utils;
import nep.timeline.tgar.obfuscate.AutomationResolver;
import nep.timeline.tgar.utils.FieldUtils;
import nep.timeline.tgar.utils.MethodUtils;

public class MessagesController {
    private final Object instance;

    public MessagesController(Object instance)
    {
        this.instance = instance;
    }

    public TLRPC.Chat getChat(long chatId) {
        String getChatMethod = AutomationResolver.resolve("MessagesController", "getChat", AutomationResolver.ResolverType.Method);
        return new TLRPC.Chat(MethodUtils.invokeMethodOfClass(this.instance, getChatMethod, chatId));
    }

    public static MessagesController getInstance() {
        Class<?> messagesController = XposedHelpers.findClassIfExists(AutomationResolver.resolve("org.telegram.messenger.MessagesController"), Utils.globalLoadPackageParam.classLoader);
        String getInstanceMethod = AutomationResolver.resolve("MessagesController", "getInstance", AutomationResolver.ResolverType.Method);
        return new MessagesController(MethodUtils.invokeMethodOfClass(messagesController, getInstanceMethod, UserConfig.getSelectedAccount()));
    }

    public SparseArray<?> getDialogMessagesByIds()
    {
        String dialogMessagesByIdsField = AutomationResolver.resolve("MessagesController", "dialogMessagesByIds", AutomationResolver.ResolverType.Field);
        Object dialogMessagesByIdsUnchecked = FieldUtils.getFieldClassOfClass(this.instance, dialogMessagesByIdsField);
        if (dialogMessagesByIdsUnchecked instanceof SparseArray<?>)
            return (SparseArray<?>) FieldUtils.getFieldClassOfClass(this.instance, dialogMessagesByIdsField);
        return null;
    }
}
