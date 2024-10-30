/*     */ package br.com.arremate.l.q.c;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class n
/*     */   extends AbstractTableModel
/*     */ {
/*     */   private final List<f> C;
/*     */   private final Class[] a;
/*     */   private final String[] columnNames;
/*     */   
/*     */   protected n(String[] paramArrayOfString, Class[] paramArrayOfClass) {
/*  18 */     this.C = new ArrayList<>();
/*  19 */     this.columnNames = paramArrayOfString;
/*  20 */     this.a = paramArrayOfClass;
/*     */   }
/*     */   
/*     */   public void a(f paramf) {
/*     */     try {
/*  25 */       if (paramf == null || M().stream().anyMatch(paramf2 -> (paramf2.b().v() == paramf1.b().v()))) {
/*     */         return;
/*     */       }
/*     */       
/*  29 */       M().add(paramf);
/*  30 */       fireTableDataChanged();
/*  31 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(int paramInt) {
/*  36 */     if (paramInt >= getRowCount() || paramInt < 0) {
/*  37 */       return null;
/*     */     }
/*  39 */     return M().get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValueAt(int paramInt1, int paramInt2) {
/*  44 */     f f = a(paramInt1);
/*     */     
/*  46 */     if (f != null) {
/*  47 */       return f.toArray()[paramInt2];
/*     */     }
/*  49 */     return null;
/*     */   }
/*     */   
/*     */   public int a(f paramf) {
/*  53 */     if (paramf == null) {
/*  54 */       return -1;
/*     */     }
/*  56 */     return M().indexOf(paramf);
/*     */   }
/*     */   
/*     */   public f b(int paramInt) {
/*  60 */     for (f f : M()) {
/*  61 */       if (f.b().v() == paramInt) {
/*  62 */         return f;
/*     */       }
/*     */     } 
/*  65 */     return null;
/*     */   }
/*     */   
/*     */   public f a(String paramString) {
/*  69 */     for (f f : M()) {
/*  70 */       if (f.b().bo().equals(paramString)) {
/*  71 */         return f;
/*     */       }
/*     */     } 
/*  74 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cH() {
/*  81 */     M().parallelStream().forEach(paramf -> {
/*     */           if (!paramf.h().ba()) {
/*     */             paramf.S(true);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/*  90 */     return M().size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCellEditable(int paramInt1, int paramInt2) {
/*  95 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getColumnClass(int paramInt) {
/* 100 */     return this.a[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColumnName(int paramInt) {
/* 105 */     if (paramInt >= getColumnCount()) {
/* 106 */       return "";
/*     */     }
/* 108 */     return this.columnNames[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumnCount() {
/* 114 */     return this.columnNames.length;
/*     */   }
/*     */   
/*     */   public List<f> M() {
/* 118 */     return this.C;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 122 */     M().clear();
/* 123 */     fireTableDataChanged();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */