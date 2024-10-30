/*    */ package com.google.a.e;
/*    */ 
/*    */ import com.google.a.a.a;
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.a.d;
/*    */ import com.google.a.b.D;
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
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
/*    */ @a
/*    */ @b
/*    */ public final class b
/*    */ {
/*    */   private final char[][] b;
/*    */   
/*    */   public static b a(Map<Character, String> paramMap) {
/* 49 */     return new b(a(paramMap));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private b(char[][] paramArrayOfchar) {
/* 57 */     this.b = paramArrayOfchar;
/*    */   }
/*    */ 
/*    */   
/*    */   char[][] a() {
/* 62 */     return this.b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @d
/*    */   static char[][] a(Map<Character, String> paramMap) {
/* 70 */     D.checkNotNull(paramMap);
/* 71 */     if (paramMap.isEmpty()) {
/* 72 */       return c;
/*    */     }
/* 74 */     char c = ((Character)Collections.<Character>max(paramMap.keySet())).charValue();
/* 75 */     char[][] arrayOfChar = new char[c + 1][];
/* 76 */     for (Iterator<Character> iterator = paramMap.keySet().iterator(); iterator.hasNext(); ) { char c1 = ((Character)iterator.next()).charValue();
/* 77 */       arrayOfChar[c1] = ((String)paramMap.get(Character.valueOf(c1))).toCharArray(); }
/*    */     
/* 79 */     return arrayOfChar;
/*    */   }
/*    */ 
/*    */   
/* 83 */   private static final char[][] c = new char[0][0];
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\e\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */