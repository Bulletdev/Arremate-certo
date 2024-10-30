/*    */ package org.junit.c;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.Arrays;
/*    */ import java.util.Comparator;
/*    */ import org.junit.j;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class i
/*    */ {
/* 13 */   public static final Comparator<Method> j = new Comparator<Method>() {
/*    */       public int compare(Method param1Method1, Method param1Method2) {
/* 15 */         int i = param1Method1.getName().hashCode();
/* 16 */         int j = param1Method2.getName().hashCode();
/* 17 */         if (i != j) {
/* 18 */           return (i < j) ? -1 : 1;
/*    */         }
/* 20 */         return i.k.compare(param1Method1, param1Method2);
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 27 */   public static final Comparator<Method> k = new Comparator<Method>() {
/*    */       public int compare(Method param1Method1, Method param1Method2) {
/* 29 */         int i = param1Method1.getName().compareTo(param1Method2.getName());
/* 30 */         if (i != 0) {
/* 31 */           return i;
/*    */         }
/* 33 */         return param1Method1.toString().compareTo(param1Method2.toString());
/*    */       }
/*    */     };
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
/*    */   public static Method[] a(Class<?> paramClass) {
/* 52 */     Comparator<Method> comparator = a(paramClass.<j>getAnnotation(j.class));
/*    */     
/* 54 */     Method[] arrayOfMethod = paramClass.getDeclaredMethods();
/* 55 */     if (comparator != null) {
/* 56 */       Arrays.sort(arrayOfMethod, comparator);
/*    */     }
/*    */     
/* 59 */     return arrayOfMethod;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static Comparator<Method> a(j paramj) {
/* 66 */     if (paramj == null) {
/* 67 */       return j;
/*    */     }
/*    */     
/* 70 */     return paramj.a().getComparator();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */