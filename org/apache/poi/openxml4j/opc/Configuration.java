/*    */ package org.apache.poi.openxml4j.opc;
/*    */ 
/*    */ import java.io.File;
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
/*    */ public final class Configuration
/*    */ {
/* 33 */   private static String pathForXmlSchema = System.getProperty("user.dir") + File.separator + "src" + File.separator + "schemas";
/*    */ 
/*    */   
/*    */   public static String getPathForXmlSchema() {
/* 37 */     return pathForXmlSchema;
/*    */   }
/*    */   
/*    */   public static void setPathForXmlSchema(String paramString) {
/* 41 */     pathForXmlSchema = paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */