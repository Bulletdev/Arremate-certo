/*     */ package org.c.a.b.a;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.c.a.a.b.b;
/*     */ import org.c.a.a.b.c;
/*     */ import org.c.a.a.b.e;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.h.d;
/*     */ import org.c.a.b.n.b;
/*     */ import org.c.a.b.n.e;
/*     */ import org.c.a.b.q.k;
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
/*     */ public class g
/*     */ {
/*  43 */   private static final org.c.a.a.f.a a = c.b(g.class);
/*     */   
/*  45 */   private final List<a> ai = new ArrayList<>();
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
/*     */   public g(b paramb, e parame, k paramk, b paramb1) {
/*  62 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*  64 */     a.debug("Scanning for SQL callbacks ...");
/*  65 */     Collection collection = parame.a("", paramb1.m());
/*  66 */     for (b b1 : collection) {
/*  67 */       String str2, str3, str1 = a(b1.getFilename(), paramb1.m());
/*     */ 
/*     */       
/*  70 */       int i = str1.indexOf(paramb1.ek());
/*  71 */       if (i >= 0) {
/*  72 */         str2 = str1.substring(0, i);
/*  73 */         str3 = str1.substring(i + paramb1.ek().length());
/*     */       } else {
/*  75 */         str2 = str1;
/*  76 */         str3 = null;
/*     */       } 
/*  78 */       e e1 = e.a(str2);
/*  79 */       if (e1 != null) {
/*  80 */         org.c.a.b.q.g g1 = (org.c.a.b.q.g)hashMap.get(str1);
/*  81 */         if (g1 != null) {
/*  82 */           throw new org.c.a.a.a("Found more than 1 SQL callback script called " + str1 + "!\nOffenders:\n-> " + g1
/*     */               
/*  84 */               .b().eJ() + "\n-> " + b1
/*  85 */               .eJ());
/*     */         }
/*  87 */         org.c.a.b.q.g g2 = new org.c.a.b.q.g(paramk, b1, paramb1.fj());
/*  88 */         hashMap.put(str1, g2);
/*  89 */         this.ai.add(new a(e1, str3, paramb, g2));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     Collections.sort(this.ai);
/*     */   }
/*     */   
/*     */   public List<b> aH() {
/* 100 */     return new ArrayList<>((Collection)this.ai);
/*     */   }
/*     */   
/*     */   private String a(String paramString, String[] paramArrayOfString) {
/* 104 */     for (String str : paramArrayOfString) {
/* 105 */       if (paramString.endsWith(str)) {
/* 106 */         return paramString.substring(0, paramString.length() - str.length());
/*     */       }
/*     */     } 
/* 109 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class a
/*     */     implements Comparable<a>, b
/*     */   {
/*     */     private final e I;
/*     */     
/*     */     private final String description;
/*     */     
/*     */     private final b a;
/*     */     
/*     */     private final org.c.a.b.q.g a;
/*     */ 
/*     */     
/*     */     private a(e param1e, String param1String, b param1b, org.c.a.b.q.g param1g) {
/* 127 */       this.I = param1e;
/* 128 */       this.description = param1String;
/* 129 */       this.a = (org.c.a.b.q.g)param1b;
/* 130 */       this.a = param1g;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean a(e param1e, c param1c) {
/* 139 */       return (this.I == param1e);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean b(e param1e, c param1c) {
/* 144 */       return this.a.fU();
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(e param1e, c param1c) {
/* 149 */       g.a().info("Executing SQL callback: " + param1e.getId() + (
/* 150 */           (this.description == null) ? "" : (" - " + this.description)) + (
/* 151 */           this.a.fU() ? "" : " [non-transactional]"));
/* 152 */       this.a.a(new d(param1c.getConnection()))
/*     */ 
/*     */ 
/*     */         
/* 156 */         .a(this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public int a(a param1a) {
/* 161 */       int i = this.I.compareTo((Enum)param1a.I);
/* 162 */       if (i == 0) {
/* 163 */         if (this.description == null) {
/* 164 */           return Integer.MIN_VALUE;
/*     */         }
/* 166 */         if (param1a.description == null) {
/* 167 */           return Integer.MAX_VALUE;
/*     */         }
/* 169 */         i = this.description.compareTo(param1a.description);
/*     */       } 
/* 171 */       return i;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\a\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */