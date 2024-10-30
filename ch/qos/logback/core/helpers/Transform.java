/*     */ package ch.qos.logback.core.helpers;
/*     */ 
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Transform
/*     */ {
/*     */   private static final String CDATA_START = "<![CDATA[";
/*     */   private static final String CDATA_END = "]]>";
/*     */   private static final String CDATA_PSEUDO_END = "]]&gt;";
/*     */   private static final String CDATA_EMBEDED_END = "]]>]]&gt;<![CDATA[";
/*  29 */   private static final int CDATA_END_LEN = "]]>".length();
/*  30 */   private static final Pattern UNSAFE_XML_CHARS = Pattern.compile("[\000-\b\013\f\016-\037<>&'\"]");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escapeTags(String paramString) {
/*  41 */     if (paramString == null || paramString.length() == 0 || !UNSAFE_XML_CHARS.matcher(paramString).find()) {
/*  42 */       return paramString;
/*     */     }
/*  44 */     StringBuffer stringBuffer = new StringBuffer(paramString);
/*  45 */     return escapeTags(stringBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escapeTags(StringBuffer paramStringBuffer) {
/*  56 */     for (byte b = 0; b < paramStringBuffer.length(); b++) {
/*  57 */       char c = paramStringBuffer.charAt(b);
/*  58 */       switch (c) {
/*     */         case '\t':
/*     */         case '\n':
/*     */         case '\r':
/*     */           break;
/*     */         
/*     */         case '&':
/*  65 */           paramStringBuffer.replace(b, b + 1, "&amp;");
/*     */           break;
/*     */         case '<':
/*  68 */           paramStringBuffer.replace(b, b + 1, "&lt;");
/*     */           break;
/*     */         case '>':
/*  71 */           paramStringBuffer.replace(b, b + 1, "&gt;");
/*     */           break;
/*     */         case '"':
/*  74 */           paramStringBuffer.replace(b, b + 1, "&quot;");
/*     */           break;
/*     */         case '\'':
/*  77 */           paramStringBuffer.replace(b, b + 1, "&#39;");
/*     */           break;
/*     */         default:
/*  80 */           if (c < ' ')
/*     */           {
/*     */             
/*  83 */             paramStringBuffer.replace(b, b + 1, "�");
/*     */           }
/*     */           break;
/*     */       } 
/*     */     } 
/*  88 */     return paramStringBuffer.toString();
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
/*     */   public static void appendEscapingCDATA(StringBuilder paramStringBuilder, String paramString) {
/* 103 */     if (paramString == null) {
/*     */       return;
/*     */     }
/*     */     
/* 107 */     int i = paramString.indexOf("]]>");
/*     */     
/* 109 */     if (i < 0) {
/* 110 */       paramStringBuilder.append(paramString);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 115 */     int j = 0;
/*     */     
/* 117 */     while (i > -1) {
/* 118 */       paramStringBuilder.append(paramString.substring(j, i));
/* 119 */       paramStringBuilder.append("]]>]]&gt;<![CDATA[");
/* 120 */       j = i + CDATA_END_LEN;
/*     */       
/* 122 */       if (j < paramString.length()) {
/* 123 */         i = paramString.indexOf("]]>", j);
/*     */         
/*     */         continue;
/*     */       } 
/*     */       return;
/*     */     } 
/* 129 */     paramStringBuilder.append(paramString.substring(j));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\helpers\Transform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */