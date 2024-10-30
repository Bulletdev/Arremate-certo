/*     */ package org.jsoup;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import org.jsoup.helper.DataUtil;
/*     */ import org.jsoup.helper.HttpConnection;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.parser.Parser;
/*     */ import org.jsoup.safety.Cleaner;
/*     */ import org.jsoup.safety.Whitelist;
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
/*     */ public class Jsoup
/*     */ {
/*     */   public static Document parse(String paramString1, String paramString2) {
/*  31 */     return Parser.parse(paramString1, paramString2);
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
/*     */   public static Document parse(String paramString1, String paramString2, Parser paramParser) {
/*  45 */     return paramParser.parseInput(paramString1, paramString2);
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
/*     */   public static Document parse(String paramString) {
/*  58 */     return Parser.parse(paramString, "");
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
/*     */   public static Connection connect(String paramString) {
/*  73 */     return HttpConnection.connect(paramString);
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
/*     */   public static Document parse(File paramFile, String paramString1, String paramString2) throws IOException {
/*  88 */     return DataUtil.load(paramFile, paramString1, paramString2);
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
/*     */   public static Document parse(File paramFile, String paramString) throws IOException {
/* 103 */     return DataUtil.load(paramFile, paramString, paramFile.getAbsolutePath());
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
/*     */   public static Document parse(InputStream paramInputStream, String paramString1, String paramString2) throws IOException {
/* 118 */     return DataUtil.load(paramInputStream, paramString1, paramString2);
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
/*     */   public static Document parse(InputStream paramInputStream, String paramString1, String paramString2, Parser paramParser) throws IOException {
/* 135 */     return DataUtil.load(paramInputStream, paramString1, paramString2, paramParser);
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
/*     */   public static Document parseBodyFragment(String paramString1, String paramString2) {
/* 148 */     return Parser.parseBodyFragment(paramString1, paramString2);
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
/*     */   public static Document parseBodyFragment(String paramString) {
/* 160 */     return Parser.parseBodyFragment(paramString, "");
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
/*     */ 
/*     */   
/*     */   public static Document parse(URL paramURL, int paramInt) throws IOException {
/* 181 */     Connection connection = HttpConnection.connect(paramURL);
/* 182 */     connection.timeout(paramInt);
/* 183 */     return connection.get();
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
/*     */   public static String clean(String paramString1, String paramString2, Whitelist paramWhitelist) {
/* 198 */     Document document1 = parseBodyFragment(paramString1, paramString2);
/* 199 */     Cleaner cleaner = new Cleaner(paramWhitelist);
/* 200 */     Document document2 = cleaner.clean(document1);
/* 201 */     return document2.body().html();
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
/*     */   public static String clean(String paramString, Whitelist paramWhitelist) {
/* 215 */     return clean(paramString, "", paramWhitelist);
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
/*     */   public static String clean(String paramString1, String paramString2, Whitelist paramWhitelist, Document.OutputSettings paramOutputSettings) {
/* 231 */     Document document1 = parseBodyFragment(paramString1, paramString2);
/* 232 */     Cleaner cleaner = new Cleaner(paramWhitelist);
/* 233 */     Document document2 = cleaner.clean(document1);
/* 234 */     document2.outputSettings(paramOutputSettings);
/* 235 */     return document2.body().html();
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
/*     */   public static boolean isValid(String paramString, Whitelist paramWhitelist) {
/* 247 */     Document document = parseBodyFragment(paramString, "");
/* 248 */     Cleaner cleaner = new Cleaner(paramWhitelist);
/* 249 */     return cleaner.isValid(document);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\Jsoup.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */