/*    */ package org.apache.poi.util;
/*    */ 
/*    */ import java.util.Locale;
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
/*    */ public class JvmBugs
/*    */ {
/* 22 */   private static final POILogger LOG = POILogFactory.getLogger(JvmBugs.class);
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
/*    */   public static boolean hasLineBreakMeasurerBug() {
/* 46 */     String str1 = System.getProperty("java.version");
/* 47 */     String str2 = System.getProperty("os.name").toLowerCase(Locale.ROOT);
/* 48 */     boolean bool = Boolean.getBoolean("org.apache.poi.JvmBugs.LineBreakMeasurer.ignore");
/* 49 */     boolean bool1 = (!bool && str2.contains("win") && ("1.6.0_45".equals(str1) || "1.7.0_21".equals(str1))) ? true : false;
/* 50 */     if (bool1) {
/* 51 */       LOG.log(5, "JVM has LineBreakMeasurer bug - see POI bug #54904 - caller code might default to Lucida Sans");
/*    */     }
/* 53 */     return bool1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\JvmBugs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */