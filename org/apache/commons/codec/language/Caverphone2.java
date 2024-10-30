/*     */ package org.apache.commons.codec.language;
/*     */ 
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Caverphone2
/*     */   extends AbstractCaverphone
/*     */ {
/*     */   private static final String TEN_1 = "1111111111";
/*     */   
/*     */   public String encode(String paramString) {
/*  45 */     String str = paramString;
/*  46 */     if (str == null || str.length() == 0) {
/*  47 */       return "1111111111";
/*     */     }
/*     */ 
/*     */     
/*  51 */     str = str.toLowerCase(Locale.ENGLISH);
/*     */ 
/*     */     
/*  54 */     str = str.replaceAll("[^a-z]", "");
/*     */ 
/*     */     
/*  57 */     str = str.replaceAll("e$", "");
/*     */ 
/*     */     
/*  60 */     str = str.replaceAll("^cough", "cou2f");
/*  61 */     str = str.replaceAll("^rough", "rou2f");
/*  62 */     str = str.replaceAll("^tough", "tou2f");
/*  63 */     str = str.replaceAll("^enough", "enou2f");
/*  64 */     str = str.replaceAll("^trough", "trou2f");
/*     */     
/*  66 */     str = str.replaceAll("^gn", "2n");
/*     */ 
/*     */     
/*  69 */     str = str.replaceAll("mb$", "m2");
/*     */ 
/*     */     
/*  72 */     str = str.replaceAll("cq", "2q");
/*  73 */     str = str.replaceAll("ci", "si");
/*  74 */     str = str.replaceAll("ce", "se");
/*  75 */     str = str.replaceAll("cy", "sy");
/*  76 */     str = str.replaceAll("tch", "2ch");
/*  77 */     str = str.replaceAll("c", "k");
/*  78 */     str = str.replaceAll("q", "k");
/*  79 */     str = str.replaceAll("x", "k");
/*  80 */     str = str.replaceAll("v", "f");
/*  81 */     str = str.replaceAll("dg", "2g");
/*  82 */     str = str.replaceAll("tio", "sio");
/*  83 */     str = str.replaceAll("tia", "sia");
/*  84 */     str = str.replaceAll("d", "t");
/*  85 */     str = str.replaceAll("ph", "fh");
/*  86 */     str = str.replaceAll("b", "p");
/*  87 */     str = str.replaceAll("sh", "s2");
/*  88 */     str = str.replaceAll("z", "s");
/*  89 */     str = str.replaceAll("^[aeiou]", "A");
/*  90 */     str = str.replaceAll("[aeiou]", "3");
/*  91 */     str = str.replaceAll("j", "y");
/*  92 */     str = str.replaceAll("^y3", "Y3");
/*  93 */     str = str.replaceAll("^y", "A");
/*  94 */     str = str.replaceAll("y", "3");
/*  95 */     str = str.replaceAll("3gh3", "3kh3");
/*  96 */     str = str.replaceAll("gh", "22");
/*  97 */     str = str.replaceAll("g", "k");
/*  98 */     str = str.replaceAll("s+", "S");
/*  99 */     str = str.replaceAll("t+", "T");
/* 100 */     str = str.replaceAll("p+", "P");
/* 101 */     str = str.replaceAll("k+", "K");
/* 102 */     str = str.replaceAll("f+", "F");
/* 103 */     str = str.replaceAll("m+", "M");
/* 104 */     str = str.replaceAll("n+", "N");
/* 105 */     str = str.replaceAll("w3", "W3");
/* 106 */     str = str.replaceAll("wh3", "Wh3");
/* 107 */     str = str.replaceAll("w$", "3");
/* 108 */     str = str.replaceAll("w", "2");
/* 109 */     str = str.replaceAll("^h", "A");
/* 110 */     str = str.replaceAll("h", "2");
/* 111 */     str = str.replaceAll("r3", "R3");
/* 112 */     str = str.replaceAll("r$", "3");
/* 113 */     str = str.replaceAll("r", "2");
/* 114 */     str = str.replaceAll("l3", "L3");
/* 115 */     str = str.replaceAll("l$", "3");
/* 116 */     str = str.replaceAll("l", "2");
/*     */ 
/*     */     
/* 119 */     str = str.replaceAll("2", "");
/* 120 */     str = str.replaceAll("3$", "A");
/* 121 */     str = str.replaceAll("3", "");
/*     */ 
/*     */     
/* 124 */     str = str + "1111111111";
/*     */ 
/*     */     
/* 127 */     return str.substring(0, "1111111111".length());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\Caverphone2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */