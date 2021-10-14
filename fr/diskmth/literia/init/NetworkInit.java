/*    */ package fr.diskmth.literia.init;
/*    */ 
/*    */ import fr.diskmth.literia.network.CancelIsBlockingPacket;
/*    */ import fr.diskmth.literia.network.SetIsBlockingPacket;
/*    */ import net.minecraftforge.fml.common.network.NetworkRegistry;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NetworkInit
/*    */ {
/*    */   public static SimpleNetworkWrapper NETWORK;
/*    */   
/*    */   public static void registerNetwork() {
/* 16 */     NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel("literiamod");
/*    */     
/* 18 */     NETWORK.registerMessage(SetIsBlockingPacket.Handler.class, SetIsBlockingPacket.class, 0, Side.SERVER);
/* 19 */     NETWORK.registerMessage(CancelIsBlockingPacket.Handler.class, CancelIsBlockingPacket.class, 1, Side.SERVER);
/*    */   }
/*    */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\init\NetworkInit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */