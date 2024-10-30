/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import br.com.arremate.f.s;
/*    */ import br.com.arremate.i.a.d;
/*    */ import br.com.arremate.i.b;
/*    */ import br.com.arremate.l.q.b.e;
/*    */ import br.com.arremate.l.q.b.i;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Font;
/*    */ import java.awt.font.TextAttribute;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.swing.JTable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class x
/*    */   extends r
/*    */ {
/*    */   public x(int paramInt) {
/* 28 */     super(paramInt);
/* 29 */     a((b)new d());
/*    */   }
/*    */ 
/*    */   
/*    */   public Component getTableCellRendererComponent(JTable paramJTable, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2) {
/* 34 */     Component component = super.getTableCellRendererComponent(paramJTable, paramObject, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
/*    */     
/* 36 */     if (paramJTable.getModel() instanceof i) {
/* 37 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 38 */       String str = "";
/* 39 */       boolean bool = true;
/*    */       
/* 41 */       if (paramInt2 == 13 && 
/* 42 */         n.aE()) {
/* 43 */         hashMap.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
/* 44 */         str = "Clique aqui para exibir os 5 melhores lances para o item";
/*    */       } 
/*    */       
/* 47 */       e e = ((i)paramJTable.getModel()).b(paramJTable.convertRowIndexToModel(paramInt1));
/*    */ 
/*    */       
/* 50 */       s s = e.a();
/*    */ 
/*    */       
/* 53 */       switch (null.j[s.ordinal()]) {
/*    */         case 1:
/* 55 */           component.setForeground(y.e());
/*    */           break;
/*    */         case 2:
/* 58 */           component.setForeground(new Color(213, 157, 0));
/*    */           break;
/*    */         case 3:
/* 61 */           component.setForeground(y.f());
/*    */           break;
/*    */         default:
/* 64 */           component.setForeground(Color.BLACK);
/* 65 */           bool = false;
/*    */           break;
/*    */       } 
/*    */       
/* 69 */       if (!str.isEmpty()) {
/* 70 */         setToolTipText(str);
/*    */       }
/*    */       
/* 73 */       Font font = bool ? new Font("Dialog", 1, 12) : new Font("Dialog", 0, 12);
/*    */ 
/*    */ 
/*    */       
/* 77 */       component.setFont(font.deriveFont((Map)hashMap));
/*    */     } 
/*    */     
/* 80 */     return component;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */