/*    */ package org.junit.c.e.b;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ import org.junit.f.a.c;
/*    */ 
/*    */ class b
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 3176511008672645574L;
/*    */   
/*    */   public b(c<?> paramc, Class<? extends Annotation> paramClass, String paramString) {
/* 12 */     super(String.format("The @%s '%s' %s", new Object[] { paramClass.getSimpleName(), paramc.getName(), paramString }));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\b\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */