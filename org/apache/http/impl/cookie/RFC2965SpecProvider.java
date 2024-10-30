/*    */ package org.apache.http.impl.cookie;
/*    */ 
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.Obsolete;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.conn.util.PublicSuffixMatcher;
/*    */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*    */ import org.apache.http.cookie.CookieSpec;
/*    */ import org.apache.http.cookie.CookieSpecProvider;
/*    */ import org.apache.http.protocol.HttpContext;
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
/*    */ @Obsolete
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*    */ public class RFC2965SpecProvider
/*    */   implements CookieSpecProvider
/*    */ {
/*    */   private final PublicSuffixMatcher publicSuffixMatcher;
/*    */   private final boolean oneHeader;
/*    */   private volatile CookieSpec cookieSpec;
/*    */   
/*    */   public RFC2965SpecProvider(PublicSuffixMatcher paramPublicSuffixMatcher, boolean paramBoolean) {
/* 59 */     this.oneHeader = paramBoolean;
/* 60 */     this.publicSuffixMatcher = paramPublicSuffixMatcher;
/*    */   }
/*    */   
/*    */   public RFC2965SpecProvider(PublicSuffixMatcher paramPublicSuffixMatcher) {
/* 64 */     this(paramPublicSuffixMatcher, false);
/*    */   }
/*    */   
/*    */   public RFC2965SpecProvider() {
/* 68 */     this(null, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public CookieSpec create(HttpContext paramHttpContext) {
/* 73 */     if (this.cookieSpec == null) {
/* 74 */       synchronized (this) {
/* 75 */         if (this.cookieSpec == null) {
/* 76 */           this.cookieSpec = new RFC2965Spec(this.oneHeader, new CommonCookieAttributeHandler[] { new RFC2965VersionAttributeHandler(), new BasicPathHandler(), PublicSuffixDomainFilter.decorate(new RFC2965DomainAttributeHandler(), this.publicSuffixMatcher), new RFC2965PortAttributeHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new RFC2965CommentUrlAttributeHandler(), new RFC2965DiscardAttributeHandler() });
/*    */         }
/*    */       } 
/*    */     }
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
/* 90 */     return this.cookieSpec;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\RFC2965SpecProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */