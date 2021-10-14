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
/*    */ public class CancelIsBlockingPacket
/*    */   implements IMessage
/*    */ {
/*    */   private String isBlocking;
/*    */   
/*    */   public CancelIsBlockingPacket() {}
/*    */   
/*    */   public CancelIsBlockingPacket(String text) {
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
/*    */     implements IMessageHandler<CancelIsBlockingPacket, IMessage>
/*    */   {
/*    */     public IMessage onMessage(CancelIsBlockingPacket message, MessageContext ctx) {
/* 40 */       EventHandler.isBlocking = false;
/* 41 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\network\CancelIsBlockingPacket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */