package fr.diskmth.literia.network;

import fr.diskmth.literia.utils.handlers.EventHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CancelIsBlockingPacket implements IMessage {
   private String isBlocking;

   public CancelIsBlockingPacket() {
   }

   public CancelIsBlockingPacket(String text) {
      this.isBlocking = text;
   }

   public void fromBytes(ByteBuf buf) {
      this.isBlocking = ByteBufUtils.readUTF8String(buf);
   }

   public void toBytes(ByteBuf buf) {
      ByteBufUtils.writeUTF8String(buf, this.isBlocking);
   }

   public static class Handler implements IMessageHandler {
      public IMessage onMessage(CancelIsBlockingPacket message, MessageContext ctx) {
         EventHandler.isBlocking = false;
         return null;
      }
   }
}
