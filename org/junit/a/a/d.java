/*    */ package org.junit.a.a;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import org.junit.a;
/*    */ import org.junit.b;
/*    */ import org.junit.f;
/*    */ import org.junit.g;
/*    */ import org.junit.g.a;
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
/*    */ public final class d
/*    */   extends a
/*    */ {
/* 30 */   private static final Set<Class<? extends Annotation>> K = Collections.unmodifiableSet(new HashSet<Class<? extends Annotation>>(Arrays.asList((Class<? extends Annotation>[])new Class[] { g.class, b.class, f.class, a.class })));
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
/*    */   public List<Exception> a(org.junit.f.a.d paramd) {
/* 45 */     ArrayList<Exception> arrayList = new ArrayList();
/* 46 */     Annotation[] arrayOfAnnotation = paramd.getAnnotations();
/* 47 */     for (Annotation annotation : arrayOfAnnotation) {
/* 48 */       for (Class<?> clazz : K) {
/* 49 */         if (annotation.annotationType().isAssignableFrom(clazz)) {
/* 50 */           a(arrayList, clazz);
/*    */         }
/*    */       } 
/*    */     } 
/* 54 */     return Collections.unmodifiableList(arrayList);
/*    */   }
/*    */   
/*    */   private void a(List<Exception> paramList, Class<?> paramClass) {
/* 58 */     String str = String.format("@%s can not be combined with @Category", new Object[] { paramClass.getSimpleName() });
/*    */     
/* 60 */     paramList.add(new Exception(str));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\a\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */