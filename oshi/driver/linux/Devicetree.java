/*    */ package oshi.driver.linux;
/*    */ 
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.FileUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class Devicetree
/*    */ {
/*    */   public static String queryModel() {
/* 44 */     String str = FileUtil.getStringFromFile("/sys/firmware/devicetree/base/model");
/* 45 */     if (!str.isEmpty()) {
/* 46 */       return str.replace("Machine: ", "");
/*    */     }
/* 48 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\linux\Devicetree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */