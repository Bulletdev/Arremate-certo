/*    */ package org.apache.http.impl.cookie;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.conn.util.PublicSuffixList;
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
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class PublicSuffixListParser
/*    */ {
/*    */   private final PublicSuffixFilter filter;
/*    */   private final org.apache.http.conn.util.PublicSuffixListParser parser;
/*    */   
/*    */   PublicSuffixListParser(PublicSuffixFilter paramPublicSuffixFilter) {
/* 52 */     this.filter = paramPublicSuffixFilter;
/* 53 */     this.parser = new org.apache.http.conn.util.PublicSuffixListParser();
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
/*    */   public void parse(Reader paramReader) throws IOException {
/* 65 */     PublicSuffixList publicSuffixList = this.parser.parse(paramReader);
/* 66 */     this.filter.setPublicSuffixes(publicSuffixList.getRules());
/* 67 */     this.filter.setExceptions(publicSuffixList.getExceptions());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\PublicSuffixListParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */