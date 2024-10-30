/*     */ package org.c.a.b.r;
/*     */ 
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class g
/*     */ {
/*  25 */   private static final a a = c.b(g.class);
/*     */   
/*     */   private ClassLoader classLoader;
/*     */   
/*     */   private Boolean d;
/*     */   private Boolean e;
/*     */   private Boolean f;
/*     */   private Boolean g;
/*     */   private Boolean h;
/*     */   private Boolean i;
/*     */   private Boolean j;
/*     */   
/*     */   public g(ClassLoader paramClassLoader) {
/*  38 */     this.classLoader = paramClassLoader;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fX() {
/*  82 */     if (this.d == null) {
/*  83 */       this.d = Boolean.valueOf(d.a("org.apache.commons.logging.Log", this.classLoader));
/*     */     }
/*     */     
/*  86 */     return this.d.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fY() {
/*  95 */     if (this.e == null) {
/*  96 */       this.e = Boolean.valueOf(d.a("org.slf4j.Logger", this.classLoader));
/*     */     }
/*     */     
/*  99 */     return this.e.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fZ() {
/* 108 */     if (this.f == null) {
/* 109 */       this.f = Boolean.valueOf(d.a("org.springframework.jdbc.core.JdbcTemplate", this.classLoader));
/* 110 */       a.debug("Spring Jdbc available: " + this.f);
/*     */     } 
/*     */     
/* 113 */     return this.f.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ga() {
/* 122 */     if (this.g == null) {
/* 123 */       this.g = Boolean.valueOf(d.a("org.jboss.virtual.VFS", this.classLoader));
/* 124 */       a.debug("JBoss VFS v2 available: " + this.g);
/*     */     } 
/*     */     
/* 127 */     return this.g.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean gb() {
/* 136 */     if (this.h == null) {
/* 137 */       this.h = Boolean.valueOf(d.a("org.jboss.vfs.VFS", this.classLoader));
/* 138 */       a.debug("JBoss VFS v3 available: " + this.h);
/*     */     } 
/*     */     
/* 141 */     return this.h.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean gc() {
/* 150 */     if (this.i == null) {
/* 151 */       this.i = Boolean.valueOf(d.a("org.osgi.framework.Bundle", g.class.getClassLoader()));
/* 152 */       a.debug("OSGi framework available: " + this.i);
/*     */     } 
/*     */     
/* 155 */     return this.i.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean gd() {
/* 164 */     if (this.j == null) {
/* 165 */       this.j = Boolean.valueOf("Android Runtime".equals(System.getProperty("java.runtime.name")));
/*     */     }
/*     */     
/* 168 */     return this.j.booleanValue();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */