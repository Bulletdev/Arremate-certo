/*     */ package br.com.arremate.l.q;
/*     */ 
/*     */ import br.com.arremate.l.p.g;
/*     */ import br.com.arremate.l.p.h;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends AbstractTableModel
/*     */ {
/*     */   public static final int bE = 0;
/*     */   private final g b;
/*     */   private final String[] columnNames;
/*     */   private final Class[] a;
/*     */   
/*     */   public b(g paramg) {
/*  21 */     this.columnNames = new String[] { "Data/Hora", "Descrição", "Visibilidade" };
/*  22 */     this.a = new Class[] { Long.class, String.class, Boolean.class };
/*  23 */     this.b = paramg;
/*     */   }
/*     */   
/*     */   public synchronized void e(h paramh) {
/*  27 */     if (paramh == null) {
/*     */       return;
/*     */     }
/*     */     
/*  31 */     (new Thread(() -> f(paramh)))
/*     */       
/*  33 */       .start();
/*     */   }
/*     */   
/*     */   private synchronized void f(h paramh) {
/*     */     try {
/*  38 */       this.b.d(paramh);
/*  39 */       fireTableRowsInserted(0, 0);
/*  40 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public void cx() {
/*  45 */     fireTableDataChanged();
/*     */   }
/*     */   
/*     */   public h b(int paramInt) {
/*  49 */     if (paramInt >= getRowCount()) {
/*  50 */       return null;
/*     */     }
/*     */     
/*  53 */     return this.b.a(paramInt);
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
/*     */   public Object getValueAt(int paramInt1, int paramInt2) {
/*  66 */     h h = b(paramInt1);
/*     */     
/*  68 */     if (h != null) {
/*  69 */       switch (paramInt2) {
/*     */         case 0:
/*  71 */           return Long.valueOf(h.b().getTime());
/*     */         case 1:
/*  73 */           return h.j();
/*     */         case 2:
/*  75 */           return Boolean.valueOf(h.bp());
/*     */       } 
/*  77 */       return null;
/*     */     } 
/*     */     
/*  80 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueAt(Object paramObject, int paramInt1, int paramInt2) {}
/*     */ 
/*     */   
/*     */   public void clear() {
/*  89 */     this.b.clear();
/*  90 */     fireTableDataChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColumnName(int paramInt) {
/*  95 */     if (paramInt >= getColumnCount()) {
/*  96 */       return "";
/*     */     }
/*  98 */     return this.columnNames[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCellEditable(int paramInt1, int paramInt2) {
/* 104 */     return (paramInt2 == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getColumnClass(int paramInt) {
/* 109 */     return this.a[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/* 114 */     return this.b.F().size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnCount() {
/* 119 */     return this.columnNames.length;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */