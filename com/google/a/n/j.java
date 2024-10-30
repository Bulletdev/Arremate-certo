/*    */ package com.google.a.n;
/*    */ 
/*    */ import com.google.a.a.a;
/*    */ import com.google.a.b.D;
/*    */ import java.lang.reflect.Type;
/*    */ import java.lang.reflect.TypeVariable;
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
/*    */ public abstract class j<T>
/*    */   extends i<T>
/*    */ {
/*    */   final TypeVariable<?> a;
/*    */   
/*    */   protected j() {
/* 43 */     Type type = b();
/* 44 */     D.a(type instanceof TypeVariable, "%s should be a type variable.", type);
/* 45 */     this.a = (TypeVariable)type;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 50 */     return this.a.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 55 */     if (paramObject instanceof j) {
/* 56 */       j j1 = (j)paramObject;
/* 57 */       return this.a.equals(j1.a);
/*    */     } 
/* 59 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 64 */     return this.a.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */