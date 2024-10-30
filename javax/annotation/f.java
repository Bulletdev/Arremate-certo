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
/*    */ @Documented
/*    */ @c(e = Number.class)
/*    */ @Retention(RetentionPolicy.RUNTIME)
/*    */ public @interface f
/*    */ {
/*    */   g a() default g.ALWAYS;
/*    */   
/*    */   public static class a
/*    */     implements f<f>
/*    */   {
/*    */     public g a(f param1f, Object param1Object) {
/*    */       boolean bool;
/* 25 */       if (!(param1Object instanceof Number)) {
/* 26 */         return g.d;
/*    */       }
/* 28 */       Number number = (Number)param1Object;
/* 29 */       if (number instanceof Long) {
/* 30 */         bool = (number.longValue() < 0L) ? true : false;
/* 31 */       } else if (number instanceof Double) {
/* 32 */         bool = (number.doubleValue() < 0.0D) ? true : false;
/* 33 */       } else if (number instanceof Float) {
/* 34 */         bool = (number.floatValue() < 0.0F) ? true : false;
/*    */       } else {
/* 36 */         bool = (number.intValue() < 0) ? true : false;
/*    */       } 
/* 38 */       if (bool) {
/* 39 */         return g.d;
/*    */       }
/* 41 */       return g.a;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\javax\annotation\f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */