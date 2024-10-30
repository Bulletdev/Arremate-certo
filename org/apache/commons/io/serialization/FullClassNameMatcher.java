/*    */ package org.apache.commons.io.serialization;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
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
/*    */ final class FullClassNameMatcher
/*    */   implements ClassNameMatcher
/*    */ {
/*    */   private final Set<String> classesSet;
/*    */   
/*    */   public FullClassNameMatcher(String... paramVarArgs) {
/* 42 */     this.classesSet = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(paramVarArgs)));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matches(String paramString) {
/* 47 */     return this.classesSet.contains(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\serialization\FullClassNameMatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */