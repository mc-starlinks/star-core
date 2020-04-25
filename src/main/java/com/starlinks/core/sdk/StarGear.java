package com.starlinks.core.sdk;

import lombok.SneakyThrows;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public final class StarGear {

    public String colourText(String text) {
        return text.replace("&", "§");
    }

    @SneakyThrows
    public String serializeItemStack(ItemStack itemStack) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);

        dataOutput.writeObject(itemStack);

        final byte[] bytes = outputStream.toByteArray();

        dataOutput.close();
        outputStream.close();

        return Base64Coder.encodeLines(bytes);
    }

    @SneakyThrows
    public ItemStack deserializeItemStack(String base) {
        final byte[] data = Base64Coder.decodeLines(base);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        BukkitObjectInputStream objectInputStream = new BukkitObjectInputStream(inputStream);

        final ItemStack itemStack = (ItemStack) objectInputStream.readObject();

        objectInputStream.close();
        inputStream.close();

        return itemStack;
    }
}