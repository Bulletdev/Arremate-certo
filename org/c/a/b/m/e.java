/*     */ package org.c.a.b.m;
/*     */ 
/*     */ import org.c.a.a.e.b;
/*     */ import org.c.a.a.f;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.a.h.d;
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
/*     */ public class e
/*     */   implements d
/*     */ {
/*     */   private g f;
/*     */   private String description;
/*     */   private String lB;
/*     */   private Integer g;
/*     */   private f k;
/*     */   private String lC;
/*     */   private b a;
/*     */   
/*     */   public g c() {
/*  65 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void c(g paramg) {
/*  72 */     this.f = paramg;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  77 */     return this.description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String paramString) {
/*  84 */     this.description = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String es() {
/*  89 */     return this.lB;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bH(String paramString) {
/*  96 */     this.lB = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer d() {
/* 101 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void c(Integer paramInteger) {
/* 108 */     this.g = paramInteger;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a() {
/* 113 */     return this.k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(f paramf) {
/* 120 */     this.k = paramf;
/*     */   }
/*     */ 
/*     */   
/*     */   public String ew() {
/* 125 */     return this.lC;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bI(String paramString) {
/* 132 */     this.lC = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public b a() {
/* 137 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(b paramb) {
/* 144 */     this.a = paramb;
/*     */   }
/*     */ 
/*     */   
/*     */   public int a(e parame) {
/* 149 */     return this.f.a(parame.f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 155 */     if (this == paramObject) return true; 
/* 156 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 158 */     e e1 = (e)paramObject;
/*     */     
/* 160 */     if ((this.g != null) ? !this.g.equals(e1.g) : (e1.g != null)) return false; 
/* 161 */     if ((this.description != null) ? !this.description.equals(e1.description) : (e1.description != null))
/* 162 */       return false; 
/* 163 */     if ((this.lB != null) ? !this.lB.equals(e1.lB) : (e1.lB != null)) return false; 
/* 164 */     if (this.k != e1.k) return false; 
/* 165 */     return k.j(this.f, e1.f);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 170 */     int i = (this.f != null) ? this.f.hashCode() : 0;
/* 171 */     i = 31 * i + ((this.description != null) ? this.description.hashCode() : 0);
/* 172 */     i = 31 * i + ((this.lB != null) ? this.lB.hashCode() : 0);
/* 173 */     i = 31 * i + ((this.g != null) ? this.g.hashCode() : 0);
/* 174 */     i = 31 * i + this.k.hashCode();
/* 175 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 180 */     return "ResolvedMigrationImpl{version=" + this.f + ", description='" + this.description + '\'' + ", script='" + this.lB + '\'' + ", checksum=" + this.g + ", type=" + this.k + ", physicalLocation='" + this.lC + '\'' + ", executor=" + this.a + '}';
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\m\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */