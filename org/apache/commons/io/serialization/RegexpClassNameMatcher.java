/*    */ package org.apache.commons.io.serialization;
/*    */ 
/*    */ import java.util.regex.Pattern;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class RegexpClassNameMatcher
/*    */   implements ClassNameMatcher
/*    */ {
/*    */   private final Pattern pattern;
/*    */   
/*    */   public RegexpClassNameMatcher(String paramString) {
/* 39 */     this(Pattern.compile(paramString));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RegexpClassNameMatcher(Pattern paramPattern) {
/* 49 */     if (paramPattern == null) {
/* 50 */       throw new IllegalArgumentException("Null pattern");
/*    */     }
/* 52 */     this.pattern = paramPattern;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matches(String paramString) {
/* 57 */     return this.pattern.matcher(paramString).matches();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\serialization\RegexpClassNameMatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */