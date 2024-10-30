/*    */ package javax.annotation;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ import java.lang.annotation.Documented;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ import java.util.regex.Pattern;
/*    */ import java.util.regex.PatternSyntaxException;
/*    */ import javax.annotation.b.e;
/*    */ import javax.annotation.b.f;
/*    */ import javax.annotation.b.g;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Documented
/*    */ @o("RegEx")
/*    */ @Retention(RetentionPolicy.RUNTIME)
/*    */ @e
/*    */ public @interface m
/*    */ {
/*    */   g a() default g.ALWAYS;
/*    */   
/*    */   public static class a
/*    */     implements f<m>
/*    */   {
/*    */     public g a(m param1m, Object param1Object) {
/* 29 */       if (!(param1Object instanceof String)) {
/* 30 */         return g.d;
/*    */       }
/*    */       try {
/* 33 */         Pattern.compile((String)param1Object);
/* 34 */       } catch (PatternSyntaxException patternSyntaxException) {
/* 35 */         return g.d;
/*    */       } 
/* 37 */       return g.a;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\javax\annotation\m.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */