/*     */ package org.c.a.b.e.m;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.b.e.a.b;
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
/*     */ public class c
/*     */   extends d<b>
/*     */ {
/*  33 */   private static final a a = org.c.a.a.f.c.b(c.class);
/*     */ 
/*     */   
/*  36 */   private static final List<String> al = Arrays.asList(new String[] { "android_metadata", "sqlite_sequence" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   c(d paramd, b paramb, String paramString) {
/*  46 */     super(paramd, paramb, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/*     */     try {
/*  52 */       b();
/*  53 */       return true;
/*  54 */     } catch (SQLException sQLException) {
/*  55 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/*  61 */     f[] arrayOfF = a();
/*  62 */     ArrayList<String> arrayList = new ArrayList();
/*  63 */     for (f f : arrayOfF) {
/*  64 */       String str = f.getName();
/*  65 */       if (!al.contains(str)) {
/*  66 */         arrayList.add(str);
/*     */       }
/*     */     } 
/*  69 */     return arrayList.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hY() throws SQLException {
/*  74 */     a.info("SQLite does not support creating schemas. Schema not created: " + this.name);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  79 */     a.info("SQLite does not support dropping schemas. Schema not dropped: " + this.name);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/*  84 */     List list = this.a.a("SELECT tbl_name FROM " + ((b)this.a).d(new String[] { this.name }, ) + ".sqlite_master WHERE type='view'", new String[0]);
/*  85 */     for (String str : list) {
/*  86 */       this.a.a("DROP VIEW " + ((b)this.a).d(new String[] { this.name, str }, ), new Object[0]);
/*     */     } 
/*     */     
/*  89 */     for (f f : a()) {
/*  90 */       f.drop();
/*     */     }
/*     */     
/*  93 */     if (a("sqlite_sequence").exists()) {
/*  94 */       this.a.a("DELETE FROM sqlite_sequence", new Object[0]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/* 100 */     List<String> list = this.a.a("SELECT tbl_name FROM " + ((b)this.a).d(new String[] { this.name }, ) + ".sqlite_master WHERE type='table'", new String[0]);
/*     */     
/* 102 */     f[] arrayOfF = new f[list.size()];
/* 103 */     for (byte b = 0; b < list.size(); b++) {
/* 104 */       arrayOfF[b] = new e((d)this.a, (b)this.a, this, list.get(b));
/*     */     }
/* 106 */     return arrayOfF;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/* 111 */     return new e((d)this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\m\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */