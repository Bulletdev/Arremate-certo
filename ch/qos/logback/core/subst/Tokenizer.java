/*     */ package ch.qos.logback.core.subst;
/*     */ 
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
/*     */ public class Tokenizer
/*     */ {
/*     */   final String pattern;
/*     */   final int patternLength;
/*     */   a state;
/*     */   int pointer;
/*     */   
/*     */   enum a
/*     */   {
/*  25 */     a, b, c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tokenizer(String paramString) {
/*  36 */     this.state = (a)a.a;
/*  37 */     this.pointer = 0;
/*     */     this.pattern = paramString;
/*     */     this.patternLength = paramString.length(); } List<Token> tokenize() throws ScanException {
/*  40 */     ArrayList<Token> arrayList = new ArrayList();
/*  41 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  43 */     while (this.pointer < this.patternLength) {
/*  44 */       char c = this.pattern.charAt(this.pointer);
/*  45 */       this.pointer++;
/*     */       
/*  47 */       switch (null.x[this.state.ordinal()]) {
/*     */         case 1:
/*  49 */           handleLiteralState(c, arrayList, stringBuilder);
/*     */         
/*     */         case 2:
/*  52 */           handleStartState(c, arrayList, stringBuilder);
/*     */         
/*     */         case 3:
/*  55 */           handleDefaultValueState(c, arrayList, stringBuilder);
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/*  60 */     switch (null.x[this.state.ordinal()]) {
/*     */       case 1:
/*  62 */         addLiteralToken(arrayList, stringBuilder);
/*     */         break;
/*     */       
/*     */       case 3:
/*  66 */         stringBuilder.append(':');
/*  67 */         addLiteralToken(arrayList, stringBuilder);
/*     */         break;
/*     */       
/*     */       case 2:
/*  71 */         stringBuilder.append('$');
/*  72 */         addLiteralToken(arrayList, stringBuilder);
/*     */         break;
/*     */     } 
/*  75 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void handleDefaultValueState(char paramChar, List<Token> paramList, StringBuilder paramStringBuilder) {
/*  79 */     switch (paramChar) {
/*     */       case '-':
/*  81 */         paramList.add(Token.DEFAULT_SEP_TOKEN);
/*  82 */         this.state = (a)a.a;
/*     */         return;
/*     */       case '$':
/*  85 */         paramStringBuilder.append(':');
/*  86 */         addLiteralToken(paramList, paramStringBuilder);
/*  87 */         paramStringBuilder.setLength(0);
/*  88 */         this.state = a.b;
/*     */         return;
/*     */     } 
/*  91 */     paramStringBuilder.append(':').append(paramChar);
/*  92 */     this.state = (a)a.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void handleStartState(char paramChar, List<Token> paramList, StringBuilder paramStringBuilder) {
/*  98 */     if (paramChar == '{') {
/*  99 */       paramList.add(Token.START_TOKEN);
/*     */     } else {
/* 101 */       paramStringBuilder.append('$').append(paramChar);
/*     */     } 
/* 103 */     this.state = (a)a.a;
/*     */   }
/*     */   
/*     */   private void handleLiteralState(char paramChar, List<Token> paramList, StringBuilder paramStringBuilder) {
/* 107 */     if (paramChar == '$') {
/* 108 */       addLiteralToken(paramList, paramStringBuilder);
/* 109 */       paramStringBuilder.setLength(0);
/* 110 */       this.state = a.b;
/* 111 */     } else if (paramChar == ':') {
/* 112 */       addLiteralToken(paramList, paramStringBuilder);
/* 113 */       paramStringBuilder.setLength(0);
/* 114 */       this.state = a.c;
/* 115 */     } else if (paramChar == '{') {
/* 116 */       addLiteralToken(paramList, paramStringBuilder);
/* 117 */       paramList.add(Token.CURLY_LEFT_TOKEN);
/* 118 */       paramStringBuilder.setLength(0);
/* 119 */     } else if (paramChar == '}') {
/* 120 */       addLiteralToken(paramList, paramStringBuilder);
/* 121 */       paramList.add(Token.CURLY_RIGHT_TOKEN);
/* 122 */       paramStringBuilder.setLength(0);
/*     */     } else {
/* 124 */       paramStringBuilder.append(paramChar);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void addLiteralToken(List<Token> paramList, StringBuilder paramStringBuilder) {
/* 130 */     if (paramStringBuilder.length() == 0)
/*     */       return; 
/* 132 */     paramList.add(new Token(Token.Type.LITERAL, paramStringBuilder.toString()));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\subst\Tokenizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */