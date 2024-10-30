/*     */ package org.c.a.b.e.g;
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
/*  37 */     super(paramd, paramb, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/*  42 */     return (this.a.b("SELECT COUNT(*) FROM systables where owner = ? and tabid > 99", new String[] { this.name }) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/*  47 */     return ((b()).length == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hY() {}
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  56 */     clean();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/*  61 */     List list1 = this.a.a("SELECT t.procname FROM \"informix\".sysprocedures AS t WHERE t.owner=? AND t.mode='O' AND t.externalname IS NULL AND t.procname NOT IN ( 'tscontainerusage', 'tscontainertotalused', 'tscontainertotalpages', 'tscontainernelems', 'tscontainerpctused', 'tsl_flushstatus', 'tsmakenullstamp')", new String[] { this.name });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     for (String str : list1) {
/*  69 */       this.a.a("DROP PROCEDURE " + str, new Object[0]);
/*     */     }
/*     */     
/*  72 */     for (f f : a()) {
/*  73 */       f.drop();
/*     */     }
/*     */     
/*  76 */     List list2 = this.a.a("SELECT t.tabname FROM \"informix\".systables AS t WHERE owner=? AND t.tabid > 99 AND t.tabtype='Q' AND t.tabname NOT IN ('iot_data_seq')", new String[] { this.name });
/*     */ 
/*     */     
/*  79 */     for (String str : list2) {
/*  80 */       this.a.a("DROP SEQUENCE " + str, new Object[0]);
/*     */     }
/*     */   }
/*     */   
/*     */   private f[] a(String paramString, String... paramVarArgs) throws SQLException {
/*  85 */     List<String> list = this.a.a(paramString, paramVarArgs);
/*  86 */     f[] arrayOfF = new f[list.size()];
/*  87 */     for (byte b = 0; b < list.size(); b++) {
/*  88 */       arrayOfF[b] = new e(this.a, (b)this.a, this, list.get(b));
/*     */     }
/*  90 */     return arrayOfF;
/*     */   }
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/*  95 */     return a("SELECT t.tabname FROM \"informix\".systables AS t WHERE owner=? AND t.tabid > 99 AND t.tabtype='T' AND t.tabname NOT IN ( 'calendarpatterns', 'calendartable', 'tscontainertable', 'tscontainerwindowtable', 'tsinstancetable',  'tscontainerusageactivewindowvti', 'tscontainerusagedormantwindowvti')", new String[] { this.name });
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
/*     */   public f a(String paramString) {
/* 107 */     return new e(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\g\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */