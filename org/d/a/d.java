/*    */ package org.d.a;
/*    */ 
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import org.d.b;
/*    */ import org.d.g;
/*    */ import org.d.i;
/*    */ import org.d.k;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d<T>
/*    */   extends b<T>
/*    */ {
/*    */   private final String lM;
/*    */   private final k<T> b;
/*    */   private final Object[] values;
/* 22 */   private static final Pattern D = Pattern.compile("%([0-9]+)");
/*    */   
/*    */   public d(String paramString, k<T> paramk, Object[] paramArrayOfObject) {
/* 25 */     this.lM = paramString;
/* 26 */     this.b = paramk;
/* 27 */     this.values = (Object[])paramArrayOfObject.clone();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean E(Object paramObject) {
/* 32 */     return this.b.E(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(g paramg) {
/* 37 */     Matcher matcher = D.matcher(this.lM);
/*    */     
/* 39 */     int i = 0;
/* 40 */     while (matcher.find()) {
/* 41 */       paramg.a(this.lM.substring(i, matcher.start()));
/* 42 */       paramg.a(this.values[Integer.parseInt(matcher.group(1))]);
/* 43 */       i = matcher.end();
/*    */     } 
/*    */     
/* 46 */     if (i < this.lM.length()) {
/* 47 */       paramg.a(this.lM.substring(i));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(Object paramObject, g paramg) {
/* 53 */     this.b.a(paramObject, paramg);
/*    */   }
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
/*    */   @i
/*    */   public static <T> k<T> a(String paramString, k<T> paramk, Object... paramVarArgs) {
/* 72 */     return (k<T>)new d<T>(paramString, paramk, paramVarArgs);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */