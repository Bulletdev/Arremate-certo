/*     */ package br.com.arremate.l.q.a;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends AbstractTableModel
/*     */ {
/*     */   public static final int bK = 0;
/*     */   public static final int bL = 1;
/*     */   public static final int bM = 2;
/*     */   public static final int bN = 3;
/*     */   private final List<a> C;
/*  19 */   private final String[] columnNames = new String[] { "Quem fala?", "Item", "Data/Hora", "Descrição" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  25 */   private final Class[] a = new Class[] { String.class, String.class, Long.class, String.class };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c() {
/*  33 */     this.C = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public void a(a parama) {
/*  37 */     if (parama != null) {
/*  38 */       (new Thread(() -> {
/*     */             synchronized (this) {
/*     */               String str = parama.b().j().replace("<b>", "[b]").replace("</b>", "[/b]").replace("<u>", "[u]").replace("</u>", "[/u]").replace("<i>", "[i]").replace("</i>", "[/i]").replace("<strong>", "[strong]").replace("</strong>", "[/strong]").replaceAll("\\<[^\\>]*\\>", "").replace("[b]", "<b>").replace("[/b]", "</b>").replace("[u]", "<u>").replace("[/u]", "</u>").replace("[i]", "<i>").replace("[/i]", "</i>").replace("[strong]", "<strong>").replace("[/strong]", "</strong>");
/*     */ 
/*     */ 
/*     */               
/*     */               parama.b().f(str);
/*     */ 
/*     */ 
/*     */               
/*     */               this.C.add(parama);
/*     */ 
/*     */ 
/*     */               
/*     */               fireTableDataChanged();
/*     */             } 
/*  54 */           })).start();
/*     */     }
/*     */   }
/*     */   
/*     */   public a a(int paramInt) {
/*  59 */     if (paramInt >= getRowCount() || paramInt < 0) {
/*  60 */       return null;
/*     */     }
/*     */     
/*  63 */     return this.C.get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValueAt(int paramInt1, int paramInt2) {
/*  68 */     a a = a(paramInt1);
/*     */     
/*  70 */     if (a != null) {
/*  71 */       return a.toArray()[paramInt2];
/*     */     }
/*     */     
/*  74 */     return null;
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
/*  89 */     this.C.clear();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCellEditable(int paramInt1, int paramInt2) {
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getColumnClass(int paramInt) {
/* 116 */     return this.a[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/* 121 */     return this.C.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnCount() {
/* 126 */     return this.columnNames.length;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */