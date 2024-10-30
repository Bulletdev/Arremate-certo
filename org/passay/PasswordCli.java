/*     */ package org.passay;
/*     */ 
/*     */ import java.io.RandomAccessFile;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.passay.dictionary.TernaryTreeDictionary;
/*     */ import org.passay.dictionary.d;
/*     */ import org.passay.dictionary.f;
/*     */ import org.passay.dictionary.k;
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
/*     */ public final class PasswordCli
/*     */ {
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  34 */     ArrayList<t> arrayList = new ArrayList();
/*  35 */     String str1 = null;
/*  36 */     String str2 = null;
/*     */     try {
/*  38 */       if (paramArrayOfString.length < 2) {
/*  39 */         throw new ArrayIndexOutOfBoundsException();
/*     */       }
/*  41 */       for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  42 */         if ("-l".equals(paramArrayOfString[b]))
/*  43 */         { int i = Integer.parseInt(paramArrayOfString[++b]);
/*  44 */           int j = Integer.parseInt(paramArrayOfString[++b]);
/*  45 */           t t = new t(i, j);
/*  46 */           arrayList.add(t); }
/*  47 */         else if ("-c".equals(paramArrayOfString[b]))
/*  48 */         { e e1 = new e();
/*  49 */           e1.getRules().add(new g(m.c, Integer.parseInt(paramArrayOfString[++b])));
/*  50 */           e1.getRules().add(new g(m.d, Integer.parseInt(paramArrayOfString[++b])));
/*  51 */           e1.getRules().add(new g(m.e, Integer.parseInt(paramArrayOfString[++b])));
/*  52 */           e1.getRules().add(new g(m.b, Integer.parseInt(paramArrayOfString[++b])));
/*  53 */           e1.getRules().add(new g((f)m.a, Integer.parseInt(paramArrayOfString[++b])));
/*  54 */           e1.bv(Integer.parseInt(paramArrayOfString[++b]));
/*  55 */           arrayList.add(e1); }
/*  56 */         else if ("-d".equals(paramArrayOfString[b]))
/*  57 */         { TernaryTreeDictionary ternaryTreeDictionary = new TernaryTreeDictionary((k)new f(new RandomAccessFile(paramArrayOfString[++b], "r"), false));
/*     */           
/*  59 */           j j = new j((d)ternaryTreeDictionary);
/*  60 */           j.aO(true);
/*  61 */           arrayList.add(j); }
/*  62 */         else if ("-u".equals(paramArrayOfString[b]))
/*  63 */         { arrayList.add(new J(true, true));
/*  64 */           str1 = paramArrayOfString[++b]; }
/*  65 */         else if ("-s".equals(paramArrayOfString[b]))
/*  66 */         { arrayList.add(new r(n.c));
/*  67 */           arrayList.add(new r((H)n.a));
/*  68 */           arrayList.add(new r(n.b));
/*  69 */           arrayList.add(new C()); }
/*  70 */         else { if ("-h".equals(paramArrayOfString[b])) {
/*  71 */             throw new ArrayIndexOutOfBoundsException();
/*     */           }
/*  73 */           str2 = paramArrayOfString[b]; }
/*     */       
/*     */       } 
/*     */       
/*  77 */       if (str2 == null) {
/*  78 */         throw new ArrayIndexOutOfBoundsException();
/*     */       }
/*     */       
/*  81 */       x x = new x(str2);
/*  82 */       A a = new A((List)arrayList);
/*  83 */       if (str1 != null) {
/*  84 */         x.setUsername(str1);
/*     */       }
/*  86 */       E e = a.a(x);
/*  87 */       if (e.isValid()) {
/*  88 */         System.out.println("Valid password");
/*     */       } else {
/*  90 */         a.a(e).forEach(System.out::println);
/*     */       }
/*     */     
/*     */     }
/*  94 */     catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*  95 */       System.out.println("Usage: java " + PasswordCli.class.getName() + " <options> <password> \\");
/*  96 */       System.out.println("");
/*  97 */       System.out.println("where <options> includes:");
/*  98 */       System.out.println("       -l (Set the min & max password length) \\");
/*  99 */       System.out.println("          <min> \\");
/* 100 */       System.out.println("          <max> \\");
/* 101 */       System.out.println("       -c (Set the characters which must be present in the password) \\");
/*     */       
/* 103 */       System.out.println("          (Each of the following must be >= 0) \\");
/* 104 */       System.out.println("          <digits> \\");
/* 105 */       System.out.println("          <alphabetical> \\");
/* 106 */       System.out.println("          <non-alphanumeric> \\");
/* 107 */       System.out.println("          <uppercase> \\");
/* 108 */       System.out.println("          <lowercase> \\");
/* 109 */       System.out.println("          <num> (Number of these rules to enforce) \\");
/*     */       
/* 111 */       System.out.println("       -d (Test password against a dictionary) \\");
/* 112 */       System.out.println("          <file> (dictionary files) \\");
/* 113 */       System.out.println("          <num> (number of characters in matching words) \\");
/*     */       
/* 115 */       System.out.println("       -u (Test for a user id) \\");
/* 116 */       System.out.println("          <userid> \\");
/* 117 */       System.out.println("       -s (Test for sequences) \\");
/* 118 */       System.out.println("       -h (Print this message) \\");
/* 119 */       System.exit(1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\PasswordCli.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */