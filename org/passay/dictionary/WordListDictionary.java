/*     */ package org.passay.dictionary;
/*     */ 
/*     */ import java.io.FileReader;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import org.passay.dictionary.a.a;
/*     */ import org.passay.dictionary.a.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WordListDictionary
/*     */   implements d
/*     */ {
/*     */   protected final k a;
/*     */   
/*     */   public WordListDictionary(k paramk) {
/*  31 */     this.a = paramk;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public k a() {
/*  42 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long size() {
/*  49 */     return (this.a == null) ? 0L : this.a.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean search(String paramString) {
/*  56 */     return (l.a(this.a, paramString) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  63 */     return String.format("%s@%h::wordList=%s", new Object[] { getClass().getName(), Integer.valueOf(hashCode()), this.a });
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
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  77 */     ArrayList<FileReader> arrayList = new ArrayList();
/*     */     try {
/*  79 */       if (paramArrayOfString.length == 0) {
/*  80 */         throw new ArrayIndexOutOfBoundsException();
/*     */       }
/*     */ 
/*     */       
/*  84 */       boolean bool1 = true;
/*  85 */       boolean bool2 = false;
/*  86 */       boolean bool3 = false;
/*     */ 
/*     */       
/*  89 */       String str = null;
/*     */       
/*  91 */       for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  92 */         if ("-ci".equals(paramArrayOfString[b]))
/*  93 */         { bool1 = false; }
/*  94 */         else if ("-s".equals(paramArrayOfString[b]))
/*  95 */         { bool2 = true;
/*  96 */           str = paramArrayOfString[++b]; }
/*  97 */         else if ("-p".equals(paramArrayOfString[b]))
/*  98 */         { bool3 = true; }
/*  99 */         else { if ("-h".equals(paramArrayOfString[b])) {
/* 100 */             throw new ArrayIndexOutOfBoundsException();
/*     */           }
/* 102 */           arrayList.add(new FileReader(paramArrayOfString[b])); }
/*     */       
/*     */       } 
/*     */ 
/*     */       
/* 107 */       c c = l.a(arrayList
/* 108 */           .<Reader>toArray((Reader[])new FileReader[arrayList.size()]), bool1, (a)new b());
/*     */ 
/*     */       
/* 111 */       WordListDictionary wordListDictionary = new WordListDictionary(c);
/*     */ 
/*     */       
/* 114 */       if (bool2) {
/* 115 */         if (wordListDictionary.search(str)) {
/* 116 */           System.out.println(String.format("%s was found in this dictionary", new Object[] { str }));
/*     */         } else {
/* 118 */           System.out.println(String.format("%s was not found in this dictionary", new Object[] { str }));
/*     */         } 
/* 120 */       } else if (bool3) {
/* 121 */         System.out.println(wordListDictionary.a());
/*     */       } else {
/* 123 */         throw new ArrayIndexOutOfBoundsException();
/*     */       }
/*     */     
/* 126 */     } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 127 */       System.out.println("Usage: java " + WordListDictionary.class.getName() + " \\");
/* 128 */       System.out.println("       <dictionary1> <dictionary2> ... <options> <operation> \\");
/*     */       
/* 130 */       System.out.println("");
/* 131 */       System.out.println("where <options> includes:");
/* 132 */       System.out.println("       -ci (Make search case-insensitive) \\");
/* 133 */       System.out.println("");
/* 134 */       System.out.println("where <operation> includes:");
/* 135 */       System.out.println("       -s <word> (Search for a word) \\");
/* 136 */       System.out.println("       -p (Print the entire dictionary) \\");
/* 137 */       System.out.println("       -h (Print this message) \\");
/* 138 */       System.exit(1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\WordListDictionary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */