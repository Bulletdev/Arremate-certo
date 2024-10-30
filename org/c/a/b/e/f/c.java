/*     */ package org.c.a.b.e.f;
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
/*  43 */     return (this.a.b("SELECT COUNT (*) FROM information_schema.system_schemas WHERE table_schem=?", new String[] { this.name }) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/*  48 */     return ((a()).length == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hY() throws SQLException {
/*  53 */     String str = this.a.b("SELECT USER() FROM (VALUES(0))", new String[0]);
/*  54 */     this.a.a("CREATE SCHEMA " + ((b)this.a).d(new String[] { this.name }, ) + " AUTHORIZATION " + str, new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  59 */     this.a.a("DROP SCHEMA " + ((b)this.a).d(new String[] { this.name }, ) + " CASCADE", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/*  64 */     for (f f : a()) {
/*  65 */       f.drop();
/*     */     }
/*     */     
/*  68 */     for (String str : aJ()) {
/*  69 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aJ() throws SQLException {
/*  80 */     List list = this.a.a("SELECT SEQUENCE_NAME FROM INFORMATION_SCHEMA.SYSTEM_SEQUENCES where SEQUENCE_SCHEMA = ?", new String[] { this.name });
/*     */ 
/*     */     
/*  83 */     ArrayList<String> arrayList = new ArrayList();
/*  84 */     for (String str : list) {
/*  85 */       arrayList.add("DROP SEQUENCE " + ((b)this.a).d(new String[] { this.name, str }));
/*     */     } 
/*     */     
/*  88 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/*  93 */     List<String> list = this.a.a("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.SYSTEM_TABLES where TABLE_SCHEM = ? AND TABLE_TYPE = 'TABLE'", new String[] { this.name });
/*     */ 
/*     */     
/*  96 */     f[] arrayOfF = new f[list.size()];
/*  97 */     for (byte b = 0; b < list.size(); b++) {
/*  98 */       arrayOfF[b] = new e(this.a, (b)this.a, this, list.get(b));
/*     */     }
/* 100 */     return arrayOfF;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/* 105 */     return new e(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\f\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */