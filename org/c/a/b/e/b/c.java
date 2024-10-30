/*     */ package org.c.a.b.e.b;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.e.a.f;
/*     */ import org.c.a.b.h.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends d<b>
/*     */ {
/*     */   final boolean cB;
/*     */   
/*     */   c(d paramd, b paramb, String paramString) {
/*  43 */     super(paramd, paramb, paramString);
/*  44 */     this.cB = !paramb.c().H("2");
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/*  49 */     return this.a.b("SELECT EXISTS ( SELECT 1 FROM pg_database WHERE datname=? )", new String[] { this.name });
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/*  54 */     if (this.cB) {
/*  55 */       return !this.a.b("SELECT EXISTS (  SELECT 1  FROM information_schema.tables  WHERE table_schema=?  AND table_type='BASE TABLE')", new String[] { this.name });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  62 */     return !this.a.b("SELECT EXISTS (  SELECT 1  FROM information_schema.tables   WHERE table_catalog=?  AND table_schema='public'  AND table_type='BASE TABLE' UNION ALL  SELECT 1  FROM information_schema.sequences   WHERE sequence_catalog=?  AND sequence_schema='public')", new String[] { this.name, this.name });
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
/*     */   protected void hY() throws SQLException {
/*  78 */     this.a.a("CREATE DATABASE " + ((b)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  83 */     this.a.a("DROP DATABASE " + ((b)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/*  88 */     for (String str : aI()) {
/*  89 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  92 */     for (f f : a()) {
/*  93 */       f.drop();
/*     */     }
/*     */     
/*  96 */     for (String str : aJ()) {
/*  97 */       this.a.a(str, new Object[0]);
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
/*     */   private List<String> aI() throws SQLException {
/* 109 */     List list = this.a.a("SELECT table_name FROM information_schema.views WHERE table_catalog=? AND table_schema='public'", new String[] { this.name });
/*     */ 
/*     */     
/* 112 */     ArrayList<String> arrayList = new ArrayList();
/* 113 */     for (String str : list) {
/* 114 */       arrayList.add("DROP VIEW IF EXISTS " + ((b)this.a).d(new String[] { this.name, str }) + " CASCADE");
/*     */     } 
/*     */     
/* 117 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aJ() throws SQLException {
/* 128 */     List list = this.a.a("SELECT sequence_name FROM information_schema.sequences WHERE sequence_catalog=? AND sequence_schema='public'", new String[] { this.name });
/*     */ 
/*     */     
/* 131 */     ArrayList<String> arrayList = new ArrayList();
/* 132 */     for (String str : list) {
/* 133 */       arrayList.add("DROP SEQUENCE IF EXISTS " + ((b)this.a).d(new String[] { this.name, str }) + " CASCADE");
/*     */     } 
/*     */     
/* 136 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/*     */     String str;
/* 142 */     if (this.cB) {
/* 143 */       str = "SELECT table_name FROM information_schema.tables WHERE table_schema=? AND table_type='BASE TABLE'";
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */       
/* 151 */       str = "SELECT table_name FROM information_schema.tables WHERE table_catalog=? AND table_schema='public' AND table_type='BASE TABLE'";
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 161 */     List<String> list = this.a.a(str, new String[] { this.name });
/*     */ 
/*     */     
/* 164 */     f[] arrayOfF = new f[list.size()];
/* 165 */     for (byte b = 0; b < list.size(); b++) {
/* 166 */       arrayOfF[b] = new e(this.a, (b)this.a, this, list.get(b));
/*     */     }
/* 168 */     return arrayOfF;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/* 173 */     return new e(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\b\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */