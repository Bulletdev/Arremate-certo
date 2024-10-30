/*    */ package org.junit.a.e.a;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class e
/*    */   extends AssertionError {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public e(Throwable paramThrowable, String paramString, Object... paramVarArgs) {
/* 12 */     super(String.format("%s(%s)", new Object[] { paramString, join(", ", paramVarArgs) }));
/* 13 */     initCause(paramThrowable);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 18 */     return (paramObject instanceof e && toString().equals(paramObject.toString()));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 23 */     return toString().hashCode();
/*    */   }
/*    */   
/*    */   public static String join(String paramString, Object... paramVarArgs) {
/* 27 */     return a(paramString, Arrays.asList(paramVarArgs));
/*    */   }
/*    */   
/*    */   public static String a(String paramString, Collection<Object> paramCollection) {
/* 31 */     StringBuilder stringBuilder = new StringBuilder();
/* 32 */     Iterator<Object> iterator = paramCollection.iterator();
/* 33 */     while (iterator.hasNext()) {
/* 34 */       Object object = iterator.next();
/* 35 */       stringBuilder.append(n(object));
/* 36 */       if (iterator.hasNext()) {
/* 37 */         stringBuilder.append(paramString);
/*    */       }
/*    */     } 
/* 40 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   private static String n(Object paramObject) {
/*    */     try {
/* 45 */       return String.valueOf(paramObject);
/* 46 */     } catch (Throwable throwable) {
/* 47 */       return "[toString failed]";
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\e\a\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */