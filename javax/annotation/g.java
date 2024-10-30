/*    */ package javax.annotation;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ import java.lang.annotation.Documented;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ import javax.annotation.b.c;
/*    */ import javax.annotation.b.f;
/*    */ import javax.annotation.b.g;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Documented
/*    */ @c
/*    */ @Retention(RetentionPolicy.RUNTIME)
/*    */ public @interface g
/*    */ {
/*    */   g a() default g.ALWAYS;
/*    */   
/*    */   public static class a
/*    */     implements f<g>
/*    */   {
/*    */     public g a(g param1g, Object param1Object) {
/* 27 */       if (param1Object == null)
/* 28 */         return g.d; 
/* 29 */       return g.a;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\javax\annotation\g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */