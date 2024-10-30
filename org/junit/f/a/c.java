/*    */ package org.junit.f.a;
/*    */ 
/*    */ import java.lang.reflect.Modifier;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class c<T extends c<T>>
/*    */   implements a
/*    */ {
/*    */   abstract boolean h(T paramT);
/*    */   
/*    */   T a(List<T> paramList) {
/* 16 */     for (int i = paramList.size() - 1; i >= 0; i--) {
/* 17 */       c c1 = (c)paramList.get(i);
/* 18 */       if (h((T)c1)) {
/* 19 */         if (c1.gy()) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 25 */           paramList.remove(i);
/* 26 */           return (T)c1;
/*    */         } 
/*    */         
/* 29 */         return null;
/*    */       } 
/*    */     } 
/*    */     
/* 33 */     return (T)this;
/*    */   }
/*    */ 
/*    */   
/*    */   abstract boolean gy();
/*    */ 
/*    */   
/*    */   protected abstract int getModifiers();
/*    */ 
/*    */   
/*    */   public boolean isStatic() {
/* 44 */     return Modifier.isStatic(getModifiers());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isPublic() {
/* 51 */     return Modifier.isPublic(getModifiers());
/*    */   }
/*    */   
/*    */   public abstract String getName();
/*    */   
/*    */   public abstract Class<?> getType();
/*    */   
/*    */   public abstract Class<?> getDeclaringClass();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\a\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */