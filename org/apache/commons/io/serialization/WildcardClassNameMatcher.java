/*    */ package org.apache.commons.io.serialization;
/*    */ 
/*    */ import org.apache.commons.io.FilenameUtils;
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
/*    */ 
/*    */ final class WildcardClassNameMatcher
/*    */   implements ClassNameMatcher
/*    */ {
/*    */   private final String pattern;
/*    */   
/*    */   public WildcardClassNameMatcher(String paramString) {
/* 40 */     this.pattern = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matches(String paramString) {
/* 45 */     return FilenameUtils.wildcardMatch(paramString, this.pattern);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\serialization\WildcardClassNameMatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */