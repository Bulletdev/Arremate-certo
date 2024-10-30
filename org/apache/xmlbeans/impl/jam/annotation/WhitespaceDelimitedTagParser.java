/*     */ package org.apache.xmlbeans.impl.jam.annotation;
/*     */ 
/*     */ import com.sun.javadoc.Tag;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Properties;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WhitespaceDelimitedTagParser
/*     */   extends JavadocTagParser
/*     */ {
/*     */   public void parse(MAnnotatedElement paramMAnnotatedElement, Tag paramTag) {
/*  34 */     MAnnotation[] arrayOfMAnnotation = createAnnotations(paramMAnnotatedElement, paramTag);
/*  35 */     String str = paramTag.text();
/*  36 */     if (str == null)
/*  37 */       return;  str = str.trim();
/*  38 */     if (str.length() == 0)
/*  39 */       return;  Properties properties = new Properties();
/*  40 */     parseAssignments(properties, str);
/*  41 */     if (properties.size() > 0) {
/*  42 */       Enumeration enumeration = properties.propertyNames();
/*  43 */       while (enumeration.hasMoreElements()) {
/*  44 */         String str1 = (String)enumeration.nextElement();
/*  45 */         setValue(arrayOfMAnnotation, str1, properties.getProperty(str1));
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  51 */       setSingleValueText(arrayOfMAnnotation, paramTag);
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
/*     */   private void parseAssignments(Properties paramProperties, String paramString) {
/*  74 */     getLogger().verbose("PARSING LINE " + paramString, this);
/*  75 */     String str = paramString;
/*  76 */     paramString = removeComments(paramString);
/*  77 */     while (null != paramString && -1 != paramString.indexOf("=")) {
/*  78 */       int i = -1;
/*  79 */       int j = -1;
/*  80 */       int k = 0;
/*     */       
/*  82 */       char c = paramString.charAt(k);
/*  83 */       while (isBlank(c)) {
/*  84 */         k++;
/*  85 */         c = paramString.charAt(k);
/*     */       } 
/*  87 */       i = k;
/*  88 */       for (; isLegal(paramString.charAt(k)); k++);
/*  89 */       j = k;
/*  90 */       String str1 = paramString.substring(i, j);
/*  91 */       k = paramString.indexOf("=");
/*  92 */       if (k == -1) {
/*     */         return;
/*     */       }
/*     */       
/*  96 */       k++;
/*     */       
/*     */       try {
/*  99 */         c = paramString.charAt(k);
/*     */       }
/* 101 */       catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
/* 102 */         stringIndexOutOfBoundsException.printStackTrace();
/*     */       } 
/* 104 */       while (isBlank(c)) {
/* 105 */         k++;
/* 106 */         c = paramString.charAt(k);
/*     */       } 
/*     */ 
/*     */       
/* 110 */       int m = -1;
/* 111 */       int n = -1;
/* 112 */       if (c == '"') {
/* 113 */         m = ++k;
/* 114 */         while ('"' != paramString.charAt(k)) {
/* 115 */           k++;
/* 116 */           if (k >= paramString.length()) {
/* 117 */             getLogger().verbose("missing double quotes on line " + paramString, this);
/*     */           }
/*     */         } 
/* 120 */         n = k;
/*     */       } else {
/*     */         
/* 123 */         m = k++;
/* 124 */         for (; k < paramString.length() && isLegal(paramString.charAt(k)); k++);
/* 125 */         n = k;
/*     */       } 
/* 127 */       String str2 = paramString.substring(m, n);
/* 128 */       if (k < paramString.length()) {
/* 129 */         paramString = paramString.substring(k + 1);
/*     */       } else {
/*     */         
/* 132 */         paramString = null;
/*     */       } 
/* 134 */       getLogger().verbose("SETTING KEY:" + str1 + " VALUE:" + str2, this);
/* 135 */       paramProperties.setProperty(str1, str2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String removeComments(String paramString) {
/* 145 */     String str1 = "";
/* 146 */     int i = paramString.length();
/* 147 */     String str2 = paramString;
/*     */     
/* 149 */     int j = 0;
/*     */     
/* 151 */     int k = str2.indexOf("//");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 156 */     int m = str2.indexOf("\"");
/* 157 */     if (-1 != m && m < k) {
/*     */       
/* 159 */       str1 = paramString;
/*     */     } else {
/*     */       
/* 162 */       while (j < i && k != -1) {
/* 163 */         k = paramString.indexOf("//", j);
/* 164 */         if (-1 != k) {
/* 165 */           if (k > 0 && paramString.charAt(k - 1) == ':') {
/*     */ 
/*     */ 
/*     */             
/* 169 */             j = k + 2;
/*     */             continue;
/*     */           } 
/* 172 */           int n = paramString.indexOf('\n', k);
/* 173 */           if (-1 == n) n = i;
/*     */ 
/*     */           
/* 176 */           str1 = str1 + paramString.substring(j, k).trim() + "\n";
/* 177 */           str2 = paramString.substring(n);
/* 178 */           j = n;
/*     */         } 
/*     */       } 
/* 181 */       str1 = str1 + str2;
/*     */     } 
/*     */     
/* 184 */     return str1.trim();
/*     */   }
/*     */   
/*     */   private boolean isBlank(char paramChar) {
/* 188 */     return (paramChar == ' ' || paramChar == '\t' || paramChar == '\n');
/*     */   }
/*     */   
/*     */   private boolean isLegal(char paramChar) {
/* 192 */     return (!isBlank(paramChar) && paramChar != '=');
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\annotation\WhitespaceDelimitedTagParser.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */