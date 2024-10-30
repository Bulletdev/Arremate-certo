/*     */ package br.com.arremate.l.q;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */   extends AbstractTableModel
/*     */ {
/*     */   public static final int bF = 3;
/*     */   public static final int bG = 0;
/*     */   public static final int bH = 1;
/*     */   public static final int bI = 2;
/*     */   private final List<c> C;
/*     */   private final String[] columnNames;
/*     */   private final Class[] a;
/*     */   
/*     */   public d() {
/*  25 */     this(new String[] { "Posição", "Data/Hora", "Valor Lance" }, new Class[] { Integer.class, Date.class, Double.class });
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
/*     */   public d(String[] paramArrayOfString, Class[] paramArrayOfClass) {
/*  37 */     this.C = new ArrayList<>();
/*  38 */     this.columnNames = paramArrayOfString;
/*  39 */     this.a = paramArrayOfClass;
/*     */   }
/*     */   
/*     */   public void a(c paramc) {
/*  43 */     if (paramc != null) {
/*  44 */       this.C.add(paramc);
/*     */       
/*  46 */       fireTableRowsInserted(this.C.size() - 1, this.C.size() - 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public c a(int paramInt) {
/*  51 */     if (paramInt >= getRowCount() || paramInt < 0) {
/*  52 */       return null;
/*     */     }
/*     */     
/*  55 */     return this.C.get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValueAt(int paramInt1, int paramInt2) {
/*  60 */     c c = a(paramInt1);
/*     */     
/*  62 */     if (c != null) {
/*  63 */       return c.toArray()[paramInt2];
/*     */     }
/*     */     
/*  66 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueAt(Object paramObject, int paramInt1, int paramInt2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  81 */     this.C.clear();
/*  82 */     fireTableDataChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColumnName(int paramInt) {
/*  87 */     if (paramInt >= getColumnCount()) {
/*  88 */       return "";
/*     */     }
/*  90 */     return this.columnNames[paramInt];
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
/*     */   public boolean isCellEditable(int paramInt1, int paramInt2) {
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getColumnClass(int paramInt) {
/* 108 */     return this.a[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/* 113 */     return this.C.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnCount() {
/* 118 */     return this.columnNames.length;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */