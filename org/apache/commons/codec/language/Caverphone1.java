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
/*     */ public class Caverphone1
/*     */   extends AbstractCaverphone
/*     */ {
/*     */   private static final String SIX_1 = "111111";
/*     */   
/*     */   public String encode(String paramString) {
/*  45 */     String str = paramString;
/*  46 */     if (str == null || str.length() == 0) {
/*  47 */       return "111111";
/*     */     }
/*     */ 
/*     */     
/*  51 */     str = str.toLowerCase(Locale.ENGLISH);
/*     */ 
/*     */     
/*  54 */     str = str.replaceAll("[^a-z]", "");
/*     */ 
/*     */ 
/*     */     
/*  58 */     str = str.replaceAll("^cough", "cou2f");
/*  59 */     str = str.replaceAll("^rough", "rou2f");
/*  60 */     str = str.replaceAll("^tough", "tou2f");
/*  61 */     str = str.replaceAll("^enough", "enou2f");
/*  62 */     str = str.replaceAll("^gn", "2n");
/*     */ 
/*     */     
/*  65 */     str = str.replaceAll("mb$", "m2");
/*     */ 
/*     */     
/*  68 */     str = str.replaceAll("cq", "2q");
/*  69 */     str = str.replaceAll("ci", "si");
/*  70 */     str = str.replaceAll("ce", "se");
/*  71 */     str = str.replaceAll("cy", "sy");
/*  72 */     str = str.replaceAll("tch", "2ch");
/*  73 */     str = str.replaceAll("c", "k");
/*  74 */     str = str.replaceAll("q", "k");
/*  75 */     str = str.replaceAll("x", "k");
/*  76 */     str = str.replaceAll("v", "f");
/*  77 */     str = str.replaceAll("dg", "2g");
/*  78 */     str = str.replaceAll("tio", "sio");
/*  79 */     str = str.replaceAll("tia", "sia");
/*  80 */     str = str.replaceAll("d", "t");
/*  81 */     str = str.replaceAll("ph", "fh");
/*  82 */     str = str.replaceAll("b", "p");
/*  83 */     str = str.replaceAll("sh", "s2");
/*  84 */     str = str.replaceAll("z", "s");
/*  85 */     str = str.replaceAll("^[aeiou]", "A");
/*     */     
/*  87 */     str = str.replaceAll("[aeiou]", "3");
/*  88 */     str = str.replaceAll("3gh3", "3kh3");
/*  89 */     str = str.replaceAll("gh", "22");
/*  90 */     str = str.replaceAll("g", "k");
/*  91 */     str = str.replaceAll("s+", "S");
/*  92 */     str = str.replaceAll("t+", "T");
/*  93 */     str = str.replaceAll("p+", "P");
/*  94 */     str = str.replaceAll("k+", "K");
/*  95 */     str = str.replaceAll("f+", "F");
/*  96 */     str = str.replaceAll("m+", "M");
/*  97 */     str = str.replaceAll("n+", "N");
/*  98 */     str = str.replaceAll("w3", "W3");
/*  99 */     str = str.replaceAll("wy", "Wy");
/* 100 */     str = str.replaceAll("wh3", "Wh3");
/* 101 */     str = str.replaceAll("why", "Why");
/* 102 */     str = str.replaceAll("w", "2");
/* 103 */     str = str.replaceAll("^h", "A");
/* 104 */     str = str.replaceAll("h", "2");
/* 105 */     str = str.replaceAll("r3", "R3");
/* 106 */     str = str.replaceAll("ry", "Ry");
/* 107 */     str = str.replaceAll("r", "2");
/* 108 */     str = str.replaceAll("l3", "L3");
/* 109 */     str = str.replaceAll("ly", "Ly");
/* 110 */     str = str.replaceAll("l", "2");
/* 111 */     str = str.replaceAll("j", "y");
/* 112 */     str = str.replaceAll("y3", "Y3");
/* 113 */     str = str.replaceAll("y", "2");
/*     */ 
/*     */     
/* 116 */     str = str.replaceAll("2", "");
/* 117 */     str = str.replaceAll("3", "");
/*     */ 
/*     */     
/* 120 */     str = str + "111111";
/*     */ 
/*     */     
/* 123 */     return str.substring(0, "111111".length());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\Caverphone1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */