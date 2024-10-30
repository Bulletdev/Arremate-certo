/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.util.regex.MatchResult;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.regex.PatternSyntaxException;
/*     */ import org.apache.commons.net.ftp.FTPFileEntryParserImpl;
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
/*     */ public abstract class RegexFTPFileEntryParserImpl
/*     */   extends FTPFileEntryParserImpl
/*     */ {
/*     */   private Pattern pattern;
/*     */   private MatchResult result;
/*     */   protected Matcher _matcher_;
/*     */   
/*     */   public RegexFTPFileEntryParserImpl(String paramString) {
/*  70 */     compileRegex(paramString, 0);
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
/*     */ 
/*     */   
/*     */   public RegexFTPFileEntryParserImpl(String paramString, int paramInt) {
/*  89 */     compileRegex(paramString, paramInt);
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
/*     */   public boolean matches(String paramString) {
/* 101 */     this.result = null;
/* 102 */     this._matcher_ = this.pattern.matcher(paramString);
/* 103 */     if (this._matcher_.matches()) {
/* 104 */       this.result = this._matcher_.toMatchResult();
/*     */     }
/* 106 */     return (null != this.result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGroupCnt() {
/* 116 */     if (this.result == null) {
/* 117 */       return 0;
/*     */     }
/* 119 */     return this.result.groupCount();
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
/*     */   public String group(int paramInt) {
/* 133 */     if (this.result == null) {
/* 134 */       return null;
/*     */     }
/* 136 */     return this.result.group(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGroupsAsString() {
/* 147 */     StringBuilder stringBuilder = new StringBuilder();
/* 148 */     for (byte b = 1; b <= this.result.groupCount(); b++) {
/* 149 */       stringBuilder.append(b).append(") ").append(this.result.group(b)).append(
/* 150 */           System.getProperty("line.separator"));
/*     */     }
/* 152 */     return stringBuilder.toString();
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
/*     */   public boolean setRegex(String paramString) {
/* 164 */     compileRegex(paramString, 0);
/* 165 */     return true;
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
/*     */   public boolean setRegex(String paramString, int paramInt) {
/* 179 */     compileRegex(paramString, paramInt);
/* 180 */     return true;
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
/*     */   private void compileRegex(String paramString, int paramInt) {
/*     */     try {
/* 195 */       this.pattern = Pattern.compile(paramString, paramInt);
/* 196 */     } catch (PatternSyntaxException patternSyntaxException) {
/* 197 */       throw new IllegalArgumentException("Unparseable regex supplied: " + paramString);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\RegexFTPFileEntryParserImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */