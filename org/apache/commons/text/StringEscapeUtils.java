/*     */ package org.apache.commons.text;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import org.apache.commons.text.translate.AggregateTranslator;
/*     */ import org.apache.commons.text.translate.CharSequenceTranslator;
/*     */ import org.apache.commons.text.translate.CsvTranslators;
/*     */ import org.apache.commons.text.translate.EntityArrays;
/*     */ import org.apache.commons.text.translate.JavaUnicodeEscaper;
/*     */ import org.apache.commons.text.translate.LookupTranslator;
/*     */ import org.apache.commons.text.translate.NumericEntityEscaper;
/*     */ import org.apache.commons.text.translate.NumericEntityUnescaper;
/*     */ import org.apache.commons.text.translate.OctalUnescaper;
/*     */ import org.apache.commons.text.translate.UnicodeUnescaper;
/*     */ import org.apache.commons.text.translate.UnicodeUnpairedSurrogateRemover;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StringEscapeUtils
/*     */ {
/*     */   public static final CharSequenceTranslator ESCAPE_JAVA;
/*     */   public static final CharSequenceTranslator ESCAPE_ECMASCRIPT;
/*     */   public static final CharSequenceTranslator ESCAPE_JSON;
/*     */   public static final CharSequenceTranslator ESCAPE_XML10;
/*     */   public static final CharSequenceTranslator ESCAPE_XML11;
/*     */   
/*     */   static {
/*  66 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  67 */     hashMap.put("\"", "\\\"");
/*  68 */     hashMap.put("\\", "\\\\");
/*     */ 
/*     */ 
/*     */     
/*  72 */     ESCAPE_JAVA = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(Collections.unmodifiableMap(hashMap)), (CharSequenceTranslator)new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE), (CharSequenceTranslator)JavaUnicodeEscaper.outsideOf(32, 127) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     hashMap = new HashMap<>();
/*  86 */     hashMap.put("'", "\\'");
/*  87 */     hashMap.put("\"", "\\\"");
/*  88 */     hashMap.put("\\", "\\\\");
/*  89 */     hashMap.put("/", "\\/");
/*     */ 
/*     */ 
/*     */     
/*  93 */     ESCAPE_ECMASCRIPT = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(Collections.unmodifiableMap(hashMap)), (CharSequenceTranslator)new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE), (CharSequenceTranslator)JavaUnicodeEscaper.outsideOf(32, 127) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     hashMap = new HashMap<>();
/* 107 */     hashMap.put("\"", "\\\"");
/* 108 */     hashMap.put("\\", "\\\\");
/* 109 */     hashMap.put("/", "\\/");
/*     */ 
/*     */ 
/*     */     
/* 113 */     ESCAPE_JSON = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(Collections.unmodifiableMap(hashMap)), (CharSequenceTranslator)new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE), (CharSequenceTranslator)JavaUnicodeEscaper.outsideOf(32, 126) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     hashMap = new HashMap<>();
/* 127 */     hashMap.put("\000", "");
/* 128 */     hashMap.put("\001", "");
/* 129 */     hashMap.put("\002", "");
/* 130 */     hashMap.put("\003", "");
/* 131 */     hashMap.put("\004", "");
/* 132 */     hashMap.put("\005", "");
/* 133 */     hashMap.put("\006", "");
/* 134 */     hashMap.put("\007", "");
/* 135 */     hashMap.put("\b", "");
/* 136 */     hashMap.put("\013", "");
/* 137 */     hashMap.put("\f", "");
/* 138 */     hashMap.put("\016", "");
/* 139 */     hashMap.put("\017", "");
/* 140 */     hashMap.put("\020", "");
/* 141 */     hashMap.put("\021", "");
/* 142 */     hashMap.put("\022", "");
/* 143 */     hashMap.put("\023", "");
/* 144 */     hashMap.put("\024", "");
/* 145 */     hashMap.put("\025", "");
/* 146 */     hashMap.put("\026", "");
/* 147 */     hashMap.put("\027", "");
/* 148 */     hashMap.put("\030", "");
/* 149 */     hashMap.put("\031", "");
/* 150 */     hashMap.put("\032", "");
/* 151 */     hashMap.put("\033", "");
/* 152 */     hashMap.put("\034", "");
/* 153 */     hashMap.put("\035", "");
/* 154 */     hashMap.put("\036", "");
/* 155 */     hashMap.put("\037", "");
/* 156 */     hashMap.put("￾", "");
/* 157 */     hashMap.put("￿", "");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     ESCAPE_XML10 = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(EntityArrays.BASIC_ESCAPE), (CharSequenceTranslator)new LookupTranslator(EntityArrays.APOS_ESCAPE), (CharSequenceTranslator)new LookupTranslator(Collections.unmodifiableMap(hashMap)), (CharSequenceTranslator)NumericEntityEscaper.between(127, 132), (CharSequenceTranslator)NumericEntityEscaper.between(134, 159), (CharSequenceTranslator)new UnicodeUnpairedSurrogateRemover() });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     hashMap = new HashMap<>();
/* 178 */     hashMap.put("\000", "");
/* 179 */     hashMap.put("\013", "&#11;");
/* 180 */     hashMap.put("\f", "&#12;");
/* 181 */     hashMap.put("￾", "");
/* 182 */     hashMap.put("￿", "");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     ESCAPE_XML11 = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(EntityArrays.BASIC_ESCAPE), (CharSequenceTranslator)new LookupTranslator(EntityArrays.APOS_ESCAPE), (CharSequenceTranslator)new LookupTranslator(Collections.unmodifiableMap(hashMap)), (CharSequenceTranslator)NumericEntityEscaper.between(1, 8), (CharSequenceTranslator)NumericEntityEscaper.between(14, 31), (CharSequenceTranslator)NumericEntityEscaper.between(127, 132), (CharSequenceTranslator)NumericEntityEscaper.between(134, 159), (CharSequenceTranslator)new UnicodeUnpairedSurrogateRemover() });
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
/* 202 */   public static final CharSequenceTranslator ESCAPE_HTML3 = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(EntityArrays.BASIC_ESCAPE), (CharSequenceTranslator)new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 215 */   public static final CharSequenceTranslator ESCAPE_HTML4 = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(EntityArrays.BASIC_ESCAPE), (CharSequenceTranslator)new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE), (CharSequenceTranslator)new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 229 */   public static final CharSequenceTranslator ESCAPE_CSV = (CharSequenceTranslator)new CsvTranslators.CsvEscaper();
/*     */ 
/*     */   
/*     */   public static final CharSequenceTranslator ESCAPE_XSI;
/*     */   
/*     */   public static final CharSequenceTranslator UNESCAPE_JAVA;
/*     */ 
/*     */   
/*     */   static {
/* 238 */     hashMap = new HashMap<>();
/* 239 */     hashMap.put("|", "\\|");
/* 240 */     hashMap.put("&", "\\&");
/* 241 */     hashMap.put(";", "\\;");
/* 242 */     hashMap.put("<", "\\<");
/* 243 */     hashMap.put(">", "\\>");
/* 244 */     hashMap.put("(", "\\(");
/* 245 */     hashMap.put(")", "\\)");
/* 246 */     hashMap.put("$", "\\$");
/* 247 */     hashMap.put("`", "\\`");
/* 248 */     hashMap.put("\\", "\\\\");
/* 249 */     hashMap.put("\"", "\\\"");
/* 250 */     hashMap.put("'", "\\'");
/* 251 */     hashMap.put(" ", "\\ ");
/* 252 */     hashMap.put("\t", "\\\t");
/* 253 */     hashMap.put("\r\n", "");
/* 254 */     hashMap.put("\n", "");
/* 255 */     hashMap.put("*", "\\*");
/* 256 */     hashMap.put("?", "\\?");
/* 257 */     hashMap.put("[", "\\[");
/* 258 */     hashMap.put("#", "\\#");
/* 259 */     hashMap.put("~", "\\~");
/* 260 */     hashMap.put("=", "\\=");
/* 261 */     hashMap.put("%", "\\%");
/*     */     
/* 263 */     ESCAPE_XSI = (CharSequenceTranslator)new LookupTranslator(Collections.unmodifiableMap(hashMap));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 278 */     hashMap = new HashMap<>();
/* 279 */     hashMap.put("\\\\", "\\");
/* 280 */     hashMap.put("\\\"", "\"");
/* 281 */     hashMap.put("\\'", "'");
/* 282 */     hashMap.put("\\", "");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 287 */     UNESCAPE_JAVA = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new OctalUnescaper(), (CharSequenceTranslator)new UnicodeUnescaper(), (CharSequenceTranslator)new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_UNESCAPE), (CharSequenceTranslator)new LookupTranslator(Collections.unmodifiableMap(hashMap)) });
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
/* 298 */   public static final CharSequenceTranslator UNESCAPE_ECMASCRIPT = UNESCAPE_JAVA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 307 */   public static final CharSequenceTranslator UNESCAPE_JSON = UNESCAPE_JAVA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 316 */   public static final CharSequenceTranslator UNESCAPE_HTML3 = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(EntityArrays.BASIC_UNESCAPE), (CharSequenceTranslator)new LookupTranslator(EntityArrays.ISO8859_1_UNESCAPE), (CharSequenceTranslator)new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 330 */   public static final CharSequenceTranslator UNESCAPE_HTML4 = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(EntityArrays.BASIC_UNESCAPE), (CharSequenceTranslator)new LookupTranslator(EntityArrays.ISO8859_1_UNESCAPE), (CharSequenceTranslator)new LookupTranslator(EntityArrays.HTML40_EXTENDED_UNESCAPE), (CharSequenceTranslator)new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 345 */   public static final CharSequenceTranslator UNESCAPE_XML = (CharSequenceTranslator)new AggregateTranslator(new CharSequenceTranslator[] { (CharSequenceTranslator)new LookupTranslator(EntityArrays.BASIC_UNESCAPE), (CharSequenceTranslator)new LookupTranslator(EntityArrays.APOS_UNESCAPE), (CharSequenceTranslator)new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 359 */   public static final CharSequenceTranslator UNESCAPE_CSV = (CharSequenceTranslator)new CsvTranslators.CsvUnescaper();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 368 */   public static final CharSequenceTranslator UNESCAPE_XSI = new XsiUnescaper();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class XsiUnescaper
/*     */     extends CharSequenceTranslator
/*     */   {
/*     */     private static final char BACKSLASH = '\\';
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int translate(CharSequence param1CharSequence, int param1Int, Writer param1Writer) throws IOException {
/* 383 */       if (param1Int != 0) {
/* 384 */         throw new IllegalStateException("XsiUnescaper should never reach the [1] index");
/*     */       }
/*     */       
/* 387 */       String str = param1CharSequence.toString();
/*     */       
/* 389 */       int i = 0;
/* 390 */       int j = 0;
/*     */       while (true) {
/* 392 */         int k = str.indexOf('\\', j);
/* 393 */         if (k == -1) {
/* 394 */           if (i < str.length()) {
/* 395 */             param1Writer.write(str.substring(i));
/*     */           }
/*     */           break;
/*     */         } 
/* 399 */         if (k > i) {
/* 400 */           param1Writer.write(str.substring(i, k));
/*     */         }
/* 402 */         i = k + 1;
/* 403 */         j = k + 2;
/*     */       } 
/*     */       
/* 406 */       return Character.codePointCount(param1CharSequence, 0, param1CharSequence.length());
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
/*     */   public static final class Builder
/*     */   {
/*     */     private final StringBuilder sb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final CharSequenceTranslator translator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Builder(CharSequenceTranslator param1CharSequenceTranslator) {
/* 459 */       this.sb = new StringBuilder();
/* 460 */       this.translator = param1CharSequenceTranslator;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder escape(String param1String) {
/* 470 */       this.sb.append(this.translator.translate(param1String));
/* 471 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder append(String param1String) {
/* 481 */       this.sb.append(param1String);
/* 482 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 492 */       return this.sb.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Builder builder(CharSequenceTranslator paramCharSequenceTranslator) {
/* 502 */     return new Builder(paramCharSequenceTranslator);
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
/*     */   public static final String escapeJava(String paramString) {
/* 528 */     return ESCAPE_JAVA.translate(paramString);
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
/*     */   public static final String escapeEcmaScript(String paramString) {
/* 561 */     return ESCAPE_ECMASCRIPT.translate(paramString);
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
/*     */   public static final String escapeJson(String paramString) {
/* 587 */     return ESCAPE_JSON.translate(paramString);
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
/* 600 */     return UNESCAPE_JAVA.translate(paramString);
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
/*     */   public static final String unescapeEcmaScript(String paramString) {
/* 615 */     return UNESCAPE_ECMASCRIPT.translate(paramString);
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
/*     */   public static final String unescapeJson(String paramString) {
/* 630 */     return UNESCAPE_JSON.translate(paramString);
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
/*     */   public static final String escapeHtml4(String paramString) {
/* 661 */     return ESCAPE_HTML4.translate(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String escapeHtml3(String paramString) {
/* 672 */     return ESCAPE_HTML3.translate(paramString);
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
/*     */   public static final String unescapeHtml4(String paramString) {
/* 692 */     return UNESCAPE_HTML4.translate(paramString);
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
/*     */   public static final String unescapeHtml3(String paramString) {
/* 704 */     return UNESCAPE_HTML3.translate(paramString);
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
/*     */   public static String escapeXml10(String paramString) {
/* 735 */     return ESCAPE_XML10.translate(paramString);
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
/*     */   public static String escapeXml11(String paramString) {
/* 764 */     return ESCAPE_XML11.translate(paramString);
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
/*     */   public static final String unescapeXml(String paramString) {
/* 785 */     return UNESCAPE_XML.translate(paramString);
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
/*     */   public static final String escapeCsv(String paramString) {
/* 810 */     return ESCAPE_CSV.translate(paramString);
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
/*     */   public static final String unescapeCsv(String paramString) {
/* 834 */     return UNESCAPE_CSV.translate(paramString);
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
/*     */   public static final String escapeXSI(String paramString) {
/* 855 */     return ESCAPE_XSI.translate(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String unescapeXSI(String paramString) {
/* 866 */     return UNESCAPE_XSI.translate(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\StringEscapeUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */