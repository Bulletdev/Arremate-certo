/*     */ package org.h2.bnf;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RuleFixed
/*     */   implements Rule
/*     */ {
/*     */   public static final int YMD = 0;
/*     */   public static final int HMS = 1;
/*     */   public static final int NANOS = 2;
/*     */   public static final int ANY_EXCEPT_SINGLE_QUOTE = 3;
/*     */   public static final int ANY_EXCEPT_DOUBLE_QUOTE = 4;
/*     */   public static final int ANY_UNTIL_EOL = 5;
/*     */   public static final int ANY_UNTIL_END = 6;
/*     */   public static final int ANY_WORD = 7;
/*     */   public static final int ANY_EXCEPT_2_DOLLAR = 8;
/*     */   public static final int HEX_START = 10;
/*     */   public static final int CONCAT = 11;
/*     */   public static final int AZ_UNDERSCORE = 12;
/*     */   public static final int AF = 13;
/*     */   public static final int DIGIT = 14;
/*     */   public static final int OPEN_BRACKET = 15;
/*     */   public static final int CLOSE_BRACKET = 16;
/*     */   private final int type;
/*     */   
/*     */   RuleFixed(int paramInt) {
/*  29 */     this.type = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void accept(BnfVisitor paramBnfVisitor) {
/*  34 */     paramBnfVisitor.visitRuleFixed(this.type);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinks(HashMap<String, RuleHead> paramHashMap) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean autoComplete(Sentence paramSentence) {
/*  44 */     paramSentence.stopIfRequired();
/*  45 */     String str1 = paramSentence.getQuery();
/*  46 */     String str2 = str1;
/*  47 */     boolean bool = false;
/*  48 */     switch (this.type) {
/*     */       case 0:
/*  50 */         while (str2.length() > 0 && "0123456789-".indexOf(str2.charAt(0)) >= 0) {
/*  51 */           str2 = str2.substring(1);
/*     */         }
/*  53 */         if (str2.length() == 0) {
/*  54 */           paramSentence.add("2006-01-01", "1", 1);
/*     */         }
/*     */         
/*  57 */         bool = true;
/*     */         break;
/*     */       case 1:
/*  60 */         while (str2.length() > 0 && "0123456789:".indexOf(str2.charAt(0)) >= 0) {
/*  61 */           str2 = str2.substring(1);
/*     */         }
/*  63 */         if (str2.length() == 0) {
/*  64 */           paramSentence.add("12:00:00", "1", 1);
/*     */         }
/*     */         break;
/*     */       case 2:
/*  68 */         while (str2.length() > 0 && Character.isDigit(str2.charAt(0))) {
/*  69 */           str2 = str2.substring(1);
/*     */         }
/*  71 */         if (str2.length() == 0) {
/*  72 */           paramSentence.add("nanoseconds", "0", 1);
/*     */         }
/*  74 */         bool = true;
/*     */         break;
/*     */       case 3:
/*     */         while (true) {
/*  78 */           if (str2.length() > 0 && str2.charAt(0) != '\'') {
/*  79 */             str2 = str2.substring(1); continue;
/*     */           } 
/*  81 */           if (str2.startsWith("''")) {
/*  82 */             str2 = str2.substring(2);
/*     */             continue;
/*     */           } 
/*     */           break;
/*     */         } 
/*  87 */         if (str2.length() == 0) {
/*  88 */           paramSentence.add("anything", "Hello World", 1);
/*  89 */           paramSentence.add("'", "'", 1);
/*     */         } 
/*     */         break;
/*     */       case 8:
/*  93 */         while (str2.length() > 0 && !str2.startsWith("$$")) {
/*  94 */           str2 = str2.substring(1);
/*     */         }
/*  96 */         if (str2.length() == 0) {
/*  97 */           paramSentence.add("anything", "Hello World", 1);
/*  98 */           paramSentence.add("$$", "$$", 1);
/*     */         } 
/*     */         break;
/*     */       case 4:
/*     */         while (true) {
/* 103 */           if (str2.length() > 0 && str2.charAt(0) != '"') {
/* 104 */             str2 = str2.substring(1); continue;
/*     */           } 
/* 106 */           if (str2.startsWith("\"\"")) {
/* 107 */             str2 = str2.substring(2);
/*     */             continue;
/*     */           } 
/*     */           break;
/*     */         } 
/* 112 */         if (str2.length() == 0) {
/* 113 */           paramSentence.add("anything", "identifier", 1);
/* 114 */           paramSentence.add("\"", "\"", 1);
/*     */         } 
/*     */         break;
/*     */       case 7:
/* 118 */         while (str2.length() > 0 && !Bnf.startWithSpace(str2)) {
/* 119 */           str2 = str2.substring(1);
/*     */         }
/* 121 */         if (str2.length() == 0) {
/* 122 */           paramSentence.add("anything", "anything", 1);
/*     */         }
/*     */         break;
/*     */       case 10:
/* 126 */         if (str2.startsWith("0X") || str2.startsWith("0x")) {
/* 127 */           str2 = str2.substring(2); break;
/* 128 */         }  if ("0".equals(str2)) {
/* 129 */           paramSentence.add("0x", "x", 1); break;
/* 130 */         }  if (str2.length() == 0) {
/* 131 */           paramSentence.add("0x", "0x", 1);
/*     */         }
/*     */         break;
/*     */       case 11:
/* 135 */         if (str2.equals("|")) {
/* 136 */           paramSentence.add("||", "|", 1);
/* 137 */         } else if (str2.startsWith("||")) {
/* 138 */           str2 = str2.substring(2);
/* 139 */         } else if (str2.length() == 0) {
/* 140 */           paramSentence.add("||", "||", 1);
/*     */         } 
/* 142 */         bool = true;
/*     */         break;
/*     */       case 12:
/* 145 */         if (str2.length() > 0 && (Character.isLetter(str2.charAt(0)) || str2.charAt(0) == '_'))
/*     */         {
/* 147 */           str2 = str2.substring(1);
/*     */         }
/* 149 */         if (str2.length() == 0) {
/* 150 */           paramSentence.add("character", "A", 1);
/*     */         }
/*     */         break;
/*     */       case 13:
/* 154 */         if (str2.length() > 0) {
/* 155 */           char c = Character.toUpperCase(str2.charAt(0));
/* 156 */           if (c >= 'A' && c <= 'F') {
/* 157 */             str2 = str2.substring(1);
/*     */           }
/*     */         } 
/* 160 */         if (str2.length() == 0) {
/* 161 */           paramSentence.add("hex character", "0A", 1);
/*     */         }
/*     */         break;
/*     */       case 14:
/* 165 */         if (str2.length() > 0 && Character.isDigit(str2.charAt(0))) {
/* 166 */           str2 = str2.substring(1);
/*     */         }
/* 168 */         if (str2.length() == 0) {
/* 169 */           paramSentence.add("digit", "1", 1);
/*     */         }
/*     */         break;
/*     */       case 15:
/* 173 */         if (str2.length() == 0) {
/* 174 */           paramSentence.add("[", "[", 1);
/* 175 */         } else if (str2.charAt(0) == '[') {
/* 176 */           str2 = str2.substring(1);
/*     */         } 
/* 178 */         bool = true;
/*     */         break;
/*     */       case 16:
/* 181 */         if (str2.length() == 0) {
/* 182 */           paramSentence.add("]", "]", 1);
/* 183 */         } else if (str2.charAt(0) == ']') {
/* 184 */           str2 = str2.substring(1);
/*     */         } 
/* 186 */         bool = true;
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 193 */         throw new AssertionError("type=" + this.type);
/*     */     } 
/* 195 */     if (!str2.equals(str1)) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 200 */       if (bool) {
/* 201 */         while (Bnf.startWithSpace(str2)) {
/* 202 */           str2 = str2.substring(1);
/*     */         }
/*     */       }
/* 205 */       paramSentence.setQuery(str2);
/* 206 */       return true;
/*     */     } 
/* 208 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\RuleFixed.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */