/*    */ package org.junit.a.d;
/*    */ 
/*    */ import java.lang.reflect.Modifier;
/*    */ import java.util.ArrayList;
/*    */ import org.junit.f.a.j;
/*    */ import org.junit.f.h;
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
/*    */ public class a
/*    */   extends h
/*    */ {
/*    */   public a(Class<?> paramClass, j paramj) throws Throwable {
/* 31 */     super(paramj, paramClass, a(paramClass.getClasses()));
/*    */   }
/*    */   
/*    */   private static Class<?>[] a(Class<?>[] paramArrayOfClass) {
/* 35 */     ArrayList<Class<?>> arrayList = new ArrayList(paramArrayOfClass.length);
/*    */     
/* 37 */     for (Class<?> clazz : paramArrayOfClass) {
/* 38 */       if (!Modifier.isAbstract(clazz.getModifiers())) {
/* 39 */         arrayList.add(clazz);
/*    */       }
/*    */     } 
/*    */     
/* 43 */     return (Class[])arrayList.<Class<?>[]>toArray((Class<?>[][])new Class[arrayList.size()]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\d\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */