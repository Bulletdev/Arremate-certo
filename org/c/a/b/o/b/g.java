/*    */ package org.c.a.b.o.b;
/*    */ 
/*    */ import java.net.URL;
/*    */ import java.util.Enumeration;
/*    */ import java.util.Set;
/*    */ import java.util.TreeSet;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import org.osgi.framework.Bundle;
/*    */ import org.osgi.framework.FrameworkUtil;
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
/*    */ public class g
/*    */   implements a
/*    */ {
/* 39 */   private static final Pattern B = Pattern.compile("^\\d+");
/*    */ 
/*    */   
/* 42 */   private static final Pattern C = Pattern.compile(".*_(\\d+)\\..*");
/*    */   
/*    */   public Set<String> a(String paramString, URL paramURL) {
/* 45 */     TreeSet<String> treeSet = new TreeSet();
/*    */     
/* 47 */     Bundle bundle = a(FrameworkUtil.getBundle(getClass()), paramURL);
/*    */     
/* 49 */     Enumeration<URL> enumeration = bundle.findEntries(paramURL.getPath(), "*", true);
/*    */     
/* 51 */     if (enumeration != null) {
/* 52 */       while (enumeration.hasMoreElements()) {
/* 53 */         URL uRL = enumeration.nextElement();
/* 54 */         String str = a(uRL);
/*    */         
/* 56 */         treeSet.add(str);
/*    */       } 
/*    */     }
/*    */     
/* 60 */     return treeSet;
/*    */   }
/*    */   
/*    */   private Bundle a(Bundle paramBundle, URL paramURL) {
/*    */     try {
/* 65 */       Bundle bundle = paramBundle.getBundleContext().getBundle(e(paramURL.getHost()));
/* 66 */       return (bundle != null) ? bundle : paramBundle;
/* 67 */     } catch (Exception exception) {
/* 68 */       return paramBundle;
/*    */     } 
/*    */   }
/*    */   
/*    */   static long e(String paramString) {
/* 73 */     Matcher matcher = B.matcher(paramString);
/* 74 */     if (matcher.find()) {
/* 75 */       return Double.valueOf(matcher.group()).longValue();
/*    */     }
/* 77 */     matcher = C.matcher(paramString);
/* 78 */     if (matcher.find()) {
/* 79 */       return Double.valueOf(matcher.group(1)).longValue();
/*    */     }
/*    */     
/* 82 */     throw new IllegalArgumentException("There's no bundleId in passed URL");
/*    */   }
/*    */   
/*    */   private String a(URL paramURL) {
/* 86 */     String str = paramURL.getPath();
/*    */     
/* 88 */     return str.startsWith("/") ? str.substring(1) : str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\o\b\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */