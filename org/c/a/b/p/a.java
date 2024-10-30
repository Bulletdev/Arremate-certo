/*     */ package org.c.a.b.p;
/*     */ 
/*     */ import java.util.Date;
/*     */ import org.c.a.a.f;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.b.r.k;
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
/*     */ public class a
/*     */   implements Comparable<a>
/*     */ {
/*     */   private final int iF;
/*     */   private final g f;
/*     */   private final String description;
/*     */   private final f k;
/*     */   private final String lB;
/*     */   private final Integer g;
/*     */   private final Date d;
/*     */   private final String jT;
/*     */   private final int iG;
/*     */   private final boolean cS;
/*     */   
/*     */   public a(int paramInt1, g paramg, String paramString1, f paramf, String paramString2, Integer paramInteger, Date paramDate, String paramString3, int paramInt2, boolean paramBoolean) {
/*  95 */     this.iF = paramInt1;
/*  96 */     this.f = paramg;
/*  97 */     this.description = paramString1;
/*  98 */     this.k = paramf;
/*  99 */     this.lB = paramString2;
/* 100 */     this.g = paramInteger;
/* 101 */     this.d = paramDate;
/* 102 */     this.jT = paramString3;
/* 103 */     this.iG = paramInt2;
/* 104 */     this.cS = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bQ() {
/* 111 */     return this.iF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g c() {
/* 118 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 125 */     return this.description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f a() {
/* 132 */     return this.k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String es() {
/* 139 */     return this.lB;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer d() {
/* 146 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date d() {
/* 153 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String eo() {
/* 160 */     return this.jT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bR() {
/* 167 */     return this.iG;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean g() {
/* 174 */     return this.cS;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 180 */     if (this == paramObject) return true; 
/* 181 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 183 */     a a1 = (a)paramObject;
/*     */     
/* 185 */     if (this.iG != a1.iG) return false; 
/* 186 */     if (this.iF != a1.iF) return false; 
/* 187 */     if (this.cS != a1.cS) return false; 
/* 188 */     if ((this.g != null) ? !this.g.equals(a1.g) : (a1.g != null)) return false; 
/* 189 */     if (!this.description.equals(a1.description)) return false; 
/* 190 */     if ((this.jT != null) ? !this.jT.equals(a1.jT) : (a1.jT != null)) return false; 
/* 191 */     if ((this.d != null) ? !this.d.equals(a1.d) : (a1.d != null)) return false; 
/* 192 */     if (!this.lB.equals(a1.lB)) return false; 
/* 193 */     if (this.k != a1.k) return false; 
/* 194 */     return k.j(this.f, a1.f);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 199 */     int i = this.iF;
/* 200 */     i = 31 * i + ((this.f != null) ? this.f.hashCode() : 0);
/* 201 */     i = 31 * i + this.description.hashCode();
/* 202 */     i = 31 * i + this.k.hashCode();
/* 203 */     i = 31 * i + this.lB.hashCode();
/* 204 */     i = 31 * i + ((this.g != null) ? this.g.hashCode() : 0);
/* 205 */     i = 31 * i + ((this.d != null) ? this.d.hashCode() : 0);
/* 206 */     i = 31 * i + ((this.jT != null) ? this.jT.hashCode() : 0);
/* 207 */     i = 31 * i + this.iG;
/* 208 */     i = 31 * i + (this.cS ? 1 : 0);
/* 209 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int a(a parama) {
/* 214 */     return this.iF - parama.iF;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\p\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */