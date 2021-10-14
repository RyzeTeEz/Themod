/*    */ package fr.diskmth.literia.network;
/*    */ 
/*    */ import fr.diskmth.literia.utils.handlers.EventHandler;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SetIsBlockingPacket
/*    */   implements IMessage
/*    */ {
/*    */   private String isBlocking;
/*    */   
/*    */   public SetIsBlockingPacket() {}
/*    */   
/*    */   public SetIsBlockingPacket(String text) {
/* 20 */     this.isBlocking = text;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 26 */     this.isBlocking = ByteBufUtils.readUTF8String(buf);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 32 */     ByteBufUtils.writeUTF8String(buf, this.isBlocking);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<SetIsBlockingPacket, IMessage>
/*    */   {
/*    */     public IMessage onMessage(SetIsBlockingPacket message, MessageContext ctx) {
/* 40 */       EventHandler.isBlocking = true;
/* 41 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\network\SetIsBlockingPacket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */