/*    */ package oshi.driver.unix;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.ExecutingCommand;
/*    */ import oshi.util.ParseUtil;
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
/*    */ public final class Xrandr
/*    */ {
/* 40 */   private static final String[] XRANDR_VERBOSE = new String[] { "xrandr", "--verbose" };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static List<byte[]> getEdidArrays() {
/* 47 */     List list = ExecutingCommand.runNative(XRANDR_VERBOSE, null);
/*    */ 
/*    */     
/* 50 */     if (list.isEmpty()) {
/* 51 */       return (List)Collections.emptyList();
/*    */     }
/* 53 */     ArrayList<byte[]> arrayList = new ArrayList();
/* 54 */     StringBuilder stringBuilder = null;
/* 55 */     for (String str : list) {
/* 56 */       if (str.contains("EDID")) {
/* 57 */         stringBuilder = new StringBuilder(); continue;
/* 58 */       }  if (stringBuilder != null) {
/* 59 */         stringBuilder.append(str.trim());
/* 60 */         if (stringBuilder.length() < 256) {
/*    */           continue;
/*    */         }
/* 63 */         String str1 = stringBuilder.toString();
/* 64 */         byte[] arrayOfByte = ParseUtil.hexStringToByteArray(str1);
/* 65 */         if (arrayOfByte.length >= 128) {
/* 66 */           arrayList.add(arrayOfByte);
/*    */         }
/* 68 */         stringBuilder = null;
/*    */       } 
/*    */     } 
/* 71 */     return (List<byte[]>)arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\Xrandr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */