package fr.nomapech.literia.network;

import fr.nomapech.literia.utils.handlers.EventHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SetIsBlockingPacket implements IMessage {
   private String isBlocking;

   public SetIsBlockingPacket() {
   }

   public SetIsBlockingPacket(String text) {
      this.isBlocking = text;
   }

   public void fromBytes(ByteBuf buf) {
      this.isBlocking = ByteBufUtils.readUTF8String(buf);
   }

   public void toBytes(ByteBuf buf) {
      ByteBufUtils.writeUTF8String(buf, this.isBlocking);
   }

   public static class Handler implements IMessageHandler {
      public IMessage onMessage(SetIsBlockingPacket message, MessageContext ctx) {
         EventHandler.isBlocking = true;
         return null;
      }

      @Override
      public IMessage onMessage(IMessage message, MessageContext ctx) {
         return null;
        }
      }
   }