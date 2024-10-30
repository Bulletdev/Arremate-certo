/*     */ package ch.qos.logback.core.pattern.parser;
/*     */ 
/*     */ import ch.qos.logback.core.pattern.util.AsIsEscapeUtil;
/*     */ import ch.qos.logback.core.pattern.util.IEscapeUtil;
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
/*     */ public class OptionTokenizer
/*     */ {
/*     */   private static final int EXPECTING_STATE = 0;
/*     */   private static final int RAW_COLLECTING_STATE = 1;
/*     */   private static final int QUOTED_COLLECTING_STATE = 2;
/*     */   final IEscapeUtil escapeUtil;
/*     */   final c tokenStream;
/*     */   final String pattern;
/*     */   final int patternLength;
/*     */   char quoteChar;
/*  44 */   int state = 0;
/*     */   
/*     */   OptionTokenizer(c paramc) {
/*  47 */     this(paramc, (IEscapeUtil)new AsIsEscapeUtil());
/*     */   }
/*     */   
/*     */   OptionTokenizer(c paramc, IEscapeUtil paramIEscapeUtil) {
/*  51 */     this.tokenStream = paramc;
/*  52 */     this.pattern = paramc.pattern;
/*  53 */     this.patternLength = paramc.patternLength;
/*  54 */     this.escapeUtil = paramIEscapeUtil;
/*     */   }
/*     */   
/*     */   void tokenize(char paramChar, List<b> paramList) throws ScanException {
/*  58 */     StringBuffer stringBuffer = new StringBuffer();
/*  59 */     ArrayList<String> arrayList = new ArrayList();
/*  60 */     char c1 = paramChar;
/*     */     
/*  62 */     while (this.tokenStream.pointer < this.patternLength) {
/*  63 */       switch (this.state) {
/*     */         case 0:
/*  65 */           switch (c1) {
/*     */             case '\t':
/*     */             case '\n':
/*     */             case '\r':
/*     */             case ' ':
/*     */             case ',':
/*     */               break;
/*     */             case '"':
/*     */             case '\'':
/*  74 */               this.state = 2;
/*  75 */               this.quoteChar = c1;
/*     */               break;
/*     */             case '}':
/*  78 */               emitOptionToken(paramList, arrayList);
/*     */               return;
/*     */           } 
/*  81 */           stringBuffer.append(c1);
/*  82 */           this.state = 1;
/*     */           break;
/*     */         
/*     */         case 1:
/*  86 */           switch (c1) {
/*     */             case ',':
/*  88 */               arrayList.add(stringBuffer.toString().trim());
/*  89 */               stringBuffer.setLength(0);
/*  90 */               this.state = 0;
/*     */               break;
/*     */             case '}':
/*  93 */               arrayList.add(stringBuffer.toString().trim());
/*  94 */               emitOptionToken(paramList, arrayList);
/*     */               return;
/*     */           } 
/*  97 */           stringBuffer.append(c1);
/*     */           break;
/*     */         
/*     */         case 2:
/* 101 */           if (c1 == this.quoteChar) {
/* 102 */             arrayList.add(stringBuffer.toString());
/* 103 */             stringBuffer.setLength(0);
/* 104 */             this.state = 0; break;
/* 105 */           }  if (c1 == '\\') {
/* 106 */             escape(String.valueOf(this.quoteChar), stringBuffer); break;
/*     */           } 
/* 108 */           stringBuffer.append(c1);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 114 */       c1 = this.pattern.charAt(this.tokenStream.pointer);
/* 115 */       this.tokenStream.pointer++;
/*     */     } 
/*     */ 
/*     */     
/* 119 */     if (c1 == '}') {
/* 120 */       if (this.state == 0) {
/* 121 */         emitOptionToken(paramList, arrayList);
/* 122 */       } else if (this.state == 1) {
/* 123 */         arrayList.add(stringBuffer.toString().trim());
/* 124 */         emitOptionToken(paramList, arrayList);
/*     */       } else {
/* 126 */         throw new ScanException("Unexpected end of pattern string in OptionTokenizer");
/*     */       } 
/*     */     } else {
/* 129 */       throw new ScanException("Unexpected end of pattern string in OptionTokenizer");
/*     */     } 
/*     */   }
/*     */   
/*     */   void emitOptionToken(List<b> paramList, List<String> paramList1) {
/* 134 */     paramList.add(new b(1006, paramList1));
/* 135 */     this.tokenStream.a = c.a.b;
/*     */   }
/*     */   
/*     */   void escape(String paramString, StringBuffer paramStringBuffer) {
/* 139 */     if (this.tokenStream.pointer < this.patternLength) {
/* 140 */       char c1 = this.pattern.charAt(this.tokenStream.pointer++);
/* 141 */       this.escapeUtil.escape(paramString, paramStringBuffer, c1, this.tokenStream.pointer);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\parser\OptionTokenizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */