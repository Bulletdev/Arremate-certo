/*    */ package org.apache.poi;
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
/*    */ public class Version
/*    */ {
/*    */   private static final String VERSION_STRING = "3.15";
/*    */   private static final String RELEASE_DATE = "20160924";
/*    */   
/*    */   public static String getVersion() {
/* 37 */     return "3.15";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getReleaseDate() {
/* 44 */     return "20160924";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getProduct() {
/* 51 */     return "POI";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getImplementationLanguage() {
/* 57 */     return "Java";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] paramArrayOfString) {
/* 64 */     System.out.println("Apache " + getProduct() + " " + getVersion() + " (" + getReleaseDate() + ")");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */