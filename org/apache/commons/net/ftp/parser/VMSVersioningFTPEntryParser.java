/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.regex.MatchResult;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.regex.PatternSyntaxException;
/*     */ import org.apache.commons.net.ftp.FTPClientConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VMSVersioningFTPEntryParser
/*     */   extends VMSFTPEntryParser
/*     */ {
/*     */   private final Pattern preparsePattern;
/*     */   private static final String PRE_PARSE_REGEX = "(.*?);([0-9]+)\\s*.*";
/*     */   
/*     */   public VMSVersioningFTPEntryParser() {
/*  62 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VMSVersioningFTPEntryParser(FTPClientConfig paramFTPClientConfig) {
/*  79 */     configure(paramFTPClientConfig);
/*     */ 
/*     */     
/*     */     try {
/*  83 */       this.preparsePattern = Pattern.compile("(.*?);([0-9]+)\\s*.*");
/*     */     }
/*  85 */     catch (PatternSyntaxException patternSyntaxException) {
/*     */       
/*  87 */       throw new IllegalArgumentException("Unparseable regex supplied:  (.*?);([0-9]+)\\s*.*");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> preParse(List<String> paramList) {
/* 104 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 105 */     ListIterator<String> listIterator = paramList.listIterator();
/* 106 */     while (listIterator.hasNext()) {
/* 107 */       String str = ((String)listIterator.next()).trim();
/* 108 */       MatchResult matchResult = null;
/* 109 */       Matcher matcher = this.preparsePattern.matcher(str);
/* 110 */       if (matcher.matches()) {
/* 111 */         matchResult = matcher.toMatchResult();
/* 112 */         String str1 = matchResult.group(1);
/* 113 */         String str2 = matchResult.group(2);
/* 114 */         Integer integer1 = Integer.valueOf(str2);
/* 115 */         Integer integer2 = (Integer)hashMap.get(str1);
/* 116 */         if (null != integer2 && 
/* 117 */           integer1.intValue() < integer2.intValue()) {
/* 118 */           listIterator.remove();
/*     */           
/*     */           continue;
/*     */         } 
/* 122 */         hashMap.put(str1, integer1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     while (listIterator.hasPrevious()) {
/* 131 */       String str = ((String)listIterator.previous()).trim();
/* 132 */       MatchResult matchResult = null;
/* 133 */       Matcher matcher = this.preparsePattern.matcher(str);
/* 134 */       if (matcher.matches()) {
/* 135 */         matchResult = matcher.toMatchResult();
/* 136 */         String str1 = matchResult.group(1);
/* 137 */         String str2 = matchResult.group(2);
/* 138 */         Integer integer1 = Integer.valueOf(str2);
/* 139 */         Integer integer2 = (Integer)hashMap.get(str1);
/* 140 */         if (null != integer2 && 
/* 141 */           integer1.intValue() < integer2.intValue()) {
/* 142 */           listIterator.remove();
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 148 */     return paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isVersioning() {
/* 154 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\VMSVersioningFTPEntryParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */