/*     */ package ch.qos.logback.core.pattern.parser;
/*     */ 
/*     */ import ch.qos.logback.core.pattern.util.IEscapeUtil;
/*     */ import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
/*     */ import ch.qos.logback.core.pattern.util.RestrictedEscapeUtil;
/*     */ import ch.qos.logback.core.spi.ScanException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class c
/*     */ {
/*     */   final String pattern;
/*     */   final int patternLength;
/*     */   final IEscapeUtil escapeUtil;
/*     */   final IEscapeUtil a;
/*     */   
/*     */   enum a
/*     */   {
/*  50 */     b, c, d, e, f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   a a = (a)new RestrictedEscapeUtil(); int pointer;
/*     */   c(String paramString, IEscapeUtil paramIEscapeUtil) {
/*  59 */     this.a = a.b;
/*  60 */     this.pointer = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     if (paramString == null || paramString.length() == 0) {
/*  69 */       throw new IllegalArgumentException("null or empty pattern string not allowed");
/*     */     }
/*  71 */     this.pattern = paramString;
/*  72 */     this.patternLength = paramString.length();
/*  73 */     this.escapeUtil = paramIEscapeUtil;
/*     */   }
/*     */   
/*     */   List tokenize() throws ScanException {
/*  77 */     ArrayList<b> arrayList = new ArrayList();
/*  78 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  80 */     while (this.pointer < this.patternLength) {
/*  81 */       char c1 = this.pattern.charAt(this.pointer);
/*  82 */       this.pointer++;
/*     */       
/*  84 */       switch (null.r[this.a.ordinal()]) {
/*     */         case 1:
/*  86 */           d(c1, arrayList, stringBuffer);
/*     */         
/*     */         case 2:
/*  89 */           c(c1, arrayList, stringBuffer);
/*     */         
/*     */         case 3:
/*  92 */           b(c1, arrayList, stringBuffer);
/*     */         
/*     */         case 4:
/*  95 */           e(c1, arrayList, stringBuffer);
/*     */         
/*     */         case 5:
/*  98 */           a(c1, arrayList, stringBuffer);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 106 */     switch (null.r[this.a.ordinal()]) {
/*     */       case 1:
/* 108 */         a(1000, stringBuffer, arrayList);
/*     */         break;
/*     */       case 4:
/* 111 */         arrayList.add(new b(1004, stringBuffer.toString()));
/*     */         break;
/*     */       case 5:
/* 114 */         arrayList.add(b.b);
/*     */         break;
/*     */       
/*     */       case 2:
/*     */       case 3:
/* 119 */         throw new ScanException("Unexpected end of pattern string");
/*     */     } 
/*     */     
/* 122 */     return arrayList;
/*     */   } c(String paramString) {
/*     */     this(paramString, (IEscapeUtil)new RegularEscapeUtil());
/*     */   } private void a(char paramChar, List<b> paramList, StringBuffer paramStringBuffer) {
/* 126 */     paramList.add(b.b);
/* 127 */     switch (paramChar) {
/*     */       case ')':
/*     */         return;
/*     */       case '{':
/* 131 */         this.a = a.e;
/*     */       
/*     */       case '\\':
/* 134 */         escape("%{}", paramStringBuffer);
/* 135 */         this.a = a.b;
/*     */     } 
/*     */     
/* 138 */     paramStringBuffer.append(paramChar);
/* 139 */     this.a = a.b;
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(char paramChar, List<b> paramList, StringBuffer paramStringBuffer) throws ScanException {
/* 144 */     OptionTokenizer optionTokenizer = new OptionTokenizer(this);
/* 145 */     optionTokenizer.tokenize(paramChar, paramList);
/*     */   }
/*     */   
/*     */   private void c(char paramChar, List<b> paramList, StringBuffer paramStringBuffer) {
/* 149 */     if (paramChar == '(') {
/* 150 */       a(1002, paramStringBuffer, paramList);
/* 151 */       paramList.add(b.c);
/* 152 */       this.a = a.b;
/* 153 */     } else if (Character.isJavaIdentifierStart(paramChar)) {
/* 154 */       a(1002, paramStringBuffer, paramList);
/* 155 */       this.a = a.d;
/* 156 */       paramStringBuffer.append(paramChar);
/*     */     } else {
/* 158 */       paramStringBuffer.append(paramChar);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void d(char paramChar, List<b> paramList, StringBuffer paramStringBuffer) {
/* 163 */     switch (paramChar) {
/*     */       case '\\':
/* 165 */         escape("%()", paramStringBuffer);
/*     */         return;
/*     */       
/*     */       case '%':
/* 169 */         a(1000, paramStringBuffer, paramList);
/* 170 */         paramList.add(b.d);
/* 171 */         this.a = a.c;
/*     */         return;
/*     */       
/*     */       case ')':
/* 175 */         a(1000, paramStringBuffer, paramList);
/* 176 */         this.a = a.f;
/*     */         return;
/*     */     } 
/*     */     
/* 180 */     paramStringBuffer.append(paramChar);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void e(char paramChar, List<b> paramList, StringBuffer paramStringBuffer) {
/* 186 */     if (Character.isJavaIdentifierPart(paramChar)) {
/* 187 */       paramStringBuffer.append(paramChar);
/* 188 */     } else if (paramChar == '{') {
/* 189 */       a(1004, paramStringBuffer, paramList);
/* 190 */       this.a = a.e;
/* 191 */     } else if (paramChar == '(') {
/* 192 */       a(1005, paramStringBuffer, paramList);
/* 193 */       this.a = a.b;
/* 194 */     } else if (paramChar == '%') {
/* 195 */       a(1004, paramStringBuffer, paramList);
/* 196 */       paramList.add(b.d);
/* 197 */       this.a = a.c;
/* 198 */     } else if (paramChar == ')') {
/* 199 */       a(1004, paramStringBuffer, paramList);
/* 200 */       this.a = a.f;
/*     */     } else {
/* 202 */       a(1004, paramStringBuffer, paramList);
/* 203 */       if (paramChar == '\\') {
/* 204 */         if (this.pointer < this.patternLength) {
/* 205 */           char c1 = this.pattern.charAt(this.pointer++);
/* 206 */           this.escapeUtil.escape("%()", paramStringBuffer, c1, this.pointer);
/*     */         } 
/*     */       } else {
/* 209 */         paramStringBuffer.append(paramChar);
/*     */       } 
/* 211 */       this.a = a.b;
/*     */     } 
/*     */   }
/*     */   
/*     */   void escape(String paramString, StringBuffer paramStringBuffer) {
/* 216 */     if (this.pointer < this.patternLength) {
/* 217 */       char c1 = this.pattern.charAt(this.pointer++);
/* 218 */       this.escapeUtil.escape(paramString, paramStringBuffer, c1, this.pointer);
/*     */     } 
/*     */   }
/*     */   
/*     */   void a(String paramString, StringBuffer paramStringBuffer) {
/* 223 */     if (this.pointer < this.patternLength) {
/* 224 */       char c1 = this.pattern.charAt(this.pointer++);
/* 225 */       this.a.escape(paramString, paramStringBuffer, c1, this.pointer);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(int paramInt, StringBuffer paramStringBuffer, List<b> paramList) {
/* 230 */     if (paramStringBuffer.length() > 0) {
/* 231 */       paramList.add(new b(paramInt, paramStringBuffer.toString()));
/* 232 */       paramStringBuffer.setLength(0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\parser\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */