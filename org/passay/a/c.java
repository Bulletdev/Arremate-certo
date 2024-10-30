/*    */ package org.passay.a;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import org.passay.D;
/*    */ import org.passay.e;
/*    */ import org.passay.g;
/*    */ import org.passay.x;
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
/*    */ public final class c
/*    */ {
/*    */   public static b a(List<? extends D> paramList, x paramx) {
/* 40 */     if (!paramx.a().equals(x.c.c)) {
/* 41 */       throw new IllegalArgumentException("Password data must have an origin of " + x.c.c);
/*    */     }
/* 43 */     HashSet hashSet = new HashSet();
/* 44 */     paramList.stream().forEach(paramD -> {
/*    */           if (paramD instanceof e) {
/*    */             e e = (e)paramD;
/*    */             
/*    */             e.getRules().forEach(());
/*    */           } else if (paramD instanceof g) {
/*    */             g g = (g)paramD;
/*    */             paramSet.addAll(a(g.ff()));
/*    */           } else if (paramD instanceof org.passay.c) {
/*    */             org.passay.c c1 = (org.passay.c)paramD;
/*    */             paramSet.addAll(a(String.valueOf(c1.e())));
/*    */           } 
/*    */         });
/* 57 */     if (hashSet.isEmpty()) {
/* 58 */       throw new IllegalArgumentException("Password rules must contain at least 1 unique character by CharacterRule definition");
/*    */     }
/*    */     
/* 61 */     return new b(hashSet.size(), paramx.getPassword().length());
/*    */   }
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
/*    */   private static Set<Character> a(String paramString) {
/* 74 */     HashSet<Character> hashSet = new HashSet();
/* 75 */     if (paramString != null) {
/* 76 */       for (char c1 : paramString.toCharArray()) {
/* 77 */         hashSet.add(Character.valueOf(c1));
/*    */       }
/*    */     }
/* 80 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */