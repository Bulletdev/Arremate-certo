/*     */ package br.com.arremate.l.q.a;
/*     */ 
/*     */ import br.com.arremate.i.a.c;
/*     */ import br.com.arremate.m.r;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.m.z;
/*     */ import java.awt.Component;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.RowSorter;
/*     */ import javax.swing.SortOrder;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.table.DefaultTableCellRenderer;
/*     */ import javax.swing.table.TableCellRenderer;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableModel;
/*     */ import javax.swing.table.TableRowSorter;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends JTable
/*     */ {
/*     */   public static final int bJ = 16;
/*     */   
/*     */   public b() {
/*  30 */     this(new c());
/*     */   }
/*     */   
/*     */   public b(c paramc) {
/*  34 */     setModel(paramc);
/*     */     
/*  36 */     cy();
/*  37 */     l();
/*  38 */     cz();
/*  39 */     cA();
/*  40 */     cB();
/*     */   }
/*     */ 
/*     */   
/*     */   private void cy() {
/*  45 */     setAutoCreateRowSorter(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void l() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(int paramInt, a parama) {
/*  58 */     String str1 = parama.b().cf();
/*     */     
/*  60 */     TableColumn tableColumn = getColumnModel().getColumn(3);
/*  61 */     int i = tableColumn.getWidth() - 6;
/*     */ 
/*     */     
/*  64 */     String str2 = y.a(i, getGraphics().getFontMetrics(), str1);
/*  65 */     parama.b().f(str2);
/*  66 */     int j = a(16, str2);
/*     */     
/*  68 */     if (j != getRowHeight(paramInt)) {
/*  69 */       setRowHeight(paramInt, j);
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
/*     */   private int a(int paramInt, String paramString) {
/*  81 */     int i = StringUtils.countMatches(paramString, "<br>");
/*  82 */     int j = i + 1;
/*     */     
/*  84 */     return paramInt * j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValueAt(int paramInt1, int paramInt2) {
/*  91 */     Object object = super.getValueAt(paramInt1, paramInt2);
/*     */     
/*  93 */     if (paramInt2 == 3) {
/*  94 */       int i = getRowSorter().convertRowIndexToModel(paramInt1);
/*  95 */       a a = ((c)getModel()).a(i);
/*  96 */       a(paramInt1, a);
/*     */     } 
/*     */     
/*  99 */     return object;
/*     */   }
/*     */   
/*     */   private void cz() {
/* 103 */     r r = new r(0);
/* 104 */     r.a((br.com.arremate.i.b)new c());
/*     */     
/* 106 */     getColumnModel().getColumn(0).setCellRenderer((TableCellRenderer)new r(0));
/* 107 */     getColumnModel().getColumn(1).setCellRenderer((TableCellRenderer)new r(0));
/* 108 */     getColumnModel().getColumn(2).setCellRenderer((TableCellRenderer)r);
/* 109 */     getColumnModel().getColumn(3).setCellRenderer((TableCellRenderer)new r(2));
/*     */     
/* 111 */     getColumnModel().getColumn(z.b.e.getIndex()).setHeaderRenderer(new DefaultTableCellRenderer(this)
/*     */         {
/*     */           public Component getTableCellRendererComponent(JTable param1JTable, Object param1Object, boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2) {
/* 114 */             DefaultTableCellRenderer defaultTableCellRenderer1 = (DefaultTableCellRenderer)super.getTableCellRendererComponent(param1JTable, param1Object, param1Boolean1, param1Boolean2, param1Int1, param1Int2);
/*     */             
/* 116 */             defaultTableCellRenderer1.setHorizontalAlignment(2);
/*     */             
/* 118 */             DefaultTableCellRenderer defaultTableCellRenderer2 = (DefaultTableCellRenderer)param1JTable.getTableHeader().getDefaultRenderer();
/*     */             
/* 120 */             defaultTableCellRenderer1.setForeground(defaultTableCellRenderer2.getForeground());
/* 121 */             defaultTableCellRenderer1.setBackground(defaultTableCellRenderer2.getBackground());
/* 122 */             defaultTableCellRenderer1.setBorder(defaultTableCellRenderer2.getBorder());
/* 123 */             return defaultTableCellRenderer1;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private void cA() {
/* 129 */     y.a(this, 0, 150);
/* 130 */     y.a(this, 1, 40);
/* 131 */     y.a(this, 2, 150);
/*     */   }
/*     */   
/*     */   private void cB() {
/* 135 */     SwingUtilities.invokeLater(() -> {
/*     */           TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<>(getModel());
/*     */           ArrayList<RowSorter.SortKey> arrayList = new ArrayList();
/*     */           arrayList.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
/*     */           tableRowSorter.setSortKeys(arrayList);
/*     */           tableRowSorter.setSortable(0, false);
/*     */           tableRowSorter.setSortable(1, false);
/*     */           tableRowSorter.setSortable(2, false);
/*     */           tableRowSorter.setSortable(3, false);
/*     */           setRowSorter(tableRowSorter);
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */