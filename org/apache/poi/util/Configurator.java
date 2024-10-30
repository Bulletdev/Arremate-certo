/*    */ package org.apache.poi.util;
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
/*    */ public class Configurator
/*    */ {
/* 24 */   private static POILogger logger = POILogFactory.getLogger(Configurator.class);
/*    */   
/*    */   public static int getIntValue(String paramString, int paramInt) {
/* 27 */     int i = paramInt;
/* 28 */     String str = System.getProperty(paramString);
/*    */     try {
/* 30 */       i = Integer.parseInt(str);
/* 31 */     } catch (Exception exception) {
/* 32 */       logger.log(7, "System property -D" + paramString + " do not contains a valid integer " + str);
/*    */     } 
/* 34 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\Configurator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */