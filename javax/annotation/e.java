/*    */ package javax.annotation;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ import java.lang.annotation.Documented;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ import java.util.regex.Pattern;
/*    */ import javax.annotation.b.c;
/*    */ import javax.annotation.b.f;
/*    */ import javax.annotation.b.g;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Documented
/*    */ @c(e = String.class)
/*    */ @Retention(RetentionPolicy.RUNTIME)
/*    */ public @interface e
/*    */ {
/*    */   @m
/*    */   String value();
/*    */   
/*    */   int ac() default 0;
/*    */   
/*    */   public static class a
/*    */     implements f<e>
/*    */   {
/*    */     public g a(e param1e, Object param1Object) {
/* 28 */       Pattern pattern = Pattern.compile(param1e.value(), param1e.ac());
/* 29 */       if (pattern.matcher((String)param1Object).matches())
/* 30 */         return g.a; 
/* 31 */       return g.d;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\javax\annotation\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */