/*     */ package br.com.arremate.c;
/*     */ 
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.l.n;
/*     */ import br.com.arremate.l.p.j;
/*     */ import br.com.arremate.m.h;
/*     */ import br.com.arremate.m.l;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.HashMap;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.ListCellRenderer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends JComboBox
/*     */ {
/*  22 */   private final HashMap<Integer, n> a = new HashMap<>();
/*     */   
/*     */   private boolean f = false;
/*     */ 
/*     */   
/*     */   public a() {
/*  28 */     setName("comboBoxPortal");
/*  29 */     setRenderer((ListCellRenderer<? super E>)new h(this));
/*     */     
/*  31 */     addActionListener((ActionListener)new br.com.arremate.m.a.a(this, this)
/*     */         {
/*     */           public void g() {
/*  34 */             JOptionPane.showMessageDialog(null, "Portal desabilitado", "Erro", 0);
/*  35 */             j.a().ag(a().a().v());
/*     */             
/*  37 */             for (byte b = 0; b < a().getItemCount(); b++) {
/*  38 */               if (a().a(b).getStatus() != 0) {
/*  39 */                 a().setSelectedIndex(b);
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*  46 */     f();
/*     */   }
/*     */ 
/*     */   
/*     */   private void f() {
/*  51 */     DefaultComboBoxModel<E> defaultComboBoxModel = new DefaultComboBoxModel();
/*     */     
/*     */     try {
/*  54 */       l.a().values().stream()
/*  55 */         .filter(paramn -> 
/*  56 */           (paramn.a() != null && (paramn.a() != o.q || paramn.getStatus() != n.aW)))
/*  57 */         .forEach(paramn -> {
/*     */             String str = paramn.K();
/*     */             
/*     */             if (paramn.getStatus() == n.aY) {
/*     */               str = str + " (Em Homologação)";
/*     */             }
/*     */             paramDefaultComboBoxModel.addElement(str);
/*     */             this.a.put(Integer.valueOf(paramDefaultComboBoxModel.getSize() - 1), paramn);
/*     */           });
/*  66 */     } catch (Exception exception) {
/*  67 */       exception.printStackTrace();
/*     */     } 
/*     */     
/*  70 */     setMaximumRowCount(12);
/*  71 */     setModel(defaultComboBoxModel);
/*     */   }
/*     */   
/*     */   public n a(int paramInt) {
/*  75 */     return this.a.get(Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   public n a() {
/*  79 */     return a(getSelectedIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(int paramInt) {
/*  87 */     for (byte b = 0; b < this.a.size(); b++) {
/*  88 */       if (((n)this.a.get(Integer.valueOf(b))).v() == paramInt) {
/*  89 */         setSelectedIndex(b);
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void doLayout() {
/*     */     try {
/*  98 */       this.f = true;
/*  99 */       super.doLayout();
/*     */     } finally {
/* 101 */       this.f = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Dimension getSize() {
/* 107 */     Dimension dimension = super.getSize();
/* 108 */     if (!this.f) {
/* 109 */       dimension.width = Math.max(dimension.width, (getPreferredSize()).width);
/*     */     }
/*     */     
/* 112 */     return dimension;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */