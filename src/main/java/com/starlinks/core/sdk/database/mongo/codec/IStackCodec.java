package com.starlinks.core.sdk.database.mongo.codec;

import com.starlinks.core.sdk.StarGear;
import lombok.RequiredArgsConstructor;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
public final class IStackCodec implements Codec<ItemStack> {

    private final StarGear gear;

    @Override
    public ItemStack decode(BsonReader bsonReader, DecoderContext context) {
        final String serializedStack = bsonReader.readString();
        return gear.deserializeItemStack(serializedStack);
    }

    @Override
    public void encode(BsonWriter bsonWriter, ItemStack itemStack, EncoderContext encoderContext) {
        final String serializedStack = gear.serializeItemStack(itemStack);
        bsonWriter.writeString(serializedStack);
    }

    @Override
    public Class<ItemStack> getEncoderClass() {
        return ItemStack.class;
    }
}