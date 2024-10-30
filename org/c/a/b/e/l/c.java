/*     */ package org.c.a.b.e.l;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends d<b>
/*     */ {
/*     */   c(d paramd, b paramb, String paramString) {
/*  38 */     super(paramd, paramb, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/*  43 */     return (this.a.b("SELECT COUNT(*) FROM SYS.SCHEMAS WHERE SCHEMA_NAME=?", new String[] { this.name }) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/*  48 */     int i = this.a.b("select count(*) from sys.tables where schema_name = ?", new String[] { this.name });
/*  49 */     i += this.a.b("select count(*) from sys.views where schema_name = ?", new String[] { this.name });
/*  50 */     i += this.a.b("select count(*) from sys.sequences where schema_name = ?", new String[] { this.name });
/*  51 */     i += this.a.b("select count(*) from sys.synonyms where schema_name = ?", new String[] { this.name });
/*  52 */     return (i == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hY() throws SQLException {
/*  57 */     this.a.a("CREATE SCHEMA " + ((b)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  62 */     clean();
/*  63 */     this.a.a("DROP SCHEMA " + ((b)this.a).d(new String[] { this.name }, ) + " RESTRICT", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/*  68 */     for (String str : g("SYNONYM")) {
/*  69 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  72 */     for (String str : g("VIEW")) {
/*  73 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  76 */     for (String str : g("TABLE")) {
/*  77 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  80 */     for (String str : g("SEQUENCE")) {
/*  81 */       this.a.a(str, new Object[0]);
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
/*     */   private List<String> g(String paramString) throws SQLException {
/*  93 */     ArrayList<String> arrayList = new ArrayList();
/*  94 */     List<String> list = h(paramString);
/*  95 */     for (String str : list) {
/*  96 */       arrayList.add("DROP " + paramString + " " + ((b)this.a).d(new String[] { this.name, str }) + " CASCADE");
/*     */     } 
/*  98 */     return arrayList;
/*     */   }
/*     */   
/*     */   private List<String> h(String paramString) throws SQLException {
/* 102 */     return this.a.a("select " + paramString + "_NAME from SYS." + paramString + "S where SCHEMA_NAME = ?", new String[] { this.name });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/* 108 */     List<String> list = h("TABLE");
/* 109 */     f[] arrayOfF = new f[list.size()];
/* 110 */     for (byte b = 0; b < list.size(); b++) {
/* 111 */       arrayOfF[b] = new f(this.a, (b)this.a, this, list.get(b));
/*     */     }
/* 113 */     return arrayOfF;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/* 118 */     return new f(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\l\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */