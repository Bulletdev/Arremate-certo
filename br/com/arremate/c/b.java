/*     */ package br.com.arremate.c;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.LinkedHashSet;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.DefaultListCellRenderer;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JTextField;
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
/*     */ public final class b
/*     */   extends JComboBox<Object>
/*     */ {
/*     */   private final JTextField a;
/*     */   private final DefaultComboBoxModel<Object> a;
/*     */   private final LinkedHashSet<Object> a;
/*     */   
/*     */   public b() {
/*  41 */     setName("comboBoxBuscaPregoes");
/*     */     
/*  43 */     this.a = (LinkedHashSet<Object>)getEditor().getEditorComponent();
/*  44 */     this.a = (LinkedHashSet<Object>)getModel();
/*  45 */     this.a = new LinkedHashSet();
/*  46 */     setEditable(true);
/*  47 */     f();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void f() {
/*  55 */     setRenderer(new DefaultListCellRenderer(this)
/*     */         {
/*     */           public Component getListCellRendererComponent(JList<?> param1JList, Object param1Object, int param1Int, boolean param1Boolean1, boolean param1Boolean2) {
/*  58 */             super.getListCellRendererComponent(param1JList, param1Object, param1Int, param1Boolean1, param1Boolean2);
/*  59 */             setText(param1Object.toString());
/*  60 */             return this;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  65 */     this.a.addKeyListener(new KeyAdapter(this)
/*     */         {
/*     */           public void keyReleased(KeyEvent param1KeyEvent) {
/*  68 */             if (param1KeyEvent.getKeyCode() == 10) {
/*  69 */               if (this.a.isPopupVisible()) {
/*  70 */                 this.a.hidePopup();
/*     */               }
/*  72 */             } else if (param1KeyEvent.getKeyCode() != 40 && param1KeyEvent.getKeyCode() != 38) {
/*  73 */               String str = b.a(this.a).getText();
/*     */               
/*  75 */               b.a(this.a).removeAllElements();
/*     */               
/*  77 */               b.a(this.a).stream().filter(param1Object -> param1Object.toString().toLowerCase().contains(param1String.toLowerCase()))
/*     */                 
/*  79 */                 .forEachOrdered(param1Object -> b.a(this.a).addElement(param1Object));
/*     */ 
/*     */ 
/*     */               
/*  83 */               b.a(this.a).setSelectedItem(str);
/*     */               
/*  85 */               if (str.isEmpty() && this.a.isPopupVisible()) {
/*  86 */                 this.a.hidePopup();
/*  87 */               } else if (!this.a.isPopupVisible()) {
/*  88 */                 this.a.showPopup();
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addItem(Object paramObject) {
/* 102 */     this.a.addElement(paramObject);
/* 103 */     this.a.add(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JTextField a() {
/* 112 */     return (JTextField)this.a;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */