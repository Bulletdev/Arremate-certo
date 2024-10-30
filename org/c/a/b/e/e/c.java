/*     */ package org.c.a.b.e.e;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.e.a.f;
/*     */ import org.c.a.b.h.d;
/*     */ import org.c.a.b.r.n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   c(d paramd, b paramb, String paramString) {
/*  43 */     super(paramd, paramb, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/*  48 */     return (this.a.b("SELECT COUNT(*) FROM INFORMATION_SCHEMA.schemata WHERE schema_name=?", new String[] { this.name }) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fC() {
/*  53 */     return ((a()).length == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hY() throws SQLException {
/*  58 */     this.a.a("CREATE SCHEMA " + ((b)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  63 */     this.a.a("DROP SCHEMA " + ((b)this.a).d(new String[] { this.name
/*  64 */           }, ) + (((b)this.a).cC ? " CASCADE" : ""), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/*  69 */     for (f f : a()) {
/*  70 */       f.drop();
/*     */     }
/*     */     
/*  73 */     List<String> list1 = e("SEQUENCE", "IS_GENERATED = false");
/*  74 */     for (String str : a("SEQUENCE", list1)) {
/*  75 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  78 */     List<String> list2 = e("CONSTANT", "");
/*  79 */     for (String str : a("CONSTANT", list2)) {
/*  80 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  83 */     List<String> list3 = e("DOMAIN", "");
/*  84 */     if (!list3.isEmpty()) {
/*  85 */       if (this.name.equals(((a)((b)this.a).a()).a().getName())) {
/*  86 */         for (String str : b("DOMAIN", list3)) {
/*  87 */           this.a.a(str, new Object[0]);
/*     */         }
/*     */       } else {
/*  90 */         a.error("Unable to drop DOMAIN objects in schema " + ((b)this.a).d(new String[] { this.name }) + " due to H2 bug! (More info: http://code.google.com/p/h2database/issues/detail?id=306)");
/*     */       } 
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
/*     */   
/*     */   private List<String> a(String paramString, List<String> paramList) {
/* 104 */     ArrayList<String> arrayList = new ArrayList();
/* 105 */     for (String str1 : paramList) {
/*     */       
/* 107 */       String str2 = "DROP " + paramString + ((b)this.a).d(new String[] { this.name, str1 });
/*     */       
/* 109 */       arrayList.add(str2);
/*     */     } 
/* 111 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> b(String paramString, List<String> paramList) {
/* 122 */     ArrayList<String> arrayList = new ArrayList();
/* 123 */     for (String str1 : paramList) {
/*     */       
/* 125 */       String str2 = "DROP " + paramString + ((b)this.a).d(new String[] { str1 });
/*     */       
/* 127 */       arrayList.add(str2);
/*     */     } 
/* 129 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/* 134 */     List<String> list = e("TABLE", "TABLE_TYPE = 'TABLE'");
/*     */     
/* 136 */     f[] arrayOfF = new f[list.size()];
/* 137 */     for (byte b = 0; b < list.size(); b++) {
/* 138 */       arrayOfF[b] = new f((d)this.a, (b)this.a, this, list.get(b));
/*     */     }
/* 140 */     return arrayOfF;
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
/*     */   private List<String> e(String paramString1, String paramString2) throws SQLException {
/* 152 */     String str = "SELECT " + paramString1 + "_NAME FROM INFORMATION_SCHEMA." + paramString1 + "s WHERE " + paramString1 + "_schema = ?";
/* 153 */     if (n.W(paramString2)) {
/* 154 */       str = str + " AND " + paramString2;
/*     */     }
/*     */     
/* 157 */     return this.a.a(str, new String[] { this.name });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/* 163 */     return new f((d)this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\e\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */