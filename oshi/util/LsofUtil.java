/*     */ package oshi.util;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class LsofUtil
/*     */ {
/*     */   public static Map<Integer, String> getCwdMap(int paramInt) {
/*  51 */     List<String> list = ExecutingCommand.runNative("lsof -F n -d cwd" + ((paramInt < 0) ? "" : (" -p " + paramInt)));
/*  52 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  53 */     Integer integer = Integer.valueOf(-1);
/*  54 */     for (String str : list) {
/*  55 */       if (str.isEmpty()) {
/*     */         continue;
/*     */       }
/*  58 */       switch (str.charAt(0)) {
/*     */         case 'p':
/*  60 */           integer = Integer.valueOf(ParseUtil.parseIntOrDefault(str.substring(1), -1));
/*     */         
/*     */         case 'n':
/*  63 */           hashMap.put(integer, str.substring(1));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  71 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getCwd(int paramInt) {
/*  82 */     List<String> list = ExecutingCommand.runNative("lsof -F n -d cwd -p " + paramInt);
/*  83 */     for (String str : list) {
/*  84 */       if (!str.isEmpty() && str.charAt(0) == 'n') {
/*  85 */         return str.substring(1).trim();
/*     */       }
/*     */     } 
/*  88 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getOpenFiles(int paramInt) {
/*  99 */     int i = ExecutingCommand.runNative("lsof -p " + paramInt).size();
/*     */     
/* 101 */     return (i > 0) ? (i - 1L) : 0L;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\LsofUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */