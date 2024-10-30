/*     */ package org.c.a.b.g;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.c.a.a.g;
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
/*     */ public class b
/*     */ {
/*     */   public boolean cs;
/*     */   public boolean cz;
/*     */   public boolean cM;
/*     */   public boolean cN;
/*     */   public boolean cO;
/*     */   public g d;
/*     */   public g g;
/*     */   public g h;
/*  70 */   public g i = g.a;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  75 */   public g j = g.a;
/*     */   
/*  77 */   public Map<String, Integer> ar = new HashMap<>();
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  81 */     if (this == paramObject) return true; 
/*  82 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/*  84 */     b b1 = (b)paramObject;
/*     */     
/*  86 */     if (this.cs != b1.cs) return false; 
/*  87 */     if (this.cz != b1.cz) return false; 
/*  88 */     if (this.cM != b1.cM) return false; 
/*  89 */     if (this.cN != b1.cN) return false; 
/*  90 */     if (this.cO != b1.cO) return false; 
/*  91 */     if ((this.d != null) ? !this.d.equals(b1.d) : (b1.d != null)) return false; 
/*  92 */     if ((this.g != null) ? !this.g.equals(b1.g) : (b1.g != null)) return false; 
/*  93 */     if ((this.h != null) ? !this.h.equals(b1.h) : (b1.h != null)) return false; 
/*  94 */     if ((this.i != null) ? !this.i.equals(b1.i) : (b1.i != null)) return false; 
/*  95 */     if ((this.j != null) ? !this.j.equals(b1.j) : (b1.j != null)) return false; 
/*  96 */     return this.ar.equals(b1.ar);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 102 */     int i = this.cs ? 1 : 0;
/* 103 */     i = 31 * i + (this.cz ? 1 : 0);
/* 104 */     i = 31 * i + (this.cM ? 1 : 0);
/* 105 */     i = 31 * i + (this.cN ? 1 : 0);
/* 106 */     i = 31 * i + (this.cO ? 1 : 0);
/* 107 */     i = 31 * i + ((this.d != null) ? this.d.hashCode() : 0);
/* 108 */     i = 31 * i + ((this.g != null) ? this.g.hashCode() : 0);
/* 109 */     i = 31 * i + ((this.h != null) ? this.h.hashCode() : 0);
/* 110 */     i = 31 * i + ((this.i != null) ? this.i.hashCode() : 0);
/* 111 */     i = 31 * i + ((this.j != null) ? this.j.hashCode() : 0);
/* 112 */     i = 31 * i + this.ar.hashCode();
/* 113 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\g\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */