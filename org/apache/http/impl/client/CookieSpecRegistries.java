/*    */ package org.apache.http.impl.client;
/*    */ 
/*    */ import org.apache.http.config.Lookup;
/*    */ import org.apache.http.config.RegistryBuilder;
/*    */ import org.apache.http.conn.util.PublicSuffixMatcher;
/*    */ import org.apache.http.conn.util.PublicSuffixMatcherLoader;
/*    */ import org.apache.http.cookie.CookieSpecProvider;
/*    */ import org.apache.http.impl.cookie.DefaultCookieSpecProvider;
/*    */ import org.apache.http.impl.cookie.IgnoreSpecProvider;
/*    */ import org.apache.http.impl.cookie.NetscapeDraftSpecProvider;
/*    */ import org.apache.http.impl.cookie.RFC6265CookieSpecProvider;
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
/*    */ public final class CookieSpecRegistries
/*    */ {
/*    */   public static RegistryBuilder<CookieSpecProvider> createDefaultBuilder(PublicSuffixMatcher paramPublicSuffixMatcher) {
/* 50 */     DefaultCookieSpecProvider defaultCookieSpecProvider = new DefaultCookieSpecProvider(paramPublicSuffixMatcher);
/* 51 */     RFC6265CookieSpecProvider rFC6265CookieSpecProvider1 = new RFC6265CookieSpecProvider(RFC6265CookieSpecProvider.CompatibilityLevel.RELAXED, paramPublicSuffixMatcher);
/*    */     
/* 53 */     RFC6265CookieSpecProvider rFC6265CookieSpecProvider2 = new RFC6265CookieSpecProvider(RFC6265CookieSpecProvider.CompatibilityLevel.STRICT, paramPublicSuffixMatcher);
/*    */     
/* 55 */     return RegistryBuilder.create().register("default", defaultCookieSpecProvider).register("best-match", defaultCookieSpecProvider).register("compatibility", defaultCookieSpecProvider).register("standard", rFC6265CookieSpecProvider1).register("standard-strict", rFC6265CookieSpecProvider2).register("netscape", new NetscapeDraftSpecProvider()).register("ignoreCookies", new IgnoreSpecProvider());
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
/*    */   public static RegistryBuilder<CookieSpecProvider> createDefaultBuilder() {
/* 69 */     return createDefaultBuilder(PublicSuffixMatcherLoader.getDefault());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Lookup<CookieSpecProvider> createDefault() {
/* 76 */     return createDefault(PublicSuffixMatcherLoader.getDefault());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Lookup<CookieSpecProvider> createDefault(PublicSuffixMatcher paramPublicSuffixMatcher) {
/* 83 */     return (Lookup<CookieSpecProvider>)createDefaultBuilder(paramPublicSuffixMatcher).build();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\CookieSpecRegistries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */