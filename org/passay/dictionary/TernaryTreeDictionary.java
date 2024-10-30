/*     */ package org.passay.dictionary;
/*     */ 
/*     */ import java.io.FileReader;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TernaryTreeDictionary
/*     */   implements d
/*     */ {
/*     */   protected final j a;
/*     */   
/*     */   public TernaryTreeDictionary(k paramk) {
/*  42 */     this(paramk, true);
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
/*     */   public TernaryTreeDictionary(k paramk, boolean paramBoolean) {
/*     */     Iterator<String> iterator;
/*  62 */     if (paramk.getComparator().compare("A", "a") == 0) {
/*  63 */       this.a = new j(false);
/*     */     } else {
/*  65 */       this.a = new j(true);
/*     */     } 
/*     */ 
/*     */     
/*  69 */     if (paramBoolean) {
/*  70 */       iterator = paramk.p();
/*     */     } else {
/*  72 */       iterator = paramk.iterator();
/*     */     } 
/*  74 */     while (iterator.hasNext()) {
/*  75 */       this.a.bN(iterator.next());
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
/*     */   public TernaryTreeDictionary(j paramj) {
/*  87 */     this.a = paramj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long size() {
/*  94 */     return (this.a == null) ? 0L : this.a.bC().size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean search(String paramString) {
/* 101 */     return this.a.search(paramString);
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
/*     */   public String[] b(String paramString) {
/* 115 */     return this.a.b(paramString);
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
/*     */   public String[] a(String paramString, int paramInt) {
/* 130 */     return this.a.a(paramString, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j a() {
/* 141 */     return this.a;
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
/* 155 */     ArrayList<FileReader> arrayList = new ArrayList();
/*     */     try {
/* 157 */       if (paramArrayOfString.length == 0) {
/* 158 */         throw new ArrayIndexOutOfBoundsException();
/*     */       }
/*     */ 
/*     */       
/* 162 */       boolean bool1 = false;
/* 163 */       boolean bool2 = true;
/* 164 */       boolean bool3 = false;
/* 165 */       boolean bool4 = false;
/* 166 */       boolean bool5 = false;
/* 167 */       boolean bool6 = false;
/*     */ 
/*     */       
/* 170 */       String str = null;
/* 171 */       int i = 0;
/*     */       
/* 173 */       for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 174 */         if ("-m".equals(paramArrayOfString[b]))
/* 175 */         { bool1 = true; }
/* 176 */         else if ("-ci".equals(paramArrayOfString[b]))
/* 177 */         { bool2 = false; }
/* 178 */         else if ("-s".equals(paramArrayOfString[b]))
/* 179 */         { bool3 = true;
/* 180 */           str = paramArrayOfString[++b]; }
/* 181 */         else if ("-ps".equals(paramArrayOfString[b]))
/* 182 */         { bool4 = true;
/* 183 */           str = paramArrayOfString[++b]; }
/* 184 */         else if ("-ns".equals(paramArrayOfString[b]))
/* 185 */         { bool5 = true;
/* 186 */           str = paramArrayOfString[++b];
/* 187 */           i = Integer.parseInt(paramArrayOfString[++b]); }
/* 188 */         else if ("-p".equals(paramArrayOfString[b]))
/* 189 */         { bool6 = true; }
/* 190 */         else { if ("-h".equals(paramArrayOfString[b])) {
/* 191 */             throw new ArrayIndexOutOfBoundsException();
/*     */           }
/* 193 */           arrayList.add(new FileReader(paramArrayOfString[b])); }
/*     */       
/*     */       } 
/*     */ 
/*     */       
/* 198 */       c c = l.a(arrayList
/* 199 */           .<Reader>toArray((Reader[])new FileReader[arrayList.size()]), bool2, (a)new b());
/*     */ 
/*     */       
/* 202 */       TernaryTreeDictionary ternaryTreeDictionary = new TernaryTreeDictionary(c, bool1);
/*     */ 
/*     */       
/* 205 */       if (bool3) {
/* 206 */         if (ternaryTreeDictionary.search(str)) {
/* 207 */           System.out.println(String.format("%s was found in this dictionary", new Object[] { str }));
/*     */         } else {
/* 209 */           System.out.println(String.format("%s was not found in this dictionary", new Object[] { str }));
/*     */         } 
/* 211 */       } else if (bool4) {
/* 212 */         String[] arrayOfString = ternaryTreeDictionary.b(str);
/* 213 */         System.out.println(
/* 214 */             String.format("Found %s matches for %s in this dictionary : %s", new Object[] {
/*     */                 
/* 216 */                 Integer.valueOf(arrayOfString.length), str, 
/*     */                 
/* 218 */                 Arrays.asList(arrayOfString) }));
/* 219 */       } else if (bool5) {
/* 220 */         String[] arrayOfString = ternaryTreeDictionary.a(str, i);
/* 221 */         System.out.println(
/* 222 */             String.format("Found %s matches for %s in this dictionary at a distance of %s : %s", new Object[] {
/*     */ 
/*     */                 
/* 225 */                 Integer.valueOf(arrayOfString.length), str, 
/*     */                 
/* 227 */                 Integer.valueOf(i), 
/* 228 */                 Arrays.asList(arrayOfString) }));
/* 229 */       } else if (bool6) {
/* 230 */         ternaryTreeDictionary.a().a(new PrintWriter(System.out, true));
/*     */       } else {
/* 232 */         throw new ArrayIndexOutOfBoundsException();
/*     */       } 
/* 234 */     } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 235 */       System.out.println("Usage: java " + TernaryTreeDictionary.class.getName() + " \\");
/* 236 */       System.out.println("       <dictionary1> <dictionary2> ... <options> <operation> \\");
/*     */       
/* 238 */       System.out.println("");
/* 239 */       System.out.println("where <options> includes:");
/* 240 */       System.out.println("       -m (Insert dictionary using it's median) \\");
/* 241 */       System.out.println("       -ci (Make search case-insensitive) \\");
/* 242 */       System.out.println("");
/* 243 */       System.out.println("where <operation> includes:");
/* 244 */       System.out.println("       -s <word> (Search for a word) \\");
/* 245 */       System.out.println("       -ps <word> (Partial search for a word) \\");
/* 246 */       System.out.println("           (where word like '.a.a.a') \\");
/* 247 */       System.out.println("       -ns <word> <distance> (Near search for a word) \\");
/*     */       
/* 249 */       System.out.println("       -p (Print the entire dictionary in tree form) \\");
/* 250 */       System.out.println("       -h (Print this message) \\");
/* 251 */       System.exit(1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\TernaryTreeDictionary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */