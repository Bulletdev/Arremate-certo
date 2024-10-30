/*    */ package oshi.driver.unix.freebsd.disk;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.ExecutingCommand;
/*    */ import oshi.util.ParseUtil;
/*    */ import oshi.util.tuples.Triplet;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class GeomDiskList
/*    */ {
/*    */   private static final String GEOM_DISK_LIST = "geom disk list";
/*    */   
/*    */   public static Map<String, Triplet<String, String, Long>> queryDisks() {
/* 55 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*    */     
/* 57 */     String str1 = null;
/* 58 */     String str2 = "unknown";
/* 59 */     String str3 = "unknown";
/* 60 */     long l = 0L;
/*    */     
/* 62 */     List list = ExecutingCommand.runNative("geom disk list");
/* 63 */     for (String str : list) {
/* 64 */       str = str.trim();
/*    */       
/* 66 */       if (str.startsWith("Geom name:")) {
/*    */         
/* 68 */         if (str1 != null) {
/* 69 */           hashMap.put(str1, new Triplet(str2, str3, Long.valueOf(l)));
/* 70 */           str2 = "unknown";
/* 71 */           str3 = "unknown";
/* 72 */           l = 0L;
/*    */         } 
/*    */         
/* 75 */         str1 = str.substring(str.lastIndexOf(' ') + 1);
/*    */       } 
/*    */       
/* 78 */       if (str1 != null) {
/* 79 */         str = str.trim();
/* 80 */         if (str.startsWith("Mediasize:")) {
/* 81 */           String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 82 */           if (arrayOfString.length > 1) {
/* 83 */             l = ParseUtil.parseLongOrDefault(arrayOfString[1], 0L);
/*    */           }
/*    */         } 
/* 86 */         if (str.startsWith("descr:")) {
/* 87 */           str2 = str.replace("descr:", "").trim();
/*    */         }
/* 89 */         if (str.startsWith("ident:")) {
/* 90 */           str3 = str.replace("ident:", "").replace("(null)", "").trim();
/*    */         }
/*    */       } 
/*    */     } 
/* 94 */     if (str1 != null) {
/* 95 */       hashMap.put(str1, new Triplet(str2, str3, Long.valueOf(l)));
/*    */     }
/* 97 */     return (Map)hashMap;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\freebsd\disk\GeomDiskList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */