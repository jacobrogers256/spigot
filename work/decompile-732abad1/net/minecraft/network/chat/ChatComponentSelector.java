package net.minecraft.network.chat;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.logging.LogUtils;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.commands.CommandListenerWrapper;
import net.minecraft.commands.arguments.selector.ArgumentParserSelector;
import net.minecraft.commands.arguments.selector.EntitySelector;
import net.minecraft.world.entity.Entity;
import org.slf4j.Logger;

public class ChatComponentSelector extends ChatBaseComponent implements ChatComponentContextual {

    private static final Logger LOGGER = LogUtils.getLogger();
    private final String pattern;
    @Nullable
    private final EntitySelector selector;
    protected final Optional<IChatBaseComponent> separator;

    public ChatComponentSelector(String s, Optional<IChatBaseComponent> optional) {
        this.pattern = s;
        this.separator = optional;
        EntitySelector entityselector = null;

        try {
            ArgumentParserSelector argumentparserselector = new ArgumentParserSelector(new StringReader(s));

            entityselector = argumentparserselector.parse();
        } catch (CommandSyntaxException commandsyntaxexception) {
            ChatComponentSelector.LOGGER.warn("Invalid selector component: {}: {}", s, commandsyntaxexception.getMessage());
        }

        this.selector = entityselector;
    }

    public String getPattern() {
        return this.pattern;
    }

    @Nullable
    public EntitySelector getSelector() {
        return this.selector;
    }

    public Optional<IChatBaseComponent> getSeparator() {
        return this.separator;
    }

    @Override
    public IChatMutableComponent resolve(@Nullable CommandListenerWrapper commandlistenerwrapper, @Nullable Entity entity, int i) throws CommandSyntaxException {
        if (commandlistenerwrapper != null && this.selector != null) {
            Optional<? extends IChatBaseComponent> optional = ChatComponentUtils.updateForEntity(commandlistenerwrapper, this.separator, entity, i);

            return ChatComponentUtils.formatList(this.selector.findEntities(commandlistenerwrapper), optional, Entity::getDisplayName);
        } else {
            return new ChatComponentText("");
        }
    }

    @Override
    public String getContents() {
        return this.pattern;
    }

    @Override
    public ChatComponentSelector plainCopy() {
        return new ChatComponentSelector(this.pattern, this.separator);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof ChatComponentSelector)) {
            return false;
        } else {
            ChatComponentSelector chatcomponentselector = (ChatComponentSelector) object;

            return this.pattern.equals(chatcomponentselector.pattern) && super.equals(object);
        }
    }

    @Override
    public String toString() {
        return "SelectorComponent{pattern='" + this.pattern + "', siblings=" + this.siblings + ", style=" + this.getStyle() + "}";
    }
}
