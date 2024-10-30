/*    */ package br.com.arremate.c.a;
/*    */ 
/*    */ import br.com.arremate.m.y;
/*    */ import java.awt.Cursor;
/*    */ import java.awt.Font;
/*    */ import java.awt.event.MouseAdapter;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseMotionAdapter;
/*    */ import java.awt.font.TextAttribute;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ 
/*    */ 
/*    */ public class g
/*    */   extends JPanel
/*    */ {
/*    */   private String url;
/*    */   private JLabel o;
/*    */   
/*    */   public g() {
/* 26 */     k();
/*    */   }
/*    */   
/*    */   public void setUrl(String paramString) {
/* 30 */     this.url = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void k() {
/* 37 */     this.o = new JLabel();
/*    */     
/* 39 */     this.o.setText("?");
/* 40 */     this.o.setToolTipText("Para saber mais sobre estas configurações, clique aqui!");
/* 41 */     this.o.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(0, 3, 1, 3)));
/* 42 */     this.o.addMouseMotionListener(new MouseMotionAdapter(this) {
/*    */           public void mouseMoved(MouseEvent param1MouseEvent) {
/* 44 */             g.a(this.a, param1MouseEvent);
/*    */           }
/*    */         });
/* 47 */     this.o.addMouseListener(new MouseAdapter(this) {
/*    */           public void mouseClicked(MouseEvent param1MouseEvent) {
/* 49 */             g.b(this.a, param1MouseEvent);
/*    */           }
/*    */           public void mouseExited(MouseEvent param1MouseEvent) {
/* 52 */             g.c(this.a, param1MouseEvent);
/*    */           }
/*    */         });
/*    */     
/* 56 */     GroupLayout groupLayout = new GroupLayout(this);
/* 57 */     setLayout(groupLayout);
/* 58 */     groupLayout.setHorizontalGroup(groupLayout
/* 59 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 60 */         .addComponent(this.o));
/*    */     
/* 62 */     groupLayout.setVerticalGroup(groupLayout
/* 63 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 64 */         .addComponent(this.o));
/*    */   }
/*    */ 
/*    */   
/*    */   private void a(MouseEvent paramMouseEvent) {
/* 69 */     y.l(this.url);
/*    */   }
/*    */   
/*    */   private void b(MouseEvent paramMouseEvent) {
/* 73 */     setCursor(new Cursor(0));
/* 74 */     Font font = new Font(this.o.getFont().getName(), 1, this.o.getFont().getSize());
/* 75 */     this.o.setFont(font);
/*    */   }
/*    */   
/*    */   private void c(MouseEvent paramMouseEvent) {
/* 79 */     setCursor(new Cursor(12));
/* 80 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 81 */     hashMap.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
/* 82 */     Font font = this.o.getFont().deriveFont((Map)hashMap);
/* 83 */     this.o.setFont(font);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\a\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */