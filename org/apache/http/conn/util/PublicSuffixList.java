/*    */ package org.apache.http.conn.util;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.util.Args;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public final class PublicSuffixList
/*    */ {
/*    */   private final DomainType type;
/*    */   private final List<String> rules;
/*    */   private final List<String> exceptions;
/*    */   
/*    */   public PublicSuffixList(DomainType paramDomainType, List<String> paramList1, List<String> paramList2) {
/* 56 */     this.type = (DomainType)Args.notNull(paramDomainType, "Domain type");
/* 57 */     this.rules = Collections.unmodifiableList((List<? extends String>)Args.notNull(paramList1, "Domain suffix rules"));
/* 58 */     this.exceptions = Collections.unmodifiableList((paramList2 != null) ? paramList2 : Collections.<String>emptyList());
/*    */   }
/*    */   
/*    */   public PublicSuffixList(List<String> paramList1, List<String> paramList2) {
/* 62 */     this(DomainType.UNKNOWN, paramList1, paramList2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DomainType getType() {
/* 69 */     return this.type;
/*    */   }
/*    */   
/*    */   public List<String> getRules() {
/* 73 */     return this.rules;
/*    */   }
/*    */   
/*    */   public List<String> getExceptions() {
/* 77 */     return this.exceptions;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\con\\util\PublicSuffixList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */