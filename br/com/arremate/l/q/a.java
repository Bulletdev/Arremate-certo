/*     */ package br.com.arremate.l.q;
/*     */ 
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.l.j;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import javax.swing.table.AbstractTableModel;
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
/*     */ public class a
/*     */   extends AbstractTableModel
/*     */ {
/*  25 */   private final String[] columnNames = new String[] { "", "Situação", "Número", "UASG", "Órgão", "Data Abertura", "Modalidade", "Modo Disputa", "SRP", "ICMS", "Observações" };
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
/*  39 */   private final Class[] a = new Class[] { Boolean.class, String.class, String.class, Integer.class, String.class, String.class, l.class, m.class, Boolean.class, Boolean.class, String.class };
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
/*  53 */   private final List<j> C = new ArrayList<>();
/*     */   public static final int bE = 0;
/*     */   
/*     */   public void b(j paramj, boolean paramBoolean) {
/*  57 */     paramj.ac = paramBoolean;
/*  58 */     q(paramj);
/*     */   }
/*     */   
/*     */   public void q(j paramj) {
/*  62 */     if (paramj != null) {
/*  63 */       this.C.add(paramj);
/*     */     }
/*     */     
/*  66 */     fireTableDataChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/*  71 */     return this.C.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnCount() {
/*  76 */     return this.columnNames.length;
/*     */   }
/*     */   
/*     */   public j a(int paramInt) {
/*  80 */     if (paramInt >= getRowCount()) {
/*  81 */       return null;
/*     */     }
/*     */     
/*  84 */     return this.C.get(paramInt);
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
/*     */   public Object getValueAt(int paramInt1, int paramInt2) {
/*  96 */     j j = a(paramInt1);
/*  97 */     if (j != null) {
/*  98 */       return j.a()[paramInt2];
/*     */     }
/* 100 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueAt(Object paramObject, int paramInt1, int paramInt2) {
/* 106 */     if (isCellEditable(paramInt1, paramInt2)) {
/* 107 */       j j = a(paramInt1);
/*     */       
/* 109 */       if (j != null) {
/* 110 */         switch (paramInt2) {
/*     */           case 0:
/* 112 */             if (paramObject instanceof Boolean) {
/* 113 */               j.ac = ((Boolean)paramObject).booleanValue();
/*     */             }
/*     */             break;
/*     */         } 
/*     */       
/*     */       }
/*     */     } 
/* 120 */     fireTableDataChanged();
/*     */   }
/*     */   
/*     */   public void clear() {
/* 124 */     this.C.clear();
/* 125 */     fireTableDataChanged();
/*     */   }
/*     */   
/*     */   public boolean g(int paramInt) {
/* 129 */     if (paramInt >= getRowCount()) {
/* 130 */       return false;
/*     */     }
/* 132 */     return (a(paramInt)).ac;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getColumnName(int paramInt) {
/* 138 */     if (paramInt >= getColumnCount()) {
/* 139 */       return "";
/*     */     }
/* 141 */     return this.columnNames[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCellEditable(int paramInt1, int paramInt2) {
/* 147 */     return (paramInt2 == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getColumnClass(int paramInt) {
/* 152 */     return this.a[paramInt];
/*     */   }
/*     */   
/*     */   public void removeRow(int paramInt) {
/* 156 */     if (paramInt < getRowCount()) {
/* 157 */       this.C.remove(paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public ListIterator<j> getListIterator() {
/* 162 */     return this.C.listIterator();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */