/*    */ package com.google.a.g;
/*    */ 
/*    */ import com.google.a.a.a;
/*    */ import java.util.Set;
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
/*    */ public abstract class c<N>
/*    */   extends a<N>
/*    */   implements s<N>
/*    */ {
/*    */   public final boolean equals(Object paramObject) {
/* 35 */     if (paramObject == this) {
/* 36 */       return true;
/*    */     }
/* 38 */     if (!(paramObject instanceof s)) {
/* 39 */       return false;
/*    */     }
/* 41 */     s s1 = (s)paramObject;
/*    */     
/* 43 */     return (cX() == s1.cX() && 
/* 44 */       A().equals(s1.A()) && 
/* 45 */       v().equals(s1.v()));
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 50 */     return v().hashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 57 */     boolean bool1 = cX();
/*    */     
/* 59 */     boolean bool2 = cY();
/*    */     
/* 61 */     String str1 = String.valueOf(A());
/*    */     
/* 63 */     String str2 = String.valueOf(v()); return (new StringBuilder(59 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("isDirected: ").append(bool1).append(", allowsSelfLoops: ").append(bool2).append(", nodes: ").append(str1).append(", edges: ").append(str2).toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */