/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import org.apache.commons.lang3.text.translate.AggregateTranslator;
/*     */ import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
/*     */ import org.apache.commons.lang3.text.translate.EntityArrays;
/*     */ import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;
/*     */ import org.apache.commons.lang3.text.translate.LookupTranslator;
/*     */ import org.apache.commons.lang3.text.translate.NumericEntityEscaper;
/*     */ import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;
/*     */ import org.apache.commons.lang3.text.translate.OctalUnescaper;
/*     */ import org.apache.commons.lang3.text.translate.UnicodeUnescaper;
/*     */ import org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover;
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
/*     */ @Deprecated
/*     */ public class StringEscapeUtils
/*     */ {
/*  57 */   public static final CharSequenceTranslator ESCAPE_JAVA = (new LookupTranslator((CharSequence[][])new String[][] { { "\"", "\\\"" }, { "\\", "\\\\"
/*     */ 
/*     */         
/*     */         }
/*     */       
/*  62 */       })).with(new CharSequenceTranslator[] {
/*  63 */         (CharSequenceTranslator)new LookupTranslator((CharSequence[][])EntityArrays.JAVA_CTRL_CHARS_ESCAPE())
/*  64 */       }).with(new CharSequenceTranslator[] {
/*  65 */         (CharSequenceTranslator)JavaUnicodeEscaper.outsideOf(32, 127)
/*     */       });
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
/*  77 */   public static final CharSequenceTranslator ESCAPE_ECMASCRIPT = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator((CharSequence[][])new String[][] { { "'", "\\'" }, { "\"", "\\\"" }, { "\\", "\\\\" }, { "/", "\\/" } }), (CharSequenceTranslator)new LookupTranslator(
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  86 */           (CharSequence[][])EntityArrays.JAVA_CTRL_CHARS_ESCAPE()), 
/*  87 */         (CharSequenceTranslator)JavaUnicodeEscaper.outsideOf(32, 127) });
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
/*  99 */   public static final CharSequenceTranslator ESCAPE_JSON = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator((CharSequence[][])new String[][] { { "\"", "\\\"" }, { "\\", "\\\\" }, { "/", "\\/" } }), (CharSequenceTranslator)new LookupTranslator(
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 107 */           (CharSequence[][])EntityArrays.JAVA_CTRL_CHARS_ESCAPE()), 
/* 108 */         (CharSequenceTranslator)JavaUnicodeEscaper.outsideOf(32, 127) });
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
/*     */   @Deprecated
/* 122 */   public static final CharSequenceTranslator ESCAPE_XML = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(
/*     */           
/* 124 */           (CharSequence[][])EntityArrays.BASIC_ESCAPE()), (CharSequenceTranslator)new LookupTranslator(
/* 125 */           (CharSequence[][])EntityArrays.APOS_ESCAPE()) });
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
/* 137 */   public static final CharSequenceTranslator ESCAPE_XML10 = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(
/*     */           
/* 139 */           (CharSequence[][])EntityArrays.BASIC_ESCAPE()), (CharSequenceTranslator)new LookupTranslator(
/* 140 */           (CharSequence[][])EntityArrays.APOS_ESCAPE()), (CharSequenceTranslator)new LookupTranslator((CharSequence[][])new String[][] { { "\000", "" }, { "\001", "" }, { "\002", "" }, { "\003", "" }, { "\004", "" }, { "\005", "" }, { "\006", "" }, { "\007", "" }, { "\b", "" }, { "\013", "" }, { "\f", "" }, { "\016", "" }, { "\017", "" }, { "\020", "" }, { "\021", "" }, { "\022", "" }, { "\023", "" }, { "\024", "" }, { "\025", "" }, { "\026", "" }, { "\027", "" }, { "\030", "" }, { "\031", "" }, { "\032", "" }, { "\033", "" }, { "\034", "" }, { "\035", "" }, { "\036", "" }, { "\037", "" }, { "￾", "" }, { "￿", ""
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
/*     */             }
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
/* 175 */           }), (CharSequenceTranslator)NumericEntityEscaper.between(127, 132), 
/* 176 */         (CharSequenceTranslator)NumericEntityEscaper.between(134, 159), (CharSequenceTranslator)new UnicodeUnpairedSurrogateRemover() });
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
/* 189 */   public static final CharSequenceTranslator ESCAPE_XML11 = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(
/*     */           
/* 191 */           (CharSequence[][])EntityArrays.BASIC_ESCAPE()), (CharSequenceTranslator)new LookupTranslator(
/* 192 */           (CharSequence[][])EntityArrays.APOS_ESCAPE()), (CharSequenceTranslator)new LookupTranslator((CharSequence[][])new String[][] { { "\000", "" }, { "\013", "&#11;" }, { "\f", "&#12;" }, { "￾", "" }, { "￿", ""
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             }
/*     */ 
/*     */ 
/*     */           
/* 201 */           }), (CharSequenceTranslator)NumericEntityEscaper.between(1, 8), 
/* 202 */         (CharSequenceTranslator)NumericEntityEscaper.between(14, 31), 
/* 203 */         (CharSequenceTranslator)NumericEntityEscaper.between(127, 132), 
/* 204 */         (CharSequenceTranslator)NumericEntityEscaper.between(134, 159), (CharSequenceTranslator)new UnicodeUnpairedSurrogateRemover() });
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
/* 217 */   public static final CharSequenceTranslator ESCAPE_HTML3 = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(
/*     */           
/* 219 */           (CharSequence[][])EntityArrays.BASIC_ESCAPE()), (CharSequenceTranslator)new LookupTranslator(
/* 220 */           (CharSequence[][])EntityArrays.ISO8859_1_ESCAPE()) });
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
/* 232 */   public static final CharSequenceTranslator ESCAPE_HTML4 = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(
/*     */           
/* 234 */           (CharSequence[][])EntityArrays.BASIC_ESCAPE()), (CharSequenceTranslator)new LookupTranslator(
/* 235 */           (CharSequence[][])EntityArrays.ISO8859_1_ESCAPE()), (CharSequenceTranslator)new LookupTranslator(
/* 236 */           (CharSequence[][])EntityArrays.HTML40_EXTENDED_ESCAPE()) });
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
/* 248 */   public static final CharSequenceTranslator ESCAPE_CSV = new CsvEscaper();
/*     */ 
/*     */   
/*     */   static class CsvEscaper
/*     */     extends CharSequenceTranslator
/*     */   {
/*     */     private static final char CSV_DELIMITER = ',';
/*     */     
/*     */     private static final char CSV_QUOTE = '"';
/* 257 */     private static final String CSV_QUOTE_STR = String.valueOf('"');
/* 258 */     private static final char[] CSV_SEARCH_CHARS = new char[] { ',', '"', '\r', '\n' };
/*     */ 
/*     */ 
/*     */     
/*     */     public int translate(CharSequence param1CharSequence, int param1Int, Writer param1Writer) throws IOException {
/* 263 */       if (param1Int != 0) {
/* 264 */         throw new IllegalStateException("CsvEscaper should never reach the [1] index");
/*     */       }
/*     */       
/* 267 */       if (StringUtils.containsNone(param1CharSequence.toString(), CSV_SEARCH_CHARS)) {
/* 268 */         param1Writer.write(param1CharSequence.toString());
/*     */       } else {
/* 270 */         param1Writer.write(34);
/* 271 */         param1Writer.write(StringUtils.replace(param1CharSequence.toString(), CSV_QUOTE_STR, CSV_QUOTE_STR + CSV_QUOTE_STR));
/* 272 */         param1Writer.write(34);
/*     */       } 
/* 274 */       return Character.codePointCount(param1CharSequence, 0, param1CharSequence.length());
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
/* 290 */   public static final CharSequenceTranslator UNESCAPE_JAVA = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new OctalUnescaper(), (CharSequenceTranslator)new UnicodeUnescaper(), (CharSequenceTranslator)new LookupTranslator(
/*     */ 
/*     */ 
/*     */           
/* 294 */           (CharSequence[][])EntityArrays.JAVA_CTRL_CHARS_UNESCAPE()), (CharSequenceTranslator)new LookupTranslator((CharSequence[][])new String[][] { { "\\\\", "\\" }, { "\\\"", "\"" }, { "\\'", "'" }, { "\\", "" } }) });
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
/* 313 */   public static final CharSequenceTranslator UNESCAPE_ECMASCRIPT = UNESCAPE_JAVA;
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
/* 324 */   public static final CharSequenceTranslator UNESCAPE_JSON = UNESCAPE_JAVA;
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
/* 335 */   public static final CharSequenceTranslator UNESCAPE_HTML3 = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(
/*     */           
/* 337 */           (CharSequence[][])EntityArrays.BASIC_UNESCAPE()), (CharSequenceTranslator)new LookupTranslator(
/* 338 */           (CharSequence[][])EntityArrays.ISO8859_1_UNESCAPE()), (CharSequenceTranslator)new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]) });
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
/* 351 */   public static final CharSequenceTranslator UNESCAPE_HTML4 = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(
/*     */           
/* 353 */           (CharSequence[][])EntityArrays.BASIC_UNESCAPE()), (CharSequenceTranslator)new LookupTranslator(
/* 354 */           (CharSequence[][])EntityArrays.ISO8859_1_UNESCAPE()), (CharSequenceTranslator)new LookupTranslator(
/* 355 */           (CharSequence[][])EntityArrays.HTML40_EXTENDED_UNESCAPE()), (CharSequenceTranslator)new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]) });
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
/* 368 */   public static final CharSequenceTranslator UNESCAPE_XML = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(
/*     */           
/* 370 */           (CharSequence[][])EntityArrays.BASIC_UNESCAPE()), (CharSequenceTranslator)new LookupTranslator(
/* 371 */           (CharSequence[][])EntityArrays.APOS_UNESCAPE()), (CharSequenceTranslator)new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]) });
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
/* 384 */   public static final CharSequenceTranslator UNESCAPE_CSV = new CsvUnescaper();
/*     */   
/*     */   static class CsvUnescaper
/*     */     extends CharSequenceTranslator {
/*     */     private static final char CSV_DELIMITER = ',';
/*     */     private static final char CSV_QUOTE = '"';
/* 390 */     private static final String CSV_QUOTE_STR = String.valueOf('"');
/* 391 */     private static final char[] CSV_SEARCH_CHARS = new char[] { ',', '"', '\r', '\n' };
/*     */ 
/*     */ 
/*     */     
/*     */     public int translate(CharSequence param1CharSequence, int param1Int, Writer param1Writer) throws IOException {
/* 396 */       if (param1Int != 0) {
/* 397 */         throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
/*     */       }
/*     */       
/* 400 */       if (param1CharSequence.charAt(0) != '"' || param1CharSequence.charAt(param1CharSequence.length() - 1) != '"') {
/* 401 */         param1Writer.write(param1CharSequence.toString());
/* 402 */         return Character.codePointCount(param1CharSequence, 0, param1CharSequence.length());
/*     */       } 
/*     */ 
/*     */       
/* 406 */       String str = param1CharSequence.subSequence(1, param1CharSequence.length() - 1).toString();
/*     */       
/* 408 */       if (StringUtils.containsAny(str, CSV_SEARCH_CHARS)) {
/*     */         
/* 410 */         param1Writer.write(StringUtils.replace(str, CSV_QUOTE_STR + CSV_QUOTE_STR, CSV_QUOTE_STR));
/*     */       } else {
/* 412 */         param1Writer.write(param1CharSequence.toString());
/*     */       } 
/* 414 */       return Character.codePointCount(param1CharSequence, 0, param1CharSequence.length());
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
/*     */   public static final String escapeJava(String paramString) {
/* 457 */     return ESCAPE_JAVA.translate(paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String escapeEcmaScript(String paramString) {
/* 485 */     return ESCAPE_ECMASCRIPT.translate(paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String escapeJson(String paramString) {
/* 513 */     return ESCAPE_JSON.translate(paramString);
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
/*     */   public static final String unescapeJava(String paramString) {
/* 526 */     return UNESCAPE_JAVA.translate(paramString);
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
/*     */   public static final String unescapeEcmaScript(String paramString) {
/* 543 */     return UNESCAPE_ECMASCRIPT.translate(paramString);
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
/*     */   public static final String unescapeJson(String paramString) {
/* 560 */     return UNESCAPE_JSON.translate(paramString);
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
/*     */   public static final String escapeHtml4(String paramString) {
/* 593 */     return ESCAPE_HTML4.translate(paramString);
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
/*     */   public static final String escapeHtml3(String paramString) {
/* 606 */     return ESCAPE_HTML3.translate(paramString);
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
/*     */   
/*     */   public static final String unescapeHtml4(String paramString) {
/* 628 */     return UNESCAPE_HTML4.translate(paramString);
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
/*     */   public static final String unescapeHtml3(String paramString) {
/* 642 */     return UNESCAPE_HTML3.translate(paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static final String escapeXml(String paramString) {
/* 668 */     return ESCAPE_XML.translate(paramString);
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
/*     */   public static String escapeXml10(String paramString) {
/* 700 */     return ESCAPE_XML10.translate(paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escapeXml11(String paramString) {
/* 730 */     return ESCAPE_XML11.translate(paramString);
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
/*     */   
/*     */   public static final String unescapeXml(String paramString) {
/* 752 */     return UNESCAPE_XML.translate(paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String escapeCsv(String paramString) {
/* 778 */     return ESCAPE_CSV.translate(paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String unescapeCsv(String paramString) {
/* 803 */     return UNESCAPE_CSV.translate(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\StringEscapeUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */