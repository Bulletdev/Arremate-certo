/*    */ package com.sun.jna.platform.unix.aix;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ final class SharedObjectLoader
/*    */ {
/*    */   static Perfstat getPerfstatInstance() {
/* 45 */     Map<String, Object> map = getOptions();
/*    */     try {
/* 47 */       return (Perfstat)Native.load("/usr/lib/libperfstat.a(shr_64.o)", Perfstat.class, map);
/* 48 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*    */ 
/*    */       
/* 51 */       return (Perfstat)Native.load("/usr/lib/libperfstat.a(shr.o)", Perfstat.class, map);
/*    */     } 
/*    */   }
/*    */   private static Map<String, Object> getOptions() {
/* 55 */     int i = 262144;
/* 56 */     int j = 65536;
/* 57 */     byte b = 4;
/* 58 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 59 */     hashMap.put("open-flags", Integer.valueOf(i | j | b));
/* 60 */     return (Map)Collections.unmodifiableMap(hashMap);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platfor\\unix\aix\SharedObjectLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */