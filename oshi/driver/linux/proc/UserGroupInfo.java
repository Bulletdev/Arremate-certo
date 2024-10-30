/*     */ package oshi.driver.linux.proc;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
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
/*     */ public final class UserGroupInfo
/*     */ {
/*  46 */   private static final Supplier<Map<String, String>> usersIdMap = Memoizer.memoize(UserGroupInfo::getUserMap, TimeUnit.MINUTES
/*  47 */       .toNanos(1L));
/*  48 */   private static final Supplier<Map<String, String>> groupsIdMap = Memoizer.memoize(UserGroupInfo::getGroupMap, TimeUnit.MINUTES
/*  49 */       .toNanos(1L));
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
/*     */   public static String getUser(String paramString) {
/*  63 */     return (String)((Map)usersIdMap.get()).getOrDefault(paramString, "unknown");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getGroupName(String paramString) {
/*  74 */     return (String)((Map)groupsIdMap.get()).getOrDefault(paramString, "unknown");
/*     */   }
/*     */   
/*     */   private static Map<String, String> getUserMap() {
/*  78 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  79 */     List list = ExecutingCommand.runNative("getent passwd");
/*     */     
/*  81 */     for (String str : list) {
/*  82 */       String[] arrayOfString = str.split(":");
/*  83 */       if (arrayOfString.length > 2) {
/*  84 */         String str1 = arrayOfString[0];
/*  85 */         String str2 = arrayOfString[2];
/*     */ 
/*     */         
/*  88 */         hashMap.putIfAbsent(str2, str1);
/*     */       } 
/*     */     } 
/*  91 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private static Map<String, String> getGroupMap() {
/*  95 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  96 */     List list = ExecutingCommand.runNative("getent group");
/*     */     
/*  98 */     for (String str : list) {
/*  99 */       String[] arrayOfString = str.split(":");
/* 100 */       if (arrayOfString.length > 2) {
/* 101 */         String str1 = arrayOfString[0];
/* 102 */         String str2 = arrayOfString[2];
/* 103 */         hashMap.putIfAbsent(str2, str1);
/*     */       } 
/*     */     } 
/* 106 */     return (Map)hashMap;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\linux\proc\UserGroupInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */