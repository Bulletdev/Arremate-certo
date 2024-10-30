/*     */ package org.c.a.b.e.o;
/*     */ 
/*     */ import java.sql.SQLException;
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
/*     */ public class c
/*     */   extends d<b>
/*     */ {
/*     */   c(d paramd, b paramb, String paramString) {
/*  30 */     super(paramd, paramb, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/*  36 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/*  43 */     return (this.a.b("select count(*) from sysobjects ob where (ob.type='U' or ob.type = 'V' or ob.type = 'P' or ob.type = 'TR') and ob.name != 'sysquerymetrics'", new String[0]) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hY() throws SQLException {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  54 */     ia();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/*  65 */     bF("V");
/*     */     
/*  67 */     bF("U");
/*     */     
/*  69 */     bF("P");
/*     */     
/*  71 */     bF("TR");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/*  77 */     List<String> list = aY();
/*     */     
/*  79 */     f[] arrayOfF = new f[list.size()];
/*     */     
/*  81 */     for (byte b = 0; b < list.size(); b++) {
/*  82 */       String str = list.get(b);
/*  83 */       arrayOfF[b] = new f(this.a, (b)this.a, this, str);
/*     */     } 
/*     */     
/*  86 */     return arrayOfF;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/*  91 */     return new f(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aY() throws SQLException {
/*  98 */     return this.a.a("select ob.name from sysobjects ob where ob.type=? order by ob.name", new String[] { "U" });
/*     */   }
/*     */ 
/*     */   
/*     */   private void bF(String paramString) throws SQLException {
/* 103 */     List list = this.a.a("select ob.name from sysobjects ob where ob.type=? order by ob.name", new String[] { paramString });
/*     */ 
/*     */     
/* 106 */     for (String str1 : list) {
/*     */       String str2;
/*     */       
/* 109 */       if ("U".equals(paramString)) {
/* 110 */         str2 = "drop table ";
/* 111 */       } else if ("V".equals(paramString)) {
/* 112 */         str2 = "drop view ";
/* 113 */       } else if ("P".equals(paramString)) {
/*     */         
/* 115 */         str2 = "drop procedure ";
/* 116 */       } else if ("TR".equals(paramString)) {
/* 117 */         str2 = "drop trigger ";
/*     */       } else {
/* 119 */         throw new IllegalArgumentException("Unknown database object type " + paramString);
/*     */       } 
/*     */       
/* 122 */       this.a.a(str2 + str1, new Object[0]);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\o\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */