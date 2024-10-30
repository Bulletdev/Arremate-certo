/*    */ package br.com.arremate.l.q.c;
/*    */ 
/*    */ import br.com.arremate.m.y;
/*    */ import java.awt.Font;
/*    */ import java.util.Map;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.RowFilter;
/*    */ import javax.swing.RowSorter;
/*    */ import javax.swing.table.TableModel;
/*    */ import javax.swing.table.TableRowSorter;
/*    */ import org.apache.commons.lang3.SystemUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class k
/*    */   extends JTable
/*    */ {
/*    */   private final TableRowSorter<TableModel> a;
/*    */   
/*    */   protected k(n paramn) {
/* 27 */     setModel(paramn);
/* 28 */     this.a = new TableRowSorter<>(paramn);
/* 29 */     super.setRowSorter(this.a);
/*    */     
/* 31 */     cy();
/* 32 */     l();
/* 33 */     cz();
/* 34 */     cA();
/* 35 */     cB();
/* 36 */     cG();
/*    */     
/* 38 */     if (SystemUtils.IS_OS_MAC) {
/* 39 */       Font font = getFont();
/* 40 */       font = new Font(font.getName(), font.getStyle(), font.getSize() - 1);
/* 41 */       setFont(font);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void cy() {
/* 46 */     setAutoCreateRowSorter(false);
/* 47 */     setName("itensEncerradosTable");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void c(Map<Integer, Integer> paramMap) {
/* 75 */     paramMap.keySet().forEach(paramInteger -> y.a(this, paramInteger.intValue(), ((Integer)paramMap.get(paramInteger)).intValue()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void a(RowFilter<TableModel, Object> paramRowFilter) {
/* 81 */     this.a.setRowFilter((RowFilter)paramRowFilter);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRowSorter(RowSorter<? extends TableModel> paramRowSorter) {}
/*    */ 
/*    */   
/*    */   protected TableRowSorter<TableModel> a() {
/* 90 */     return this.a;
/*    */   }
/*    */   
/*    */   protected abstract void l();
/*    */   
/*    */   protected abstract void cz();
/*    */   
/*    */   protected abstract void cA();
/*    */   
/*    */   protected abstract void cB();
/*    */   
/*    */   protected abstract void cG();
/*    */   
/*    */   protected abstract void p(int paramInt);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */